package com.tallinn.six.recap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task18 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Storage");
        UtilitiesForStorage uts=new UtilitiesForStorage();

        while (true) {
            System.out.println("What you wanna do? add/remove/search/view/done");
            String order = scan.nextLine();


            if (order.equalsIgnoreCase("add")) {
                uts.add();

            } else if (order.equalsIgnoreCase("remove")) {
               uts.remove();

            } else if (order.equalsIgnoreCase("view")) {
                uts.view();

            }else if (order.equalsIgnoreCase("search")) {
               uts.search();

            } else if (order.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Unknown command");
            }
        }


    }

    private static class UtilitiesForStorage{
        HashMap<String, BigDecimal> storageItems=new HashMap<>();


        public void add() {
            System.out.println("Please write item name for adding: ");
            String itemName = scan.nextLine();
            boolean doesExist = false;
            for (Map.Entry<String, BigDecimal> entry : storageItems.entrySet()) {
                if (itemName.equals(entry.getKey())) {
                    System.out.println("Item " + itemName + " already exists.");
                    doesExist=true;
                    break;
                }
            }
            if (!doesExist) {
                System.out.println("Please write item price for adding: ");
                String itemPriceS = scan.nextLine();
                BigDecimal itemPrice=new BigDecimal(itemPriceS).setScale(2, BigDecimal.ROUND_HALF_UP);
                //siin veahaldus
                storageItems.put(itemName,itemPrice);
                System.out.println("Item added");
            }

        }

        public void remove() {
            System.out.println("Please write item name for removing: ");
            String itemName = scan.nextLine();
            boolean doesExist = false;
            for (Map.Entry<String, BigDecimal> entry : storageItems.entrySet()) {
                if (itemName.equals(entry.getKey())) {
                    doesExist=true;
                    break;
                }
            }
            if (!doesExist) {
                System.out.println("Item "+itemName+" not existing in storage. Can't remove");


            }else{
                storageItems.remove(itemName);
                System.out.println("Item removed");
            }
        }

        public void view() {
            System.out.println("Printing out items and prices:");
            System.out.println("--------------------------------");
            for (Map.Entry<String, BigDecimal> entry : storageItems.entrySet()) {
                System.out.println("Item name: "+entry.getKey()+", price: "+entry.getValue());

            }
            System.out.println("--------------------------------");

        }
        public void search() {
            System.out.println("Please write item name for searching: ");
            String itemName = scan.nextLine();
            boolean doesExist = false;
            System.out.println("Items found: ");
            System.out.println("===============");
            for (Map.Entry<String, BigDecimal> entry : storageItems.entrySet()) {
                if (itemName.equalsIgnoreCase(entry.getKey())) {
                    System.out.println("Item " + entry.getKey() + ", price "+entry.getValue());
                    doesExist=true;
                }
            }
            if(!doesExist){
                System.out.println("Item "+itemName+" not found in Storage.");
            }
            System.out.println("===============");

        }
    }
}
