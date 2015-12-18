package miniproject_vigenere_cipher;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    /**
     * Write the public method sliceString , which has three parameters—a String message,
     * representing the encrypted message, an integer whichSlice , indicating the index the
     * slice should start from, and an integer totalSlices , indicating the length of the key. 
     *  
     * You can test your method on these examples:
     * sliceString("abcdefghijklm", 0, 3) should return "adgjm"
     * sliceString("abcdefghijklm", 1, 3) should return "behk"
     * 
     * @param message
     * @param whichSlice
     * @param totalSlices
     * @return String consisting of every totalSlices-th character from message,
     * starting at the whichSlice-th character.
     */
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for(int i = whichSlice; i < message.length(); i=i+totalSlices) {
            char c = message.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
    
    /**
     * Write the public method tryKeyLength, which takes three parameters—a String
     * encrypted that represents the encrypted message, an integer klength that represents
     * the key length, and a character mostCommon that indicates the most common
     * character in the language of the message. This method should make use of the
     * CaesarCracker class, as well as the sliceString method, to find the shift for each index
     * in the key. You should fill in the key (which is an array of integers) and return it. 
     * 
     * Test this method on the text file athens_keyflute.txt , which is a scene from 
     * "A Midsummer Night’s Dream" encrypted with the key “flute”, and make sure 
     * you get the key {5, 11, 20, 19, 4}.
     * 
     * @param encrypted
     * @param klength
     * @param mostCommon
     * @return 
     */

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i<klength; i++) {
            String sliced = sliceString(encrypted, i, klength);
            int findedKey = cc.getKey(sliced);
            key[i] = findedKey;
        }
        return key;
    }
    
    /**
     * This void method should put everything together, so that you can create 
     * a new VigenereBreaker in BlueJ, call this method on it, and crack the cipher 
     * used on a message. This method should perform 6 tasks (in this order):
     *     a. Create a new FileResource using its default constructor (which displays a dialog
     *        for you to select a file to decrypt).
     *     b. Use the .asString() method to read the entire contents of the file into a String.
     *     c. Use the tryKeyLength method, which you just wrote, to find the key for the
     *        message you read in. For now, you should just pass ‘e’ for mostCommon .
     *     d. You should create a new VigenereCipher , passing in the key that tryKeyLength
     *        found for you.
     *     e. You should use the VigenereCipher ’s decrypt method to decrypt the encrypted
     *        message.
     *     f. Finally, you should print out the decrypted message!
     * 
     * Test this method on the text file athens_keyflute.txt , using key length 5. 
     * The first line should be “SCENE II. Athens. QUINCE'S house.”
     */

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String asString = fr.asString();
        int[] tryKeyLengthtest = tryKeyLength(asString, 5, 'e');
        VigenereCipher vc = new VigenereCipher(tryKeyLengthtest);
        String decrypt = vc.decrypt(asString);
        System.out.println(decrypt);
    }
    
}
