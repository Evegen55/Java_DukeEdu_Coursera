/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography_keeping_information_secret;

/**
 *
 * @author Lartsev
 */
public class TestSimple {
    public void print() {  	
          Simple item = new Simple(3, "blue");     	
          System.out.println(item);
          //System.out.println(item.mystery(5, "ho"));
     }
    
    public static void main (String[] args) {
        TestSimple ts = new TestSimple();
        ts.print();
    }
}
