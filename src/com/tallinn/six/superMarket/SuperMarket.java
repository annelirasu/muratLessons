package com.tallinn.six.superMarket;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SuperMarket {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void printAllProducts() {

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat dFormat = new DecimalFormat("#.00");
        dFormat.setDecimalFormatSymbols(otherSymbols);
        for (Product p : products
        ) {
            System.out.print(p.getName() + " ");
            System.out.printf(dFormat.format(p.getPrice()));
            System.out.println(" eur.");
        }
    }

    public void insertProduct(Product p) {
        this.products.add(p);

    }

    public void deleteProduct(String productName) {
        int i = getIndexOfProduct(productName); //oluline, et oleks samast mäluruumist
        this.products.remove(i);
    }

    public int getIndexOfProduct(String productName) {
        int index = -1;
        for (int i = 0; i < this.products.size(); i++) {
            if (productName.equalsIgnoreCase(this.products.get(i).getName())) {
                index = i;
            }
        }
        return index;

    }

}
