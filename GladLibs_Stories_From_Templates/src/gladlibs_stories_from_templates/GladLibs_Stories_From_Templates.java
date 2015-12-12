/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

import java.util.ArrayList;

/**
 *
 * @author Lartsev
 * 
 * After completing this module, you will be able 
 * (1) to program a word frequency counter to analyze any input text file, 
 * (2) to select and substitute words from a list into a document template using both ArrayList and HashMap, 
 * (3) to create new lists to use in templates, 
 * (4) to recognize brittle code, and 
 * (5) to improve code with flexible, object-oriented design. 
 * You will gain these skills in the framework of developing a randomly generated 
 * story that we call GladLibs. You may discover that bald lions change 
 * peoples’ lives, or that fluffy dinosaurs get things done in a jiffy.
 * We hope you have fun developing your Java skills this week!
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
        cps.charactersWithNumParts(1, 100);
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
    /*
    Write a tester method that prompts the user for a file that contains a DNA strand 
    (could be upper or lower case letters in the file, convert them all to uppercase, 
    since case should not matter). 
    Then for each of the three possible reading frames, this method
         ○ builds a HashMap of codons to their number of occurrences in the DNA strand
         ○ prints the total number of unique codons in the reading frame
         ○ prints the most common codon and its count
         ○ prints the codons and their number of occurrences for those codons whose
           number of occurrences in this reading frame are between two numbers inclusive
    */
    public void testCountDNA() {
        CountDNA cdna = new CountDNA();
        for(int i = 0; i<3; i++) {
            System.out.println("Reading frame starting with " + i);
            ArrayList<String> buildCodonList = cdna.buildCodonList(i);
            for (String dna : buildCodonList) {
                cdna.buildCodonMap(i, dna);
            }
            cdna.printCodonCounts(0, 1000);
            System.out.println("The most common codon is"+ "\t" + cdna.getMostCommonCodon() + "\n");
            cdna.getMapCodons().clear();
        }
    }
    /*
    Write the void method tester that has no parameters. This method should
        ○ call buildWordFileMap() to select a group of files and build a HashMap of words,
           with each word mapped to an ArrayList of the filenames this word appears in.
        ○ determine the maximum number of files any word is in, considering all words.
        ○ determine all the words that are in the maximum number of files and for each
          such word, print the filenames of the files it is in.
        ○ (optional) If the map is not too big, then you might want to print out the complete
          map, all the keys, and for each key its ArrayList. This might be helpful to make
          sure the map was built correctly.
    */
    public void testWordsInFiles() {
        WordsInFiles win = new WordsInFiles();
        win.buildWordFileMap();
        int numMax = win.maxNumber();
        System.out.println(numMax);
        System.out.println();
        
        ArrayList<String> wordsInNumFiles = win.wordsInNumFiles(7);
        for(String st : wordsInNumFiles) {
            //System.out.println(st);
            //win.printFilesIn(st);
        }
        System.out.println(wordsInNumFiles.size());
        System.out.println();
        win.printFilesIn("laid");
        
    }
    public void testGladLibMap() {
        GladLibMap glbm = new GladLibMap();
        glbm.makeStory();
        System.out.println(glbm.totalWordsInMap());
        System.out.println(glbm.totalWordsConsidered());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GladLibs_Stories_From_Templates ex = new GladLibs_Stories_From_Templates ();
        // Assignment 1: Most Frequent Word
        //System.out.println();
        //System.out.println("Assignment 1: Most Frequent Word");
        //ex.testerFindUnique();
        // Assignment 2: Character Names
        //System.out.println();
        //System.out.println("Assignment 2: Character Names");
        //ex.testerFindAllCharacters();
        // Programming Exercise: Using GladLibs
        //System.out.println();
        //System.out.println("Programming Exercise: Using GladLibs");
        //ex.testGladLib();
        //Programming Exercise: Improving GladLibs
        //System.out.println();
        //System.out.println("Programming Exercise: Improving GladLibs");
        //ex.testCountDNA();
        //System.out.println();
        //System.out.println("Programming Exercise: Improving GladLibss");
        //System.out.println("Assignment 2: Words in Files");
        //ex.testWordsInFiles();
        //System.out.println();
        //System.out.println("Programming Exercise: Improving GladLibss");
        //System.out.println("Assignment 3: Maps Version of GladLibs");
        //ex.testGladLibMap();
    }
    
}
