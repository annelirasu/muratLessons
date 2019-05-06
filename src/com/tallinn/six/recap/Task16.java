package com.tallinn.six.recap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        UtilitiesForSchool uts = new UtilitiesForSchool();
        System.out.println("Welcome to the School!");
        while (true) {
            System.out.println("What you wanna do? add/remove/view/search/done");
            String order = scan.nextLine();


            if (order.equalsIgnoreCase("add")) {
                uts.add(students);
            } else if (order.equalsIgnoreCase("remove")) {
                uts.remove(students);
            } else if (order.equalsIgnoreCase("view")) {
                uts.view(students);

            } else if (order.equalsIgnoreCase("search")) {
                uts.search(students);

            } else if (order.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}

class UtilitiesForSchool {
    private static Scanner scan = new Scanner(System.in);

    void add(List<String> students) {
        System.out.println("Please write student's name for adding: ");
        String s = scan.nextLine();
        students.add(s);
        System.out.println(s + " is added.");
    }


    void remove(List<String> students) {
        if (isEmpty(students)) {
            System.out.println("Can't remove,  students list is empty!");
        } else {
            System.out.println("Please write student's name for removing: ");
            String s = scan.nextLine();
            boolean found = false;
            String foundStudent = "";
            for (String student : students) {
                if (s.equals(student)) {
                    found = true;
                    foundStudent = student;
                    break;
                }
            }
            if (!found) {
                System.out.println("Can't remove, student " + s + " not in school.");
            } else {
                students.remove(foundStudent);
                System.out.println("Student " + s + " removed.");
            }
        }
    }

    void search(List<String> students) {
        if (isEmpty(students)) {
            System.out.println("Students lists empty, nothing to search.");
        } else {
            System.out.println("Please write student name for searching: ");
            String s = scan.nextLine();
            int occurence = 0;
            for (String student : students) {
                if (s.equalsIgnoreCase(student)) {
                    occurence++;
                }
            }
            System.out.println("Total occurence of " + s + " is " + occurence);
        }

    }

    void view(List<String> students) {
        if (isEmpty(students)) {
            System.out.println("Students list is empty, nothing to view.");
        } else {
            System.out.println(students.toString());
        }
    }

    private boolean isEmpty(List<String> students) {
        return students.isEmpty();
    }
}


