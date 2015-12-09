/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

/**
 *
 * @author Lartsev
 */
public class GladLibs_Stories_From_Templates {
    
    /**
     * 
     */
    public void testerFindUnique() {
        WordFrequencies wF = new WordFrequencies();
        wF.findUnique();
        int sizeOf = wF.getMyWords().size();
        System.out.println(sizeOf);
        for(int i=0; i<sizeOf; i++){
             System.out.print(wF.getMyWords().get(i) + "\t");
             System.out.println(wF.getMyFreqs().get(i));
        }
        System.out.println();
        System.out.println("The numbers of the most frequently word is" + "\t" + wF.findIndexOfMax());
    }
    /**
     * 
     */
    public void testerFindAllCharacters(){
        CharactersInPlay cps = new CharactersInPlay();
        cps.findAllCharacters();
        cps.charactersWithNumParts(9, 16);
        /*for test on the web-site
        int find = cps.getNames().indexOf("ROSALIND");
        System.out.println(cps.getCountNames().get(find));
        */
    }

    /**
     *
     */
    public void testGladLib() {
        GladLib glb = new GladLib();
        glb.makeStory();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GladLibs_Stories_From_Templates ex = new GladLibs_Stories_From_Templates ();
        // Assignment 1: Most Frequent Word
        System.out.println();
        System.out.println("Assignment 1: Most Frequent Word");
        ex.testerFindUnique();
        // Assignment 2: Character Names
        System.out.println();
        System.out.println("Assignment 2: Character Names");
        ex.testerFindAllCharacters();
        // Programming Exercise: Using GladLibs
        System.out.println();
        System.out.println("Programming Exercise: Using GladLibs");
        ex.testGladLib();
        
    }
    
}
