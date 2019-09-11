package com.interview.models;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 03:59
 */
public class Employee extends User {

    @Override
    public double getEligibleDiscountOnNonGroceryItems() {
        return EMPLOYEE_DISCOUNT;
    }
}
