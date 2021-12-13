package ir.maktab.model;

import ir.maktab.enumeration.UserType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_code")
    private String nationalCode;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "user_creation_date")
    @CreationTimestamp
    private Date userCreationDate;
    @Column(name = "update_info_date")
    @UpdateTimestamp
    private Date updateInfoDate;
    @Transient
    private Map<Date, String> updates;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Account> accounts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Transaction> Transactions;
}
