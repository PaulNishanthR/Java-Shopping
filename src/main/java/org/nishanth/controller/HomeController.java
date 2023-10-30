package org.nishanth.controller;

import org.nishanth.controller.impl.IHomeController;
import org.nishanth.models.Product;
import org.nishanth.utils.AppException;
import org.nishanth.utils.StringUtil;
import org.nishanth.view.HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.nishanth.utils.AppInput.enterInt;
import static org.nishanth.utils.UserUtils.setLoggedInUser;
import static org.nishanth.utils.Utils.println;

public class HomeController implements IHomeController {

    private final AuthController authController;
    private final HomePage homePage;
    private final ProductController productController;
    private final CartController cartController;
    private final CategoryController categoryController;
    private final OrderController orderController;
    private List<Product> cart;
    private Product product;

    public HomeController(AuthController authController) {
        this.authController = authController;
        homePage = new HomePage();
        productController = new ProductController(this);
        cartController = new CartController(this);
        categoryController = new CategoryController(this);
        orderController=new OrderController(this);
        this.cart=new ArrayList<>();
    }


    @Override
    public void printMenu() {

//        System.out.println("Hiii");
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtil.ENTER_CHOICE);
            switch (choice) {
                case 1:
                    displayCategories();
                    break;
                case 2:
                    productController.loadproduct();
                    productController.selectProductAndAddToCart();
                    break;
                case 3:
                    cartController.viewCart();
                    cartController.saveCartToCSV();
                    break;
                case 4:
                    //order
                    break;
                case 5:
                    setLoggedInUser(null);
                    authController.authMenu();
                    break;
                default:
                    invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }

        } catch (AppException e) {
            invalidChoice(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayCategories() {
        println("1. mobile");
        println("2. watch");
        println("88. Checkout");
        println("99. Go Back");
        categoryController.chooseCategory();
    }

    private void invalidChoice(AppException e) {
        println(e.getMessage());
        printMenu();


    }

    public void loadProducts(String Category) {

    }

    public void addToCart(Product selectedProduct) {
//        Product product = null;
        cart.add(product);
    }
}
