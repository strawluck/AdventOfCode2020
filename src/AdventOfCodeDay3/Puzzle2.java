/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay3;

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
        int row, col;
        long trees, treeSlope1, treeSlope2, treeSlope3, treeSlope4, treeSlope5;
        
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

        treeSlope1 = treeCount(1, 1, map);
        treeSlope2 = treeCount(3, 1, map);
        treeSlope3 = treeCount(5, 1, map);
        treeSlope4 = treeCount(7, 1, map);
        treeSlope5 = treeCount(1, 2, map);
        
        System.out.println(treeSlope1);
        System.out.println(treeSlope2);
        System.out.println(treeSlope3);
        System.out.println(treeSlope4);
        System.out.println(treeSlope5);
        trees = treeSlope1 * treeSlope2 * treeSlope3 * treeSlope4 * treeSlope5;
        System.out.println(trees);      // prints the number of trees encountered
    }
    
    public static int treeCount (int right, int down, String [] map){
        int trees = 0;
        
        int c = right;
        for (int r = down; r < map.length; r = r + down) {        // starting at a row check the row and column number to see if there is a tree (#). This loop also increase the col by 3 and row by 1 (slope)

            String s = map[r];      // let s = the string of text in a certain row

            if (c < map[0].length()) {        // if the column # is less than the length of symbols in the string, then...
                if (s.charAt(c) == '#') {     // if the column num contains a '#', then there is a tree there
                    trees++;        // increase tree by 1
                }
            } else {       // else the column num is larger than the number of symbols in the string
                c = c - map[0].length();        // set c back to normal by subtracting the number of symbols in the string from c
                if (s.charAt(c) == '#') {     // continues to check if there is a '#' in the new column and if there is, increase tree by 1
                    trees++;
                }
            }
            c = c + right;        // increase the col by 'right' which is the slope

        }
        return trees;
    }
    
}
