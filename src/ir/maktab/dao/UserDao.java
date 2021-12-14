package ir.maktab.dao;

import ir.maktab.model.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao {
    static SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    public Integer saveUser(User user) {
        Integer id = (Integer) session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    public User findUserByFirstname(String firstname){
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("firstName",firstname));
        List<User> list = criteria.list();
        User user = list.get(0);
        return user;
    }

    public User findUserByLastname(String lastname){
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("lastName",lastname));
        List<User> list = criteria.list();
        User user = list.get(0);
        return user;
    }
}
