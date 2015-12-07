package weblogprogram;


/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

/**
 *
 * @author Lartsev
 */
public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
    /**
     *
     */
    public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>(); 
     }
        
    /**
     *
     * @param filename
     */
    public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()){
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
            } 
     }
        
    /**
     *
     */
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
    /**
     *
     * @return
     */
    public int countUniqueIPs() {
        /*
         //way #1
          
        ArrayList<String> recordsCopy = new  ArrayList<String>();
        for(LogEntry le : records){
            String ipAdd = le.getIpAddress();
            if(!recordsCopy.contains(ipAdd)) {
            recordsCopy.add(ipAdd);
            }
        }
        */
       //way #2
        HashMap<String, Integer> recordsCopy = countVisitsPerIP();
        return recordsCopy.size();
     }
     
    /**
     *
     * @param num
     */
    public void printAllHigherThanNum(int num) {
         
         for(LogEntry le : records){
            int gotI = le.getStatusCode();
            if(gotI>num){
                System.out.println(gotI);
            }
        }
         
        }

    /**
     *
     * @param someday
     * @return
     */
    public int uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> recordsCopy = new  ArrayList<String>();
        for(LogEntry le : records){
            String ipAdd = le.getIpAddress();
            String str = le.getAccessTime().toString().substring(4,10);
            if (str.equals(someday) && !recordsCopy.contains(ipAdd)) {
               recordsCopy.add(ipAdd);
               }
        }
        return recordsCopy.size();
       }

    /**
     *
     * @param low
     * @param high
     * @return
     */
    public int countUniqueIPsInRange (int low, int high) {
        
        ArrayList<String> recordsCopy = new  ArrayList<String>();
        for(LogEntry le : records){
            String ipAdd = le.getIpAddress();
            int stC = le.getStatusCode();
            if (stC>=low && stC<=high && !recordsCopy.contains(ipAdd)) {
               recordsCopy.add(ipAdd);
               }
        }
        return recordsCopy.size();
        } 

    /**
     *In the LogAnalyzer class, write the method countVisitsPerIP , which has no
     * parameters. This method returns a HashMap<String, Integer> that maps an IP address
     * to the number of times that IP address appears in records , meaning the number of
     * times this IP address visited the website. Recall that records stores 
     * LogEntrys from a file of web logs. For help, refer to the video in this 
     * lesson on translating to code. Be sure to test this method on sample files.
     * @return
     */
    public HashMap<String, Integer> countVisitsPerIP() {
        
         HashMap<String, Integer>  keyValue = new HashMap<String, Integer>();
         for(LogEntry le : records){
            String ipAdd = le.getIpAddress();
            if(!keyValue.containsKey(ipAdd)) {
            keyValue.put(ipAdd,1);
            } else {
            
            keyValue.put(ipAdd,keyValue.get(ipAdd)+1);
            }
        }
        return keyValue;
        }
    
    /**
     * java hashmap find maximum value 
     * 
     * In the LogAnalyzer class, write the method mostNumberVisitsByIP , which has one
     * parameter, a HashMap<String, Integer> that maps an IP address to the number of times
     * that IP address appears in the web log file. This method returns the maximum number of
     * visits to this website by a single IP address. For example, the call
     * mostNumberVisitsByIP on a HashMap formed using the file weblog3short_log returns 3.
     * @param par
     * @return int
     */
    public int mostNumberVisitsByIP(HashMap<String, Integer> par){
        Map.Entry<String,Integer> maxEntry = null;
        for(Map.Entry<String,Integer> entry : par.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }
        
    /**
     * In the LogAnalyzer class, write the method iPsMostVisits , which has one parameter, a
     * HashMap<String, Integer> that maps an IP address to the number of times that IP
     * address appears in the web log file. This method returns an ArrayList of Strings of IP
     * addresses that all have the maximum number of visits to this website. For example, the
     * call iPsMostVisits on a HashMap formed using the file weblog3short_log 
     * returns the ArrayList with these two IP addresses, 61.15.121.171 and 84.133.195.161. 
     * Both of them visited the site three times, which is the maximum number 
     * of times any IP address visited the site.
     * @param par
     * @return ArrayList
     */
    public ArrayList<String> iPsMostVisits (HashMap<String, Integer> par){
        int maxValue = mostNumberVisitsByIP(par);
        ArrayList<String> recordsCopy = new  ArrayList<String>();
        for(Map.Entry<String,Integer> entry : par.entrySet()) {
            if (entry.getValue() == maxValue) {
                recordsCopy.add(entry.getKey());
            }
        }
        return recordsCopy;
    }
    /**
     * In the LogAnalyzer class, write the method iPsForDays , which has no parameters. This
     * method returns a HashMap<String, ArrayList<String>> that uses records and maps
     * days from web logs to an ArrayList of IP addresses that occurred on that day. A day is in
     * the format “MMM DD” where MMM is the first three characters of the month name with
     * the first letter capital and the others in lowercase, and DD is the day in two digits
     * (examples are “Dec 05” and “Apr 22”). For example, for the file weblog3short_log ,
     * after building this HashMap, if you print it out, you will see that Sep 14 maps to one IP
     * address, Sep 21 maps to four IP addresses, and Sep 30 maps to five IP addresses.
     * @return 
     */
    public HashMap<String, ArrayList<String>> iPsForDays () {
    
    
    return new HashMap<String, ArrayList<String>>();
    }
}
