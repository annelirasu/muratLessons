package com.tallinn.six.HarryPotterGame;

import java.util.HashMap;

 class Spells {
    /**
     * Contains the spells
     * Lacarnum Inflamarae => 25(Price),10(min),16(max),70(success),1(speed rate)
     * Lumos Solem => 45,17,23,65,2
     * Everte Statum => 45,23,29,60,3
     * Arania Exumai => 50,30,36,55,4
     * Avada Kedavra => 100,100,100,10,5
     * Vulnera Sanentur => 25,10,20,70,1
     * <p>
     * getSpell Method and parameter will be SpellName(String) and it will return the Spell Object.
     */

    private static HashMap<String, Spell> spells = new HashMap<>();

    Spells() {
        Spell lacranum = new Spell("Lacranum Inflamarae", 25, 10, 16, 70, 1);
        Spell lumos = new Spell("Lumos Solem", 45, 17, 23, 65, 2);
        Spell everte = new Spell("Everte Statum", 45, 23, 29, 60, 3);
        Spell arania = new Spell("Arania Exumai", 50, 30, 36, 55, 4);
        Spell avada = new Spell("Avada Kedavra", 100, 100, 100, 10, 5);
        Spell vulnera = new Spell("Vulnera Sanentur", 25, 10, 20, 70, 1);
        spells.put("Lacranum Inflamarae", lacranum);
        spells.put("Lumos Solem", lumos);
        spells.put("Everte Statum", everte);
        spells.put("Arania Exumai", arania);
        spells.put("Avada Kedavra", avada);
        spells.put("Vulnera Sanentur", vulnera);

    }


     Spell getSpell(String spellName) {
       /* for (Map.Entry<String, Spell> entry : spells.entrySet()) {
            if (spellName.equals(entry.getKey())) {
                return entry.getValue();
            }
        }*/
       return spells.get(spellName);

    }



}

