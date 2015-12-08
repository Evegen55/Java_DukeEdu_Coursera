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
 */
//if you wish to use some ierarhy!!!

public class countWordsInText {
    private final ArrayList<String> myWords;
    private final ArrayList<Integer> myNums;
    public String folder;
    public String filename;
    
    /**
     *
     */
    public countWordsInText() {
        myWords = new ArrayList<>();
        myNums = new ArrayList<>();
        folder = "data/";
        filename = "likeit.txt";
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
    public ArrayList<Integer> getMyNums() {
        return myNums;
    }
    
}
