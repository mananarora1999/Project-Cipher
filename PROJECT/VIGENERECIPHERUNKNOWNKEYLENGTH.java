package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class VIGENERECIPHERUNKNOWNKEYLENGTH
{
    public VIGENERECIPHERUNKNOWNKEYLENGTH()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        FileResource fr = new FileResource("data/VigenereKnownKeyLengthDecrypt.txt");// open a file for reading
        String message =fr.asString();// convert it to a string as a input message
        System.out.println("Encrypted Message is : "+message);// print input message
        VigenereBreaker decryption = new VigenereBreaker();// vigenerebreakerobject 
        String decrypted = decryption.breakVigenereunknownkeylength(message);// called breakVigenereunknownkeylength method from vigenerebreaker class
        System.out.println("Decrypted/Original Message is : "+ decrypted);// print decrypted message
    }
}
