package PROJECT;

import edu.duke.*;
public class counter 
{
    private counter()
    {
        // CONSTRUCTOR
    }
    
    public int[] intarray(String message) // method to count the occurences of every letter
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++)
        {
            int dex = alpha.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public char[] chararray(String message) // method to count the occurences of every letter
    {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        char[] alph = new char[26];
        for(int k=0; k < alpha.length(); k++)
        {
            alph[k]=alpha.charAt(k);
        }
        return alph;
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

    public static void main (String[] args)
    {
        FileResource fr = new FileResource("data/New Text Document (3).txt");
        String message =fr.asString();
        
        counter c = new counter();
        char[] chararray = c.chararray(message);
        int[] intarray = c.intarray(message);
        int maxDex = c.maxIndex(intarray);
        for(int k=0; k<26; k++)
        {
            System.out.println(chararray[k]+" is "+intarray[k]);
        }
        System.out.println("Most occuring character is : " + chararray[maxDex]);
    }    
}
