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
public class CaesarCipherOO {
    private String abc;
    private String shiftedAbc;
    private String small;
    private String shiftedAbcSmall;
    
    /**
     * 
     * @param key 
     */
    public CaesarCipherOO(int key) {
        abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAbc = abc.substring(key)+abc.substring(0,key);
        small = "abcdefghijklmnopqrstuvwxyz";
        shiftedAbcSmall = small.substring(key)+small.substring(0,key);
        
    }
    /**
     * This method returns a string that has been encrypted using the Caesar Cipher Algorithm 
     * explained in the videos. Assume that all the alphabetic characters are uppercase letters. 
     * For example, the call encrypt("FIRST LEGION ATTACK EAST FLANK!", 23) should return the string
     * "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!"
     * 
     * @param input
     * @return 
     */
    public String encrypt(String input) {
        StringBuilder enc = new StringBuilder(input);
        for(int i = 0; i < enc.length(); i++) {
            char currChar = enc.charAt(i);
            int idx = abc.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAbc.charAt(idx);
                enc.setCharAt(i, newChar);
            }
        }
        return enc.toString();
    }
    /**
     * Modify the encrypt method to be able to handle both uppercase and lowercase letters.
     * For example, encrypt("First Legion", 23) should return “Cfopq Ibdflk” and 
     * encrypt("First Legion", 17) should return “Wzijk Cvxzfe”. Be sure to test the encrypt method.
     * @param input
     * @return 
     */
    public String encryptMod(String input) {
        StringBuilder enc = new StringBuilder(input);
        for(int i = 0; i < enc.length(); i++) {
            //work with big letters 
            char currChar = enc.charAt(i);
            int idx = abc.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAbc.charAt(idx);
                enc.setCharAt(i, newChar);
            } else {
                //work with small letters
                int idx_s = small.indexOf(currChar);
                if(idx_s != -1) {
                    char newCharSmall = shiftedAbcSmall.charAt(idx_s);
                    enc.setCharAt(i, newCharSmall);
                }
            }
        }
        return enc.toString();
    }
    /**
     * This method returns a String that has been encrypted using the following algorithm. 
     * Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, 
     * starting with the first character, and key2 is used to encrypt every other character, 
     * starting with the second character. For example, the call encryptTwoKeys(“First Legion”, 23, 17)
     * should return “Czojq Ivdzle” . Note the ‘F’ is encrypted with key 23, 
     * the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method.
     * @param input
     * @param key1
     * @param key2
     * @return 
     */
    public String encryptTwoKeys(String input,int key1, int key2) {
        //TODO!!!!!!!!!
        String encKey1 = encryptMod(input,key1);
        String encKey2 = encryptMod(input,key2);
        StringBuilder enc = new StringBuilder(input);
        for(int i = 0; i < enc.length(); i++) {
            if (i%2 == 0) {
                char currChar = encKey1.charAt(i);
                enc.setCharAt(i, currChar);
            } else  {
                char currChar = encKey2.charAt(i);
                enc.setCharAt(i, currChar);
            }
        }
        return enc.toString();
    }
    
    public char encryptLetter(char c) {
        
        return 'c';
        
    }
    
    
}
