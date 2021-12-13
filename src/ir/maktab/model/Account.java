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
    @Column(name ="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long balance;
    private Integer cvv2;
    @Column(name ="opening_date")
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @Column(name ="expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
