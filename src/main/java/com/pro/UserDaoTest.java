package com.pro;

import com.pro.Dao.ConnectionMaker;
import com.pro.Dao.DConnectionMaker;
import com.pro.Dao.UserDao;
import com.pro.Factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);
        UserDao dao1 = new DaoFactory().userDao();// dao와 같은 일을 한다.

        System.out.println("!!");


    }
}
