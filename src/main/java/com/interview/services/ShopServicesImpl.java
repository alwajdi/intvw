package com.interview.services;

import com.interview.models.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:14
 */
public class ShopServicesImpl  implements ShopServices{

    @Override
    public BigDecimal calculateNetPayable(Cart cart, User user){

        List<GroceryItem> groceryItems = cart.getRetailItems().stream()
                .filter(item -> item instanceof GroceryItem)
                .map(theItem -> (GroceryItem) theItem)
                .collect(Collectors.toList());

        BigDecimal totalGroceryPrice = calculatePrice(groceryItems);

        List<NonGroceryItem> nonGroceryItems = cart.getRetailItems().stream()
                .filter(item -> item instanceof NonGroceryItem)
                .map(theItem -> (NonGroceryItem) theItem)
                .collect(Collectors.toList());

        BigDecimal totalNonGroceryPrice = calculatePrice(nonGroceryItems);

        BigDecimal discountedNonGroceryPrice = applyUserTypeBasedDiscount(totalNonGroceryPrice, user);
        BigDecimal totalPrice = totalGroceryPrice.add(discountedNonGroceryPrice);

        return plusFiveDollarDiscountForEachHundredDollarBill(totalPrice);

    }


    private <T extends RetailItem> BigDecimal calculatePrice(List<T> retailItems){
        final BigDecimal[] totalPrice = {new BigDecimal("0.00")};

        retailItems.forEach( item -> {
            totalPrice[0] = totalPrice[0].add(item.getPrice());
        });

        return totalPrice[0];
    }

    private BigDecimal applyUserTypeBasedDiscount(BigDecimal price, User user){
        return price.subtract(price.multiply(BigDecimal.valueOf(user.getEligibleDiscountOnNonGroceryItems())));
    }

    private BigDecimal plusFiveDollarDiscountForEachHundredDollarBill(BigDecimal totalPrice){
        int dTotalPrice = totalPrice.intValue();
        int quotient = dTotalPrice / 100;
        return totalPrice.subtract(new BigDecimal(String.valueOf(quotient * 5)));
    }


}
