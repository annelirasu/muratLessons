package com.tallinn.six.recap;

import java.util.Scanner;

public class Task11 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String[] words = new String[]{"", "", "", "", ""};

       Utilities uts = new Utilities();

        while (true) {
            System.out.println("What you wanna do? add/remove/view/search/say/done");
            String order = scan.nextLine();


            if (order.equalsIgnoreCase("add")) {
                uts.add(words);
            } else if (order.equalsIgnoreCase("remove")) {
                uts.remove(words);
            } else if (order.equalsIgnoreCase("view")) {
                uts.view(words);

            } else if (order.equalsIgnoreCase("search")) {
                uts.search(words);

            } else if (order.equalsIgnoreCase("say")) {
                JustAnotherClass jst=new JustAnotherClass();
                jst.saySomething();

            }else if (order.equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Unknown order");
            }
        }
    }
    private static class Utilities {
        //private static Scanner scan = new Scanner(System.in);

        void add(String[] words) {
            int indexCounter = getIndexOfNextEmptyString(words);
            if (indexCounter == -1) {
                System.out.println("Can't add, there is no more space");
            } else {
                System.out.println("Please write something for adding: ");
                String s = scan.nextLine();
                boolean doesntExist = true;
                for (int j = 0; j < words.length; j++) {
                    if (s.equalsIgnoreCase(words[j])) {
                        System.out.println("Already exists, no adding");
                        doesntExist = false;
                    }
                }
                if (doesntExist) {
                    words[indexCounter] = s;
                    System.out.println("Item added");
                }

            }
        }

        void remove(String[] words) {
            if (isEmpty(words)) {
                System.out.println("Array is empty, nothing to remove.");
            } else {

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
                    System.out.println("Item removed.");
                }
            }

        }

        void search(String[] words) {
            if (isEmpty(words)) {
                System.out.println("Array is empty, nothing to search.");
            } else {

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

        }

        void view(String[] words) {
            if (isEmpty(words)) {
                System.out.println("Array is empty, nothing to view.");
            } else {
                String aString = "";
                for (String word : words
                ) {
                    if (!word.equalsIgnoreCase("")) {
                        aString += (word + " ");
                    }
                }
                String finalString = aString.trim().replaceAll(" ", ", ");
                System.out.println(finalString);
            }

        }

        private boolean isEmpty(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equalsIgnoreCase("")) {
                    return false;
                }
            }
            return true;
        }

        private int getIndexOfNextEmptyString(String[] words) {
            for (int j = 0; j < words.length; j++) {
                if ("".equalsIgnoreCase(words[j])) {
                    return j;
                }
            }
            return -1;
        }
    }

    public static class JustAnotherClass{
        //to show additional possibility of inner classes
        public void saySomething(){
            System.out.println("This is message from inner class JustAnotherClass!");
        }
    }
}


