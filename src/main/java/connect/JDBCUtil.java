package connect;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(String url, String user, String password) throws SQLException {
        Connection c = null;
        try {
            //create and register JDBC Driver with Driver Manager
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            //create connection
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c) throws SQLException {
        try {
            if (c != null){
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
