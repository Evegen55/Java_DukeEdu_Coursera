/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_vigenere_cipher;

import edu.duke.FileResource;

/**
 *
 * @author Lartsev
 * 
 * In this module, you will develop a program to break the Vigenère Cipher, 
 * a more complex version of the Caesar Cipher. You will improve your program 
 * in three stages: first decrypting messages where you know the language and key length,
 * then adding the capability to handle messages with unknown key length, 
 * then extending the program to handle messages in a range of possible languages. 
 * Through this project, you will be able 
 * (1) to effectively use HashSet and HashMap, 
 * (2) to expand an algorithm from solving a simpler problem to handle broader, 
 *     more complex problems, and 
 * (3) to design and modify program code involving a more complex collection 
 *     of classes, methods, and data.
 */
public class MiniProject_Vigenere_Cipher {
    private int key;
    private final String folder = "data";
    private final String subFolder1 = "messages";
    private final String subFolder2 = "dictionaries";
    private String filename;
    private final String separator = "/";
    
    /**
     * 
     */
    public void testCaesarCipherOO() {
        key = 23;
        CaesarCipherOO cc1 = new CaesarCipherOO(key);
        String encryptBig = cc1.encrypt("FIRST LEGION ATTACK EAST FLANK!");
        String encryptMod = cc1.encryptMod("First Legion");
        
        key = 17;
        CaesarCipherOO cc2 = new CaesarCipherOO(key);
        String encryptMod2 = cc2.encryptMod("First Legion");
        
        System.out.println("encryptBig" + "\t" + encryptBig + "\n" + "encryptMod" + "\t" + encryptMod + "\n" + "encryptMod2" + "\t" + encryptMod2);
    }
    /**
     * 
     */
    public void testCaesarCipher() {
        key = 5;
        filename = "titus-small.txt";
        CaesarCipher cc = new CaesarCipher(key);
        FileResource fr = new FileResource(folder+separator+filename);
        System.out.println("testing string encryted and decrypted");
        for (String line : fr.lines()) {
            String enc = cc.encrypt(line);
            String dec = cc.decrypt(enc);
            System.out.println("String before encrypting" + "\t" + line);
            System.out.println("String after encrypting" + "\t" + "\t" + enc);
            System.out.println("String after decrypting" + "\t" + "\t" + dec + "\n");
            
            
        }
        System.out.println("testing char encryted and decrypted");
        for (String line : fr.lines()) {
            for (char c : line.toCharArray()) {
                char encCh = cc.encryptLetter(c);
                char decCh = cc.decryptLetter(encCh);
                System.out.println("before enc" + "\t" + c + "\t" + "after enc" + "\t" + encCh + "\t" + "after dec" + "\t" + decCh);
            }
        }
    }
    
    public void testCaesarCracker() {
        filename = "titus-small_key5.txt";
        CaesarCracker ccr = new CaesarCracker();
        CaesarCracker ccr2 = new CaesarCracker('a');
        FileResource fr = new FileResource(folder+separator+filename);
        String asString = fr.asString();
        //--------------------------------------------
        //bad way for decrypting because statistical data for most common letter is bad
        for (String line : fr.lines()) {
            String decByCracker = ccr.decrypt(line);
            System.out.println("String after decrypting" + "\t" + "\t" + decByCracker );
        }
        //--------------------------------------------
        System.out.println();
        String decByCrackerasString = ccr.decrypt(asString);
        System.out.println("String after decrypting" + "\n" + decByCrackerasString);
    }
    
    /**
     * You can test methods from VigenereCipher class in the tester class by creating a VigenereCipher
     * object with the key “rome”, which is {17, 14, 12, 4} in integers and encrypting and
     * decrypting the file titussmall. txt , the encrypted first line of which is 
     * "Tcmp-pxety mj nikhqv htee mrfhtii tyv".
     */
    public void testVigenereCipher() {
        filename = "titus-small.txt";
        int[] keyArr = {17, 14, 12, 4};
        VigenereCipher cv = new VigenereCipher(keyArr);
        FileResource fr = new FileResource(folder+separator+filename);
        String asString = fr.asString();
        String dec = cv.encrypt(asString);
        System.out.println();
        System.out.println(dec);
    }
    public void testVigenereBreaker() {
        VigenereBreaker vb = new VigenereBreaker();
        String sliceString = vb.sliceString("abcdefghijklm", 0, 3);
        String sliceString2 = vb.sliceString("abcdefghijklm", 1, 3);
        String sliceString3 = vb.sliceString("abcdefghijklm", 2, 5);
        System.out.println();
        System.out.println(sliceString);
        System.out.println(sliceString2);
        System.out.println(sliceString3);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MiniProject_Vigenere_Cipher mp = new MiniProject_Vigenere_Cipher();
        //test testCaesarCipherOO
        //mp.testCaesarCipherOO();
        //test CaesarCipher
        //mp.testCaesarCipher();
        //System.out.println();
        // test CaesarCracker
        //mp.testCaesarCracker();
        // test VigenereCipher
        //System.out.println("test VigenereCipher");
        //mp.testVigenereCipher();
        // test VigenereBreaker
        System.out.println("test VigenereBreaker");
        mp.testVigenereBreaker();
        
    }
    
}
