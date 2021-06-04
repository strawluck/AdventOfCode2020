/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay2;

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
        int spot1, spot2, validPass = 0, count = 0;
        String sLetter, pass;
        char letter;

        ArrayList<String> num = new ArrayList<String>();        // creates an array list to store the imported text document
        BufferedReader br = null;

        try {       // stores the data in booklist.txt in the array list
            br = new BufferedReader(new FileReader("puzzleInput2.txt"));
            String word;
            while ((word = br.readLine()) != null) {
                num.add(word);
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

        String[] passwords = new String[num.size()];      // converts the ArrayList to an Array
        num.toArray(passwords);

        for (int i = 0; i < passwords.length; i++) {      // goes through each password and finds out if they are valid 
            String[] split = passwords[i].split("[- :]+");      // splits the password into 4 parts

            spot1 = Integer.parseInt(split[0]);      // min # of times a given letter can appear in the pass
            spot2 = Integer.parseInt(split[1]);      // max # of times a given letter can appear in the pass
            sLetter = split[2];     // the given letter
            letter = sLetter.charAt(0);     // converts the letter string into a char
            pass = split[3];        // the password 
            count = 0;

            if(pass.charAt(spot1-1) == letter){     // if the spot1 equals the given letter, then count+
                count++;
            }
            if(pass.charAt(spot2-1) == letter){     // if the spot2 equals the given letter, then count+
                count++;
            }
            
            if (count == 1) {       // if counter is = to 1, than the password is valid
                validPass++;
            }
            //System.out.println(count);
            //System.out.println(validPass);

        }

        System.out.println(validPass);
        /* tests what is split from the line of text (splits it into 4 sections which is right)
        String[] split = passwords[0].split("[- :]+");
            
            for (String a : split)
            System.out.println(a);
         */
    
    }
    
}
