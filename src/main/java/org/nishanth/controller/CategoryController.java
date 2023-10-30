package org.nishanth.controller;

import org.nishanth.controller.impl.ICategoryController;
import org.nishanth.utils.AppException;
import org.nishanth.utils.StringUtil;
import org.nishanth.view.CategoryPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.nishanth.utils.AppInput.enterInt;
import static org.nishanth.utils.Utils.println;

//public class CategoryController implements ICategoryController {
//    private final CategoryPage categoryPage;
//    private final HomeController homeController;
//    private final ProductController productController;
//    public CategoryController(HomeController homeController){
//        this.homeController=homeController;
//        productController=new ProductController();
//        categoryPage=new CategoryPage();
//    }
//    public static void printMenu() {
////        ArrayList<>
//
//    }
//}

public class CategoryController {
    private static  HomeController homeController = null;

    public CategoryController(HomeController homeController) {

        this.homeController = homeController;
    }



    public void displayCategories() {
        println("1. mobile");
        println("2. watch");

    }

    public static void chooseCategory() {

        try {
            int categoryChoice = 0;
            categoryChoice = enterInt(StringUtil.ENTER_CHOICE);
            switch (categoryChoice) {
                case 1:
                    displayProductsByCategory("mobile");
                    break;
                case 2:
                    displayProductsByCategory("watch");
                    break;
                case 88:
                    checkout();
                    break;
                case 99:
                    homeController.printMenu();
                    break;
                default:
                    invalidChoice(new AppException("Invalid category choice."));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }

    }

    private static void displayProductsByCategory(String category) {
        println("Products in " + category + ":");

        ArrayList<String[]> products =(ArrayList<String[]>) readProductsFromFile();

        for (String[] product : products) {
            if (product.length >= 5 && product[4].equalsIgnoreCase(category)) {
                println(product[0] + ". " + product[1] + " Price: Rs. " + product[2] + " " + product[3]);
            }
        }



    }

    private static List<String[]> readProductsFromFile() {
        ArrayList<String[]> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/nishanth/assets/products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productArray = line.split(",");
                products.add(productArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    private static void checkout() {

    }

    static void invalidChoice(AppException e) {
        println(e.getMessage());
        chooseCategory();
    }
}
