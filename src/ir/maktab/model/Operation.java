package ir.maktab.model;

import ir.maktab.enumeration.TransactionType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    private Account account;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Long amount;
    @CreationTimestamp
    private Date date;
}
