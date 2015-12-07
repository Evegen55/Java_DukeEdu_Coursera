/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladlibs_stories_from_templates;

/**
 *
 * @author Lartsev
 */
public class GladLibs_Stories_From_Templates {
    
    
    public void testerFindUnique() {
        WordFrequencies wF = new WordFrequencies();
        wF.findUnique();
        int sizeOf = wF.getMyWords().size();
        System.out.println(sizeOf);
        for(int i=0; i<sizeOf; i++){
             System.out.print(wF.getMyWords().get(i) + "\t");
             System.out.println(wF.getMyFreqs().get(i));
        }
        System.out.println();
        System.out.println(wF.findIndexOfMax());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GladLibs_Stories_From_Templates ex = new GladLibs_Stories_From_Templates ();
        ex.testerFindUnique();
        
    }
    
}
