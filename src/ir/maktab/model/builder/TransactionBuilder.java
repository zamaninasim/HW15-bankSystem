package ir.maktab.model.builder;

import ir.maktab.enumeration.TransactionType;
import ir.maktab.model.Account;
import ir.maktab.model.Transaction;
import ir.maktab.model.User;

import java.util.Date;

public final class TransactionBuilder {
    private Integer id;
    private User user;
    private Account account;
    private TransactionType transactionType;
    private Long amount;
    private Date date;

    private TransactionBuilder() {
    }

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public TransactionBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public TransactionBuilder withAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionBuilder withTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public TransactionBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public TransactionBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public Transaction build() {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setUser(user);
        transaction.setAccount(account);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transaction.setDate(date);
        return transaction;
    }
}
