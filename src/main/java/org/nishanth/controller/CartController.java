package org.nishanth.controller;

import org.nishanth.controller.impl.ICartController;
import org.nishanth.models.Cart;
import org.nishanth.models.CartProduct;
import org.nishanth.models.Product;
import org.nishanth.models.User;
import org.nishanth.utils.AppException;
import org.nishanth.utils.FileUtil;
import org.nishanth.view.CartPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import static org.nishanth.utils.LoadUtils.getProducts;
import static org.nishanth.utils.UserUtils.getLoggedInUser;
import static org.nishanth.utils.UserUtils.setLoggedInUser;
import static org.nishanth.utils.Utils.println;

public class CartController implements ICartController {
    //    private final HomeController homeController;
//    private final OrderController orderController;
//    private final CartPage cartPage;
//
//
//    public CartController(HomeController homeController) {
//        this.homeController = homeController;
//        orderController = new OrderController(homeController);
//        cartPage = new CartPage();
//    }
//
//    public void addtocart(int productId) {
//        User loggedInUser = getLoggedInUser();
//        ArrayList<Product> products = getProducts();
//
//        Product userProduct = null;
//        for (Product product : products) {
//            if (product.getId() == productId) {
//                userProduct = product;
//                break;
//            }
//        }
//
//        if (loggedInUser.getUserCart() != null) {
//            Cart cart = loggedInUser.getUserCart();
//
//            boolean isFound = false;
//            for (CartProduct cartProduct : cart.getCartProducts()) {
//                if (cartProduct.getProduct().getId() == productId) {
//                    cartProduct.setCount(cartProduct.getCount() + 1);
//                    isFound = true;
//                }
//            }
//
//            if (!isFound) {
//                cart.getCartProducts().add(new CartProduct(userProduct, 1));
//            }
//
//            loggedInUser.setUserCart(cart);
//        } else {
//            Cart cart = new Cart();
//            ArrayList<CartProduct> cartProducts = new ArrayList<>();
//            cartProducts.add(new CartProduct(userProduct, 1));
//            cart.setCartProducts(cartProducts);
//            loggedInUser.setUserCart(cart);
//        }
//        setLoggedInUser(loggedInUser);
//    }
//
//    @Override
//    public void printcart() {
//
//    }
//
//    private void checkout() {
//        orderController.checkout();
//    }
//
//    private void invalidChoice(AppException appException) {
//        println(appException.getMessage());
//        printcart();
//    }
    private List<Product> cart;

    public CartController(HomeController homeController) {
        this.cart = new ArrayList<>();
    }


    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart:");
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i).getTitle() +
                        " $" + cart.get(i).getPrice() +
                        " " + cart.get(i).getDescription());
            }
        }
    }

    public void clearCart() {
        cart.clear();
        System.out.println("Cart cleared.");
    }

    public void saveCartToCSV() throws IOException {
        try (FileWriter writer = new FileWriter(FileUtil.CartFile())) {
            writer.write("id,title,price,stocks,category\n");

            for (Product product : cart) {
                writer.write(product.getId() + "," +
                        product.getTitle() + "," +
                        product.getPrice() + "," +
                        product.getStocks() + "," +
                        product.getCategory().getName() + "\n");
            }

            System.out.println("Cart saved to CSV file.");
        } catch (IOException e) {
            System.out.println("Error saving cart to CSV file: " + e.getMessage());
        }
//        CSVWriter writer = new CSVWriter(new FileWriter("src/main/java/org/nishanth/assets/cart.csv"));
//        //Writing data to a csv file
//        CSVWriter.write("id", "title", "price", "stocks", "category");
//        for (Product product : cart) {
//            CSVWriter.write(product.getId()+","+)
//        }
//
//        //Writing data to the csv file
//        writer.writeNext(line1);
//        writer.flush();
//        System.out.println("Data entered");
//        Scanner sc = new Scanner(new File("src/main/java/org/nishanth/assets/cart.csv"));
//        sc.useDelimiter(",");
//        public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
//            File csvOutputFile = new File(cart.csv);
//            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
//                Arrays dataLines;
//                dataLines.stream()
//                        .map(this::convertToCSV)
//                        .forEach(pw::println);
//            }
//            assertTrue(csvOutputFile.exists());
//        }

    }


    @Override
    public void addtocart(int productId) {
        Product product = null;
        cart.add(product);
        System.out.println("Product added to the cart: " + product.getTitle());

    }

    @Override
    public void printcart() {


    }
}

