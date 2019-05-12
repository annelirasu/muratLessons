package com.tallinn.six.HarryPotterGame;

import java.util.Random;

class SpellUtilities {
    private static Spells spells = new Spells();

    /**
     * method getRandomNumberInRange it will return int.... its parameters are int min and int max
     * private int getRandomNumberInRange(int min, int max) {
     * <p>
     * castDamage method it will return int.... its parameter is nameOfspell (String).
     * public int castDamage(String nameOfSpell){
     * <p>
     * castHealing it will return int... Its parameter nameOfSpell (String(
     * <p>
     * cast method it will return integer. .... It will have String parameter spellName
     */

    int getRandomNumberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    int castDamage(String nameOfSpell) {
        Spell spell = spells.getSpell(nameOfSpell);
        return getRandomNumberInRange(spell.getMinSpellPower(), spell.getMaxSpellPower());

    }

    int castHealing(String nameOfSpell) {
        Spell spell = spells.getSpell(nameOfSpell);
        return getRandomNumberInRange(spell.getMinSpellPower(), spell.getMaxSpellPower());

    }

    boolean battle(Wizard wiz, Opponent op, String wizSpell) {
        String opsSpell = op.decideSpellName(wiz);
        System.out.println(op.getFirstName() + " has spell " + opsSpell);//temporary
        int wizSpellSpeed = spells.getSpell(wizSpell).getSpeedRate();
        int opSpellSpeed = spells.getSpell(opsSpell).getSpeedRate();// nullpointer exection
        if (wizSpellSpeed > opSpellSpeed) {
            boolean continues=castSpell(wizSpell, wiz, op);
            if(!continues){
                return false;
            }
            return castSpell(opsSpell, op, wiz);

        } else if ((wizSpellSpeed < opSpellSpeed)) {
            boolean continues=castSpell(opsSpell, op, wiz);
            if(!continues){
                return false;
            }
            return castSpell(wizSpell, wiz, op);

        } else { //speeds are equal
            int rand = getRandomNumberInRange(0, 100);
            if (rand < 50) {
                boolean continues=castSpell(wizSpell, wiz, op);
                if(!continues){
                    return false;
                }
                return castSpell(opsSpell, op, wiz);
            } else {
                boolean continues=castSpell(opsSpell, op, wiz);
                if(!continues){
                    return false;
                }
                return castSpell(wizSpell, wiz, op);
            }
        }
    }

    boolean castSpell(String spellName, Wizard wiz1, Wizard opponent) {
        int rand = getRandomNumberInRange(0, 100);
        if (spellName.equals("Vulnera Sanentur")) {
            if (rand < spells.getSpell(spellName).getSuccessRate()) {
                int randPower = castHealing(spellName);
                int newHealth = wiz1.getHealth() + randPower;
                if(newHealth>100){
                    wiz1.setHealth(100);
                }else {
                    wiz1.setHealth(newHealth);
                }
                System.out.println("Vulnera Sanetur succeeded, " + wiz1.getFirstName() + " " + wiz1.getLastName()+ " health: " + wiz1.getHealth());
                return true;
            } else {
                System.out.println("Vulnera Sanetur of " + wiz1.getFirstName() + " did'nt succeed");
                return true;
            }

        } else {
            Spell damagingSpell = spells.getSpell(spellName);
            int success = damagingSpell.getSuccessRate();
            if (rand < success) {
                int randPower = castDamage(spellName);
                int newHealth = opponent.getHealth() - randPower;
                opponent.setHealth(newHealth);
                if (opponent.getHealth() <= 0) {
                    System.out.println("Came over! " + opponent.getFirstName() + " " + opponent.getLastName() + " is dead.");
                    return false;
                } else {
                    System.out.println(damagingSpell.getSpellWord() + " of " + wiz1.getFirstName() + " "
                            + wiz1.getLastName() + " succeeded, "
                            + opponent.getFirstName() + " " + opponent.getLastName() + " health: " + opponent.getHealth());
                    return true;
                }
            } else {
                System.out.println(spellName + " of " + wiz1.getFirstName() + " didn't succeeded this time.");
                return true;
            }
        }

    }
}
