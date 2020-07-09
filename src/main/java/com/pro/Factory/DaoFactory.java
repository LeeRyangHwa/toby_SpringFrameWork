package com.pro.Factory;

import com.pro.Dao.ConnectionMaker;
import com.pro.Dao.DConnectionMaker;
import com.pro.Dao.UserDao;

public class DaoFactory {
    public UserDao userDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
