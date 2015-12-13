/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography_keeping_information_secret;

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
    public static void main(String[] args) {
        // TODO code application logic here
        Cryptography_Keeping_Information_Secret ckis = new Cryptography_Keeping_Information_Secret();
        ckis.testWordPlay();
    }
    
}
