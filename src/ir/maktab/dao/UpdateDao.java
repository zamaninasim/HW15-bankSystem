package ir.maktab.dao;

import ir.maktab.model.Update;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateDao extends BaseDao {
    public Integer save(Update update) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(update);
        transaction.commit();
        session.close();
        return id;
    }

}
