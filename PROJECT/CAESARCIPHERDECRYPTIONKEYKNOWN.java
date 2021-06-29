package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class CAESARCIPHERDECRYPTIONKEYKNOWN 
{
    public CAESARCIPHERDECRYPTIONKEYKNOWN()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        FileResource fr = new FileResource("data/CaesarOneKnownKeyDecrypt.txt"); // open a file for reading
        String message =fr.asString(); // convert it to a string as a input message
        System.out.println("Encrypted Message is : "+ message); // print input message
        System.out.print("Enter Known Key for DECRYPTION (1-25) : " ); // input key used for encryption
        Scanner sc = new Scanner(System.in);
        int key=sc.nextInt();
        System.out.println("");
        CaesarCipher decryption = new CaesarCipher(key); // caesarcipher object with key as a parameter
        String decrypted = decryption.decrypt(message); // called decrypt method from caesarcipher class
        System.out.println("Decrypted/Original Message is : "+ decrypted);// print decrypted message
    }
}


