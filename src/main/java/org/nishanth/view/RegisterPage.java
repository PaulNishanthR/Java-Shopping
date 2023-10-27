package org.nishanth.view;

import org.nishanth.utils.StringUtil;

import static org.nishanth.utils.Utils.println;

public class RegisterPage {
    public void printRegistrationSuccessful() {
        try {
            println("#---------------------#");
            println(StringUtil.REGISTRATION_SUCCESSFULL);
            println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void passwordMisMatch() {
        try {
            println("#---------------------#");
            println(StringUtil.PASSWORD_MISMATCH);
            println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
