package ir.maktab.model;

import ir.maktab.enumeration.TransactionType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    private TransactionType transactionType;
    private Long amount;
    @CreationTimestamp
    private Date date;
}
