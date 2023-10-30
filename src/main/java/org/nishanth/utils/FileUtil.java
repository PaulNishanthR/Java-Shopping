package org.nishanth.utils;

import java.io.File;

public class FileUtil {
    private static File credentialFile;
    private static File productFile;
    private static File cartFile;

    public static File getCredentialFile() {
        if (credentialFile == null)
            credentialFile = new File("src/main/java/org/nishanth/assets/credentials.csv");
        return credentialFile;
    }

    public static File getProductsFile(){
        if(productFile==null)
            productFile=new File("src/main/java/org/nishanth/assets/products.csv");
        return productFile;
    }
    public static File CartFile() {
        if(cartFile==null){
            cartFile=new File("src/main/java/org/nishanth/assets/cart.csv");
        }
        return cartFile;
    }
}
