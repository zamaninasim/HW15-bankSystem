package ir.maktab.service;

import ir.maktab.dao.AccountDao;
import ir.maktab.model.Account;

public class AccountService {
    AccountDao accountDao = new AccountDao();

    public void saveAccountService(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccountService(Account account) {
        accountDao.updateAccount(account);
    }

    public Account readAccountByCartNumber(Long cartNumber) {
        Account accountWhitThisCartNumber = accountDao.findAccountByCartNumber(cartNumber);
        return accountWhitThisCartNumber;
    }
}
