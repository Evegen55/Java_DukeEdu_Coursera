/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

import edu.duke.FileResource;
import java.util.ArrayList;

/**
 *
 * @author Lartsev
 */
public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> countNames;
    private final String folder = "data/";
    private final String filename = "macbethSmall.txt";
    
    /**
     *
     */
    public CharactersInPlay() {
        names = new ArrayList<String>();
        countNames = new ArrayList<Integer>();
    }
    /**
     * This method should update the two ArrayLists, adding the character’s name 
     * if it is not already there, and counting this line as one speaking 
     * part for this person.
     * @param person 
     */
    public void update(String person) {
        String persontrimmed = person.trim();
        if(!names.contains(persontrimmed)) {
                names.add(persontrimmed);
                countNames.add(1);
        } else {
            int indexList = names.indexOf(persontrimmed);
            int next = countNames.get(indexList);
            countNames.set(indexList, next+1);
        }
    }
    /**
     * opens a file, and reads the file linebyline.
     * For each line, if there is a period on the line, extract the possible name of the
     * speaking part, and call update to count it as an occurrence for this person. 
     * Make sure you clear the appropriate instance variables before each new file.
     */
    public void findAllCharacters() {
        FileResource fr = new FileResource(folder+filename);
        for(String line : fr.lines()){
            if(line.startsWith(" ") && line.contains(".")) {
                String[] lines = line.split("[.]");
                update(lines[0]);
            }
        }
    }
    /**
     * Write a void method called charactersWithNumParts that has two int parameters
     * named num1 and num2 , where you can assume num1 should be less than or equal to
     * num2 . This method should print out the names of all those characters 
     * that have exactly number speaking parts, where number is greater than 
     * or equal to num1 and less than or equal to num2 . 
     * Add code in tester to test this method out.
     * 
     * @param num1
     * @param num2 
     */
    public void charactersWithNumParts(int num1, int num2) {
        int sizeOf = getNames().size();
        System.out.println("The size of vocab" + "\t" + sizeOf);
        for(int i=0; i<sizeOf; i++){
            if((getCountNames().get(i)>num1) && (getCountNames().get(i)<num2)) {
                System.out.print(getNames().get(i) + "\t");
                System.out.println(getCountNames().get(i));
            }
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getCountNames() {
        return countNames;
    }
}
