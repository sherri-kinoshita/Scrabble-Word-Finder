package com.sherri.kinoshita;

import java.util.*;

public class UserInterface {
        Scanner keyboard = new Scanner(System.in);
        private String input;
        private WordSorter wordSorter = new WordSorter();
        private Dictionary dictionary = new Dictionary();

    public void menuOptions(){
        int menuSelection = 0;
        System.out.println("Welcome to the Scrabble Word Finder! Please choose a selection below");
        System.out.println("1 : Get list of potential words from current letters in hand");
        System.out.println("2 : Get list of potential words including an existing word on board");
        System.out.println("3 : Exit program");
        System.out.print("Menu Selection --> ");
        String selection = keyboard.nextLine();
        menuSelection = Integer.parseInt(selection);

        do {
            if(menuSelection == 1){
                characterInput();
                sortByPointValue();
                menuOptions();
            } else if(menuSelection == 2){
                System.out.println("Feature not currently available");
            } else {
                System.out.println("Sorry, not a valid menu selection");
            }
        }while(menuSelection != 3);
    }

    public void characterInput() {
        boolean wasSuccessful = false;
        while (!wasSuccessful) {
            System.out.print("Please enter the characters you'd like to find words for (max 7 letters)  -->  ");
            input = keyboard.nextLine();
            Map<Character, Integer> inputMap = wordSorter.mapGivenLetters(input);
            if (inputMap == null) {
                System.out.println("Sorry, too many characters provided");
            } else {
                wasSuccessful = true;
            }
        }
    }

    public void sortByPointValue(){
        Map<String, Integer> wordList = dictionary.returnAllPossibleWords(input);
        LinkedHashMap<String, Integer> valuedWordList = new LinkedHashMap<>();
        wordList.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> valuedWordList.put(x.getKey(), x.getValue()));

        for(Map.Entry<String, Integer> entry : valuedWordList.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue() + " points");
        }
    }
    }
