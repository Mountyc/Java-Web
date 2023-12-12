package dao;

import pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        // 使用DbUtils获取数据库连接对象
        Connection connection = DbUtils.getConnection();
        // 查询语句，其中问号为需要添加的参数
        String sql = "select * from users where username=? and password=?";
        // @connection对象生成PreparedStatement对象，对SQL语句进行预编译
        PreparedStatement pst = connection.prepareStatement(sql);
        // 为问号的参数赋值，setXXX方法中的XXX为参数类型，方法的第一个参数是要设置的参数索引，第二个参数是参数值
        pst.setString(1, username);
        pst.setString(2, password);
        // 执行查询，并得到结果集ResultSet对象
        ResultSet rs = pst.executeQuery();
        // 在本例中根据账号密码查询用户，最多返回1个用户，所以用if，并通过查询结果判断
        if (rs.next()) {
            // 若有结果，生成一个User对象并将查询结果一一赋值
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setUsertype(rs.getString("usertype"));
            user.setPhone(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
            // 返回查询到的用户对象
            return user;
        } else {
            // 没有查询到符合的用户，返回null
            return null;
        }
    }
    public void addUser(User user) throws SQLException {
        // 使用DbUtils获取数据库连接对象
        Connection connection = DbUtils.getConnection();
        // 查询语句，向数据库中插入新用户
        String sql = "INSERT INTO users (username, password, usertype, phone, email) VALUES (?, ?, ?, ?, ?)";
        // 创建PreparedStatement对象，对SQL语句进行预编译
        PreparedStatement pst = connection.prepareStatement(sql);
        // 为参数赋值
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getUsertype());
        pst.setString(4, user.getPhone());
        pst.setString(5, user.getEmail());
        // 执行更新
        pst.executeUpdate();
        // 关闭连接
        connection.close();
    }
}
