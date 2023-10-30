package org.nishanth.view;

import org.nishanth.models.CartProduct;

import java.util.ArrayList;

public class CartPage {
    public void printEmptyCart() {
        System.out.println("Your shopping cart is empty.");
    }

    public void printcart(ArrayList<CartProduct> cartProducts) {
        if (cartProducts.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Your Shopping Cart:");
            double total = 0;
            for (CartProduct cartProduct : cartProducts) {
                String productInfo = String.format("%s x %d", cartProduct.getProduct().getTitle(), cartProduct.getCount());
                System.out.println(productInfo);
                total += cartProduct.getCount() * cartProduct.getProduct().getPrice();
            }
            System.out.println("Total Price: " + total);
        }
    }

    public void printcheckout() {
        System.out.println("Thank you for shopping with us!");
        System.out.println("Your order has been placed.");
        System.out.println("Please proceed to checkout.");
        System.out.println("#---------------------#");
    }

    public void printback() {
        System.out.println("Press 'B' to go back.");
    }

}
