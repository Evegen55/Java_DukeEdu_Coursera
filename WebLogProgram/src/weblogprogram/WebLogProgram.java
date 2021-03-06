/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblogprogram;

/**
 *
 * @author Lartsev
 * 
 * In this module, you will learn about how web server logs store information 
 * about visitors to a website, and you will write programs to access information 
 * like user IP address, date and time of access, and more. Using Java programs 
 * you write in this module, you will be able 
 * (1) to read information from a web server log, 
 * (2) to count the number of unique visitors to your website, and 
 * (3) to count the number of times each visitor uses your website.
 */
import java.util.*;

/**
 *
 * @author Lartsev
 */
public class WebLogProgram {
    
    private final String folder = "data/";
 
    /**
     *
     */
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    /**
     *
     */
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "short-test_log");
        la.printAll();
        
    }
    
    /**
     *
     */
    public void testCountUniqueIPs(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        System.out.println(la.countUniqueIPs());
    }
    
    /**
     *
     */
    public void testPrintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    /**
     *
     */
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        int laU = la.uniqueIPVisitsOnDay("Sep 24");
        System.out.println(laU);
    }

    /**
     *
     */
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        int laU = la.countUniqueIPsInRange(200,299);
        System.out.println(laU);
    }

    /**
     *
     */
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        HashMap<String, Integer> par = la.countVisitsPerIP();
        int laU = la.mostNumberVisitsByIP(par);
        System.out.println(laU);
    }

    /**
     *
     */
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        HashMap<String, Integer> parAm = la.countVisitsPerIP();
        ArrayList<String> par = la.iPsMostVisits(parAm);
        for (String le : par) {
             System.out.println(le);
         }
        
    }
    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog3-short_log");
        HashMap<String, ArrayList<String>> parAm = la.iPsForDays();
        
        for(Map.Entry<String, ArrayList<String>> entry : parAm.entrySet()) {
            String day = entry.getKey();
            int numIps = entry.getValue().size();
            System.out.println(day + "\t" + numIps);
        }
        
    }
    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        HashMap<String, ArrayList<String>> parAm = la.iPsForDays();
        String day = la.dayWithMostIPVisits(parAm);
        System.out.println(day + "\t");
    }
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog2_log");
        HashMap<String, ArrayList<String>> parAm = la.iPsForDays();
        String day = "Sep 30";
        ArrayList<String> list = la.iPsWithMostVisitsOnDay(parAm,day);
        for (String le : list) {
             System.out.println(le);
         }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WebLogProgram tester = new WebLogProgram();
        //tester.testLogEntry();
        //tester.testLogAnalyzer();
        tester.testCountUniqueIPs();
        //tester.testPrintAllHigherThanNum();
        //tester.testUniqueIPVisitsOnDay();
        //tester.testCountUniqueIPsInRange();
        //tester.testMostNumberVisitsByIP();
        //tester.testIPsMostVisits();
        //tester.testIPsForDays();
        //tester.testDayWithMostIPVisits();
        //tester.testIPsWithMostVisitsOnDay();
    }
    
}
