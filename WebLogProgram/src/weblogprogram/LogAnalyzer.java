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
     * @return This method returns the maximum number of visits to this website by a single IP address
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
     * 
     * @return 
     */
    public HashMap<String, ArrayList<String>> iPsForDays () {
        HashMap<String, ArrayList<String>> foo = new HashMap<String, ArrayList<String>>();
        for(LogEntry le : records){
            ArrayList<String> recordsCopy = new  ArrayList<String>();
            String str = le.getAccessTime().toString().substring(4,10);
            for(LogEntry leIn : records){
                String strIn = leIn.getAccessTime().toString().substring(4,10);
                String ipAdd = leIn.getIpAddress();
                if(strIn.equals(str) && (!recordsCopy.contains(ipAdd))) {
                    recordsCopy.add(ipAdd);
                }
            }
            foo.put(str, recordsCopy);
        }
        return foo;
    }
    /**
     * In the LogAnalyzer class, write the method dayWithMostIPVisits , which has one
     * parameter that is a HashMap<String, ArrayList<String>> that uses records and maps
     * days from web logs to an ArrayList of IP addresses that occurred on that day. This
     * method returns the day that has the most IP address visits. If there is a tie, then return
     * any such day. For example, if you use the file weblog3short_log , then this method
     * should return the day most visited as Sep 30.
     * @param par
     * @return the day that has the most IP address visits
     */
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> par) {
        
        HashMap<String, Integer> parMy = new HashMap<String, Integer>();
        //преобразоваваем один хаш-мап(день/список IP) в другой (день/кол-во IP)
        for(Map.Entry<String, ArrayList<String>> entry : par.entrySet()) {
            String day = entry.getKey();
            int numIps = entry.getValue().size();
            parMy.put(day, numIps);
        }
        //ищем максимальное значение
        Map.Entry<String,Integer> maxEntry = null;
        for(Map.Entry<String,Integer> entry : parMy.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
       return maxEntry.getKey();
    }
    /**
     * In the LogAnalyzer class, write the method iPsWithMostVisitsOnDay , which has two
     * parameters—the first one is a HashMap<String, ArrayList<String>> that uses records
     * and maps days from web logs to an ArrayList of IP addresses that occurred on that day,
     * and the second parameter is a String representing a day in the format “MMM DD”
     * described above. This method returns an ArrayList<String> of IP addresses that had the
     * most accesses on the given day. For example, if you use the file weblog3short_log ,
     * and the parameter for the day is “Sep 30”, then there are two IP addresses in the
     * ArrayList returned: 61.15.121.171 and 177.4.40.87. Hint: This method should call
     * another method you have written.
     * 
     * @param parOne records and maps days from web logs to an ArrayList of IP addresses 
     * that occurred on that day
     * @param someday day in the format “MMM DD”
     * @return ArrayList<String> of IP addresses that had the most accesses on the given day
     */
    public ArrayList<String> iPsWithMostVisitsOnDay (HashMap<String, ArrayList<String>> parOne,String someday) {
        ArrayList<String> list = null;
        for(Map.Entry<String, ArrayList<String>> entry : parOne.entrySet()) {
            String day = entry.getKey();
            if(day.equals(someday)){
            list = entry.getValue();
            }
        }
       return list;
    }
}
