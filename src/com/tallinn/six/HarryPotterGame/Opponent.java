package com.tallinn.six.HarryPotterGame;

import java.util.ArrayList;

public class Opponent extends Wizard {
    SpellUtilities uts = new SpellUtilities();

    public Opponent(String firstName, String lastName) {
        super(firstName, lastName);
        ArrayList<String> spells=new ArrayList<>();
        spells.add("Lacarnum Inflamarae");
        spells.add("Lumos Solem");
        spells.add("Everte Statum");
        spells.add("Arania Exumai");
        spells.add("Avada Kedavra");
        spells.add("Vulnera Sanentur");
        this.setBoughtSpells(spells);

    }

    public String decideSpellName(Wizard player1) {
        String flame = "Lacranum Inflamarae";
        String lightening = "Lumos Solem";
        String wind = "Everte Statum";
        String fireball = "Arania Exumai";
        String death = "Avada Kedavra";
        String healing = "Vulnera Sanentur";

        /**
         * Task1: If health of opponent below 45
         * 50% change to cast healing
         * 50% there will be below decision
         * he will get players health
         * if playerHealth is below 11 he will castFlame
         * else if playerHealth is below 17 he will castLightening
         * else if playerHealth is below 23 he will castWind
         * else if playerHealth is below 30 he will castFireball
         * else if playerHealth is below 65 he will castDeath
         * else castHealing
         */
        int random = uts.getRandomNumberInRange(0, 100);
        if (getHealth() < 45) {

            if (random <= 50) {
                return healing;
            } else {
                int p1Health = player1.getHealth();
                if (p1Health < 11) {
                    return flame;
                } else if (p1Health < 17) {
                    return lightening;
                } else if (p1Health < 23) {
                    return wind;
                } else if (p1Health < 30) {
                    return fireball;
                } else if (p1Health < 65) {
                    return death;
                } else {
                    return healing;
                }

            }

        } else if

        /**
         *  Task2: If health of opponent bigger than the player
         *          25% change to castLightening
         *          25% to castFireball
         *          25% to castWind
         *          25% to castFlame
         *
         */
        (getHealth() > player1.getHealth()) {

            if (random < 25) {
                return lightening;
            } else if (random < 50) {
                return fireball;
            } else if (random < 75) {
                return wind;
            } else {
                return flame;
            }
        } else {
            /**
             *  Task3: rest of the conditions
             *          20% change to castLightening
             *          15% to castFireball
             *          20% to castWind
             *          25% to castFlame
             *          20% to cast healing
             */
            if (random < 20) {
                return lightening;
            } else if (random < 35) {
                return fireball;
            } else if (random < 55) {
                return wind;
            } else if (random < 80) {
                return flame;
            } else {
                return healing;
            }
        }
    }
}
