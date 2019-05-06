package com.tallinn.six.recap.Task15;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Account {
    public static void main(String[] args) {
        AuctionedItem item1 = new AuctionedItem("golden necklace", "300.8567473");
        AuctionedItem item2 = new AuctionedItem("silver ring with brilliant", "200.2367463");
        AuctionedItem item3 = new AuctionedItem("grandma's shoes", "10.234");
        AuctionedItem item4 = new AuctionedItem("grandpa's pipe", "40.1315");
        AuctionedItem item5 = new AuctionedItem("old chess clock", "100.12133536");
        //add to auction
        Account account = new Account();
        account.addItemToAuction(item1);
        account.addItemToAuction(item1);
        account.addItemToAuction(item2);
        account.addItemToAuction(item3);
        account.addItemToAuction(item4);
        account.addItemToAuction(item5);

        account.printItemsInAuction();
        account.newOffer("Grandma's Shoes","5.00");
        account.newOffer("Grandma's Shoes","15.00");
        account.sellItem("Grandma's Shoes");
        account.printItemsInAuction();
        account.sellItem("golden necklace");
        account.sellItem("golden necklace");
        account.sellItem("old chess clock");
        account.printItemsInAuction();

    }

    private List<AuctionedItem> itemsInAuction = new LinkedList<>();
    private BigDecimal balance = new BigDecimal("0");

    public List<AuctionedItem> getItemsInAuction() {
        LinkedList<AuctionedItem> copy = new LinkedList<>(itemsInAuction);
        return copy;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addItemToAuction(AuctionedItem item) {
        if (foundItem(item)) {
            System.out.println(item.getName() + " already added to the auction!");
        } else {
            this.itemsInAuction.add(item);
            System.out.println("Item added");
        }

    }

    private boolean foundItem(AuctionedItem item) {
        for (AuctionedItem ai : this.itemsInAuction
        ) {
            if (ai.equals(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean foundItem(String itemName) {
        for (AuctionedItem ai : this.itemsInAuction
        ) {
            if (ai.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    private AuctionedItem giveItem(String itemName) {
        if (!foundItem(itemName)) {
            System.out.println("No such item: " + itemName + "in auction");
            return null;
        } else {

            for (AuctionedItem ai : this.itemsInAuction
            ) {
                if (ai.getName().equalsIgnoreCase(itemName)) {
                    return ai;

                }
            }

        }
        return null;
    }

    public void printItemsInAuction() {
        System.out.println("========================== ");
        System.out.println("Remining auctioned items: ");
        for (AuctionedItem ai : this.itemsInAuction
        ) {
            System.out.println("\t item: " + ai.getName() + " price: " + ai.getPrice());
        }
        System.out.println("========================== ");

    }

    public void sellItem(String itemName) {
        if (!foundItem(itemName)) {
            System.out.println("------------------------------------------------");
            System.out.println("Can't sell " + itemName + ", no such item in auction");
            System.out.println("------------------------------------------------");
        } else {

            BigDecimal price = new BigDecimal("0.0");
            BigDecimal initialBalance = this.getBalance();
            BigDecimal newBalance = new BigDecimal("0.0");
            AuctionedItem itemsold;
            for (AuctionedItem ai : this.itemsInAuction
            ) {
                if (ai.getName().equalsIgnoreCase(itemName)) {
                    price = ai.getPrice();
                    this.itemsInAuction.remove(ai);
                    System.out.println("Item is sold: " + ai.getName());
                    break;
                }
            }
            newBalance = initialBalance.add(price);
            this.setBalance(newBalance);

            System.out.println("Your balance is: " + getBalance().toString());
        }
    }

    public void newOffer(String itemName, String newPrice) {
        BigDecimal offeredPrice = new BigDecimal(newPrice);
        BigDecimal oldPrice = giveItem(itemName).getPrice();
        if (oldPrice.compareTo(offeredPrice) == 0 || oldPrice.compareTo(offeredPrice) == 1) {
            System.out.println("-------------------------------------");
            System.out.println("Your offer is lower than old price!");
            System.out.println("--------------------------------------");
        } else {
            for (AuctionedItem ai : this.itemsInAuction
            ) {
                if (ai.getName().equalsIgnoreCase(itemName)) {
                    ai.setPrice(offeredPrice);
                    System.out.println(ai.getName() + " has now new price: " + ai.getPrice());
                    System.out.println("************************************************");
                    break;
                }
            }
        }
    }

}
