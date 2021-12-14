package ir.maktab.model;

import ir.maktab.enumeration.AccountType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long accountNumber;
    private Long cartNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long balance;
    private Integer cvv2;
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account",fetch = FetchType.EAGER)
    private List<Operation> operations = new ArrayList<>();
    @ManyToOne()
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", cartNumber=" + cartNumber +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", cvv2=" + cvv2 +
                ", openingDate=" + openingDate +
                ", expirationDate=" + expirationDate +
                ", user=" + user +
                '}';
    }
}
