package ir.maktab.dao;

import ir.maktab.model.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao extends BaseDao {


    public Integer saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    public User findUserByFirstname(String firstname){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("firstName",firstname));
        List<User> list = criteria.list();
        User user = list.get(0);
        transaction.commit();
        session.close();
        return user;
    }

    public User findUserByLastname(String lastname){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("lastName",lastname));
        List<User> list = criteria.list();
        User user = list.get(0);
        transaction.commit();
        session.close();
        return user;
    }

    public User findUserByNationalCode(String nationalCode){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("nationalCode",nationalCode));
        List<User> list = criteria.list();
        User user = list.get(0);
        transaction.commit();
        session.close();
        return user;
    }
}
