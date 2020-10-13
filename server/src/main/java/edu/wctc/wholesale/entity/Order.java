package edu.wctc.wholesale.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Order {
    private String customerName;
    private Date date;
    private String poNumber;
    private String productName;
    private String terms;
    private Date shipped;
    private Double total;
}
