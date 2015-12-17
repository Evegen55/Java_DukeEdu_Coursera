package miniproject_vigenere_cipher;

public class CaesarCracker {
    char mostCommon;
    /**
     * 
     */
    public CaesarCracker() {
        mostCommon = 'e';
    }
    /**
     * 
     * @param c 
     */
    public CaesarCracker(char c) {
        mostCommon = c;
    }
    /**
     * 
     * @param message
     * @return 
     */
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alph.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    /**
     * 
     * @param vals
     * @return 
     */
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }
    /**
     * Finding the key has been separated from decrypting the message. You can use
     * the method getKey to pass in an encrypted message and receive the key back.
     * 
     * @param encrypted
     * @return 
     */
    public int getKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int mostCommonPos = mostCommon - 'a';
        int dkey = maxDex - mostCommonPos;
        if (maxDex < mostCommonPos) {
            dkey = 26 - (mostCommonPos-maxDex);
        }
        return dkey;
    }
    /**
     * 
     * @param encrypted
     * @return 
     */
    public String decrypt(String encrypted){
        int key = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);
        
    }
   
}
