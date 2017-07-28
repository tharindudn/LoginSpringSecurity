package secure.dao;

import secure.model.User;

import java.util.List;

/**
 * Created by tharindu on 7/27/17.
 */
public interface UserDao {
    public List<User> listUser();
    public void addUser(User user) ;
    public void updateUser(User user);
    public User getPersonByname(String name);
    public void removeUser(User user);
}
