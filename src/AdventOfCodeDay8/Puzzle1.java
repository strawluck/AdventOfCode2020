/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay8;

import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        ArrayList<String> inputArList = new ArrayList<String>();        // creates an array list to store the booklist.txt data
        BufferedReader br = null;

        try {       // stores the data in booklist.txt in the array list
            br = new BufferedReader(new FileReader("puzzleInput8.txt"));
            String word;
            while ((word = br.readLine()) != null) {
                inputArList.add(word);
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

        String[] input = new String[inputArList.size()];      // converts the ArrayList to an Array
        inputArList.toArray(input);
        
        Map<Integer, Integer> lineCounter = new HashMap<>();
        boolean isDone = false;
        int accumulator = 0;
        int lineNum = 0;
        
        
        // A loop that continues until a line is recalled again
        while(!isDone)
        {
            String[] instruction = input[lineNum].split(" ");
            
            String operation = instruction[0];
            char sign = instruction[1].charAt(0);
            int argument = Integer.parseInt(instruction[1].substring(1));
            
            /* 
            If the lineNum was never added to the hashmap, then add it. If it 
            has already been added, then it is being called for the second time so end the while loop
            */
            if(lineCounter.get(lineNum) == null)
            {
                int i = 1;
                lineCounter.put(lineNum, i);
            } else{
                isDone = true;
                break;
            }
                
            
            if(operation.equals("acc"))
            {
                
                if(sign == '+')
                {
                    accumulator += argument;
                }
                else if(sign == '-')
                {
                    accumulator -= argument;
                }
                lineNum++;
                
            } 
            else if(operation.equals("jmp"))
            {
                if (sign == '+') 
                {
                    /*if(lineNum == 647){
                        lineNum = 0;
                    }*/
                    lineNum += argument;
                } 
                else if (sign == '-') 
                {
                    lineNum -= argument;
                }
            }
            else if(operation.equals("nop"))
            {
                lineNum++;
            }
            
            
        }
        System.out.println("Answer " + accumulator);
    }
}
