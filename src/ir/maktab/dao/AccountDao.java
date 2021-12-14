package ir.maktab.dao;

import ir.maktab.model.Account;
import ir.maktab.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AccountDao {
    static SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    public Integer saveAccount(Account account) {
        Integer id = (Integer) session.save(account);
        transaction.commit();
        session.close();
        return id;
    }

    public Account findAccountByCartNumber(Long cartNumber){
        Criteria criteria = session.createCriteria(Account.class);
        criteria.add(Restrictions.eq("cartNumber",cartNumber));
        List<Account> list = criteria.list();
        Account account = list.get(0);
        return account;
    }
}
