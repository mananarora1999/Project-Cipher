package PROJECT;

import java.util.*;
import edu.duke.*;

public class VigenereBreaker 
{    
    
    
  private String sliceString(String encrypted, int whichSlice, int totalSlices) // method to slice input message string according to various keys
  //start choosing from whichSlice-th index and choose every totalslice-th index
  {
    StringBuilder original = new StringBuilder(encrypted);
    StringBuilder slice = new StringBuilder();
    for (int i = whichSlice; i < original.length(); i=i+totalSlices) 
    {
            char c = original.charAt(i);
            slice.append(c);
    }
    return slice.toString();
  }

  private int[] findindivisualkeys(String encrypted, int keylength, char mostCommon) //method to call getkey from CaesarCracker and find out the keys assuming any one most occuring character
  // method to call slicestring starting from 0 to key length 
  {
    int[] key = new int[keylength];
    int start=0;
    CaesarCracker cracker= new CaesarCracker(mostCommon); // CaesarCracker object
    for(int i=0;i<key.length;i++)
    {   
        String newencrypted = sliceString(encrypted,start,keylength);
        int indikey=cracker.getKey(newencrypted);
        key[i]=indikey;
        start++;
    }    
    return key;
  }
 
  private String charkey(int[] key) // method to convert the numeric key to character key
  {   
     String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     StringBuilder charkey= new StringBuilder();
     for(int i=0;i<key.length;i++)
     {
       int value = key[i];
       char ch = alpha.charAt(value);
       charkey.append(ch);
     }
     return charkey.toString();
  }
 
  private HashSet<String> readdictionary(FileResource fr) // method to initialize the dictionary to check from
  {
     HashSet<String> dictionary = new HashSet<String>(); 
     for(String word : fr.words())
     {
         word=word.toLowerCase();
         dictionary.add(word);
     }
     return dictionary;
  }
 
  private Integer countwords(String decrypted , HashSet<String> dictionary ) // method to count number of real words from dictionary for each and every possible keylength from every decrypted message in case of unknown keylength 
  {   
     int realwords=0;
     for(String word : decrypted.split("\\W+"))
     { 
         word=word.toLowerCase();
         if(dictionary.contains(word))
         {
             realwords++;
         }
     }
     return realwords;
  }
 
  private String findkeylength(String encrypted, HashSet<String> dictionary) // loop over every possible keylength and find out the maximum real words by calling countwords method
  // then print out the decrypted message of that keylength which has maximum real words
  {
   char mostCommon='e';
   int keylength=0;
   int counts[] = new int[101];
   for(keylength=1;keylength<=100;keylength++)
   {
    int[] keys = findindivisualkeys(encrypted,keylength,mostCommon);
    VigenereCipher vc= new VigenereCipher(keys); // VigenereCipher object
    String decrypted=vc.decrypt(encrypted);
    counts[keylength]=countwords(decrypted ,dictionary);
   }
   CaesarCracker cracker = new CaesarCracker(mostCommon);
   int maximum=cracker.maxIndex(counts);
   int[] keys = findindivisualkeys(encrypted,maximum,mostCommon); // key combination where maxiumum words make sense from dictionary
   VigenereCipher vc= new VigenereCipher(keys); // VigenereCipher object
   String numerickey=Arrays.toString(keys);
   System.out.println("Numeric Form of KEY is : "+numerickey);
   System.out.println("");
   String charkey=charkey(keys);// helper method to convert numeric key array to character key array
   System.out.println("Character Form of KEY is : "+charkey);
   System.out.println("");
   String decrypted=vc.decrypt(encrypted);
   return decrypted;
  }
 
  public String breakVigenereknownkeylength (String encmessage, int keylength, char mostCommon) // method to call findindivisualkeys to find indivisual keys
  // method to call decrypt from vigenere cipher
  {
    int[] keys = findindivisualkeys(encmessage,keylength,mostCommon);
    VigenereCipher vc= new VigenereCipher(keys); // VigenereCipher object
    String numerickey=Arrays.toString(keys);
    System.out.println("Numeric Form of KEY is : "+numerickey);
    System.out.println("");
    String charkey=charkey(keys);// helper method to convert numeric key array to character key array
    System.out.println("Character Form of KEY is : "+charkey);
    System.out.println("");
    String decrypted=vc.decrypt(encmessage); // call decrypt from vigenere cipher
    return decrypted;
  }
 
  public String breakVigenereunknownkeylength (String encmessage) // method to call findkeylength to find keylength
  // method to call decrypt from vigenere cipher
  {
    FileResource diction = new FileResource("data/English.txt");
    HashSet<String> dictionary = readdictionary(diction);// initialization of dictionary
    String decrypted = findkeylength(encmessage,dictionary);
    return decrypted;
  }
}