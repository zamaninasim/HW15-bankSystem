package ir.maktab.model;
import ir.maktab.enumeration.AccountType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long accountNumber;
    private Long cartNumber;
    private Date openingDate;
    private AccountType accountType;
    private Long balance;
    private Integer cvv2;
    private Date expirationDate;


}
