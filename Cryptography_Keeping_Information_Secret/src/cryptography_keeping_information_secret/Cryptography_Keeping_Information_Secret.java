/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography_keeping_information_secret;

import edu.duke.FileResource;

/**
 *
 * @author Lartsev
 * 
 * In this module, we will learn about the basics of cryptography, the science of 
 * keeping information private and secure. You will learn about simpler cryptographic 
 * systems, which were used from the Roman Empire through the early 1900s. 
 * You will learn how to implement these ciphers, as well as how to break them. 
 * To solve these problems, you will work more with processing Strings, but also 
 * learn about arrays—a way to store an indexable sequence of elements. 
 * You will be able to: 
 * (1) combine Strings using concatenation; 
 * (2) build Strings within a Java program using StringBuilder; 
 * (3) use arrays to store and manipulate collections of data; 
 * (4) refactor your programs for improved organization using object-oriented principles;
 * (5) and practice effective algorithm design.
 */
public class Cryptography_Keeping_Information_Secret {

    /**
     * @param args the command line arguments
     */
    public void testWordPlay() {
        WordPlay wp = new WordPlay();
        String slovo = "slovo";
        char ch = '*';
        String ret = wp.replaceVowels(slovo, ch);
        String ret1 = wp.emphasize("Mary Bella Abracadabra", 'a');
        boolean ret2 = wp.isVowel('A');
        System.out.println(ret1);
    }
    
    public void testCaesarCipherMy() {
        CaesarCipherMy cc = new CaesarCipherMy();
        String ret1 = cc.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23);
        String ret4 = cc.encrypt("XXX YYY HJKL", 23);
        String ret2 = cc.encryptMod("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        String ret3 = cc.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
        //System.out.println(ret1);
        System.out.println(ret2);
        //System.out.println(ret3);
    }
    public void testWordLengths() {
        WordLengths wl = new WordLengths();
        FileResource fr = new FileResource("data/smallHamlet.txt");
        int counts[] = new int[31];
        //wl.countWordLengths(fr, counts);
        wl.countWordLengthsWithIsLettermethod(fr, counts);
    }
    
    public void testDiceRolling() {
        DiceRolling dr = new DiceRolling();
        dr.simpleSimulate(10000);
        System.out.println();
        dr.simulate(10000);
    }
    
    public void testCaesarBreaker() {
        CaesarBreaker cb = new CaesarBreaker();
        
        //("FIRST LEGION ATTACK EAST FLANK!", 23)
        String decrypt = cb.decrypt("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!");
        
        //String ret4 = cc.encrypt("XXX YYY HJKL", 23);
        String decrypt1 = cb.decrypt("UUU VVV EGHI");
        
        String decrypt2 = cb.decrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!");
        
        String decrypt3 = cb.decryptMod("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!");
        System.out.println(decrypt3);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cryptography_Keeping_Information_Secret ckis = new Cryptography_Keeping_Information_Secret();
        //Assignment 1: Word Play
        //ckis.testWordPlay();
        //Assignment 2: Caesar Cipher
        ckis.testCaesarCipherMy();
        //Programming Exercise: Breaking the Caesar Cipher
        //Assignment 1: Word lengths
        //ckis.testWordLengths();
        //testing dice rolling
        //ckis.testDiceRolling();
        //test decrypt
        ckis.testCaesarBreaker();
    }
    
}
