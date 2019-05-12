package com.tallinn.six.HarryPotterGame;

import java.util.ArrayList;

public class Wizard {
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

    public Wizard(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setSpell(String spellName) {
        boughtSpells.add(spellName);
    }

    public ArrayList<String> getBoughtSpells() {
        return boughtSpells;
    }

    public void setBoughtSpells(ArrayList<String> boughtSpells) {
        this.boughtSpells = boughtSpells;
    }

    public boolean isBoughtSpell(String spellName) {
     /*   for (String name : this.boughtSpells
        ) {
            if (spellName.equals(name)) {
                return true;
            }
        }*/
     if(this.boughtSpells.contains(spellName)) return true;
        return false;
    }
}
