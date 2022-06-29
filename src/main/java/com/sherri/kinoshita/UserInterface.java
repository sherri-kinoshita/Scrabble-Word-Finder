package com.sherri.kinoshita;

import java.util.Map;
import java.util.Scanner;

public class UserInterface {
        Scanner keyboard = new Scanner(System.in);
        private String input;
        private WordSorter wordSorter = new WordSorter();
    public void characterInput() {
        boolean wasSuccessful = false;
        while (!wasSuccessful) {
            System.out.print("Please enter the characters you'd like to find words for (max 7 letters)  -->  ");
            input = keyboard.nextLine();
            Map<Character, Integer> inputMap = wordSorter.mapGivenLetters(input);
            if (inputMap == null) {
                System.out.println("Sorry, too many characters provided");
            } else {
                System.out.println("success");
                wasSuccessful = true;
            }
        }
    }

    }