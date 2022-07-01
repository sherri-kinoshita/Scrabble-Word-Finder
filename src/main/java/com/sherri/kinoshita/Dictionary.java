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
//        try{
//            Scanner reader = new Scanner(file);
//            Map<Character, Integer> wordMap = new HashMap<>();
//            while(reader.hasNextLine()){
//                String word = reader.nextLine();
//                    for (int i = 0; i < word.length(); i++) {
//                        char letter = word.charAt(i);
//                        if (!wordMap.containsKey(letter)) {
//                            wordMap.put(letter, 1);
//                        } else {
//                            int count = wordMap.get(letter) + 1;
//                            wordMap.put(letter, count);
//                        }
//                    }
//                }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

    public boolean checkWordForLetters(String letters, String dictionaryWord){
        boolean doesContainAll = false;
        int count = 0;
        for(int i =0; i<letters.length() - 1; i++){
            char letter = letters.charAt(i);
            if(dictionaryWord.indexOf(letter) != -1){
                count++;
            }
        }
        if (count == letters.length() - 1){
            doesContainAll = true;
        }
        return doesContainAll;
    }

    public List<String> returnAllPossibleWords(String letters){
        List<String> potentialWords = new ArrayList<>();
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
//                    if(!wordMap.containsKey(key)){
//                        continue;
//                    }
                    if(wordMap.containsKey(key) && current.getValue() >= wordMap.get(key)){
                        count++;
                    } else {
                        continue;
                    }
                    if (count == wordMap.size()){
                        potentialWords.add(word);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return potentialWords;
    }
}
