package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class CAESARCIPHERENCRYPTION 
{
    public CAESARCIPHERENCRYPTION()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        FileResource fr = new FileResource("data/CaesarOneKeyEncrypt.txt"); // open a file for reading
        String message =fr.asString(); // convert it to a string as a input message
        System.out.println("Original Message is : "+message); // print input message
        System.out.print("Enter Key for ENCRYPTION (1-25) : " );// input key to be used for encryption
        Scanner sc = new Scanner(System.in);
        int key=sc.nextInt(); 
        System.out.println("");
        CaesarCipher encryption = new CaesarCipher(key); // caesarcipher object with key as a parameter
        String encrypted = encryption.encrypt(message); // called encrypt method from caesarcipher class
        System.out.println("Encrypted Message is : "+ encrypted);// print encrypted message
    }
}
