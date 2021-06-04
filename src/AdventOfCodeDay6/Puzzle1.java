/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay6;

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
        int valid = 0, invalid = 0, sumYes = 0, yesCount = 0;
        boolean cidFound = false;
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;

        try {       // stores the puzzleInput in the array list
            br = new BufferedReader(new FileReader("puzzleInput6.txt"));
            String word, nextWord;
            while ((word = br.readLine()) != null) {
                
                
                if (word.length() >= 1) {       // if the line is not a blank, add the text into a string
                    s = s + word;
                } else{     // if the line is a blank, then add the group of text into an array list. Also reset the string "s"
                    input.add(s);
                    s = "";
                }

                /*if ((nextWord = br.readLine()) == null) {
                    input.add(s);
                    s = "";
                }*/
                    
            }
            String nextLine = br.readLine();        // read the last line of the input
            if (null == nextLine) {     // if it is null then add the group of text into the array list 
                    input.add(s);
                    s = "";
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

        String[] groupForms = new String[input.size()];      // converts the ArrayList to an Array
        input.toArray(groupForms);
        
        /*for (String n : groupForms) {       // prints the array groupForms
            System.out.println(n);
        }*/
        
        for(int i = 0; i < groupForms.length; i++){     // checks through every group of text in the array list 
            String p = groupForms[i];
            yesCount = 0;
            //System.out.println(p);        // prints the group of text being checked
            
            for(char letter = 'a'; letter <= 'z'; letter++){        // checks for the number of unique characters in the text 
                //System.out.println(letter);
                int index;
                index = p.indexOf(letter);

                if(index >= 0){     // if the 'letter' is found in the text, then a person has answered yes to that question   
                    yesCount++;     // increase yes counter 
                }
            }
            //System.out.println(yesCount);     // prints the yes counter
            sumYes = sumYes + yesCount;     // after a group of text is checked, the yes counter is added to the total sum
        }
        System.out.println(sumYes);
    }
    
}
