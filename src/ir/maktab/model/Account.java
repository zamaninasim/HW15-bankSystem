package ir.maktab.model;

import ir.maktab.enumeration.AccountType;
import lombok.Data;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Operation> operations = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
