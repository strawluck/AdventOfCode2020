/*
 * Starting at the top-left corner of your map and following a slope of right 3 and down 1
   This program determines the number of trees you would encounter on the map.
 */
package AdventOfCodeDay3;

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
        int row, col, trees = 0;

        ArrayList<String> num = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;

        try {       // stores the puzzleInput in the array list
            br = new BufferedReader(new FileReader("puzzleInput3.txt"));
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

        String[] map = new String[num.size()];      // converts the ArrayList to an Array
        num.toArray(map);
        
        //System.out.println(map[0].length());
        
        int c = 3;      // start at column 4
        for(int r = 1; r < num.size(); r = r+1){        // starting at row 1 check the row and column number to see if there is a tree (#). This loop also increase the col by 3 and row by 1 (slope)
            
            String s = map[r];      // let s = the string of text in a certain row

            if(c < map[0].length()){        // if the column # is less than the length of symbols in the string, then...
                if(s.charAt(c) == '#'){     // if the column num contains a '#', then there is a tree there
                    trees++;        // increase tree by 1
                }
            }
            else{       // else the column num is larger than the number of symbols in the string
                c = c - map[0].length();        // set c back to normal by subtracting the number of symbols in the string from c
                if(s.charAt(c) == '#'){     // continues to check if there is a '#' in the new column and if there is, increase tree by 1
                    trees++;        
                }
            }
            c = c+3;        // increase the col by 3 (slope)
            
        }
        System.out.println(trees);      // prints the number of trees encountered
    }
    
}
