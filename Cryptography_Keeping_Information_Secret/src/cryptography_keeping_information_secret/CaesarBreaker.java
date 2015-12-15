/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography_keeping_information_secret;

/**
 *
 * @author Lartsev
 * Assignment 2: Caesar Cipher Two Keys Decrypt
 */
public class CaesarBreaker {
    
    /**
     * Fint max index in an array
     * @param freqs
     * @return 
     */
    public int maxIndex(int[] freqs) {
        int max = freqs[0];
        for (int i = 1; i < freqs.length; i++) {
            if (freqs[i] > max) {
                max = freqs[i];
            }
        } 
        return freqs[max];
        //return max;
    }
    /**
     * 
     * @param message 
     * @return  
     */
    public int[] countLetters(String message) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k<message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = abc.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    /**
     * Decrypt message yhal has been in big letters and encrypted with one key
     * @param encrypted
     * @return 
     */
    public String decrypt (String encrypted) {
        CaesarCipherMy ccM = new CaesarCipherMy();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4) {
            dkey = 26 - ( 4 - maxDex);
        }
        return ccM.encrypt(encrypted, 25-dkey); // we can use encryptMod method
    }
    
    
    
    
    
    
    
    /**
     * Decrypt message yhal has been in big and small letters and encrypted with one key
     * @param encrypted
     * @return 
     */
    public String decryptMod (String encrypted) {
        CaesarCipherMy ccM = new CaesarCipherMy();
        int[] freqs = countLettersMod(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4) {
            dkey = 26 - ( 4 - maxDex);
        }
        return ccM.encryptMod(encrypted, 33-dkey); // we can use encryptMod method
    }
    public int[] countLettersMod(String message) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[52];
        for (int k = 0; k<message.length(); k++) {
            //char ch = Character.toLowerCase(message.charAt(k));
            char ch = message.charAt(k);
            int dex = abc.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    
    
    
    
    
    /**
     * In order to decrypt the encrypted String, it may be easier to split the String 
     * into two Strings, one String of all the letters encrypted with key1 
     * and one String of all the letters encrypted with key2 . Then use the algorithm from the
     * lesson to determine the key for each String, and then use those keys and the two key
     * encryption method to decrypt the original encrypted message. 
     * For example, if the encrypted message was “Qbkm Zgis” , then you would split this String into
     * two Strings: “Qk gs” , representing the characters in the odd number positions and “bmZi”
     * representing the characters in the even number positions. Then you would get the key for each
     * half String and use the two key encryption method to find the message. Note this example is so
     * small it likely won’t find the keys, but it illustrates how to take the Strings apart.
     * 
     * @param encrypted
     * @return 
     */
    public String decryptTwoKeys (String encrypted) {
        String decrypt = decrypt(encrypted);
        
        return null;
    }
}
    

