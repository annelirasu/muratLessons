package com.tallinn.six.recap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task14 {
    public static void main(String[] args) {
        System.out.println("Welcome stranger!");
        System.out.println("Give me a text or number: ");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        String patternForDigits = "(^\\w*)\\d+(\\.*\\d*)?";
        String patternForWords = "\\w+(^\\d*)";
        Pattern digitsPat = Pattern.compile(patternForDigits);
        Pattern wordsPat = Pattern.compile(patternForWords);

        Matcher m = digitsPat.matcher(input);
        Matcher m2 = wordsPat.matcher(input);
        if (m.find( )) {
            System.out.println("It is number: " + m.group() );

        }else if(m2.find()) {
            System.out.println("It is text: " + m2.group() );
        }
         else{   System.out.println("It is not number");
        }
    }
}
