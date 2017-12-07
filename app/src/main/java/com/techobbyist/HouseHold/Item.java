package com.techobbyist.HouseHold;

/**
 * Created by {OovuU} on 2017-12-03.
 */

public class Item {
    private String name;
    private String quantity;

    public Item(){
        this.name=null;
        this.quantity=null;
    }
    public Item(String item, String quantity){
        this.name=item;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
