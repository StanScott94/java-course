package com.stantonscott.javabasics.compilation;

public class Main {

    private static final String WARNING = "No arguments";

    public static void main(String[] args) {

        int sum = 0;

        if (args.length > 0 && args.length >= 3) {

            for (int i = 0; i < 3; i++) {
                sum = sum + Integer.valueOf(args[i]);
                System.out.print(args[i]);
            }


        } else {
            System.out.print(WARNING);
        }
    }
}