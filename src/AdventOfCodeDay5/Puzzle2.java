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
public class Puzzle2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> input = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;
        int row = 0, col = 0, seatID, highestSeatID = 0, lowestSeatID = 1023, mySeat = 0;
        boolean numFound = false;

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
        //int[] seatIDArr = new int[input.size()];
        ArrayList<Integer> seatIDArr = new ArrayList<Integer>();
        
        for (int i = 0; i < boardingPasses.length; i++) {     // check each line of the puzzleInput
            int size = 128, min = 0, max = 127;
            String s = boardingPasses[i];

            for (int j = 0; j < 7; j++) {     // checks all the F and B's to find the row # by checking the first 7 characters of the string
                size = size / 2;
                if (s.charAt(j) == 'F') {     // if the character is 'f', then the max value changes
                    max = max - size;
                } else if (s.charAt(j) == 'B') {      // if the character is 'b', then the min value changes
                    min = min + size;
                }

                if (max == min) {     // when max = min, then the row # is found
                    row = max;
                }
            }

            // checks all the L and R's to find the col #
            size = 8;
            min = 0;
            max = 7;
            for (int l = 7; l < s.length(); l++) {     // checks the last 3 characters of the string
                size = size / 2;
                if (s.charAt(l) == 'L') {     // if the character is 'L', then the max value changes
                    max = max - size;
                } else if (s.charAt(l) == 'R') {      // if the character is 'R', then the min value changes
                    min = min + size;
                }

                if (max == min) {     // when max = min, then the col # is found
                    col = min;
                }
            }

            seatID = row * 8 + col;     // calculates the seat ID for that string
            seatIDArr.add(seatID);
            //seatIDArr[i] = seatID;
            //System.out.println(seatID);

            if (seatID > highestSeatID) {     // finds the largest seat ID
                highestSeatID = seatID;
            }
            if (seatID < lowestSeatID) {        // finds the lowest seat ID
                lowestSeatID = seatID;
            }
            
        }
        System.out.println(seatIDArr.size());
        ArrayList<Integer> seatsAvailable = new ArrayList<>();
        
        for(int i = lowestSeatID; i <= highestSeatID; i++){
            seatsAvailable.add(i);
        }
        System.out.println(seatsAvailable.size());
        
        //Integer[] nSeatsAvailable = seatsAvailable.toArray(new Integer[0]);

        /*for (Integer n : nSeatsAvailable) {       // prints the array nSeatsAvailable
            System.out.println(n);
        }*/
        
        /*for (int m = 0; m < seatsAvailable.size(); m++){       // this works and goes through the whole array list 
            int b = seatsAvailable.get(m);
            System.out.println(b);
        }*/
        
        for (int m = 0; m < seatIDArr.size(); m++) {
            //System.out.println(seatIDArr[m]);
            //for (int n = 0; n < seatIDArr.size(); n++) {

                //int b = seatsAvailable.get(m);
                //System.out.println(b);
                numFound = binarySearch(seatsAvailable, lowestSeatID, highestSeatID, seatIDArr.get(m));

                if(numFound != true){
                    mySeat = seatIDArr.get(m); 
                    System.out.println(mySeat);
                    //m = seatIDArr.size();
                }
                /*if (b == seatIDArr.get(n)) {
                    System.out.println(seatIDArr.get(n));
                    seatsAvailable.remove(m);
                    numFound = true;
                    n = seatIDArr.size();
                } else {
                    //System.out.println(seatIDArr.get(n));
                    numFound = false;
                }
            }
        
        /*for (int m = 0; m < seatIDArr.length; m++){
            //System.out.println(seatIDArr[m]);
            for(int n = 0; n <= seatIDArr.length; n++){
                
                int b = seatsAvailable.get(m);
                //System.out.println(b);
                
                if(b == seatIDArr[n]){
                    //System.out.println(b);
                    seatsAvailable.remove(m);
                    //System.out.println(seatIDArr[m] + " " + n);
                    numFound = true;
                   // n = seatIDArr.length;
                } else{
                    numFound = false;
                }
            }*/
            
            /*if(numFound = false){
                mySeat = seatsAvailable.get(m);;
                //System.out.println("hello");
                m = seatIDArr.size();
            } else{
                numFound = false;       // reset numFound
            }*/
            
        }
        
        System.out.println(mySeat);
    }
    
    public static Boolean binarySearch(ArrayList<Integer> A, int first, int last, int key) {
        int middle;

        //System.out.println(V);
        
        int mid = (first + last) / 2;
        while (first <= last) {
            if (A.get(mid) < key) {
                first = mid + 1;
            } else if (A.get(mid) == key) {
                return true;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            return false;
        }
        
        return true;
        /*if (left > right) {
            return false;
        }

        middle = (left + right) / 2;
        //int compare = V.compareTo(A[middle]);
        if (left == right) {
            return true;
        }
        
        if (V < middle) {
            return binarySearch(A, left, middle - 1, V);
        } else {
            return binarySearch(A, middle + 1, right, V);
        }*/
    }
    
    
}
