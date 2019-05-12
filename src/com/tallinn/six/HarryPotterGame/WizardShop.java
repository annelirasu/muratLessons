package com.tallinn.six.HarryPotterGame;

import java.util.HashMap;
import java.util.Map;

/**
 * initialize prices.
 * Lacarnum Inflamarae => 25
 * Lumos Solem => 45
 * Everte Statum => 45
 * Arania Exumai => 50
 * Avada Kedavra => 100
 * Vulnera Sanentur => 25
 * <p>
 * printAllSpells method it will not have any parameter. it will just print
 * <p>
 * buy method will be void... Its parameters are String requestedSpell and Wizard object.
 */

public class WizardShop {
    private HashMap<String, Integer> spellsInShop = new HashMap<>();


    public WizardShop() {
        spellsInShop.put("Lacranum Inflamarae", 25);
        spellsInShop.put("Lumos Solem", 45);
        spellsInShop.put("Everte Statum", 45);
        spellsInShop.put("Arania Exumai", 50);
        spellsInShop.put("Avada Kedavra", 100);
        spellsInShop.put("Vulnera Sanentur", 25);


    }

    public void printSpellsWithPrices() {
        for (Map.Entry<String, Integer> entry : spellsInShop.entrySet()) {
            String spellName = entry.getKey();
            int price = entry.getValue();
            System.out.println(spellName + ", " + price);
        }
    }

    public void buySpell(String spellName, Wizard wiz) {

        if (spellNameExsists(spellName)) {
            int priceOfSpell = 0;
            for (Map.Entry<String, Integer> entry : spellsInShop.entrySet()) {
                if (spellName.equals(entry.getKey())) {
                    priceOfSpell = entry.getValue();
                    break;
                }
            }
            if (wiz.getMoney() < priceOfSpell) {
                System.out.println("Not enlough money for buying " + spellName + ", it costs " + priceOfSpell + ", but you have " + wiz.getMoney());
            } else if (wiz.isBoughtSpell(spellName)) {
                System.out.println("You already bought " + spellName + ". Try to buy something else.");

            } else {
                wiz.setSpell(spellName);
                int moneyLeft = wiz.getMoney() - priceOfSpell;
                wiz.setMoney(moneyLeft);
                System.out.println(spellName + " bought.");
            }
        } else {
            System.out.println("Probably wrong name, try again.");
        }
    }

    private boolean spellNameExsists(String spellName) {
    /*    for (Map.Entry<String, Integer> entry : spellsInShop.entrySet()) {
            if (spellName.equals(entry.getKey())) {
                return true;
            }

        }*/
    if(spellsInShop.containsKey(spellName)){
        return true;
    }
    return false;
    }

}
