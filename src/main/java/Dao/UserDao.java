package Dao;

import Dto.User;

import java.sql.*;

public class UserDao {
    //초난감 DAO
//    public void add(User user) throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/springbook","spring","book"
//        );
//        PreparedStatement ps = c.prepareStatement("insert  into users(id,name, password) valuse(?,?,?)");
//        ps.setString(1, user.getId());
//        ps.setString(1, user.getName());
//        ps.setString(1, user.getPassword());
//
//        ps.executeUpdate();
//        ps.close();
//        c.close();
//    }

//    public User get(String id) throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/springbook","spring","book"
//        );
//        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
//        ps.setString(1, id);
//
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        User user = new User();
//        user.setId(rs.getString("id"));
//        user.setName(rs.getString("name"));
//        user.setPassword(rs.getString("password"));
//
//        rs.close();
//        ps.close();
//        c.close();
//
//        return user;
//    }
    private SimpleConnectionMaker simpleConnectionMaker;
    public UserDao(){
        simpleConnectionMaker = new SimpleConnectionMaker();
    }
    //중복 코드의 메서드 추출
    public void add(User user) throws ClassNotFoundException, SQLException{
//        Connection c = getConnection();
        Connection c = simpleConnectionMaker.makeNewConnection();
        PreparedStatement ps = c.prepareStatement("insert  into users(id,name, password) valuse(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(1, user.getName());
        ps.setString(1, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException{
//        Connection c  = getConnection();
        Connection c = simpleConnectionMaker.makeNewConnection();
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
//    private Connection getConnection() throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/springbook","spring","book"
//        );
//        return c;
//    }
}
