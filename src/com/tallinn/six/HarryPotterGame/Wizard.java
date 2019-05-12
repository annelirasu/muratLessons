package com.tallinn.six.HarryPotterGame;

import java.util.ArrayList;

 class Wizard {
    /**
     * health 100 default value
     * money 100 default value
     * name and surname
     * it will have knowledge of the spell names he bought.
     */
    private String firstName;
    private String lastName;

    private int health = 100;
    private int money = 100;
    private ArrayList<String> boughtSpells = new ArrayList<>();

     Wizard(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

     int getHealth() {
        return health;
    }

     void setHealth(int health) {
        this.health = health;
    }

     int getMoney() {
        return money;
    }

    void setMoney(int money) {
        this.money = money;
    }

    String getFirstName() {
        return firstName;
    }


    String getLastName() {
        return lastName;
    }


     void setSpell(String spellName) {
        boughtSpells.add(spellName);
    }

     ArrayList<String> getBoughtSpells() {
        return boughtSpells;
    }

     void setBoughtSpells(ArrayList<String> boughtSpells) {
        this.boughtSpells = boughtSpells;
    }

    boolean isBoughtSpell(String spellName) {
     /*   for (String name : this.boughtSpells
        ) {
            if (spellName.equals(name)) {
                return true;
            }
        }*/

        return this.boughtSpells.contains(spellName);
    }
}
