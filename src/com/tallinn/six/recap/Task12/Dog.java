package com.tallinn.six.recap.Task12;


public class Dog {
    private String name;
    private String species;
    private int age;

    public Dog(String name, String species, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age is not valid!");
        }
        //beagle husky and Chihuahua
        boolean isBeagle=species.equalsIgnoreCase("beagle");
        boolean isHusky=species.equalsIgnoreCase("husky");
        boolean isChihuahua=species.equalsIgnoreCase("chihuahua");
        if(isBeagle||isChihuahua||isHusky){
            this.name = name;
            this.species = species;
            this.age = age;
        }else{
            throw new IllegalArgumentException("Species can be only beagle, husky or chihuahua!");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getAgeDecision() {
        if (this.species.equalsIgnoreCase("husky")) {
            if (this.age < 4) {
                System.out.println(getName() + " is young.");
            } else if (this.age >= 4 && this.age <= 7) {
                System.out.println(getName() + " is adult.");
            } else {
                System.out.println(getName() + " is old.");
            }
        } else if (this.species.equalsIgnoreCase("beagle")) {
            if (this.age < 3) {
                System.out.println(getName() + " is young.");
            } else if (this.age >= 3 && this.age <= 6) {
                System.out.println(getName() + " is adult.");
            } else {
                System.out.println(getName() + " is old.");
            }
        } else {
            if (this.age < 3) {
                System.out.println(getName() + " is young.");
            } else if (this.age >= 3 && this.age <= 7) {
                System.out.println(getName() + " is adult.");
            } else {
                System.out.println(getName() + " is old.");
            }
        }
    }

    public void printAllAbout(){
        System.out.println("Dog's name: "+getName()+", it's species:  "+getSpecies()+" and it's age: "+getAge());
        getAgeDecision();
    }
}
