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
     * This method attempts to determine the two keys used to encrypt the message, 
     * prints the two keys, and then returns the decrypted String with those two keys. 
     * More specifically, this method should:
     *     ○ Calculate a String of every other character starting with the first character of the
     *       encrypted String by calling halfOfString.
     *     ○ Calculate a String of every other character starting with the second character of
     *      the encrypted String.
     *     ○ Then calculate the key used to encrypt each half String.
     *     ○ You should print the two keys found.
     *     ○ Calculate and return the decrypted String using the encryptTwoKeys method
     *      from your CaesarCipher class, again making sure it is in the same folder as your
     *      CaesarBreaker class.
     * 
     * @param encrypted
     * @return 
     */
    public String decryptTwoKeys (String encrypted) {
        CaesarCipherMy ccM = new CaesarCipherMy();
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        System.out.println("firstHalf" + "\t" + firstHalf + "\t"  + "secondHalf" + "\t" + secondHalf);
        
        int firstKey = getKey(firstHalf);
        int secondKey = getKey(secondHalf);
        
        System.out.println("firstKey" + "\t" + firstKey + "\t"  + "secondKey" + "\t" + secondKey);
        
        return ccM.encryptTwoKeys(encrypted, firstKey, secondKey);
    }
    
    /**
     * This method should return a new String that is every other character from message 
     * starting with the start position. For example, the call halfOfString(“Qbkm Zgis”, 0) 
     * returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String
     * “bm Zi” . Be sure to test this method with a small example.
     * 
     * @param message
     * @param start
     * @return 
     */
    public String halfOfString(String message, int start) {
        if (start != 1 || start != 0) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            int idx = message.indexOf(c);
            if(idx%2 == start) {
            sb = sb.append(c);
            }
        }
        return sb.toString();
        }
        return null;
    }
    
    /**
     * This method should call countLetters to get an array of the letter frequencies in String s
     * and then use maxIndex to calculate the index of the largest letter frequency, which is
     * the location of the encrypted letter ‘e’, which leads to the key, which is returned.
     * 
     * @param s 
     * @return  
     */
    public int getKey(String s) {
        int[] freqs = countLettersMod(s);
        return maxIndex(freqs);
    }
}
    

