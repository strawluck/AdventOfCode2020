/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCodeDay7;


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
        String s = "";
        int counter = 0;
        boolean isDone = false;
        ArrayList<String> directlyHold = new ArrayList<String>();        // creates an array list to store the puzzleInput
        BufferedReader br = null;
        ArrayList<ArrayList<String>> aList
                = new ArrayList<ArrayList<String>>();

        try {       // stores the puzzleInput in the array list
            br = new BufferedReader(new FileReader("puzzleInput7.txt"));
            String word;
            while ((word = br.readLine()) != null) {

                String[] split = word.split("bags contain");
                
                ArrayList<String> a1 = new ArrayList<String>();
                for(int i = 0; i < split.length; i++){
                    a1.add(split[i]);
                }
                aList.add(a1);

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

        //String[] passports = new String[input.size()];      // converts the ArrayList to an Array
        //input.toArray(passports);
        
        /*for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.get(i).size(); j++) {
                System.out.println(aList.get(i).get(j));
            }
            //System.out.println();
        }*/
        
        for (int i = 0; i < aList.size(); i++) {
            for (int j = 1; j < aList.get(i).size(); j++) {     // starts at j = 1 because the first bag holder doesn't count (looking for shiny gold that would be inside a bag colour)
                if(aList.get(i).get(j).contains("shiny gold")){
                    directlyHold.add(aList.get(i).get(0));
                    counter++;
                    aList.remove(i);
                    i--;
                }
            }
        }
        for(String a: directlyHold){
            System.out.println(a);
        }
        //System.out.println(counter);
        
        while(!isDone){
            int size = directlyHold.size();
            //System.out.println(directlyHold.get(0));
            for(int k = 0; k < directlyHold.size(); k++){
                for (int i = 0; i < aList.size(); i++){
                    for (int j = 1; j < aList.get(i).size(); j++) {
                        if (aList.get(i).get(j).contains(directlyHold.get(k))) {
                            //System.out.println("hello");
                            directlyHold.add(aList.get(i).get(0));
                            counter++;
                            aList.remove(i);
                            i--;
                        }
                    }
                }
            }
            
            for(int i = size - 1; i < 0; i--){
                directlyHold.remove(i);
            }
            
            /*if(counter == 348){
                for (String a : directlyHold) {
                    System.out.println(a);
                }
            }*/
            if(directlyHold.size() <= 0){
                isDone = true; 
                
            }
            System.out.println(aList.size());
            //System.out.println(counter);
        }
        System.out.println(counter);
    }
}
