package org.nishanth.utils;

import java.io.File;
import java.util.Scanner;

public class AppScanner {
    private static Scanner scanner;
    private static Scanner FileScanner;
    public static Scanner getScanner(){
        if(scanner==null)
            scanner=new Scanner(System.in);
        return scanner;
    }

    public static Scanner getScanner(File file) {
        if(FileScanner==null)
            FileScanner=new Scanner(System.in);
        return FileScanner;
    }
}
