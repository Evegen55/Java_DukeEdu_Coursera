/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lartsev
 * Assignment 2: Words in Files
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> foo;
    
    public WordsInFiles() {
        foo = new HashMap<String, ArrayList<String>>();
    }
    /**
     * This method should add all the words from f into the map. If a word is not in
     * the map, then you must create a new ArrayList of type String with this word, 
     * and have the word map to this ArrayList. If a word is already in the map, 
     * then add the current filename to its ArrayList, unless the filename is already
     * in the ArrayList.
     * @param f 
     */
    private void addWordsFromFile (File f) {
        FileResource fr = new FileResource(f);
        ArrayList<String> listWords = new ArrayList<String>();
        for (String word : fr.words()) {
            if(!foo.containsKey(word)) {
                //listWords = new ArrayList<String>();
                listWords.add(f.getName());
                foo.put(word, listWords);
            } else {
                
                if(!listWords.contains(f.getName())) {
                    listWords.add(f.getName());
                }
            }
            //listWords.clear();
        }
    }
    /**
     * Write a void method named buildWordFileMap that has no parameters. This method
     * first clears the map, and then uses a DirectoryResource to select a group of files. 
     * For each file, it puts all of its words into the map by calling the method 
     * addWordsFromFile. The remaining methods to write all assume that 
     * the HashMap has been built.
     */
    public void buildWordFileMap () {
        foo.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile (f); 
        }
    }
    /**
     * Write the method maxNumber that has no parameters. This method returns the
     * maximum number of files any word appears in, considering all words 
     * from a group of files. In the example above, there are four files considered. 
     * No word appears in all four files. Two words appear in three of the files, 
     * so maxNumber on those four files would return 3. This method assumes that 
     * the HashMap has already been constructed.
     * @return 
     */
    public int maxNumber() {
        HashMap<String, Integer> parMy = new HashMap<String, Integer>();
        //преобразоваваем один хаш-мап(слово/список файлов) в другой (день/кол-во IP)
        for(Map.Entry<String, ArrayList<String>> entry : foo.entrySet()) {
            String word = entry.getKey();
            int numFiles = entry.getValue().size();
            parMy.put(word, numFiles);
        }
        //ищем максимальное значение
        Map.Entry<String,Integer> maxEntry = null;
        for(Map.Entry<String,Integer> entry : parMy.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }
    /**
     * This method returns an ArrayList of words that appear in exactly number files. 
     * In the example above, the call wordsInNumFiles(3) would return an ArrayList with the
     * words “cats” and “and”, and the call wordsInNumFiles(2) would return an ArrayList
     * with the words “love”, “are”, and “dogs”, all the words that appear in exactly two files.
     * @param number
     * @return 
     */
    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> listWords = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> entry : foo.entrySet()) {
            String word = entry.getKey();
            int numFiles = entry.getValue().size();
            if (numFiles == number) {
                listWords.add(word);
            }
        }
        return listWords;
    }
    /**
     * This method prints the names of the files this word appears in, one filename 
     * per line. For example, in the example above, the call printFilesIn(“cats”) 
     * would print the three filenames: brief1.txt , brief3.txt , and brief4.txt , 
     * each on a separate line.
     * @param word 
     */
    public void printFilesIn(String word) {
        
        for(Map.Entry<String, ArrayList<String>> entry : foo.entrySet()) {
            String wordInList = entry.getKey();
            for (String s : entry.getValue()) {
                System.out.println(s);
            }
        }
    }
    
    
    
}
