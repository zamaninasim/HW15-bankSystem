package ir.maktab.model;
import ir.maktab.enumeration.AccountType;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Account {
    private Long accountNumber;
    private Long cartNumber;
    private Date openingDate;
    private AccountType accountType;
    private Long balance;
    private Integer cvv2;
    private Date expirationDate;


}
