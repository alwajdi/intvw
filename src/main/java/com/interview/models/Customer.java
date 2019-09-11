package com.interview.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:00
 */
public class Customer extends User {

    @Override
    public double getEligibleDiscountOnNonGroceryItems() {
        LocalDate today = LocalDate.now();
        LocalDate memberSince = new Date(getMemberSince().getTime()).toLocalDate();
        Period period = Period.between(memberSince, today);
        if(period.getYears() >= 2){
            return CUSTOMER_DISCOUNT;
        } else {
            return 0.0;
        }
    }
}
