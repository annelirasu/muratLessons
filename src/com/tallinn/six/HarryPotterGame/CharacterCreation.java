package com.tallinn.six.HarryPotterGame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterCreation {
    /**
     * CharacterCreation Class
     * method validateName parameter will be firstName... It does not accept any space and it will not accept any
     * numbers or punctuation.
     * "First name is not suitable. You did not enter any name"
     * "First name must not contain any space"
     * "First name is not suitable. No numbers/Punctuations"
     * <p>
     * it will return true or false. If true this first name is acceptable. Otherwise return false.
     * <p>
     * method validateSurname parameter will be firstName... It does not accept any space and it will not accept any
     * numbers or punctuation.
     * "Surname is not suitable. You did not enter any name"
     * "Surname is not suitable. No numbers/Punctuations"
     * <p>
     * it will return true or false. If true this first name is acceptable. Otherwise return false.
     * <p>
     * method eraseNonLetters it gets parameter as string. Then it will filter the number and punctuation.
     */

    private static boolean validateName(String whichName, String name) {
        if (name.equalsIgnoreCase("")) {
            System.out.println(whichName + " is not suitable. You did not enter any name");
            return false;
        }
        String patternForSpaces = "\\s+";
        Pattern spacesPat = Pattern.compile(patternForSpaces);
        Matcher m = spacesPat.matcher(name);
        if (m.find()) {
            System.out.println(whichName + " must not contain any space");
            return false;
        }
        String patternForNr = "[[:punct:]]+\\d+";
        Pattern forNumber = Pattern.compile(patternForNr);
        Matcher m2 = forNumber.matcher(name);

        if (m2.find()) {
            System.out.println(whichName + " is not suitable. No numbers/punctuations");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateFirstName(String name) {
        return validateName("First name", name);
    }

    public static boolean validateLastName(String name) {
        if (name.equalsIgnoreCase("")) {
            System.out.println("Surname is not suitable. You did not enter any name");
            return false;
        }
        String patternForNr = "[[:punct:]]+\\d+";
        Pattern forNumber = Pattern.compile(patternForNr);
        Matcher m2 = forNumber.matcher(name);

        if (m2.find()) {
            System.out.println("Surname is not suitable. No numbers/punctuations");
            return false;
        } else {
            return true;
        }
    }

    public String eraseNonLetters(String name){
        return name.replaceAll("[\\W]","");
    }


}
