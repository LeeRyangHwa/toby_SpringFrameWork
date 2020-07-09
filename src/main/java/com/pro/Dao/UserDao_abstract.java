package com.pro.Dao;

import com.pro.Dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao_abstract {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("insert  into users(id,name, password) valuse(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(1, user.getName());
        ps.setString(1, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c  = getConnection();
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
