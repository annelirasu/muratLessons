package com.tallinn.six.HarryPotterGame;

import java.util.ArrayList;

class Opponent extends Wizard {
    SpellUtilities uts = new SpellUtilities();

    Opponent(String firstName, String lastName) {
        super(firstName, lastName);
        ArrayList<String> spells = new ArrayList<>();
        spells.add("Lacarnum Inflamarae");
        spells.add("Lumos Solem");
        spells.add("Everte Statum");
        spells.add("Arania Exumai");
        spells.add("Avada Kedavra");
        spells.add("Vulnera Sanentur");
        this.setBoughtSpells(spells);

    }

    String decideSpellName(Wizard player1) {
        String flame = "Lacranum Inflamarae";
        String lightening = "Lumos Solem";
        String wind = "Everte Statum";
        String fireball = "Arania Exumai";
        String death = "Avada Kedavra";
        String healing = "Vulnera Sanentur";

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

        } else if (getHealth() > player1.getHealth()) {
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
