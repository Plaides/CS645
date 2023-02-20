import java.util.*;
import java.io.*;

public class GFG1 {

  public static void main(String[] argv)
  {
    //iterate through the above
    for(int i = 0; i < args.length; i++)
    {
      //parse through args
      // --dict-file = dictionary file
      // --pw-file = password file to compary
      if argv[i].equals("--dict-file")
        {
        //assign to dictionary file variable
        }
      if argv[i].equals("--pw-file")
        {
        //assign to password file variable
        }
        
        // create a new scanner
        Scanner dictionaryScanner = new Scanner(s);
        while( (thisLine = dictionaryScanner.readLine() ) != null)
        {
        /* The shadow file is a text file in which every line corresponds to one user. The format of each line is:
        username:salt:hash
        where “username” is the user’s ID
        “salt” is a 8-character salt
        “hash” is the MD5 cryptographic hash of the string obtained by concatenating the salt with the user’s password.
        
        These fields are separated by the colon (:) character. Your task is to write a Java program that determines whether the shadow file contains any commonly
        used passwords. To obtain the cryptographic hash of a string of characters in Java, you can use the objectMessageDigest Because the hash is a string of
        characters, which may contain non-printable characters, the shadow file actually contains the hexadecimal representation of the characters. You can use 
        the following function to convert a byte array into a String that contains the hexadecimal representation of the byte array:
        
        public static String toHex(byte[] bytes)
        {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
        }
        
        */

        }

        dictionaryScanner.close();
        
        Scanner pwFileScanner = new Scanner(s);
        while( (thisLine = dictionaryScanner.readLine() ) != null)
        {
        // split up the string. looking at
        }
        pwFileScanner.close();
    }
}

}
