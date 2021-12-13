package ir.maktab.model.builder;

import ir.maktab.enumeration.AccountType;
import ir.maktab.model.Account;
import ir.maktab.model.User;

import java.util.Date;

public final class AccountBuilder {
    private Integer id;
    private Long accountNumber;
    private Long cartNumber;
    private AccountType accountType;
    private Long balance;
    private Integer cvv2;
    private Date openingDate;
    private Date expirationDate;
    private User user;

    private AccountBuilder() {
    }

    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }

    public AccountBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public AccountBuilder withAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder withCartNumber(Long cartNumber) {
        this.cartNumber = cartNumber;
        return this;
    }

    public AccountBuilder withAccountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountBuilder withBalance(Long balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder withCvv2(Integer cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    public AccountBuilder withOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    public AccountBuilder withExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public AccountBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public Account build() {
        Account account = new Account();
        account.setId(id);
        account.setAccountNumber(accountNumber);
        account.setCartNumber(cartNumber);
        account.setAccountType(accountType);
        account.setBalance(balance);
        account.setCvv2(cvv2);
        account.setOpeningDate(openingDate);
        account.setExpirationDate(expirationDate);
        account.setUser(user);
        return account;
    }
}
