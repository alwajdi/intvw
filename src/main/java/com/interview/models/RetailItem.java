package com.interview.models;

import java.math.BigDecimal;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:03
 */
public abstract class RetailItem {
    private String name;
    private BigDecimal price;

    RetailItem(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
