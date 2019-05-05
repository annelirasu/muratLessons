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
            if (order.equalsIgnoreCase("add")) {

                if (indexCounter > 4 && availableSlots.isEmpty()) {
                    System.out.println("Can't add, there is no more space");
                } else {
                    System.out.println("Please write something for adding: ");
                    String s = scan.nextLine();
                    while (true) {
                        for (int i = 0; i < words.length; i++) {

                            if (s.equalsIgnoreCase(words[i])) {
                                System.out.println("Already exists, no adding");
                                break;
                            }
                        }
                        if (indexCounter <= 4) {
                            words[indexCounter] = s;
                            indexCounter++;
                            break;
                        } else {
                            int x = availableSlots.pop();
                            words[x] = s;
                            break;
                        }
                    }


                }


            } else if (order.equalsIgnoreCase("remove")) {
                System.out.println("Please write something for removing: ");
                String s = scan.nextLine();
                int foundIndex=-1;
                for (int i = 0; i < words.length; i++) {
                    if (s.equalsIgnoreCase(words[i])) {
                        foundIndex=i;
                        break;
                    }
                }
                if(foundIndex==-1){
                    System.out.println("Can't remove, can not find the item");
                }else{
                    words[foundIndex]="";
                    availableSlots.push(foundIndex);
                }
            } else if (order.equalsIgnoreCase("view")) {
                for (String word : words
                ) {
                    if (word.equalsIgnoreCase("")) {
                        System.out.println("empty");
                    } else {
                        System.out.println(word);
                    }
                }

            } else if (order.equalsIgnoreCase("search")) {
                System.out.println("Please write something for searching: ");
                String s = scan.nextLine();
                boolean found=false;
                //give back index
                for (int i = 0; i < words.length; i++) {
                    if (s.equalsIgnoreCase(words[i])) {
                        System.out.println("Index of the " + s + " is " + i);
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Can't find "+s);
                }
            } else if (order.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Unknown order");
            }
        }
    }
}