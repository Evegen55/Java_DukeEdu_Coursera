/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography_keeping_information_secret;

/**
 *
 * @author Johnn
 */
public class WordPlay {
    
    
    /**
     * This method returns true if ch is a vowel (one of a, e, i, o, or u or the uppercase versions) 
     * and false otherwise. You should write a tester method to see if this method works correctly. 
     * For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
     * 
     * @param ch
     * @return 
     */
    public boolean isVowel (char ch) {
        char chr = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                // || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                ) {
            return true;
        }
        return false;
    }
    /**
     * This method should return a String that is the string phrase with all
     * the vowels (uppercase or lowercase) replaced by ch . For example, the call
     * replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld” . Be sure 
     * to call the method isVowel that you wrote and also test this method.
     * 
     * @param phrase
     * @param ch
     * @return 
     */
    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder();
        char[] arr = phrase.toCharArray();
        for(char c : arr) {
            if (!isVowel(c)) {
                sb = sb.append(c);
            } else {
                //c = ch;
                sb = sb.append(ch);
            }
            
        }
        return sb.toString();
    }
    
    /**
     * This method should return a String that is the string phrase but with the character ch 
     * (upper or lowercase) replaced by
     * ○ ‘*’ if it is in an odd number location in the string 
     *   (first character has index 0,third character has index 2, etc.)
     * ○ ‘+’ if it is in an even number location in the string 
     *   (second character has index 1, fourth character has index 3, etc.)
     * For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, 
     * and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”.
     * Be sure to test this method.
     * 
     * @param phrase
     * @param ch
     * @return 
     */
    public String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder();
        //char chr = Character.toLowerCase(ch);
        char[] arr = phrase.toCharArray();
        for(int i = 0; i<arr.length; i++) {
            char c = arr[i];
            char chr = Character.toLowerCase(c);
            if (!isVowel(chr) || chr != ch) {
                sb = sb.append(c);
            } else if((i%2 == 0) && chr == ch){
                
                sb = sb.append('*');
            } else if((i%2 == 1) && chr == ch){
                
                sb = sb.append('+');
            } 
        }
        return sb.toString();
    }
}
