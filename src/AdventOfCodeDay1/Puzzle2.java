/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay1;

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
        int num1, num2, num3, prod;

        ArrayList<String> num = new ArrayList<String>();        // creates an array list to store the booklist.txt data
        BufferedReader br = null;

        try {       // stores the data in booklist.txt in the array list
            br = new BufferedReader(new FileReader("puzzleInput.txt"));
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

        String[] expenseReport = new String[num.size()];      // converts the ArrayList to an Array
        num.toArray(expenseReport);
        int[] expenseInt = new int[num.size()];

        for (int i = 0; i < num.size(); i++) {
            expenseInt[i] = Integer.parseInt(expenseReport[i]);
        }

        num1 = findNum(expenseInt, 1);
        num2 = findNum(expenseInt, 2);
        num3 = findNum(expenseInt, 3);
        prod = num1 * num2 * num3;
        System.out.println(prod);
    }

    public static int findNum(int[] A, int whichNum) {       // finds the numbers that add up to equal 2020
        int num = 0, sum;

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                for(int k = 1; k < A.length; k++){
                    sum = A[i] + A[j] + A[k];

                    if (sum == 2020) {
                        if (whichNum == 1) {      // if whichNum = 1, then the method is looking for the first num
                            num = A[i];
                        } else if (whichNum == 2){      // if whichNum = 2, then the method is looking for the second num
                            num = A[j];
                        } else {        // if whichNum = 3, then the method is looking for the second num
                            num = A[k];
                        }
                        return num;
                    }
                }
            }
        }
        return 0;
    
    }
    
}
