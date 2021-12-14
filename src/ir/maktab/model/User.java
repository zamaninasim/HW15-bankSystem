package ir.maktab.model;

import ir.maktab.enumeration.UserType;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @CreationTimestamp
    private Date userCreationDate;
    @UpdateTimestamp
    private Date updateInfoDate;
    @Transient
    private Map<Date, String> updates;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Account> accounts;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
