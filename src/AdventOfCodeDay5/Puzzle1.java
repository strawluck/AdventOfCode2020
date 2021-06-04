/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay5;

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
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;
        int row = 0, col = 0, seatID, highestSeatID = 0;

        try {       // stores the puzzleInput in the array list
            br = new BufferedReader(new FileReader("puzzleInput5.txt"));
            String word;
            while ((word = br.readLine()) != null) {
                input.add(word);        // adds each line of the input to the array list

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

        String[] boardingPasses = new String[input.size()];      // converts the ArrayList to an Array
        input.toArray(boardingPasses);
        
        for(int i = 0; i < boardingPasses.length; i++){     // check each line of the puzzleInput
            int size = 128, min = 0, max = 127;
            String s = boardingPasses[i];
            
            for(int j = 0; j < 7; j++){     // checks all the F and B's to find the row # by checking the first 7 characters of the string
                size = size/2;
                if(s.charAt(j) == 'F'){     // if the character is 'f', then the max value changes
                    max = max - size;
                } else if(s.charAt(j) == 'B'){      // if the character is 'b', then the min value changes
                    min = min + size;
                }
                
                if(max == min){     // when max = min, then the row # is found
                    row = max;
                }
            }
            
            // checks all the L and R's to find the col #
            size = 8;
            min = 0;
            max = 7;
            for(int l = 7; l < s.length(); l++){     // checks the last 3 characters of the string
                size = size/2;
                if(s.charAt(l) == 'L'){     // if the character is 'L', then the max value changes
                    max = max - size;
                } else if(s.charAt(l) == 'R'){      // if the character is 'R', then the min value changes
                    min = min + size;
                }
                
                if(max == min){     // when max = min, then the col # is found
                    col = min;
                }
            }
            
            seatID = row * 8 + col;     // calculates the seat ID for that string
            //System.out.println(seatID);
            
            if(seatID > highestSeatID){     // finds the largest seat ID
                highestSeatID = seatID;
            }
        }
        System.out.println(highestSeatID);
    }
    
}
