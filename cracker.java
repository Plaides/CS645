/********************************************************************************************************************
Developer's note:																									*
Yes, I know this program is inefficiant and can be improved in multiple ways. This is an assigment for a class,		*
and thus has a massive time contraint due to an immediate deadline. Thus, I am choosing good enough to				*
accomplish the specifications provided, and would optimize it if I had more time available.							*
********************************************************************************************************************/
import java.util.*;
import java.io.*;
import java.security.*;
import java.lang.*;

public class cracker
{
	//create scanners
	Scanner dictionaryFileReader = new Scanner(dictionaryFile);
	Scanner passwordFileReader = new Scanner(passwordFile);

	// create linked lists in order to walk through the comparisons later on.
	LinkedList<String>	userNamesLinkedList		= new LinkedList<String>();
	LinkedList<String>	saltLinkedList			= new LinkedList<String>();
	LinkedList<String>	passwordLinkedList		= new LinkedList<String>();
	LinkedList<String>	dctionaryLinkedList		= new LinkedList<String>();
	LinkedList<String>	md5EncryptedString		= new LinkedList<String>();
	StringBuilder[]		splitString				= new StringBuilder<3>();
	String[] 			slicedPWfile			= new String[];

	// create stringbuffer to split the usernames, salt, and hashed passwords.
	StringBuilder 		tempPasswordHolder		= new StringBuffer(128);
	
	// create StringBuilder object to compare hashed password and dictionary
	StringBuilder comparisonString				= new StringBuilder;
	
	// placeholders for nested loop, reset inner loop at end of outer loop function.
	int dictionaryIterator						= 0;
	int passwordIterator						= 0;
	
	// create object for MD5 Shadow crypt function.
	MD5Shadow shadowCryptObject					= new MD5Shadow();

	public static void main(String[] argv)
	{
		if (args,length != 4)
			{
			howToUse();
			}
		//iterate through the arv array to assign password and dictionary files
		for(int i = 0; i < args.length; i++)
		{
			/************************************************
			*	parse through args							*
			*	--dict-file = dictionary file				*
			*	--pw-file = password file to compary		*
			************************************************/
			if args[i].equals("--dict-file")
			{
			File dictionaryFile					= new File(argv[i+1]);
			}
		
			if args[i].equals("--pw-file")
			{
			File passwordFile					= new File(argv[i+1]);
			}
		}
		
		// read through files, insert into arrays, and close file scanners
		while (dictionaryFileReader.hasNextLine())
			{
				dctionaryLinkedList.add( dictionaryFileReader.nextLine() ) )
			}
			dictionaryFileReader.close();
		
		while (passwordFileReader.hasNextLine())
			{
				tempPasswordHolder					= passwordFileReader.nextLine();
				slicedPWfile						= tempPasswordHolder.split(":");
				
				//username is in first slot in array returned in previous line;
				userNamesLinkedList.add( slicedPWfile[0] );
				
				// Salt and hash are in next array slot, but need to be split.
				// first entry is a number for some reason.
				// create string array to hold those three.
				String[] saltyHash					= new String[3];
				saltyHash							= slicedPWfile[1].split("$";)
				
				saltLinkedList.add( saltyHash[1]);
				passwordLinkedList.add( saltyHash[2] );
			}
		passwordFileReader.close()
		
		
	}
	
	public static void howToUse()
	{ 
		System.out.println("Please note: To use this coomand line program, it has to be run with 4 arguements from the command line.");
		System.out.println("The argument --dict-file is used to identify the dictionary file being used to compare a user's salt'ed and hashed password,");
		System.out.println("And is followed by the name of the dictionary file.");
		System.out.println("The argument --passwordFileReader is used to identify the file containing the user names, salt, and hashed salt+pass word, being seperated by a colon (:).");
		System.out.println("And is followed by the name of the password file.");
	}
		
	public static String toHex(byte[] bytes) 
	{ 
		BigInteger bi = new BigInteger(1, bytes); 
		return String.format("%0" + (bytes.length << 1) + "X", bi); 
	}
}

/*******************************************************************************************
public static String[] getSaltAndHash(String saltedHash)									*
	{																						*
		string deliminator						= new String();								*
		deliminator								= "$";										*
		String[] slicedString					= saltedHash.split(deliminator);			*
		return slicedString;																*
	}																						*
	public static String[] lineDissection(String lineToDissect);							*
	{																						*
		String deliminator						= new String(":");							*
		String[] sliced							= new String[];								*
		sliced									= lineToDissect.split(deliminator);			*
		return sliced;																		*
	}																						*
********************************************************************************************/
