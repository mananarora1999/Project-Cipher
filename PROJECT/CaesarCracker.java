package PROJECT;

import edu.duke.*;

public class CaesarCracker 
{
    private char mostCommon;
    
    public CaesarCracker() // DEFAULT CONSTRUCTOR
    {
        mostCommon = 'e';
    }
    
    public CaesarCracker(char c) // PARAMETERIZED CONSTRUCTOR
    {
        mostCommon = c;
    }
    
    private int[] countLetters(String message) // method to count the occurences of every letter
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alpha.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] vals) // method to calculate the maximum occuring letter's index,position where we believe the most occuring character to be shifted
    {
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }

    public int getKey(String encrypted) // method to get the unknown key used for encryption
    {
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int mostCommonPos = mostCommon - 'a';
        int keyusedforencryption = maxDex - mostCommonPos;
        if (maxDex < mostCommonPos) {
            keyusedforencryption = 26 - (mostCommonPos-maxDex); // wrap around condition
        }
        return keyusedforencryption;
    }
    
    
    public String decrypt(String encrypted) // method to decrypt a message with unknown encryption key
    {
        int key = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);
    }
   
}
