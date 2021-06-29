package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class CAESARCIPHERDECRYPTIONKEYUNKNOWN
{
    public CAESARCIPHERDECRYPTIONKEYUNKNOWN()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
        FileResource fr = new FileResource("data/CaesarOneUnknownKeyDecrypt.txt"); // open a file for reading
        String message =fr.asString(); // convert it to a string as a input message
        System.out.println("Encrypted Message is : "+message); // print input message
        System.out.print("Enter Most Common Occuring Character from the Original Message : " ); // input most used character from original message
        Scanner sc = new Scanner(System.in);
        char mostcommon=sc.next().charAt(0);
        System.out.println("");
        CaesarCracker decryption = new CaesarCracker(mostcommon); // caesarcracker object with mostcommon as a parameter
        int key = decryption.getKey(message);// called getkey method from caesarcracker class
        System.out.println("Key used to ENCRYPT is : "+key);// print out key used
        System.out.println("");
        String decrypted = decryption.decrypt(message); //called decrypt method from caesarcracker class
        System.out.println("Decrypted/Original Message is : "+ decrypted); // print decrypted message
    }
}
