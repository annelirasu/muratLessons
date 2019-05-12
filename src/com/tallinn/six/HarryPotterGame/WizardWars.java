package com.tallinn.six.HarryPotterGame;

import java.util.Arrays;
import java.util.Scanner;

public class WizardWars {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Wizard Wars. Lets create our character.");
        System.out.println("Please enter your characters' first name");
        String firstName = scan.nextLine();
        while (!CharacterCreation.validateFirstName(firstName)) {
            System.out.println("Please enter your character's first name");
            firstName = scan.nextLine();
        }
        System.out.println("Please enter your character's surname");
        String lastName = scan.nextLine();
        while (!CharacterCreation.validateLastName(lastName)) {
            System.out.println("Please enter your character's surname");
            lastName = scan.nextLine();
        }
        Wizard wiz = new Wizard(firstName, lastName);
        System.out.println("Welcome " + wiz.getFirstName() + " " + wiz.getLastName() + "! Prepare to die!");
        WizardShop shop = new WizardShop();

        System.out.println("Welcome to Wizard Shop. ");
        System.out.println("Can I take your order? Write spell Name to buy or write \"done\" if you want to finish buying : ");
        shop.printSpellsWithPrices();
        String spellName = scan.nextLine();

        while (!spellName.equalsIgnoreCase("done")) {
            shop.buySpell(spellName, wiz);
            System.out.println("-----------------------------------");
            System.out.println("Write one more spell Name to buy or write \"done\" if you want to finish buying : ");
            spellName = scan.nextLine();
        }

        System.out.println("You know now next spells: ");
        System.out.println(Arrays.toString(wiz.getBoughtSpells().toArray()));
        Opponent op = new Opponent("Lord", "Voldemort");

        System.out.println("\n Let's battle now!");
        System.out.println("Say your spell: ");

        String spellWord = scan.nextLine();
        while (!wiz.isBoughtSpell(spellWord)) {
            System.out.println("You didn't bought the Spell: " + spellWord + ", please use something you bought: ");
            spellWord = scan.nextLine();
        }
        SpellUtilities uts = new SpellUtilities();
        boolean continues = uts.battle(wiz, op, spellWord);//nullpointer exeption
        while (continues) {

            System.out.println("Battle continues - say your spell: ");
            spellWord = scan.nextLine();
            while(!wiz.isBoughtSpell(spellWord)){
                System.out.println("Wrong Spell: " + spellWord + ",  use the one you bought: ");
                spellWord = scan.nextLine();
            }

            continues = uts.battle(wiz, op, spellWord);//nullpointer exception
        }
        //küsi uuesti spelli, kontrolli jälle olemasolu...
    }


}

