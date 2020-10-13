package edu.wctc.wholesale.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    private String purchaseOrderNumber;

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

    @Column(name="purchase_date")
    private LocalDate purchaseDate;

    @Column(name="shipped_date")
    private LocalDate shippedDate;

}
//    purchase_date timestamp not null,
//        shipped_date timestamp,

//<td th:text="${order.customer.name}">CUSTOMER NAME</td>
//<td th:text="${#temporals.format(order.purchaseDate, 'MMM dd yyyy')}">PURCHASE DATE</td>
//<td th:text="${order.purchaseOrderNumber}">PURCHASE ORDER</td>
//<td th:text="${order.product.name}">PRODUCT NAME</td>
//<td th:text="${order.terms}">TERMS</td>
//<td th:text="${#temporals.format(order.shippedDate, 'MMM dd yyyy')}">SHIPPED DATE</td>
//<td th:text="${order.product.cost}">PRODUCT COST</td>