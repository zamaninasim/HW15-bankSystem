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
    @Column(name ="name")
    private String firstName;
    @Column(name ="name")
    private String lastName;
    @Column(name ="family")
    private String nationalCode;
    @OneToMany
    private List<User> accounts;
    private UserType userType;
    @CreationTimestamp
    private Date userCreationDate;
    @UpdateTimestamp
    private Date updateInfoDate;
    private Map<Date,String> updates;
    @OneToMany
    private List<Transaction> threeLastTransaction;
}
