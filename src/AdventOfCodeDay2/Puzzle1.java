/*
Description: searches through a list of passwords and finds out if they are valid.
 The password policy indicates the lowest and highest number of times a given letter 
must appear for the password to be valid. For example, 1-3 a means that the password must 
contain 'a' at least 1 time and at most 3 times.
 */
package AdventOfCodeDay2;

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
        int min, max, validPass = 0, count = 0;
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
        
        for(int i = 0; i < passwords.length; i++){      // goes through each password and finds out if they are valid 
            String[] split = passwords[i].split("[- :]+");      // splits the password into 4 parts
            
            min = Integer.parseInt(split[0]);      // min # of times a given letter can appear in the pass
            max = Integer.parseInt(split[1]);      // max # of times a given letter can appear in the pass
            sLetter = split[2];     // the given letter
            letter = sLetter.charAt(0);     // converts the letter string into a char
            pass = split[3];        // the password 
            count = 0;
            
            for (int j = 0; j < pass.length(); j++){        // counts the number of times the char is in the password
                if (pass.charAt(j) == letter) {
                    count++;
                }
            }
            if(count >= min && count <= max){       // if counter is greater than the min and less than the max, then the password is valid
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
