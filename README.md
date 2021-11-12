# Project-Cipher
A program to break the Vigenère Cipher, a more complex version of the Caesar Cipher. 

Special Technical Terms

Cipher - In cryptography, a cipher is an algorithm for performing encryption or decryption—a series of well-defined steps that can be followed as a procedure. An alternative, less common term is encipherment. To encipher or encode is to convert information into cipher or code.

Feasibility Study

Obsolete classical techniques are no longer viable. A vast system of electronic communication, commerce, and intellectual properties need to be secured across oceans and continents that would otherwise be intercepted by people with hostile intentions.
Modern Encryption Protocols/Algorithms like Advanced Encryption Standard (AES) and TKIP (Temporal Key Integrity Protocol) are all the advanced versions Modern Cryptography (Secure and made using Advance Math) used for encryption (especially in https) built on the basic idea of classical cryptography, Vigenère Cipher (Insecure and made using Simple Math) by overcoming its disadvantages and cons.

Methodology/ Planning of work

Decryption is performed by going to the row in the table corresponding to the key, finding the position of the ciphertext letter in this row, and then using the column’s label as the plaintext. For example, in row A (from AYUSH), the ciphertext G appears in column G, which is the first plaintext letter. Next, we go to row Y (from AYUSH), locate the ciphertext C which is found in column E; thus, E is the second plaintext letter.
An easier implementation could be to visualize Vigenère algebraically by converting [A-Z] into numbers [0–25].

Encryption - The plaintext(P) and key(K) are added modulo 26.
Ei = (Pi + Ki) mod 26

Decryption - Di = (Ei - Ki + 26) mod 26

Facilities required for proposed work

BlueJ - An integrated development environment with special libraries already built-in by Duke University.

Field of Project:
Cryptography - Cryptography is a method of protecting information and communications through the use of codes, so that only those for whom the information is intended can read and process it.
