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
public class Puzzle1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "";
        int valid = 0, invalid = 0;
        boolean cidFound = false;
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;
        

        try {       // stores the puzzleInput in the array list
            br = new BufferedReader(new FileReader("puzzleInput4.txt"));
            String word;
            while ((word = br.readLine()) != null) {
                
                if(word.length() >= 1){
                    s = s + " " + word;
                } else{
                    input.add(s);
                    s = "";
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
        
        /*for (int i = 0; i < passports.length; i++) {        // prints the passports (each line is a passport)
            System.out.println(passports[i]);
        }*/
        
        for (int i = 0; i < passports.length; i++) {      // goes through each passport to determine if it is valid
            String[] split = passports[i].split("[ :]+");       // splits each passport by key and value (a passport with 8 fields is split into 16 strings)
            //System.out.println(split.length + split[1]);
            
            if(split.length - 1 == 16){     // if the split array has 16 values, then the passport is valid (has 8 fields)
                valid++;
            } else if(split.length - 1 == 14){      // if the split array has 14 values, then check to see which key is missing (since only 1 field is missing)
                for (int j = 0; j < split.length - 1; j++) {        // checks every value in the split array
                    if(split[j].equals("cid")){     // if the value is equal "cid", then the passport isn't valid because another key value is missing from the passport
                        cidFound = true;
                    }
                }
                
                if(cidFound == true){
                    invalid++;
                    cidFound = false;
                } else{     // if you don't find "cid", that means the cid key is missing which means the passport is still valid
                    valid++;  
                }
                
            } else{     // if the passport misses more than 2 fields, it is invalid
                invalid++;
            }
        }
        
        System.out.println(valid);
        /*int j = 0;
        for(int i = 0; i < input.length; i++){      // goes through each password and finds out if they are valid 
            if(input[i] == "\n"){
                j++;
            } else{
               passports[j] = passports[j] + input[i];
               System.out.println(passports[i]);
            }
        }
        
        for(int i = 0; i < passports.length; i++){
            //System.out.println(passports[i]);
        }*/
    }
    
}
