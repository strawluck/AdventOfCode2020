/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay9;

import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
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
        
        //start at the first line of input, and continually add nums after until it goes over the invalidNum;
        //if it goes over, than start on the second line of input and continue;
                
                // TODO code application logic here
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the booklist.txt data
        ArrayList<Long> inputNum = new ArrayList<Long>();
        BufferedReader br = null;
        int int1, int2, sum, invalidNum = 22406676;

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
        
        for(int i = 0; i < input.size(); i++)
        {
            inputNum.add(Long.parseLong(input.get(i)));
        }
        
        long smallest, largest, encryptWeak;
        
        for(int i = 0; i < inputNum.size(); i++)
        {
            //System.out.println("hello");
            long total = 0;
            smallest = Integer.MAX_VALUE;
            largest = Integer.MIN_VALUE;
            for(int j = i; j < inputNum.size(); j++)
            {
                total += inputNum.get(j);
                if (inputNum.get(j) < smallest)
                    smallest = inputNum.get(j);
                else if (inputNum.get(j) > largest)
                    largest = inputNum.get(j);
                
                if(total == invalidNum)
                {
                    i = inputNum.size();
                    System.out.println(smallest + largest);
                    break;
                }
                else if(total > invalidNum){
                    break;
                }
            }
        }
        
        //int[] rangeNumAr = new int[rangeNum.size()];      // converts the ArrayList to an Array
        //rangeNum.toArray(rangeNumAr);
        /*ArrayList<Long> rangeNumAr = selectionSortAscend(rangeNum, rangeNum.size());
        smallest = rangeNumAr.get(0);
        largest = rangeNumAr.get(rangeNumAr.size()-1);
        encryptWeak = smallest + largest;
        
        rangeNum.sor
        System.out.println(encryptWeak);*/
    }
    
    
}
