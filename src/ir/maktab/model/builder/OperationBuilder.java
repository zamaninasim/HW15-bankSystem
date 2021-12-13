package ir.maktab.model.builder;

import ir.maktab.enumeration.TransactionType;
import ir.maktab.model.Account;
import ir.maktab.model.Operation;

import java.util.Date;

public final class OperationBuilder {
    private Integer id;
    /*    @ManyToOne(cascade = CascadeType.ALL)
            private User user;*/
    private Account account;
    private TransactionType transactionType;
    private Long amount;
    private Date date;

    private OperationBuilder() {
    }

    public static OperationBuilder aTransaction() {
        return new OperationBuilder();
    }

    public OperationBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public OperationBuilder withAccount(Account account) {
        this.account = account;
        return this;
    }

    public OperationBuilder withTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public OperationBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public OperationBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public Operation build() {
        Operation transaction = new Operation();
        transaction.setId(id);
        transaction.setAccount(account);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transaction.setDate(date);
        return transaction;
    }
}
