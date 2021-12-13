package ir.maktab.model;

import ir.maktab.enumeration.UserType;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private List<User> accounts;
    private UserType userType;
    private Date openingDate;
    private Date updateInfoDate;
    private Map<Date,String> updates;

}
