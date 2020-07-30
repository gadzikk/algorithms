package design_patterns.creational.object_pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gadzik on 27.07.20.
 */
public class Main {
    public static void main(String args[]) {
        // Create the ConnectionPool:
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb: //localhost/mydb",
                "sa", "password");

        // Get a connection:
        Connection con = null;
        try {
            con = pool.takeOut();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return the connection:
        pool.takeIn(con);
    }
}
