package ir.maktab.service;

import ir.maktab.dao.UserDao;
import ir.maktab.model.User;

public class UserService {
    UserDao userDao = new UserDao();

    public void saveUserService(User user) {
        userDao.saveUser(user);
    }

    public User readUserByFirstname(String firstname) {
        User userWhitThisFirstname = userDao.findUserByFirstname(firstname);
        return userWhitThisFirstname;
    }

    public User readUserByLastname(String lastname) {
        User userWhitThisLastname = userDao.findUserByLastname(lastname);
        return userWhitThisLastname;
    }
}
