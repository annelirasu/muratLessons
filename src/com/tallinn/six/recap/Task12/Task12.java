package com.tallinn.six.recap.Task12;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
/*        Dog aHusky=new Dog("Hundu","husky",8);
        aHusky.printAllAbout();
        Dog aChihuahua=new Dog("Caty","chihuahua",3);
        aChihuahua.printAllAbout();
        Dog aBeagle=new Dog("Wowh","beagle",2);
        aBeagle.printAllAbout();
        try {
            Dog aWrongDog = new Dog("Pitsu", "boxer", 3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
        System.out.println("Welcome stranger");
        System.out.println("Enter your dog name: ");
        Scanner scan = new Scanner(System.in);
        String dogName = scan.nextLine();
        System.out.println("Enter your dog age: ");
        int age = Integer.parseInt(scan.nextLine());
        while (age < 0) {
            System.out.println("Dog age cannot be negative!");
            System.out.println("Enter your dog age: ");
            age = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Enter your dog species: ");
        String species = scan.nextLine();
        boolean isBeagle = species.equalsIgnoreCase("beagle");
        boolean isHusky = species.equalsIgnoreCase("husky");
        boolean isChihuahua = species.equalsIgnoreCase("chihuahua");
        while (!(isBeagle || isChihuahua || isHusky)) {
            System.out.println("Species can be only beagle, husky or chihuahua!");
            System.out.println("Enter your dog species: ");
            species = scan.nextLine();
            isBeagle = species.equalsIgnoreCase("beagle");
            isHusky = species.equalsIgnoreCase("husky");
            isChihuahua = species.equalsIgnoreCase("chihuahua");
        }
        Dog aDog = new Dog(dogName, species, age);
        aDog.printAllAbout();

    }
}
