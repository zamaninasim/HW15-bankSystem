package ir.maktab.model;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Account {
    private Long accountNumber;
    private Long cartNumber;
    private Date openingDate;

}
