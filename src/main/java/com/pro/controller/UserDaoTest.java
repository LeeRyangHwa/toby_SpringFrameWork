package com.pro.controller;

import Dao.ConnectionMaker;
import Dao.DConnectionMaker;
import Dao.UserDao;
import Factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);
        UserDao dao1 = new DaoFactory().userDao();// dao와 같은 일을 한다.



    }
}
