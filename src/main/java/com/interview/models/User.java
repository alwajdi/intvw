package com.interview.models;

import java.util.Date;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 03:59
 */
public abstract class User {

    public static final double EMPLOYEE_DISCOUNT = 0.3;
    public static final double AFFILIATE_DISCOUNT = 0.1;
    public static final double CUSTOMER_DISCOUNT = 0.05;

    private String name;
    private Date memberSince;
    private double eligibleDiscountOnNonGroceryItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public abstract double getEligibleDiscountOnNonGroceryItems();

}
