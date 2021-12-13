package ir.maktab.model.builder;

import ir.maktab.enumeration.UserType;
import ir.maktab.model.Account;
import ir.maktab.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class UserBuilder {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private UserType userType;
    private Date userCreationDate;
    private Date updateInfoDate;
    private Map<Date, String> updates;
    private List<Account> accounts;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public UserBuilder withUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public UserBuilder withUserCreationDate(Date userCreationDate) {
        this.userCreationDate = userCreationDate;
        return this;
    }

    public UserBuilder withUpdateInfoDate(Date updateInfoDate) {
        this.updateInfoDate = updateInfoDate;
        return this;
    }

    public UserBuilder withUpdates(Map<Date, String> updates) {
        this.updates = updates;
        return this;
    }

    public UserBuilder withAccounts() {
        this.accounts = new ArrayList<>();
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setNationalCode(nationalCode);
        user.setUserType(userType);
        user.setUserCreationDate(userCreationDate);
        user.setUpdateInfoDate(updateInfoDate);
        user.setUpdates(updates);
        user.setAccounts(accounts);
        return user;
    }
}
