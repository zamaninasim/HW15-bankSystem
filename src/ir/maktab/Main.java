package ir.maktab;

import ir.maktab.enumeration.AccountType;
import ir.maktab.enumeration.TransactionType;
import ir.maktab.enumeration.UserType;
import ir.maktab.model.Account;
import ir.maktab.model.Operation;
import ir.maktab.model.User;
import ir.maktab.model.builder.AccountBuilder;
import ir.maktab.model.builder.OperationBuilder;
import ir.maktab.model.builder.UserBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    static SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();

    public static void main(String[] args) {
        User user = UserBuilder.anUser()
                .withFirstName("nasim")
                .withLastName("zamani")
                .withNationalCode("0018715834").withUserType(UserType.GOOD)
                .withAccounts()
                .build();

        Account account1 = AccountBuilder.anAccount()
                .withAccountNumber(123456789L)
                .withCartNumber(987654321L)
                .withAccountType(AccountType.CURRENT)
                .withBalance(10000000L)
                .withCvv2(1234)
                .withOpeningDate(new Date(2021, 12, 13))
                .withExpirationDate(new Date(2024, 12, 13))
                .withUser(user)
                .withOperations()
                .build();

        Account account2 = AccountBuilder.anAccount()
                .withAccountNumber(852963741L)
                .withCartNumber(369852147L)
                .withAccountType(AccountType.LONG_TERM)
                .withBalance(20000000L)
                .withCvv2(2525)
                .withOpeningDate(new Date(2021, 8, 1))
                .withExpirationDate(new Date(2024, 8, 1))
                .withUser(user)
                .withOperations()
                .build();


        Operation operation1 = OperationBuilder.aTransaction()
                .withAccount(account1)
                .withTransactionType(TransactionType.DEPOSIT)
                .withAmount(10000L)
                .build();

        Operation operation2 = OperationBuilder.aTransaction()
                .withAccount(account1)
                .withTransactionType(TransactionType.TRANSFER)
                .withAmount(50000L)
                .build();


        account1.getOperations().add(operation1);
        account2.getOperations().add(operation2);

        user.getAccounts().add(account1);
        user.getAccounts().add(account2);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account2);
        session.save(account1);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
