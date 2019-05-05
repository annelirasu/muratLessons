package com.tallinn.six.superMarket;

import java.util.Scanner;

public class superMarketApplication {
    public static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        SuperMarket market=new SuperMarket();
        System.out.println("Welcome Admine to the Super Market Application");


        while(true) {
            System.out.println("What do you want to do: Add - Remove - Print - Done");
            //if admin writes Done, then this part is completed
            String order = scanner.nextLine();

            if (order.equalsIgnoreCase("add")) {
                add(market);
            }else if (order.equalsIgnoreCase("remove")) {
                remove(market);
            }else if(order.equalsIgnoreCase("done")){
                break;
            }else if(order.equalsIgnoreCase("print")){
                market.printAllProducts();
            }else{
                System.out.println("You inserted invalid order");
            }
        }
    }

    public static void add(SuperMarket market){
        System.out.println("Give me a name of the product: ");
        String productName=scanner.nextLine();
        //check if already exists
        int indexOfProduct=market.getIndexOfProduct(productName);
        if(indexOfProduct==-1) {
            System.out.println("Give me the price of the product: ");
            Double productPrice = Double.parseDouble(scanner.nextLine());
            market.insertProduct(new Product(productName, productPrice));
            System.out.println("Product " + productName + " added.");
        }else{
            System.out.println("Product already exists in market.");
        }
    }

    public static void remove(SuperMarket market){
        System.out.println("Give me the name of the product you wanna remove: ");

        String productName=scanner.nextLine();
        int indexOfProduct=market.getIndexOfProduct(productName);
        if(indexOfProduct==-1) {
            System.out.println("Can't remove, ");

        }else {
            market.deleteProduct(productName);
            System.out.println("Product " + productName + " removed.");
        }
    }
}
