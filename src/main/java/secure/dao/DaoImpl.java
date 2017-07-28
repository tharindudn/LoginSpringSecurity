package secure.dao;

import secure.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tharindu on 7/27/17.
 */
@Repository
public class DaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUser() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User p : userList) {
            System.out.println(p);
        }
        return userList;
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        //session.beginTransaction().commit();

    }

    @Override
    public User getPersonByname(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new String("name"));

        return user;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);

    }
    public void removeUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        if(null != user){
            session.delete(user);
        }

    }
}