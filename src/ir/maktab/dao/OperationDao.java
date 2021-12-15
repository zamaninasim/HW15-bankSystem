package ir.maktab.dao;

import ir.maktab.model.Operation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OperationDao extends BaseDao {

    public Integer saveOperation(Operation operation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(operation);
        transaction.commit();
        session.close();
        return id;
    }

    public Operation getById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Operation operation = session.get(Operation.class, id);
        transaction.commit();
        session.close();
        return operation;
    }
}
