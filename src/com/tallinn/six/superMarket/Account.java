package com.tallinn.six.superMarket;

import java.util.ArrayList;

public  class Account {
    private double balance;
    private ArrayList<Product> productsOfClient = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Product> getProductsOfClient() {
        return productsOfClient;
    }

    public void setProductsOfClient(ArrayList<Product> productsOfClient) {
        this.productsOfClient = productsOfClient;
    }

    public void printAccountInfo() {
        System.out.println("Balance is " + this.balance);
        System.out.println("Product list of this account: ");
        for (Product p : this.productsOfClient
        ) {
            System.out.println(p.getName() + " " + p.getQuantity() + " tk");
        }

    }

    public boolean deduct(double cost) { //is there enough money for buying?
        if (cost > this.balance) {
            return false;
        }
        return true;
    }

    public void addUpdateProduct(Product p, int amount) {

        boolean foundIndex = false;

        while (true) {
            for (Product product : this.productsOfClient) {
                if (product.equals(p)) {
                    product.setQuantity(product.getQuantity() + amount);
                    foundIndex = true;
                    break;
                }
            }
            if (!foundIndex) {
                p.setQuantity(amount);
                this.productsOfClient.add(p);
            }

            //kui olemas, siis suurendab kogust
        }
    }
}

