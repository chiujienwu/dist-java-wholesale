package edu.wctc.wholesale.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Wholesale_order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "purchase_order_num")
    private String po;

    private String terms;

    //foreign key
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    //foreign key
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

//    private String purchase_date() {
//        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyy");
//        Date date = new Date();
//        return dateFormat.format(date);
//    }

    private Date purchase_date;

    private Date shipped_date;

}
