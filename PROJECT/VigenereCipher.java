package PROJECT;

import edu.duke.*;
import java.util.*;

public class VigenereCipher 
{
    private CaesarCipher[] ciphers; // cipher is an array of CaesarCipher objects (array of objects)
    
    public VigenereCipher(int[] key) // PARAMETERIZED CONSTRUCTOR
    {
        ciphers = new CaesarCipher[key.length]; // cipher array of length equal to length of the key (vigenere cipher) array integer 
        for (int i = 0; i < key.length; i++) 
        {
            ciphers[i] = new CaesarCipher(key[i]); // initilization of cipher array with CaesarCipher objects
        }
    }
    
    public String encrypt(String input) // method used for encryption 
    {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) 
        {
            int cipherIndex = i % ciphers.length; // modulus to loop over cipher array 0,1,2,3...0,1,2,3...
            CaesarCipher thisCipher = ciphers[cipherIndex]; // CaesarCipher object copied from cipher array to thisCipher
            answer.append(thisCipher.encryptLetter(c)); // call encryptletter method from CaesarCipher class
            i++;
        }
        return answer.toString();
    }
    
    public String decrypt(String input) // method used for decryption
    {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) 
        {
            int cipherIndex = i % ciphers.length; // modulus to loop over cipher array 0,1,2,3...0,1,2,3...
            CaesarCipher thisCipher = ciphers[cipherIndex]; // CaesarCipher object copied from cipher array to thisCipher
            answer.append(thisCipher.decryptLetter(c));// call decryptletter method from CaesarCipher class
            i++;
        }
        return answer.toString();
    }
    
    
}
