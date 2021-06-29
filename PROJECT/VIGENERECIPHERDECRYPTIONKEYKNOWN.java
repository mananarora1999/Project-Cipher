package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class VIGENERECIPHERDECRYPTIONKEYKNOWN
{
    public VIGENERECIPHERDECRYPTIONKEYKNOWN()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        keyconverter key=new keyconverter();// helper method to convert character key array to numeric key array
        FileResource fr = new FileResource("data/VigenereOneKnownKeyDecrypt.txt");// open a file for reading
        String message =fr.asString();// convert it to a string as a input message
        System.out.println("Encrypted Message is : "+message);// print input message
        System.out.print("Enter Known Key for Decryption : " );// input key used for encryption
        String charkey=sc.next();
        int[] numkey=key.converter(charkey);// call keyconverter to convert character key array to numeric key array
        VigenereCipher decryption = new VigenereCipher(numkey);// vigenerecipher object with numeric key array as a parameter
        String nkey=Arrays.toString(numkey);// called toString method 
        System.out.println("");
        System.out.println("Numeric Form of KEY is : "+nkey);// print out numeric key array used
        System.out.println("");
        String decrypted = decryption.decrypt(message);// called encrypt method from vigenerecipher class
        System.out.println("Decrypted/Original Message is : "+ decrypted);// print decrypted message
    }
}
