/* Name: Justin Verhoog
 * Date: 2022-10-31
 * Program Title: Capitalize
 * Description: Create a program that will read in a list of words from a file called wordList.txt.  Your program should perform the following tasks:
	-count the number of words in the file and display it
	-convert all of the words to uppercase
	-write the words to a file called CapitalWordList.txt
	-you do NOT need to display the words to the screen
	-display a message indicating that the file has been successfully written
 */
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Capitalize {

	public static void main(String[] args) throws IOException {
		// Declare variables
		int count = 0;
		String[] words = new String[0];
		File outFile = new File("CapitalWordList.txt");
		File inFile = new File("wordList.txt");
		try {
			Scanner freader = new Scanner(inFile);
			Path path = Paths.get("wordList.txt");
			// Reads in all of the words from the file
			for (int i = 0; i < Files.lines(path).count(); i++) {
				// Makes new array with increased length and then sets words and quantity
				// To the new length
				String new_array[] = new String[words.length + 1];
				for (int j = 0; j < words.length; j++) {
					new_array[j] = words[j];
				}
				words = new_array;
				// Sets the array to the new item
				words[words.length - 1] = freader.nextLine();
				count++;
			}
			// Closes the reader
			freader.close();
		} catch (FileNotFoundException e) {
		}

		System.out.println("There are " + count + " words in the file");
		// Creates a new array for the upper case words
		String[] wordsU = new String[words.length];
		try {
			// Creates a writer
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			// Makes all of the words into upper case using the toUppercase methed and sets
			// the array to the new values then writes all of the uppercase words to the
			// uppercase file
			for (int i = 0; i < words.length; i++) {
				wordsU[i] = words[i].toUpperCase();
				writer.write(wordsU[i]);
				if (i < words.length - 1) {
					writer.newLine();
				}
			}
			// closes the writer
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("mission complete");
	}
}
