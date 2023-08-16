//DARAGH DOWNES 22351159
//CAYLUM HURLEY 22356363
//DARRAGH QUINN 22359621
//JOE CONSIDINE 22344977

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.io.*;
import java.util.*;
import java.math.*;

public class Dictionary {
    public ArrayList<String> words;
    public int shortest;
    public int longest;

    public Dictionary(String filepath, int shortest, int longest) {
        this.words = new ArrayList<String>();
        this.shortest = shortest;
        this.longest = longest;

        try {
            File data = new File(filepath);
            Scanner source = new Scanner(data);
            while (source.hasNext()) {
                String line = source.next();
                String[] lineArr = line.split(",");
                for (int i = 0; i < lineArr.length; i++) {
                    if (lineArr[i].trim().length() >= shortest && lineArr[i].trim().length() <= longest) {
                        words.add(lineArr[i].trim().toUpperCase());
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        Collections.sort(words);
    }

    public boolean add(String word) {
        word = word.trim().toUpperCase();
        if (word.length() < this.shortest || word.length() > this.longest) { //keeping words within the parameters
            System.out.println(word+": is too short/long");
            return false;
        }
        int index = Collections.binarySearch(words,word);//everything will be dealt with in uppercase
        if(index >= 0){
            System.out.println("The world already exists in the dictionary and wil not be added");
            return false;
        }

        words.add(Math.abs(index)-1,word);
        return true;
    }

    public String nextWord() {
        if (words.size() == 0) {
            return "";
        }
        Random random = new Random();
        int randValue = random.nextInt(words.size() - 1);
        return words.get(randValue);
    }

    public boolean inDictionary(String word){
        word = word.toUpperCase().trim();
        int index= Collections.binarySearch(words,word);
        if(index >= 0 ) {
            return true;
        }
        return false;
    }
}
