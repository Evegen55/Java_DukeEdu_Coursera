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
public class CaesarCipherMy {
    
    /**
     * This method returns a string that has been encrypted using the Caesar Cipher Algorithm 
     * explained in the videos. Assume that all the alphabetic characters are uppercase letters. 
     * For example, the call encrypt("FIRST LEGION ATTACK EAST FLANK!", 23) should return the string
     * "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!"
     * 
     * @param input
     * @param key
     * @return 
     */
    public String encrypt(String input, int key) {
        StringBuilder enc = new StringBuilder(input);
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAbc = abc.substring(key)+abc.substring(0,key);
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
     * @param key
     * @return 
     */
    public String encryptMod(String input, int key) {
        StringBuilder enc = new StringBuilder(input);
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedAbc = abc.substring(key)+abc.substring(0,key);
        String shiftedAbcSmall = small.substring(key)+small.substring(0,key);
        
        for(int i = 0; i < enc.length(); i++) {
            char currChar = enc.charAt(i);
            System.out.print(currChar + "\t");
            
            int idx = abc.indexOf(currChar);
            System.out.println(idx);
            
            
            if(idx != -1){
                char newChar = shiftedAbc.charAt(idx);
                System.out.println("newChar" + "\t" + newChar + "\t");
                enc.setCharAt(i, newChar);
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
        return null;
    }
    
    
}
