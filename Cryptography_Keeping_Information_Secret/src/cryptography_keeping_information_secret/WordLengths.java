/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography_keeping_information_secret;

import edu.duke.FileResource;

/**
 *
 * @author Lartsev
 * 
 * Programming Exercise: Breaking the Caesar Cipher
 * 
 * Before attempting these assignments, you should type in, compile, and understand the example
 * programs from the lesson including 
 * 1) counting the twenty most common words from  * Shakespeare’s plays, 
 * 2) counting the resulting random rolls of dice (how many 2’s, 3’s, 4’s, etc),
 * 3) automatic decryption of the Caesar Cipher using statistical letter occurrences.
 * 
 * Assignment 1: Word lengths
 */
public class WordLengths {
    
    /**
     * This method should read in the words from resource and count the number of 
     * words of each length for all the words in resource , storing these counts 
     * in the array counts.
     *    ○ For example, after this method executes, counts[k] should contain the number
     *      of words of length k .
     *    ○ If a word has a nonletter as the first or last character, it should not 
     *      be counted as part of the word length. For example, the word And, 
     *      would be considered of length 3 (the comma is not counted), the word “blue-jeans”
     *      would be considered of length 10 (the double quotes are not counted, but the hyphen is).
     *      Note that we will miscount some words, such as “Hello,” which will be 
     *      counted as 6 since we don’t count the double quotes but will count the comma,
     *      but that is OK as there should not be many words in that category.
     *    ○ For any words equal to or larger than the last index of the counts array, count
     *      them as the largest size represented in the counts array.
     *    ○ You may want to consider using the Character.isLetter function that
     *      returns true if a character is a letter, and false otherwise. For example,
     *      Character.isLetter(‘a’) returns true , and Character.isLetter('-') returns false
     * 
     * @param resource
     * @param counts 
     */
    public void countWordLengths(FileResource resource, int[] counts) {
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (String word : resource.words()) {
            String trim = word.trim();
            int wordSize = trim.length();
            //System.out.println("word" + "\t" + trim);
            //int lastInd = trim.length()-1;
            //System.out.println("lastIndexOf word" + "\t" + lastInd);
            //abc.contains(trim.charAt(lastInd));
            char firstChar = trim.charAt(0);
            char endChar = trim.charAt(trim.length()-1);
            //System.out.println("firstChar" + "\t" + firstChar + "\t" + "endChar" + "\t" + endChar);
            int idx = abc.indexOf(firstChar);
            int idx_e = abc.indexOf(endChar);
            //int edx_sum = idx + idx_e;
            //System.out.println("indexes abc" + "\t" + edx_sum);
            //int idx_s = small.indexOf(firstChar);
            //int idx_s_e = small.indexOf(endChar);
            //int edx_s_sum = idx_s + idx_s_e;
            //System.out.println("indexes small" + "\t" + edx_s_sum);
            //System.out.println("indexes" + "\t" + idx + "\t" + idx_e + "\t" + idx_s + "\t" + idx_s_e);
            //System.out.println("indexes" + "\t" + idx + "\t" + idx_e + "\t");
            
            if (idx == -1 && idx_e == -1) {
                wordSize -= 2;
            } else 
            if (idx == -1 || idx_e == -1) {
                wordSize -= 1;
            }
            if(wordSize>=counts.length) {
               counts[counts.length-1] += 1; 
            } else
            //right algorithm
            if( counts[wordSize] != 0) {
                counts[wordSize] += 1;
                
            } else {
                counts[wordSize] = 1;
            }
            
            
            
        }
        
        //test
            for(int i : counts) {
                System.out.println(i);
            }
    }
    /**
     * the method countWordLengths(FileResource resource, int[] counts) with isLetter method
     * 
     * @param resource
     * @param counts 
     */
    public void countWordLengthsWithIsLettermethod(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            String trim = word.trim();
            int wordSize = trim.length();
            char firstChar = trim.charAt(0);
            char endChar = trim.charAt(trim.length()-1);
            if (!Character.isLetter(firstChar) && !Character.isLetter(endChar)) {
                wordSize -= 2;
            } else 
            if (!Character.isLetter(firstChar) || !Character.isLetter(endChar)) {
                wordSize -= 1;
            }
            if(wordSize>=counts.length) {
               counts[counts.length-1] += 1; 
            } else
            //right algorithm
            if( counts[wordSize] != 0) {
                counts[wordSize] += 1;
                
            } else {
                counts[wordSize] = 1;
            }
        }
        
        //test
            for(int i : counts) {
                System.out.println(i);
            }
    }
    
}
