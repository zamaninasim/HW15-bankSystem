package ir.maktab.dao;

import ir.maktab.model.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OperationDao {
    static SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    public Integer saveOperation(Operation operation) {
        Integer id = (Integer) session.save(operation);
        transaction.commit();
        session.close();
        return id;
    }
}
