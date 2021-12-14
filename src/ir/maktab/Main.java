package ir.maktab;

import ir.maktab.enumeration.UserType;
import ir.maktab.model.User;
import ir.maktab.model.builder.UserBuilder;
import ir.maktab.service.UserService;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static final UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("1)Create user\n2)find user by firstname\n3)find by lastname\n" +
                "3)find by cart number\n4)Create and assign an account\n5)Withdraw and deposit operations");
        Integer operations = scanner.nextInt();
        switch (operations) {
            case 1:
                User user = creatUser();
                userService.saveUserService(user);
                break;
            case 2:
                System.out.println("enter firstname:");
                String firstname = scanner.next();
                User userWhitThisFirstname = userService.readUserByFirstname(firstname);
                System.out.println(userWhitThisFirstname);
                break;
            case 3:
                System.out.println("enter lastname:");
                String lastname = scanner.next();
                User userWhitThisLastname = userService.readUserByLastname(lastname);
                System.out.println(userWhitThisLastname);
                break;

        }
    }

    private static User creatUser() {
        System.out.println("enter user info:(firstname,lastname,nationalCode");
        //TODO
        String userInfo = scanner.next();
        String[] splitedInfo = userInfo.split(",");
        String firstname = splitedInfo[0];
        String lastname = splitedInfo[1];
        String nationalCode = splitedInfo[2];

        User user = UserBuilder.anUser()
                .withFirstName(firstname)
                .withLastName(lastname)
                .withNationalCode(nationalCode)
                .withAccounts()
                .withUserType(UserType.NONE)
                .build();
        return user;
    }
}
