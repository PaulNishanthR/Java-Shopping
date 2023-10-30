package org.nishanth.controller;

import org.nishanth.controller.impl.IHomeController;
import org.nishanth.controller.impl.IProductController;
import org.nishanth.models.Category;
import org.nishanth.models.Product;
import org.nishanth.utils.AppException;
import org.nishanth.utils.FileUtil;
import org.nishanth.utils.Utils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static org.nishanth.controller.CategoryController.invalidChoice;
import static org.nishanth.utils.Utils.println;

public class ProductController implements IHomeController {
    private final HomeController homeController;
//    private Product getProducts(int id, String title, double price, int stocks, Category category) {
//        try {
//            Scanner sc = new Scanner(getProductsFile());
//            while (sc.hasNext()) {
//                String val = sc.next();
//                if (!val.startsWith("id")) {
//                    String[] userProd = val.split(",");
//                    if (userProd[1].equals(title) && userProd[2].equals(price) && userProd[3].equals(stocks) && userProd[4].equals(category)) {
//                        Product product = new Product();
////                        Product.setId(Integer.parseInt(userProd[0]));
////                        Product.setTitle(userProd[1]);
////                        Product.setPrice(userProd[2]);
////                        Product.setStocks(userProd[3]);
////                        Product.setCategory(userProd[4]);
//
//
//                    }
//                }
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

    public ProductController(HomeController homeController) {

this.homeController=homeController;
    }

    public Product loadproduct() {
        try {
            Scanner scanner = new Scanner(FileUtil.getProductsFile());
            while (scanner.hasNext()) {
                String product = scanner.next().trim();
                if (!product.startsWith("id")) {
                    String[] userArray = product.split(",");
                    println(userArray[0] + ". " + userArray[1] + " Rs. " + userArray[2] + " " + userArray[3]);
                }
            }
        } catch (Exception e) {

        }
        return null;
    }


    @Override
    public void printMenu() {
        try {
            loadproduct();
            selectProductAndAddToCart();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void selectProductAndAddToCart() {
        try {
            Scanner inputScanner = new Scanner(System.in);

            Utils.print("Enter the ID of the product to add to the cart");
            int selectedProductId = inputScanner.nextInt();

            if (selectedProductId == 0) {
                return;
            }

            Scanner scanner = new Scanner(FileUtil.getProductsFile());
            while (scanner.hasNext()) {
                String productString = scanner.next().trim();
                if (!productString.startsWith("id")) {
                    String[] productArray = productString.split(",");

                    System.out.println("Product Array in CSV: " + Arrays.toString(productArray));

                    if (!productArray[0].matches("\\d+")) {
                        System.err.println("Invalid product ID: " + productArray[0]);
                    }

                    int productId = Integer.parseInt(productArray[0]);
                    String title = productArray[1];
                    double price = Double.parseDouble(productArray[2]);
                    int stocks = Integer.parseInt(productArray[3]);
                    String category = productArray[4];

                    if (productId == selectedProductId) {
                        Product selectedProduct = new Product(
                                productId,
                                title,
                                "",
                                price,
                                stocks,
                                new Category(category)
                        );

                        // Add the selected product to the cart
                        homeController.addToCart(selectedProduct);

                        // Print a confirmation message
                        Utils.println("Product added to the cart: " + selectedProduct.getTitle());
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void invalidChoice(Exception e){
        e.printStackTrace();
    }
}
