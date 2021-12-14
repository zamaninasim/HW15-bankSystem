package ir.maktab.dao;

import ir.maktab.model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OperationDao extends BaseDao {

    public Integer saveOperation(Operation operation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(operation);
        transaction.commit();
        session.close();
        return id;
    }
}
