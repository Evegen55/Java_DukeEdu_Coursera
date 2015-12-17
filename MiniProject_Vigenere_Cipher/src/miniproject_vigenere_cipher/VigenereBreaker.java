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

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
}
