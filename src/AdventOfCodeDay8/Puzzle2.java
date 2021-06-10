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
public class Puzzle2 {

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
        
        int accCorrupted = 0;
        
        
        for(int i =0; i < input.length; i++)
        {
            System.out.println(i);
            int accumulator = 0, lineNum = 0;
            boolean isDone = false;
            
                if(input[i].contains("acc"))
                {
                    isDone = true;
                }
                while(!isDone)
                {
                    //System.out.println("hello");
                    if (lineNum >= 647 || lineNum < 0) {        // >= 647 because in the input array, it goes from 0-646 ever tho there's 647 lines of code. so input[647] doesn't exist
                        System.out.println(lineNum);
                        accCorrupted = accumulator;
                        System.out.println("Answer " + accCorrupted);
                        isDone = true;
                        i = input.length + 1;
                        break;
                    }
                    else
                    {
                        String[] instruction = input[lineNum].split(" ");

                        String operation;
                        char sign = instruction[1].charAt(0);
                        int argument = Integer.parseInt(instruction[1].substring(1));

                        if(input[i].contains("jmp") && lineNum == i)
                        {
                            operation = "nop";
                        }
                        else if(input[i].contains("nop") && lineNum == i)
                        {
                            operation = "jmp";
                        }
                        else
                        {
                            operation = instruction[0];
                        }

                        //System.out.println(instruction[1]);
                        if(lineCounter.get(lineNum) == null)
                        {
                            int j = 1;
                            lineCounter.put(lineNum, j);
                        } else{
                            //lineCounter.put(lineNum, lineCounter.get(lineNum)+1);
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
                }
                lineCounter.clear();
            }
        
        }
        
    }
    

