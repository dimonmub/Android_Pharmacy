package ru.dimonmubmail.pharmacy;

import java.io.Serializable;

/**
 * Created by Dmitriy on 16.10.2014.
 */
public class Medicine implements Serializable {

    String cost;
    String pc;
    boolean inStock;

    public Medicine(String cost, String pc, boolean inStock) {
        this.cost = cost;
        this.pc = pc;
        this.inStock = inStock;
    }

    public String getCost() {
        return cost;
    }

    public String getPc() {
        return pc;
    }

    public boolean getInStock() {
        return inStock;
    }
}
