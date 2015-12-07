/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblogprogram;

/**
 *
 * @author Lartsev
 */
import java.util.*;

/**
 *
 * @author Lartsev
 */
public class WebLogProgram {
    
    private String folder = "data/";
 
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
        la.readFile(folder + "weblog1_log");
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
        la.readFile(folder + "weblog1_log");
        int laU = la.uniqueIPVisitsOnDay("Mar 17");
        System.out.println(laU);
    }

    /**
     *
     */
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog1_log");
        int laU = la.countUniqueIPsInRange(300,399);
        System.out.println(laU);
    }

    /**
     *
     */
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog1_log");
        HashMap<String, Integer> par = la.countVisitsPerIP();
        int laU = la.mostNumberVisitsByIP(par);
        System.out.println(laU);
    }

    /**
     *
     */
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile(folder + "weblog1_log");
        HashMap<String, Integer> parAm = la.countVisitsPerIP();
        ArrayList<String> par = la.iPsMostVisits(parAm);
        for (String le : par) {
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
        //tester.testCountUniqueIPs();
        //tester.testPrintAllHigherThanNum();
        //tester.testUniqueIPVisitsOnDay();
        //tester.testCountUniqueIPsInRange();
        //tester.testMostNumberVisitsByIP();
        tester.testIPsMostVisits();
        
        
        
        
        
        
        
        
        
    }
    
}
