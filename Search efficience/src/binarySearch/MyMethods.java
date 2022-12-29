/* Name: Justin Verhoog
 * Date: 2022-11-11
 * Program Title: MyMethods
 * Description: A collection of static methods for use in future projects
 */
package binarySearch;

/**
 * <h1> My Methods</h1>
 * Methods to be used in future projects
 * @author Justin Verhoog
 * @date 2022-11-11
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyMethods {

	/**
	 * Reads all of the lines from the file specified and returns them as a string
	 * array
	 * 
	 * @param fileName is the name of the file you wish to read from
	 * @return String[] that has each line as a separate element of the array
	 * @throws IOException
	 */
	public static String[] readArrayFromFile(String fileName) throws IOException {
		// Declares variables
		File inFile = new File(fileName);
		Scanner freader = new Scanner(inFile);
		Path path = Paths.get(fileName);
		int fileLength = (int) Files.lines(path).count();
		String[] lines = new String[fileLength];
		// Reads all of the lines from the file and puts them into an array
		for (int i = 0; i < fileLength; i++) {
			lines[i] = freader.nextLine();
		}
		freader.close();
		// Returns the array
		return lines;
	}

	/**
	 * Writes all of the elements of the string array to a new line on the specified
	 * file
	 * 
	 * @param fileName The name of the file you wish to write to
	 * @param A        The array of strings you wish to write to the file
	 * @param num      the number of lines you wish to write to the file
	 * @throws IOException
	 */
	public static void writeArrayFile(String fileName, String[] A, int num) throws IOException {
		// Declare variables
		File outFile = new File(fileName);
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		// Writes the specified number of lines to the specified file
		for (int i = 0; i < num; i++) {
			writer.write(A[i]);
			if (i + 1 < num) {
				writer.newLine();
			}
		}
		// Closes the writer
		writer.close();
	}

	/**
	 * Searches through a list of numbers using a binary search
	 * 
	 * @param A   The array of numbers you are searching through that should already
	 *            be sorted in ascending order
	 * @param num The number you are searching for
	 * @return the number of times the function had to search to find the number
	 */
	public static int binarySearch(int[] A, int num) {
		int searchCount = 0;
		int max = A.length - 1;
		int min = 0;
		while (min <= max) {
			int i = min + ((max - min) / 2);
			searchCount++;
			if (A[i] > num) {
				max = i - 1;
			} else if (A[i] < num) {
				min = i + 1;

			} else if (A[i] == num) {
				return searchCount;
			}
		}
		return searchCount;
	}

	/**
	 * Sorts an integer array in ascending order
	 * 
	 * @param A the array of integers you wish to sort
	 * @return the sorted array
	 */
	public static int[] sortAscending(int[] A) {
		// Declare variables
		int count = 0;
		// Starts at 0 and check if the numbers are the same if they are add the number
		// to the array. keeps checking until all of the numbers have been added to the
		// new array
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - 1; j++) {
				if (A[j] > A[j + 1]) {
					int tempI = A[j];
					A[j] = A[j + 1];
					A[j + 1] = tempI;
				}
			}
		}
		// Returns the sorted array
		return A;
	}

	/**
	 * Sorts a integer array in descending order by finding the largest number then
	 * counting down
	 * 
	 * @param A the array of integers you wish to sort
	 * @return the sorted array
	 */
	public static int[] sortDescending(int[] A) {
		// Declare variables
		int count = 0;
		int[] temp = new int[A.length];
		int hNumber = 0;
		// Finds the highest number in the array so that the search for descending can
		// start at that number
		for (int i = 0; i < A.length; i++) {
			if (A[i] > hNumber) {
				hNumber = A[i];
			}
		}
		// Starts from the highest number found and goes down checking if the numbers
		// match if they do add the number to the new array
		for (int i = hNumber; count < A.length; i--) {
			for (int j = 0; j < A.length; j++) {
				if (A[j] == i) {
					temp[count] = A[j];
					count++;
				}
			}
		}
		// Prints the new array to the file
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i] + ", ");
		}
		// Returns the sorted array
		return temp;
	}

	/**
	 * Gets the dot product of two points/vectors
	 * 
	 * @param X1 the x value of your first vector
	 * @param Y1 the y value of your first vector
	 * @param Z1 the z value of your first vector
	 * @param X2 the x value of your second vector
	 * @param Y2 the y value of your second vector
	 * @param Z2 the z value of your second vector
	 * @return the dot product as a double
	 */
	public static double dotProduct(double X1, double Y1, double Z1, double X2, double Y2, double Z2) {
		// Gets the dot product then returns it
		double dotProduct = X1 * X2 + Y1 * Y2 + Z1 * Z2;
		return dotProduct;
	}

	/**
	 * Sorts the string array into ascending order by comparing the first character
	 * then if there are more than one word with the same first letter sort by the
	 * second letter
	 * 
	 * @param S the string array you wish to sort
	 * @return the sorted string array
	 */
	public static String[] sortAscending(String[] S) {
		// Declare variables
		String[] temp = new String[S.length];
		int count = 0;
		// Uses the ASCII values of the first character of the word to check what order
		// they should be sorted into
		for (int i = 97; i < 123; i++) {
			String[] aboutToBeAdded = new String[0];
			int countW = 0;
			// Checks to see if the ASCII value of the first letter is equal to the current
			// letter being searched for(started with A)
			for (int j = 0; j < S.length; j++) {
				// Gets the first character of the word
				int firstChar = S[j].charAt(0);
				// Checks against the current letter being searched for if found add it to the
				// aboutToBeAdded array and increase the count for the number of words in that
				// array
				if (firstChar == i) {
					String[] add = new String[aboutToBeAdded.length + 1];
					for (int l = 0; l < aboutToBeAdded.length; l++) {
						add[l] = aboutToBeAdded[l];
					}
					aboutToBeAdded = add;
					aboutToBeAdded[countW] = S[j];
					countW++;
				}
			}
			// After the words have been checked for the first letter check to see if there
			// is more than one word that starts with the same letter if there is it does
			// the same check that it did before to check what order these words should be
			// done in
			if (aboutToBeAdded.length > 1) {
				for (int k = 97; k < 123; k++) {
					for (int j = 0; j < aboutToBeAdded.length; j++) {
						int random = aboutToBeAdded[j].charAt(1);
						if (random == k) {
							// Adds the words to the final array that is sorted
							temp[count] = aboutToBeAdded[j];
							count++;
						}
					}
				}
				// If there is only one word of that letter just add it to the sorted array
			} else if (aboutToBeAdded.length == 1) {
				temp[count] = aboutToBeAdded[0];
				count++;
			}
		}
		// After the sorting has been done return the sorted array
		return temp;

	}

	/**
	 * Sorts the string array into descending order by comparing the first character
	 * then if there are more than one word with the same first letter sort by the
	 * second letter
	 * 
	 * @param S the string array you wish to sort
	 * @return the sorted string array
	 */
	public static String[] sortDescending(String[] S) {
		// Declare variables
		String[] temp = new String[S.length];
		int count = 0;
		// Uses the ASCII values of the first character of the word to check what order
		// they should be sorted into
		for (int i = 122; i > 96; i--) {
			String[] aboutToBeAdded = new String[0];
			int countW = 0;
			// Checks to see if the ASCII value of the first letter is equal to the current
			// letter being searched for(started with Z)
			for (int j = 0; j < S.length; j++) {
				int firstChar = S[j].charAt(0);
				// Checks against the current letter being searched for if found add it to the
				// aboutToBeAdded array and increase the count for the number of words in that
				// array
				if (firstChar == i) {
					String[] add = new String[aboutToBeAdded.length + 1];
					for (int l = 0; l < aboutToBeAdded.length; l++) {
						add[l] = aboutToBeAdded[l];
					}
					aboutToBeAdded = add;
					aboutToBeAdded[countW] = S[j];
					countW++;
				}
			}
			// After the words have been checked for the first letter check to see if there
			// is more than one word that starts with the same letter if there is it does
			// the same check that it did before to check what order these words should be
			// done in
			if (aboutToBeAdded.length > 1) {
				for (int k = 122; k > 96; k--) {
					for (int j = 0; j < aboutToBeAdded.length; j++) {
						int random = aboutToBeAdded[j].charAt(1);
						if (random == k) {
							temp[count] = aboutToBeAdded[j];
							count++;
						}
					}
				}
				// If there is only one word of that letter just add it to the sorted array
			} else if (aboutToBeAdded.length == 1) {
				temp[count] = aboutToBeAdded[0];
				count++;
			}
		}
		// After the sorting has been done return the sorted array
		return temp;

	}
}
