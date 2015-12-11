/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

import edu.duke.FileResource;
import edu.duke.URLResource;
//import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Lartsev
 * Assignment 3: Maps Version of GladLibs
 */
public class GladLibMap {
    private ArrayList<String> trackList;
    private ArrayList<String> catList;
    private ArrayList<String> wordList;
    private String adjectiveCat;
    private String nounCat;
    private String colorCat;
    private String countryCat;
    private String nameCat;
    private String animalCat;
    private String timeCat;
    private String verbCat;
    private String fruitsCat;
    
    private HashMap<String, ArrayList<String>> foo;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    //private String separator = FileSystems.getDefault().getSeparator();
    private String separator = "/";
	
    /**
     *
     */
    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
	}
	
    /**
     *
     * @param source
     */
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    /*
    Modify the method initializeFromSource to create an Array of categories and then
    iterate over this Array. For each category, read in the words from the associated file,
    create an ArrayList of the words (using the method readIt ), and put the category and
    ArrayList into the HashMap.
    */
    private void initializeFromSource(String source) {
        trackList = new ArrayList<>();
        wordList = new ArrayList<>();
        foo = new HashMap<String, ArrayList<String>>();
        catList = new ArrayList<String>();
        //-------------------------------
        adjectiveCat = "adjective";
        nounCat = "noun";
        colorCat = "color";
        countryCat = "country";
        nameCat = "name";
        animalCat = "animal";
        timeCat = "timeframe";
        verbCat = "verb";
        fruitsCat = "fruit";
        //-------------------------------
        catList.add(adjectiveCat);
        catList.add(nounCat);
        catList.add(colorCat);
        catList.add(countryCat);
        catList.add(nameCat);
        catList.add(animalCat);
        catList.add(timeCat);
        catList.add(verbCat);
        catList.add(fruitsCat);
        //-------------------------------
        for (String cat: catList) {
            wordList = readIt(source+separator+cat+".txt");
            foo.put(cat, wordList);
        }
    }
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    private String getSubstitute(String label) {
        
        for (String cat : catList) {
            if (label.equals(cat)) {
            return randomFrom(foo.get(cat));
	}
        }
        return "**UNKNOWN**";
    }
    private String processWord(String w){
        String pasteWord = null;
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        if(!trackList.contains(sub)) {
            trackList.add(sub);
            pasteWord =  prefix+sub+suffix;
        } else {
            sub = processWord(w);
            return sub;
        }
        return pasteWord;
    }
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
	}
    }
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
	    }
	} else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
	}
    return story;
    }
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
	    }
	} else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
	    }
	}
    return list;
    }
	
    /**
     *
     */
    public void makeStory(){
        //-------------------------------
        trackList.clear();
        System.out.println("From data/madtemplate.txt");
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate.txt");
        printOut(story, 60);
        System.out.println("\n");
        for (String s : trackList) {
            System.out.println(s);
        }
        System.out.println("Num of replaced words" + "\t" + trackList.size());
        //-------------------------------
        trackList.clear();
        System.out.println("\n");
        System.out.println("From data/madtemplate2.txt");
        System.out.println("\n");
        String storyMy = fromTemplate("data/madtemplate2.txt");
        printOut(storyMy, 60);
        System.out.println("\n");
        for (String s : trackList) {
            System.out.println(s);
        }
        System.out.println("Num of replaced words" + "\t" + trackList.size());
    }
    /**
     * This method returns the total number of words in all the ArrayLists in the HashMap. 
     * After printing the GladLib, call this method and print out the total number of words 
     * that were possible to pick from.
     * @return 
     */
    public int totalWordsInMap() {
        int total = 0;
        for(Map.Entry<String, ArrayList<String>> entry : foo.entrySet()) {
            total = total + entry.getValue().size();
        }
        return total;
    }
    /**
     * This method returns the total number of words in the ArrayLists of the 
     * categories that were used for a particular GladLib. If only noun, color, 
     * and adjective were the categories used in a GladLib, then only calculate 
     * the sum of all the words in those three ArrayLists. Hint: You will need 
     * to keep track of the categories used in solving the GladLib, 
     * then compute this total.
     * @return 
     */
    
    public int totalWordsConsidered() {
        int total = 0;
        for(Map.Entry<String, ArrayList<String>> entry : foo.entrySet()) {
            if (entry.getKey().equals(nounCat) || entry.getKey().equals(colorCat) || entry.getKey().equals(adjectiveCat)) {
                total = total + entry.getValue().size();
            }
            
        }
        return total;
    }
}
