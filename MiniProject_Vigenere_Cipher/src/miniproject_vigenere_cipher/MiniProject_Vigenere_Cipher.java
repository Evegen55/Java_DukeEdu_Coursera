/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_vigenere_cipher;

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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MiniProject_Vigenere_Cipher mp = new MiniProject_Vigenere_Cipher();
        //test testCaesarCipherOO
        mp.testCaesarCipherOO();
    }
    
}
