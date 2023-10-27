package org.nishanth.view;

import org.nishanth.utils.StringUtil;

import static org.nishanth.utils.Utils.println;

public class WelcomePage {
    public void printAuthMenu() {
        println(StringUtil.AUTH_MENU);
    }

    public void welcome() {
        try {
            println(StringUtil.WELCOME_MESSAGE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    void check(){
//        System.out.println();
//    }
}
