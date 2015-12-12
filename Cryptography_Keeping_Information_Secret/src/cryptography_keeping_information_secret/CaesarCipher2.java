package cryptography_keeping_information_secret;

import edu.duke.*;

public class CaesarCipher2 {
    public String encrypt(String input, int keyone, int keysecond) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input.toLowerCase());
        //Write down the alphabet
        //  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedAlphabetone = alphabet.substring(keyone)+
        alphabet.substring(0,keyone);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i=i+2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetone.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        
        String shiftedAlphabetsecond = alphabet.substring(keysecond)+alphabet.substring(0,keysecond);
        for(int i = 1; i < encrypted.length(); i=i+2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetsecond.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int keyone = 12;
        int keysecond=19;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, keyone, keysecond);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-keyone, 26-keysecond);
        System.out.println(decrypted);
    }
}