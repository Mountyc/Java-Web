package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static String url = "jdbc:mysql://localhost:3306/liyicheng?characterEncoding=utf-8&serverTimezone=UTC";
    //数据库驱动类名
    private static String Driver = "com.mysql.cj.jdbc.Driver";
    //数据库账号
    private static String username = "root";
    //数据库密码
    private static String password = "666999";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return connection;
        }
    }
}
