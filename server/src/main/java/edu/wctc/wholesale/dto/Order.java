package edu.wctc.wholesale.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Order {
    private String customerName;
    private LocalDate date;
    private String poNumber;
    private String productName;
    private String terms;
    private LocalDate shipped;
    private Double total;

}
// below is copied from script.js to ensure field names are the same
//            tr.append("<td>" + order.customerName + "</td>");
//                    tr.append("<td>" + order.date + "</td>");
//                    tr.append("<td>" + order.poNumber + "</td>");
//                    tr.append("<td>" + order.productName + "</td>");
//                    tr.append("<td>" + order.terms + "</td>");
//                    tr.append("<td>" + order.shipped + "</td>");
//                    tr.append("<td>" + order.total + "</td>");