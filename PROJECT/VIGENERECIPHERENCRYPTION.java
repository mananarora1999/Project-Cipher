package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class VIGENERECIPHERENCRYPTION 
{
    public VIGENERECIPHERENCRYPTION()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        keyconverter key=new keyconverter();// helper method to convert character key array to numeric key array
        FileResource fr = new FileResource("data/VigenereOneKeyEncrypt.txt");// open a file for reading
        String message =fr.asString();// convert it to a string as a input message
        System.out.println("Original Message is : "+message);// print input message
        System.out.print("Enter Key for Encryption : " );// input key to be used for encryption
        String charkey=sc.next();
        int[] numkey=key.converter(charkey);// call keyconverter to convert character key array to numeric key array
        VigenereCipher encryption = new VigenereCipher(numkey);// vigenerecipher object with numeric key array as a parameter
        String nkey=Arrays.toString(numkey);// called toString method 
        System.out.println("");
        System.out.println("Numeric Form of KEY is : "+nkey);// print out numeric key array used
        System.out.println("");
        String encrypted = encryption.encrypt(message);// called encrypt method from vigenerecipher class
        System.out.println("Encrypted Message is : "+ encrypted);// print decrypted message
    }
}
