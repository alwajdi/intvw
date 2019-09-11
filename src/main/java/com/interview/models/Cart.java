package com.interview.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohd Solehuddin Abd Wahab
 * date : 11-Sep-19
 * time : 04:14
 */
public class Cart {
    private List<RetailItem> retailItems = new ArrayList<>();

    public List<RetailItem> getRetailItems() {
        return retailItems;
    }

    public void setRetailItems(List<RetailItem> retailItems) {
        this.retailItems = retailItems;
    }

    public void addToCart(RetailItem item){
        retailItems.add(item);
    }

    public void removeFromCart(int index){
        retailItems.remove(index);
    }

    public void emptyCart(){
        retailItems.clear();
    }
}
