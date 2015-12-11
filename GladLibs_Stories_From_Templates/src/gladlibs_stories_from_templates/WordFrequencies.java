/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lartsev
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    private final String folder = "data/";
    private final String filename = "errors.txt";
    
    /**
     *
     */
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    /**
     *
     */
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource(folder+filename);
        for(String word : fr.words()){
            String wordLow = word.toLowerCase();
            if(!myWords.contains(wordLow)) {
                myWords.add(wordLow);
                myFreqs.add(1);
            } else {
                int indexList = myWords.indexOf(wordLow);
                int next = myFreqs.get(indexList);
                myFreqs.set(indexList, next+1);
            }
        }
    }
    /**
     * find max value in ArrayList<Integer> 
     * @return max value
     */
    public int findIndexOfMax() {
        Collections.sort(myFreqs);
        return myFreqs.get(myFreqs.size() - 1);
    
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getMyWords() {
        return myWords;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getMyFreqs() {
        return myFreqs;
    }
}
