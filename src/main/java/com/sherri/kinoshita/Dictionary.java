package com.sherri.kinoshita;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Dictionary {
    private String filePath = "C:\\Users\\Student\\workspace\\ScrabbleWordFinder\\theDictionary\\dictionary.txt";
    private File file;
    private WordSorter wordSorter = new WordSorter();


    public Dictionary() {}

    public void createDictionaryFile() {
        file = new File(filePath);

        if(!file.exists() || !file.isFile()){
            System.out.println("Sorry, the system seems to be down. Please try again later!");
        }
    }

    public Map<Character, Integer> numberValueMapCreation(){
        Map<Character, Integer> valueMap = new HashMap<>()
        {{
            put('A', 1);
            put('E', 1);
            put('I', 1);
            put('L', 1);
            put('N', 1);
            put('O', 1);
            put('R', 1);
            put('S', 1);
            put('T', 1);
            put('U', 1);
            put('D', 2);
            put('G', 2);
            put('B', 3);
            put('C', 3);
            put('M', 3);
            put('P', 3);
            put('F', 4);
            put('H', 4);
            put('V', 4);
            put('W', 4);
            put('Y', 4);
            put('K', 5);
            put('J', 8);
            put('X', 8);
            put('Q', 10);
            put('Z', 10);
        }};
        return valueMap;
    }

    public int wordPointValue(String word){
        Map<Character, Integer> valueMap = numberValueMapCreation();
        int points = 0;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            points += valueMap.get(letter);
        }
        return points;
    }

    public Map<String, Integer> returnAllPossibleWords(String letters){
        Map<String, Integer> potentialWords = new HashMap<>();
        createDictionaryFile();

        try{
            Scanner reader = new Scanner(file);
            Map<Character, Integer> letterMap = wordSorter.mapGivenLetters(letters);
            while (reader.hasNextLine()){
                String word = reader.nextLine();
                Map<Character, Integer> wordMap = new HashMap<>();
                if(letters.length() >= word.length()){
                    for (int i=0; i < word.length(); i++){
                        char letter = word.charAt(i);
                        if (!wordMap.containsKey(letter)) {
                            wordMap.put(letter, 1);
                        } else {
                            int count = wordMap.get(letter) + 1;
                            wordMap.put(letter, count);
                        }
                    }
                }
                int count = 0;
                for(Map.Entry<Character, Integer> current : letterMap.entrySet()){
                    char key = current.getKey();
                    if(wordMap.containsKey(key) && current.getValue() >= wordMap.get(key)){
                        count++;
                    } else {
                        continue;
                    }
                    if (count == wordMap.size()){
                        int points = wordPointValue(word);
                        potentialWords.put(word, points);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return potentialWords;
    }
}
