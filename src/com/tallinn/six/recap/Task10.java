package com.tallinn.six.recap;

import java.util.Scanner;
import java.util.Stack;

public class Task10 {
    public static void main(String[] args) {
        String[] words = new String[]{"", "", "", "", ""};

        Scanner scan = new Scanner(System.in);
        int indexCounter = 0;
        Stack<Integer> availableSlots = new Stack<>();
        while (true) {
            System.out.println("What you wanna do? add/remove/view/search/done");
            String order = scan.nextLine();

            boolean isEmpty = true;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equalsIgnoreCase("")) {
                    isEmpty = false;
                    break;
                }
            }
            if (order.equalsIgnoreCase("add")) {

                if (indexCounter > 4 && availableSlots.isEmpty()) {
                    System.out.println("Can't add, there is no more space");
                } else {
                    System.out.println("Please write something for adding: ");
                    String s = scan.nextLine();
                    while (true) {
                        for (int j = 0; j < words.length; j++) {
                            if (s.equalsIgnoreCase(words[j])) {
                                System.out.println("Already exists, no adding");
                                break;
                            }
                        }
                        if (indexCounter <= 4) {
                            words[indexCounter] = s;
                            indexCounter++;
                            System.out.println("Item added");
                            break;
                        } else {
                            int x = availableSlots.pop();
                            words[x] = s;
                            System.out.println("Item added");
                            break;
                        }
                    }
                }
            } else if (order.equalsIgnoreCase("remove")) {
                if (isEmpty){
                    System.out.println("Array is empty, nothing to remove.");
                }else {

                    System.out.println("Please write something for removing: ");
                    String s = scan.nextLine();
                    int foundIndex = -1;
                    for (int j = 0; j < words.length; j++) {
                        if (s.equalsIgnoreCase(words[j])) {
                            foundIndex = j;
                            break;
                        }
                    }
                    if (foundIndex == -1) {
                        System.out.println("Can't remove, item not in array");
                    } else {
                        words[foundIndex] = "";
                        availableSlots.push(foundIndex);
                        System.out.println("Item removed.");
                    }
                }
            } else if (order.equalsIgnoreCase("view")) {
                if (isEmpty) {
                    System.out.println("Array is empty, nothing to view.");
                } else {
                    String aString="";
                    for (String word : words
                    ) {
                        if (!word.equalsIgnoreCase("")) {
                            aString+=(word+" ");
                        }
                    }
                    String finalString=aString.trim().replaceAll(" ",", ");
                    System.out.println(finalString);
                }

            } else if (order.equalsIgnoreCase("search")) {
                if (isEmpty) {
                    System.out.println("Array is empty, nothing to search.");
                }else {

                    System.out.println("Please write something for searching: ");
                    String s = scan.nextLine();
                    boolean found = false;
                    //give back index
                    for (int j = 0; j < words.length; j++) {
                        if (s.equalsIgnoreCase(words[j])) {
                            System.out.println("Index of the " + s + " is " + j);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Can't find " + s);
                    }
                }
            } else if (order.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Unknown order");
            }
        }
    }
}
