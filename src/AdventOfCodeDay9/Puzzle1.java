/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay9;

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
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the booklist.txt data
        BufferedReader br = null;
        int int1, int2, sum;

        try {       // stores the data in booklist.txt in the array list
            br = new BufferedReader(new FileReader("puzzleInput9.txt"));
            String word;
            while ((word = br.readLine()) != null) {
                input.add(word);
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
        
        // Created the preamble that is using the first 25 numbers in the input
        ArrayList<Integer> preamble = new ArrayList<Integer>(); 
        for(int i = 0; i < 25; i++)
        {
            preamble.add(Integer.parseInt(input.get(i)));
        }
        
        /*
            Starts from the 26th number and finds the first num that can't be added 
            by two of the 25 previous numbers in the preamble to equal the num.
        */
        for(int i = 25; i < input.size(); i++)
        {
            boolean valid = false;
            int nextNum = Integer.parseInt(input.get(i));
            
            // Finds if any 2 numbers in the preamble can be added to equal nextNum
            for(int j = 0; j < preamble.size(); j++)
            {
                for(int k = j+1; k < preamble.size(); k++)
                {
                    int1 = preamble.get(j);
                    int2 = preamble.get(k);
                    sum = int1 + int2;
                    
                    // If the sum = nextNum, then remove the first number in the preamble
                    // Add nextNum to the preamble (to keep the 25 previous numbers in the preamble)
                    if(sum == nextNum){
                        valid = true; 
                        preamble.remove(0);
                        preamble.add(nextNum);
                        j = preamble.size();        // better way than this? to break out of outer for loop
                        break;
                    }
                }
            }
            
            // No 2 nums in the preamble summed up to equal nextNum so that num is not valid
            if(valid == false){
                System.out.println(nextNum);
                break;
            }
        }
        
    }
    
}
