package design_patterns.creational.object_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gadzik on 27.07.20.
 */
public class JDBCConnectionPool extends ObjectPool<Connection> {
    String dsn, usr, pwd;

    JDBCConnectionPool(String driver, String dsn, String usr, String pwd) {
        super();
        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dsn = dsn;
        this.usr = usr;
        this.pwd = pwd;
    }

    Connection create() throws SQLException {
        return (DriverManager.getConnection(dsn, usr, pwd));
    }

    void dead(Connection o) throws SQLException {
        ((Connection) o).close();
    }

    boolean validate(Connection o) throws SQLException {
        return (!((Connection) o).isClosed());
    }
}