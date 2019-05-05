package com.tallinn.six.superMarket;

public class PlayGround {
    public static void main(String[] args) {
        Product sokipaar=new Product("Pair of Socks",5.60);
        sokipaar.setQuantity(3);

        Product myts=new Product("Hat",20.00);
        myts.setQuantity(2);

        Product kasukas=new Product("Coat",300.00);
        myts.setQuantity(4);

        Product pross=new Product("Brooch",50.0035);
        myts.setQuantity(4);


        SuperMarket superMarket= new SuperMarket();
        superMarket.insertProduct(sokipaar);
        superMarket.insertProduct(myts);
        superMarket.insertProduct(kasukas);
        superMarket.insertProduct(pross);
        superMarket.printAllProducts();

        System.out.println("=== after deleting Hat ======");
        superMarket.deleteProduct("Hat");
        superMarket.printAllProducts();
        System.out.println("Index of the brooch is: "+superMarket.getIndexOfProduct("Brooch"));
    }
}
