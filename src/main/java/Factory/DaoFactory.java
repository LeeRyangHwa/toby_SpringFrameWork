package Factory;

import Dao.ConnectionMaker;
import Dao.DConnectionMaker;
import Dao.UserDao;

public class DaoFactory {
    public UserDao userDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
