package design_patterns.creational.object_pool;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by gadzik on 27.07.20.
 */
abstract class ObjectPool<T> {
    long deadTime;

    Hashtable<T, Long> lock, unlock;

    ObjectPool() {
        deadTime = 50000; // 50 seconds
        lock = new Hashtable<>();
        unlock = new Hashtable<>();
    }

    abstract T create() throws SQLException;

    abstract boolean validate(T o) throws SQLException;

    abstract void dead(T o) throws SQLException;

    synchronized T takeOut() throws SQLException {
        long now = System.currentTimeMillis();
        T object;
        if (unlock.size() > 0) {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements()) {
                object = e.nextElement();
                if ((now - unlock.get(object)) > deadTime) {
                    // object has deadd
                    unlock.remove(object);
                    dead(object);
                    object = null;
                } else {
                    if (validate(object)) {
                        unlock.remove(object);
                        lock.put(object, now);
                        return (object);
                    } else {
                        // object failed validation
                        unlock.remove(object);
                        dead(object);
                        object = null;
                    }
                }
            }
        }
        // no objects available, create a new one
        object = create();
        lock.put(object, now);
        return (object);
    }

    synchronized void takeIn(T t) {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }
}
