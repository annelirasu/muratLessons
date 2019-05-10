package com.tallinn.six.recap.Task17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome stranger to Dog Administration");
        UtilitiesForDogs uts = new UtilitiesForDogs();

        while (true) {
            System.out.println("What you wanna do? add/search/view/done");
            String order = scan.nextLine();


            if (order.equalsIgnoreCase("add")) {
                uts.add();

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

    private static class UtilitiesForDogs {
        List<Dog> dogs = new ArrayList<>();

        void add() {
            System.out.println("Enter your dog name: ");

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

            Dog newDog = new Dog(dogName, species, age);
            dogs.add(newDog);
            System.out.println("Dog is entered.");
        }

        void view() {
            if (dogs.isEmpty()) {
                System.out.println("Array is empty, nothing to view.");
            } else {
                System.out.println("Printing all dogs: ");
                System.out.println("***************************");
                printDogs();
                System.out.println("***************************");

            }

        }

        void search() {
            if (dogs.isEmpty()) {
                System.out.println("There are not one dog, nothing to search.");
            } else {

                System.out.println("Please write dog's name for searching: ");
                String name = scan.nextLine();
                boolean found = false;
                ArrayList<Dog> foundDogs = new ArrayList<>();
                for (Dog dog : dogs
                ) {
                    if (dog.getName().equalsIgnoreCase(name)) {
                        found = true;
                        foundDogs.add(dog);
                    }
                }
                if (!found) {
                    System.out.println("Can't find " + name);
                }else{
                    System.out.println("System found the dog: ");
                    printDogsFromList(foundDogs);
                }

            }

        }
        private void printDogs(){
            for (Dog dog : this.dogs
            ) {
                System.out.println("Dog name: " + dog.getName() + ", age: " + dog.getAge() + ", species: "+dog.getSpecies());
            }
        }
        private void printDogsFromList(ArrayList<Dog> list){
            for (Dog dog : list
            ) {
                System.out.println("Dog name: " + dog.getName() + ", age: " + dog.getAge() + ", species: "+dog.getSpecies());
            }
        }


    }


}


