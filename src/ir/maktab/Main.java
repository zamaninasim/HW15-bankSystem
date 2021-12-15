package ir.maktab;

import ir.maktab.enumeration.AccountType;
import ir.maktab.enumeration.TransactionType;
import ir.maktab.enumeration.UserType;
import ir.maktab.model.Account;
import ir.maktab.model.Operation;
import ir.maktab.model.Update;
import ir.maktab.model.User;
import ir.maktab.model.builder.AccountBuilder;
import ir.maktab.model.builder.OperationBuilder;
import ir.maktab.model.builder.UserBuilder;
import ir.maktab.service.AccountService;
import ir.maktab.service.OperationService;
import ir.maktab.service.UpdateService;
import ir.maktab.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final UserService userService = new UserService();
    static final AccountService accountService = new AccountService();
    static final OperationService operationService = new OperationService();
    static final UpdateService updateService = new UpdateService();

    public static void main(String[] args) {

        boolean exit = false;
        do {
            System.out.println("1)Create user\n2)find user by firstname\n3)find by lastname\n" +
                    "4)find by cart number\n5)Create an account\n6)assign an account\n" +
                    "7)Withdraw\n8)Deposit\n9)3last operations of account\n10)exit");
            Integer operations = scanner.nextInt();
            switch (operations) {
                case 1:
                    User user = creatUser();
                    Main.userService.saveUserService(user);
                    break;
                case 2:
                    System.out.println("enter firstname:");
                    String firstname = scanner.next();
                    User userWhitThisFirstname = Main.userService.readUserByFirstname(firstname);
                    System.out.println(userWhitThisFirstname);
                    break;
                case 3:
                    System.out.println("enter lastname:");
                    String lastname = scanner.next();
                    User userWhitThisLastname = Main.userService.readUserByLastname(lastname);
                    System.out.println(userWhitThisLastname);
                    break;
                case 4:
                    Account accountWhitThisCartNumber = getAccount();
                    User userWhitThisCartNumber = accountWhitThisCartNumber.getUser();
                    System.out.println(userWhitThisCartNumber);
                    break;
                case 5:
                    User userForAccount = creatUser();
                    Main.userService.saveUserService(userForAccount);
                    try {
                        Account account = creatAccount(userForAccount);
                        accountService.saveAccountService(account);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("enter user NationalCode:");
                    String nationalCode = scanner.next();
                    User userWhitThisNationalCode = Main.userService.readUserByNationalCode(nationalCode);
                    try {
                        Account account = creatAccount(userWhitThisNationalCode);
                        accountService.saveAccountService(account);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    Account accountForWithdraw = getAccount();
                    Long balanceForWithdraw = accountForWithdraw.getBalance();
                    System.out.println("your balance is: " + balanceForWithdraw);
                    System.out.println("Enter the amount:");
                    long amountForWithdraw = scanner.nextLong();
                    Long newBalanceForWithdraw = balanceForWithdraw - amountForWithdraw;
                    TransactionType withdraw = TransactionType.WITHDRAW;
                    Operation withdrawOperation = doOperation(amountForWithdraw, withdraw, accountForWithdraw);
                    accountForWithdraw.setBalance(newBalanceForWithdraw);
                    operationService.saveOperationService(withdrawOperation);
                    accountForWithdraw.getOperations().add(withdrawOperation);
                    Update updateWithdraw = new Update();
                    updateWithdraw.setMassage("Account whit " + accountForWithdraw.getCartNumber() + "cart number Withdraw " + amountForWithdraw);
                    updateService.save(updateWithdraw);
                    accountService.updateAccountService(accountForWithdraw);
                    break;
                case 8:
                    Account accountForDeposit = getAccount();
                    Long balanceForDeposit = accountForDeposit.getBalance();
                    System.out.println("your balance is: " + balanceForDeposit);
                    System.out.println("Enter the amount:");
                    long amountForDeposit = scanner.nextLong();
                    Long newBalanceForDeposit = balanceForDeposit + amountForDeposit;
                    TransactionType deposit = TransactionType.DEPOSIT;
                    Operation depositOperation = doOperation(amountForDeposit, deposit, accountForDeposit);
                    accountForDeposit.setBalance(newBalanceForDeposit);
                    operationService.saveOperationService(depositOperation);
                    accountForDeposit.getOperations().add(depositOperation);
                    Update updateDeposit = new Update();
                    updateDeposit.setMassage("Account whit " + accountForDeposit.getCartNumber() + "cart number Withdraw " + amountForDeposit);
                    updateService.save(updateDeposit);
                    accountService.updateAccountService(accountForDeposit);
                    break;
                case 9:
                    Account account = getAccount();
                    List<Operation> allOperations = account.getOperations();
                    List<Integer> lastIds = allOperations.stream().map(i -> i.getId()).sorted((i, j) -> Integer.compare(j, i)).limit(3).toList();
                    List<Operation> threeLastOperations = new ArrayList<>();
                    for (Integer id : lastIds) {
                        Operation operationById = operationService.getById(id);
                        threeLastOperations.add(operationById);
                    }
                    System.out.println(threeLastOperations);
                    break;
                case 10:
                    exit = true;
            }
        } while (!exit);
    }

    private static Operation doOperation(long amount, TransactionType transactionType, Account accountForOperation) {
        return OperationBuilder.aTransaction()
                .withAccount(accountForOperation)
                .withTransactionType(transactionType)
                .withAmount(amount)
                .build();
    }

    private static Account getAccount() {
        System.out.println("enter cartNumber:");
        long cartNumber = scanner.nextLong();
        return accountService.readAccountByCartNumber(cartNumber);
    }

    private static User creatUser() {
        System.out.println("enter user info:firstname,lastname,nationalCode");
        //TODO
        String userInfo = scanner.next();
        String[] splitedInfo = userInfo.split(",");
        String firstname = splitedInfo[0];
        String lastname = splitedInfo[1];
        String nationalCode = splitedInfo[2];

        return UserBuilder.anUser()
                .withFirstName(firstname)
                .withLastName(lastname)
                .withNationalCode(nationalCode)
                .withAccounts()
                .withUserType(UserType.NONE)
                .build();
    }

    private static Account creatAccount(User user) throws ParseException {
        System.out.println("enter Account info:(AccountNumber,CartNumber,Balance,Cvv2");
        //TODO
        String accountInfo = scanner.next();
        String[] splitAccountInfo = accountInfo.split(",");
        Long accountNumber = Long.parseLong(splitAccountInfo[0]);
        Long cartNumber = Long.parseLong(splitAccountInfo[1]);
        Long balance = Long.parseLong(splitAccountInfo[2]);
        Integer cvv2 = Integer.parseInt(splitAccountInfo[3]);

        System.out.println("enter openingDate:(like this:2021-08-01");
        String openingDate = scanner.next();
        Date parseOpeningDate = new SimpleDateFormat("yyyy-MM-dd").parse(openingDate);
        System.out.println("enter expirationDate:(like this:2021-08-01");
        String expirationDate = scanner.next();
        Date parseExpirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);

        AccountType accountType = returnAccountType();

        return AccountBuilder.anAccount()
                .withAccountNumber(accountNumber)
                .withCartNumber(cartNumber)
                .withAccountType(accountType)
                .withBalance(balance)
                .withCvv2(cvv2)
                .withOpeningDate(parseOpeningDate)
                .withExpirationDate(parseExpirationDate)
                .withUser(user)
                .withOperations()
                .build();
    }

    private static AccountType returnAccountType() {
        System.out.println("enter account type:\n1)NONE_PROFIT\n2)CURRENT\n3)SHORT_TERM\n4)LONG_TERM");
        int accountTypeInput = scanner.nextInt();
        AccountType accountType = AccountType.NONE_PROFIT;
        switch (accountTypeInput) {
            case 1:
                break;
            case 2:
                accountType = AccountType.CURRENT;
                break;
            case 3:
                accountType = AccountType.SHORT_TERM;
                break;
            case 4:
                accountType = AccountType.LONG_TERM;
                break;
        }
        return accountType;
    }
}
