package org.nishanth.controller;

import org.nishanth.controller.impl.IHomeController;
import org.nishanth.utils.AppException;
import org.nishanth.utils.StringUtil;
import org.nishanth.view.HomePage;

import static org.nishanth.utils.AppInput.enterInt;
import static org.nishanth.utils.Utils.println;

public class HomeController implements IHomeController {

    private final AuthController authController;
    private final HomePage homePage;

    public HomeController(AuthController authController) {
        this.authController = authController;
        homePage = new HomePage();
    }


    @Override
    public void printMenu() {

//        System.out.println("Hiii");
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtil.ENTER_CHOICE);
            switch (choice) {
                case 1:
                    //category
                case 2:
                    //product
                case 3:
                    //cart
                case 4:
                    //order
                case 5:
                    //logout
                default:
                    invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
            }

        } catch (AppException e) {
            invalidChoice(e);

        }
    }

    private void invalidChoice(AppException e) {
        println(e.getMessage());


    }
}
