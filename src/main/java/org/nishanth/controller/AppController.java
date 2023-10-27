package org.nishanth.controller;

import org.nishanth.controller.impl.IAppController;
import org.nishanth.view.WelcomePage;

public class AppController implements IAppController {
    private final WelcomePage welcomePage;
    private final AuthController authController;

    public AppController(){
        welcomePage=new WelcomePage();
        authController=new AuthController(this);
    }
    @Override
    public void init() {
    welcomePage.welcome();
    authController.authMenu();
    }

    @Override
    public void printAuthMenu(){
        welcomePage.printAuthMenu();
    }
}
