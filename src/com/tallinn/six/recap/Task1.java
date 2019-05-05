package com.tallinn.six.recap;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Welcome stranger. Pelase Enter your full name:");
        String answer=scan.nextLine();//next() - only until the next white space
        if(answer.equalsIgnoreCase("james bond")){//minnes Ctl klahviga meetodile, näitab tagastustüüpi
            System.out.println("Welcome 007");
        }else {
            System.out.println("Get out, you are not an agent!");
        }

    }
}
