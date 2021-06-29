package PROJECT;

import edu.duke.*;
import java.util.*;
public class tester 
{
  public String sliceString(String encrypted, int whichSlice, int totalSlices) // method to slice input message string according to various keys
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

  public void findindivisualkeys() //method to call getkey from CaesarCracker and find out the keys assuming any one most occuring character
  // method to call slicestring starting from 0 to key length 
  {
    int keylength=4;
    FileResource fr = new FileResource("data/New Text Document (1).txt");// open a file for reading
    //FileResource fr = new FileResource("data/VigenereOneKnownKeyDecrypt.txt");// open a file for reading
    String encrypted =fr.asString();// convert it to a string as a input message
    System.out.println("Encrypted Message is : "+ encrypted);
    int[] key = new int[keylength];
    int start=0;
    //CaesarCracker cracker= new CaesarCracker(); // CaesarCracker object
        
    for(int i=0;i<key.length;i++)
    {   
        
        System.out.println("");
        String newencrypted = sliceString(encrypted,start,keylength);
        System.out.println(newencrypted);
        //int indikey=cracker.getKey(newencrypted);
        //key[i]=indikey;
        start++;
    }
    
    for(int i=0;i<key.length;i++)
    {   
        System.out.print(key[i]+" ");
    }
    
  }

}
