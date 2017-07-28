package secure.service;

import org.springframework.transaction.annotation.Transactional;
import secure.dao.UserDao;
import secure.model.User;

import java.util.List;

/**
 * Created by tharindu on 7/27/17.
 */
public class ServiceImpl implements UserService{

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }
    @Transactional
    public List<User> listUser(){

        return this.userDao.listUser();
    }
    @Override
    @Transactional
    public void updateUser(User user) {

        this.userDao.updateUser(user);
    }
    @Override
    @Transactional
    public User getPersonByname(String name) {
        return this.userDao.getPersonByname(name);
    }
    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }
    @Override
    @Transactional
    public void removeUser(User user) {
        this.userDao.removeUser(user);
    }
}
