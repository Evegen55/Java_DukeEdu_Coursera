/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_vigenere_cipher;

/**
 *
 * @author Johnn
 */
public class CaesarCipherOO {
    private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAbc;
    private String small = "abcdefghijklmnopqrstuvwxyz";;
    private String shiftedAbcSmall;
    
    /**
     * 
     * @param key 
     */
    public CaesarCipherOO(int key) {
        shiftedAbc = abc.substring(key)+abc.substring(0,key);
        shiftedAbcSmall = small.substring(key)+small.substring(0,key);
    }
    /**
     * @param input
     * @return This method returns a string that has been encrypted using the Caesar Cipher 
     * only in BIG letters. For example, the call encrypt("FIRST LEGION ATTACK EAST FLANK!") with key 23
     * should return the string "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!"
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
     * @param input
     * @return This method returns a string that has been encrypted using the Caesar Cipher 
     * both uppercase and lowercase letters.  For example, encrypt("First Legion")  with key 23
     * should return “Cfopq Ibdflk” and encrypt("First Legion")  with key 17 should return “Wzijk Cvxzfe”. 
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
    
    public char encryptLetter(char c) {
        
        return 'c';
        
    }
    
    
}
