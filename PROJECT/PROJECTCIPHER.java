package PROJECT;

import edu.duke.*;
import java.io.*;
import java.util.*;

public class PROJECTCIPHER 
{
    public PROJECTCIPHER()
    {
        // CONSTRUCTOR
    }
    
    public static void main (String[] args)
    {
       char ch='a';
       do
       {
        System.out.println("Welcome to PROJECT CIPHER");
        System.out.println("Choose From the OPTIONS : ");
        System.out.println("");
        System.out.println("1.CAESAR CIPHER ONE KEY ENCRYPTION");
        System.out.println("2.CAESAR CIPHER ONE KNOWN KEY DECRYPTION");
        System.out.println("3.CAESAR CIPHER ONE UNKNOWN KEY DECRYPTION");
        System.out.println("4.VIGENERE CIPHER ONE KEY ENCRYPTION");
        System.out.println("5.VIGENERE CIPHER ONE KNOWN KEY DECRYPTION");
        System.out.println("6.VIGENERE CIPHER KNOWN KEYLENGTH DECRYPTION");
        System.out.println("7.VIGENERE CIPHER UNKNOWN KEYLENGTH DECRYPTION");
        System.out.println("");
        System.out.print("Please ENTER YOUR CHOICE : ");
        Scanner sc = new Scanner(System.in);
        int choice=sc.nextInt();
        System.out.println("");
        if(choice==1)
        {
            System.out.print('\f');
            CAESARCIPHERENCRYPTION execute = new CAESARCIPHERENCRYPTION();
            execute.main(args);
        }
        else if(choice==2)
        {
            System.out.print('\f');
            CAESARCIPHERDECRYPTIONKEYKNOWN execute = new CAESARCIPHERDECRYPTIONKEYKNOWN();
            execute.main(args);
        }
        else if(choice==3)
        {
            System.out.print('\f');
            CAESARCIPHERDECRYPTIONKEYUNKNOWN execute = new CAESARCIPHERDECRYPTIONKEYUNKNOWN();
            execute.main(args);
        }
        else if(choice==4)
        {
            System.out.print('\f');
            VIGENERECIPHERENCRYPTION execute = new VIGENERECIPHERENCRYPTION();
            execute.main(args);
        }
        else if(choice==5)
        {
            System.out.print('\f');
            VIGENERECIPHERDECRYPTIONKEYKNOWN execute = new VIGENERECIPHERDECRYPTIONKEYKNOWN();
            execute.main(args);
        }
        else if(choice==6)
        {
            System.out.print('\f');
            VIGENERECIPHERKNOWNKEYLENGTH execute = new VIGENERECIPHERKNOWNKEYLENGTH();
            execute.main(args);
        }
        else if(choice==7)
        {
            System.out.print('\f');
            VIGENERECIPHERUNKNOWNKEYLENGTH execute = new VIGENERECIPHERUNKNOWNKEYLENGTH();
            execute.main(args);
        }
        else
        {
            System.out.println("!! PLEASE ENTER CORRECT OPTION !!");
        }
        System.out.println("");
        System.out.print("DO YOU WANT TO CONTINUE (Y/y) : ");
        ch = sc.next().charAt(0);
        System.out.println("");
        System.out.print('\f');
       }
       while(ch =='Y'|| ch =='y' );
       System.out.print("THANK YOU FOR USING PROJECT CIPHER");
    }
}
