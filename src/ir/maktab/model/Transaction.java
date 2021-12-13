package ir.maktab.model;

import ir.maktab.enumeration.TransactionType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private User user;
    private TransactionType transactionType;
    private Long amount;
    private Date date;
}
