package edu.wctc.wholesale.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String customerName;
    private Date date;
    private String poNumber;
    private String productName;
    private String terms;
    private Date shipped;
    private Double productCost;

}