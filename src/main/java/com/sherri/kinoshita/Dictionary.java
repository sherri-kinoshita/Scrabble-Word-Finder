package com.sherri.kinoshita;

import java.io.*;
import java.sql.Array;
import java.util.Scanner;

public class Dictionary {
    private String filePath = "dictionary.txt";
    private File file;


    public Dictionary() throws FileNotFoundException {}

    public void readDictionary() {
        file = new File(filePath);

        if(!file.exists() || !file.isFile()){
            System.out.println("Sorry, dictionary is not a valid file.");
        }
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String word = reader.nextLine();

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String[] returnAllPossibleWords(String characters){
        return null;
    }
}
