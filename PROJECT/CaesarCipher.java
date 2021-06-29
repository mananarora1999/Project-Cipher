package PROJECT;

import edu.duke.*;

public class CaesarCipher 
{
    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;
    
    public CaesarCipher(int key) // PARAMETERIZED CONSTRUCTOR
    {
        if(key>=26) // wrap around condition
        {
            key=key-26;
        }
        theKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase(); //original
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase(); // after shifting using the key
    }
    
    private char transformLetter(char c, String original, String shifted) // method used to find and return the letter after encryption/decryption
    {
        int idx = original.indexOf(c);
        if (idx != -1) {
            return shifted.charAt(idx);
        }
        return c;
    }
    
    public char encryptLetter(char c) // method used to encrypt a particular letter by calling transformletter method
    {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }
    
    public char decryptLetter(char c) // method used to decrypt a particular letter by calling transformletter method 
    //and interchanging alphabet and shifted alphabet as original and shifted
    {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }
    
    private String transform(String input, String original, String shifted) // method used to find and return the string after encryption/decryption
    {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) 
        {
            char c = sb.charAt(i);
            c = transformLetter(c, original, shifted); 
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
    
    public String encrypt(String input) // method used to encrypt a message by calling transform method
    {
        return transform(input, alphabet, shiftedAlphabet);
    }
    
    public String decrypt(String input) // method used to decrypt a message by calling transform method
    {
        return transform(input, shiftedAlphabet, alphabet);
    }
 
}
