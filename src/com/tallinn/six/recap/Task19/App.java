package com.tallinn.six.recap.Task19;

import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Storage");
        UtilitiesForDogsHash uts = new UtilitiesForDogsHash();

        while (true) {
            System.out.println("What you wanna do? add/remove/search/view/done");
            String order = scan.nextLine();


            if (order.equalsIgnoreCase("add")) {
                uts.add();

            } else if (order.equalsIgnoreCase("remove")) {
                uts.remove();

            } else if (order.equalsIgnoreCase("view")) {
                uts.view();

            } else if (order.equalsIgnoreCase("search")) {
                uts.search();

            } else if (order.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
