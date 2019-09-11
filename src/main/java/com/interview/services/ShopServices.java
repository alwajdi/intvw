package com.interview.services;

import com.interview.models.Cart;
import com.interview.models.User;

import java.math.BigDecimal;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:14
 */
public interface ShopServices {

    BigDecimal calculateNetPayable(Cart cart, User user);

}
