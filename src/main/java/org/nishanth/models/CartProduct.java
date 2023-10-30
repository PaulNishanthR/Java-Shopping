package org.nishanth.models;

import java.sql.Timestamp;

public class CartProduct {
    private Product product;
    private int count;

    public CartProduct(Product userProduct, int i) {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
