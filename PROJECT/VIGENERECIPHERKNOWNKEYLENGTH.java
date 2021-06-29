package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class VIGENERECIPHERKNOWNKEYLENGTH 
{
    public VIGENERECIPHERKNOWNKEYLENGTH()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        FileResource fr = new FileResource("data/VigenereKnownKeyLengthDecrypt.txt");// open a file for reading
        String message =fr.asString();// convert it to a string as a input message
        System.out.println("Encrypted Message is : "+message);// print input message
        System.out.print("Enter Known Key Length for Decryption : " );// input key used for encryption
        int keylength=sc.nextInt();
        System.out.println("");
        System.out.print("Enter Most Occuring Character from the Original Message : " );// input Most Occuring Character from the Original Message
        char mostoccuring=sc.next().charAt(0);
        System.out.println("");
        VigenereBreaker decryption = new VigenereBreaker();// vigenerebreaker object
        //System.out.println("\f");
        String decrypted = decryption.breakVigenereknownkeylength (message,keylength,mostoccuring);// called breakVigenereknownkeylength method from vigenerebreaker class
        System.out.println("Decrypted/Original Message is : "+ decrypted);// print decrypted message
    }
}
