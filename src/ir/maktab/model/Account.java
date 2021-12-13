package ir.maktab.model;
import ir.maktab.enumeration.AccountType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name ="cart_number")
    private Long cartNumber;
    @Column(name ="opening_date")
    private Date openingDate;
    @Column(name ="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name ="account_type")
    private Long balance;
    @Column(name ="account_type")
    private Integer cvv2;
    @Column(name ="account_type")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
}
