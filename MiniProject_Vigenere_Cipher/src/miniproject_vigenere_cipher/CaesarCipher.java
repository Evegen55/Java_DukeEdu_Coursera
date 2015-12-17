package miniproject_vigenere_cipher;

import edu.duke.*;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;
    
    public CaesarCipher(int key) {
        theKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +
                            alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }
    /**
     * 
     * @param c
     * @param from
     * @param to
     * @return 
     */
    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }
    /**
     * 
     * @param c
     * @return encrypt one single character
     */
    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }
    /**
     * 
     * @param c
     * @return decrypt one single character
     */
    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }
    /**
     * 
     * @param input
     * @param from
     * @param to
     * @return 
     */
    private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
    /**
     * 
     * @param input
     * @return 
     */
    public String encrypt(String input) {
        return transform(input, alphabet, shiftedAlphabet);
    }
    /**
     * 
     * @param input
     * @return 
     */
    public String decrypt(String input) {
        return transform(input, shiftedAlphabet, alphabet);
    }
    /**
     * 
     * @return 
     */
    public String toString() {
        return "" + theKey;
    }
    
}
