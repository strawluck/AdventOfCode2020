/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay4;

import java.util.*;
import java.io.*;
/**
 *
 * @author Strawluck
 */
public class Puzzle2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "";
        int valid = 0, invalid = 0;
        boolean cidFound = false, checkValid;
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;

        try {       // stores the puzzleInput in the array list
            br = new BufferedReader(new FileReader("puzzleInput4.txt"));
            String word;
            while ((word = br.readLine()) != null) {

                if (word.length() >= 1) {       //if the line has any characters or numbers, add the phrase to the string 's'
                    s = s + " " + word;
                } else {        // if the line is a blank, add the string 's' to the arraylist
                    input.add(s);
                    s = "";     // reset 's' 
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        String[] passports = new String[input.size()];      // converts the ArrayList to an Array
        input.toArray(passports);

        for (int i = 0; i < passports.length; i++) {      // goes through each passport to determine if it is valid
            String[] split = passports[i].split("[ :]+");       // splits each passport by key and value (a passport with 8 fields is split into 16 strings)
            //System.out.println(split.length + split[1]);
            //checkValid = false;
            
            if (split.length - 1 == 16) {     // if the split array has 16 values, then the passport is valid (has 8 fields)
                checkValid = checkValues(split);        // check if all the values in the passport are valid
                if (checkValid == true) {
                    valid++;
                }
            } else if (split.length - 1 == 14) {      // if the split array has 14 values, then check to see which key is missing (since only 1 field is missing)
                for (int j = 0; j < split.length - 1; j++) {        // checks every value in the split array
                    if (split[j].equals("cid")) {     // if the value is equal "cid", then the passport isn't valid because another key value is missing from the passport
                        cidFound = true;
                    }
                }

                if (cidFound == true) {     // if you found "cid" then another key is missing so the passport is invalid
                    invalid++;
                    cidFound = false;
                } else {     // if you don't find "cid", that means the cid key is missing which means the passport is still valid
                    checkValid = checkValues(split);        // check if all the values in the passport are valid
                    if (checkValid == true) {
                        valid++;
                    }
                }

            } else {     // if the passport misses more than 2 fields, it is invalid
                invalid++;
            }
        }

        System.out.println(valid);
      
    
    }
    
    public static boolean checkValues(String [] split){     // method that checks the values of each key to see if they are valid
        // ** notice that it can only return false and not true. We are checking to see if any of the values make the passport invalid. If you return true after checking one 'key', then you haven't checked all the other keys
        int num;
        boolean found = false, hasLetter = false;
        
        for (int i = 1; i < split.length-1; i = i+2) {      // check every key value in the passport
            String s = split[i];
            //System.out.println(split[i]);
            switch (s) {
                case "byr": {       // checks if the values of "byr" are valid
                    num = Integer.parseInt(split[i + 1]);
                    if (num < 1920 || num > 2002) {
                        return false;
                    }
                }
                break;
                case "iyr": {       // checks if the values of "iyr" are valid
                    num = Integer.parseInt(split[i + 1]);
                    if (num < 2010 || num > 2020) {
                        return false;
                    }
                }
                break;
                case "eyr": {       // checks if the values of "eyr" are valid
                    num = Integer.parseInt(split[i + 1]);
                    if (num < 2020 || num > 2030) {
                        return false;
                    }
                }
                break;      
                case "hgt": {       // checks if the values of "hgt" are valid
                    for(int j = 0; j < split[i+1].length(); j++){       // checks to see if the value has a letter in it (or else there would be an error)
                         if (Character.isLetter(split[i+1].charAt(j))){
                             hasLetter = true;
                         }
                    }
                    
                    if(hasLetter == true){      // if there's a letter, we know it is either "cm" or "in"
                        String[] split2 = split[i+1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");      // splits the numbers and the word
                        //System.out.println(split2[0] + " " + split2[1]);
                        if(split2[1].equals("cm")){     // if the word is "cm" then check if the values are valid
                            num = Integer.parseInt(split2[0]);
                            if (num < 150|| num > 193) {
                                return false;
                            }
                        } else if (split2[1].equals("in")){     // if the word is "in" then check if the values are valid
                            num = Integer.parseInt(split2[0]);
                            if (num < 59 || num > 76) {
                                return false;
                            }
                        }
                    } else{
                        return false;
                    }
                    
                }
                break;
                case "hcl": {       // checks if the values of "hcl" are valid
                    if(split[i+1].charAt(0) != '#'){        // if the string doesn't have a # at the start, then it is invalid
                        return false;
                    } else if(split[i+1].charAt(0) == '#' && split[i + 1].length() < 7 || split[i + 1].length() > 7){       // if it has a # but the total length is not 7, than it's invalid
                        return false;
                    }
                    
                }
                break;
                case "ecl": {       // checks if the values of "ecl" are valid
                    String [] colours = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                    for(int j = 0; j < colours.length; j++){
                        if(split[i+1].equals(colours[j])){      // checks if the eye colour can be found in the array, if it is then it's valid
                            found = true;
                            j = colours.length;
                        } else{     // if no eye colour is found, then found = false;
                            found = false;
                        }
                    }
                    if(found == false){     // after checking every colour in the array, if it is still not found, then return false
                        return false;
                    }
                }
                break;
                case "pid": {       // checks if the values of "pid" are valid
                    if (split[i + 1].length() != 9) {
                        return false;
                    }
                }
                default: // when all else fails…
                    break;
            }
            
            /*if(split[i].equals("byr")){
                 num = Integer.parseInt(split[i+1]);
                 if(num < 1920 || num > 2002){
                     return false;
                 }
            }*/
        }
        return true;
    }
}
