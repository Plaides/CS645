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
	int saltLinkedListIterator					= 0;
	
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
		
		for (dictionaryIterator; dictionaryIterator < dctionaryLinkedList.size(); dictionaryIterator++)
		{
			for (passwordIterator; passwordIterator < passwordLinkedList.size(); passwordIterator++)
			{
				// linkedList.get(saltLinkedListIterator)
				tempPasswordHolder = crypt(dctionaryLinkedList[dictionaryIterator], saltLinkedList.get(saltLinkedListIterator) );
				if ( tempPasswordHolder.equals( passwordLinkedList.get(saltLinkedListIterator) ) )
					{
						System.out.println("Password match found! Username is: " + userNamesLinkedList[passwordIterator] + " and password is: " + dctionaryLinkedList[dictionaryIterator] + ".");
					}
			}
		passwordIterator = 0;
		saltLinkedListIterator++;
		}
	}
