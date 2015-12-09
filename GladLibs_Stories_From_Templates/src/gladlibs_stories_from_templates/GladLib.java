package gladlibs_stories_from_templates;

import edu.duke.*;
import java.util.*;

/**
 *
 * @author Lartsev
 *  
 */
public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitsList;
    private ArrayList<String> trackList;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
	
    /**
     *
     */
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
	}
	
    /**
     *
     * @param source
     */
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    private void initializeFromSource(String source) {
        adjectiveList= readIt(source+"/adjective.txt");	
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        verbList = readIt(source+"/verb.txt");
        fruitsList = readIt(source+"/fruit.txt");
        trackList = new ArrayList<>();
    }
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
	}
        if (label.equals("color")){
            return randomFrom(colorList);
	}
        if (label.equals("noun")){
            return randomFrom(nounList);
	}
        if (label.equals("name")){
            return randomFrom(nameList);
	}
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
	}
        if (label.equals("animal")){
            return randomFrom(animalList);
	}
        if (label.equals("timeframe")){
            return randomFrom(timeList);
	}
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if (label.equals("fruit")){
            return randomFrom(fruitsList);
	}
        if (label.equals("verb")){
            return randomFrom(verbList);
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
            //pasteWord =  prefix+sub+suffix;
            return sub;
        }
        //return prefix+sub+suffix;
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
        ///////////////////////////////////////
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
        //////////////////////////////////////
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
    /**TODO
     * @see data/Programming-Exercise---Using-GladLibs.pdf
     * @see data/programming-Exercise---Improving-GladLibs
     * @see data/Programming-Exercise---Using-GladLibs
    */
    


}
