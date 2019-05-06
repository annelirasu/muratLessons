package com.tallinn.six.recap;

import java.util.Scanner;

public class Task13 {

/*    create class Encryption
containing main method.

    ask user to get word which will be encrypted with the word which you want to encrypt to.


            if you say encrypt apple to xxx

if user prints apple is nice
    it will print xxx is nice*/

}
class Encryption{

    public static void main(String[] args) {
        System.out.println("Welcome stranger!");
        System.out.println("Which word do you want to encrypt?");
        Scanner scan=new Scanner(System.in);
        String word1=scan.nextLine();
        System.out.println("Which word do you want the word change to?");
        String word2=scan.nextLine();
        System.out.println("What is the sentence?");
        String sentence=scan.nextLine();
        System.out.println(sentence);
        String newSentence=sentence.replaceAll(word1,word2);
        System.out.println(newSentence);
    }
}
