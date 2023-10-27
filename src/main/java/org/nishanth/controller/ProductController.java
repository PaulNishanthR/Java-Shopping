package org.nishanth.controller;

import org.nishanth.controller.impl.IProductController;
import org.nishanth.models.Category;
import org.nishanth.models.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.nishanth.utils.FileUtil.getProductsFile;

public class ProductController implements IProductController {
    private Product getProducts(int id, String title, double price, int stocks, Category category) {
        try {
            Scanner sc = new Scanner(getProductsFile());
            while (sc.hasNext()) {
                String val = sc.next();
                if (!val.startsWith("id")) {
                    String[] userProd = val.split(",");
                    if (userProd[1].equals(title) && userProd[2].equals(price) && userProd[3].equals(stocks) && userProd[4].equals(category)) {
                        Product product = new Product();
//                        Product.setId(Integer.parseInt(userProd[0]));
//                        Product.setTitle(userProd[1]);
//                        Product.setPrice(userProd[2]);
//                        Product.setStocks(userProd[3]);
//                        Product.setCategory(userProd[4]);


                    }
                }

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
