package com.tallinn.six.recap.Task19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UtilitiesForDogsHash {
    private static Scanner scan = new Scanner(System.in);
    HashMap<String, Dog> dogs = new HashMap<>();

    public void add() {
        System.out.println("Please write dog name for adding: ");
        String dogName = scan.nextLine();
        boolean doesExist = false;
        for (Map.Entry<String, Dog> entry : dogs.entrySet()) {
            if (dogName.equals(entry.getKey())) {
                System.out.println("Dog " + dogName + " already exists.");
                doesExist = true;
                break;
            }
        }
        if (!doesExist) {
            System.out.println("Please write dog species: ");
            String dogSpecies = scan.nextLine();
            System.out.println("Please write dog age: ");
            int dogAge = Integer.parseInt(scan.nextLine());
            Dog dog = new Dog(dogName, dogSpecies, dogAge);
            dogs.put(dogName, dog);
            System.out.println("Dog added");
        }
    }

    public void remove() {
        System.out.println("Please write dog name for removing: ");
        String dogName = scan.nextLine();
        boolean doesExist = false;
        for (Map.Entry<String, Dog> entry : dogs.entrySet()) {
            if (dogName.equals(entry.getKey())) {
                doesExist = true;
                break;
            }
        }
        if (!doesExist) {
            System.out.println("Dog " + dogName + " not existing. Can't remove");
        } else {
            dogs.remove(dogName);
            System.out.println("Dog removed");
        }
    }

    public void view() {
        System.out.println("Printing out dogs and all information about them:");
        System.out.println("--------------------------------------------------");
        for (Map.Entry<String, Dog> entry : dogs.entrySet()) {
            Dog currenDog = entry.getValue();
            System.out.println("Name: " + currenDog.getName()
                    + ", age: " + currenDog.getAge()
                    + ", species: " + currenDog.getSpecies());
        }
        System.out.println("--------------------------------------------------");
    }

    public void search() {
        System.out.println("Please write dog name for searching: ");
        String dogName = scan.nextLine();
        boolean doesExist = false;
        System.out.println("Dogs found: ");
        System.out.println("===============");
        for (Map.Entry<String, Dog> entry : dogs.entrySet()) {
            if (dogName.equalsIgnoreCase(entry.getKey())) {
                Dog currenDog = entry.getValue();
                System.out.println("Name: " + currenDog.getName()
                        + ", age: " + currenDog.getAge()
                        + ", species: " + currenDog.getSpecies());
                doesExist = true;
            }
        }
        if (!doesExist) {
            System.out.println("Dog " + dogName + " not found.");
        }
        System.out.println("===============");
    }


}
