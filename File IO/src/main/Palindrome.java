/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: Palindrome
 * Description:Create a program that will read in a list of words from a file called pwordList.txt.  Your program should perform the following tasks:
	-determine the number of palindromes and non-palindromes in the file and display each quantity to the screen
	-write the list of palindromes to a file called palindromeList.txt
	-write the list of non-palindromes to a file called nonpalindromeList.txt
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

public class Palindrome {

	public static void main(String[] args) {
		//Declare variables
		File inFile = new File("pwordList.txt");
		String[] words = new String[0];
		File outFile = new File("palindromeList.txt");
		File outFile2 = new File("nonpalindromeList.txt");
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(outFile));
			BufferedWriter wr = new BufferedWriter(new FileWriter(outFile2));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int pCount = 0;
		int nonPCount = 0;
		try {
			Scanner freader = new Scanner(inFile);
			Path path = Paths.get("pwordList.txt");
			try {
				//Reads in all of the words from the file and adds them to an array
				for(int i = 0; i< Files.lines(path).count();i++) {
					// Makes new array with increased length and then sets words and quantity
					// To the new length
					String new_array[] = new String[words.length + 1];
					for (int j = 0; j < words.length; j++) {
						new_array[j] = words[j];
					}
					words = new_array;
					// Sets the array to the word
					words[words.length - 1] = freader.nextLine();
				}
			} catch (IOException e) {
			}
			//Closes the reader
			freader.close();
		} catch (FileNotFoundException e) {
		}
		//Gets all of the words into a backwords form
		for(int i = 0; i<words.length;i++) {
			String[] wordsB = new String[words.length];
			StringBuffer backwords = new StringBuffer();
			for(int j = 0;j<words[i].length();j++) {
				backwords.append(words[i].charAt(words[i].length()-j-1));
			}
			wordsB[i] = backwords.toString();
			//Checks if the word is the same forwords and backwords if true writes it to the palindrome file and increases the palindromes count else write it to the non palindromes file and increase the non palindromes count
			if(words[i].equals(wordsB[i])) {
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(outFile,true));
					writer.write(words[i]);
						writer.newLine();
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				pCount++;
				
			}else{
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(outFile2,true));
					writer.write(words[i]);
						writer.newLine();
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				nonPCount++;
			}
		}
		//Prints out the counts
		System.out.println("there are " + pCount + " palindromes and " + nonPCount + " non palindromes" );
		
		
}
}