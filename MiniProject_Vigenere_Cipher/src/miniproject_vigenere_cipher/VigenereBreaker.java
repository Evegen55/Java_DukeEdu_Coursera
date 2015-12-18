package miniproject_vigenere_cipher;

import java.util.*;
import edu.duke.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
        FileResource fr = new FileResource();
        String asString = fr.asString();
        int[] tryKeyLengthtest = tryKeyLength(asString, 4, 'e');
        VigenereCipher vc = new VigenereCipher(tryKeyLengthtest);
        String decrypt = vc.decrypt(asString);
        System.out.println(decrypt);
        
        //code for quiz
        for (int i : tryKeyLengthtest) {
            System.out.println(i);
        }
    }
    /**
     * 
     * @param fr
     * @return 
     */
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> hs = new HashSet<String>();
        for (String line : fr.lines()) {
            hs.add(line.toLowerCase());
        }
        return hs;
    }
    /**
     * 
     * @param message
     * @param dictionary
     * @return This method should return the integer count of how many valid words it found
     * 
     */
    public int countWords(String message, HashSet<String> dictionary) {
        int counts = 0;
        String[] split = message.split("\\W");
        for (String iter : split) {
            if (dictionary.contains(iter)) {
                counts++;
            }
        }
        return counts;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) throws FileNotFoundException {
       PrintWriter writer = new PrintWriter("the-file-name.txt");
       
       String decrypt = null; 
       for(int i = 1; i < 101; i++) {
            int[] kl =  tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(kl);
            decrypt = vc.decrypt(encrypted);
            int countWords = countWords(decrypt, dictionary);
            
            //print
            for (int k : kl) {
                //System.out.print("keys" + "\t" + k + "\t");
                writer.print("keys" + "\t" + k + "\t");
            }
            //System.out.println();
            //System.out.println("countWords" + "\t" +countWords);
            writer.println("countWords" + "\t" +countWords);
            //System.out.println();
            //System.out.println(decrypt);
            //System.out.println();
            //System.out.println();
            writer.println(decrypt);
            writer.println("============================================================================");
            
            
            /*
            if(kl.length>2) {
                break;
            }
            */
        }
       writer.close(); 
        return decrypt;
    }
}
