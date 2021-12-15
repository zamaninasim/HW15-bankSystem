package ir.maktab.dao;

import ir.maktab.model.Updates;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateDao extends BaseDao {
    public Integer save(Updates updates) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(updates);
        transaction.commit();
        session.close();
        return id;
    }

}
