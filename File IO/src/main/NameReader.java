/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: NameReader
 * Description: Read in names from the file, allow the user to change things like title and add names.
 */
package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class NameReader {

	public static void main(String[] args) throws IOException {
		//Declare variables
		int index = 0;
		String fNSearch = "";
		int count = 0;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
		File inFile = new File("nameList.txt");
		Path path = Paths.get("nameList.txt");
		Name[] name = new Name[(int) (Files.lines(path).count() / 3)];
		boolean[] fSearch = new boolean[(int) (Files.lines(path).count() / 3)];
		Scanner freader = new Scanner(inFile);
		File outFile1 = new File("updatedNames.txt");
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(outFile1));
		File outFile2 = new File("updatedInitials.txt");
		BufferedWriter writer2 = new BufferedWriter(new FileWriter(outFile2));
		//Reads in the information from the file and puts the information into the name object
		for (int i = 0; i < name.length; i++) {
			name[i] = new Name();
			name[i].setTitle(freader.nextLine());
			System.out.print(i + ". " + name[i].getTitle());
			name[i].setFirst(freader.nextLine());
			System.out.print(name[i].getFirst() + " ");
			name[i].setLast(freader.nextLine());
			System.out.print(name[i].getLast() + " ");
			System.out.println(name[i].getInitials());
		}
		//Closes reader
		freader.close();
		//Prompts user for index number then what they want for the new title
		System.out.println("what number title would you like to change");
		index = Integer.parseInt(keyboard.readLine());
		System.out.println("what would you like the new title to be");
		name[index].setTitle(keyboard.readLine());
		//Reprints all of the names in the array
		for (int i = 0; i < name.length; i++) {
			System.out.print(i + ". " + name[i].getTitle());
			System.out.print(name[i].getFirst() + " ");
			System.out.print(name[i].getLast() + " ");
			System.out.println(name[i].getInitials());
		}
		//Prompts for the name the user wants to search for
		System.out.println("what first name would you like to search for");
		fNSearch = keyboard.readLine();
		//Searches for the name and if true sets a boolean array to true and increases the count otherwise sets the boolean array to false
		for (int i = 0; i < name.length; i++) {
			if (name[i].getFirst().equals(fNSearch)) {
				count++;
				fSearch[i] = true;
			} else {
				fSearch[i] = false;
			}
		}
		//Prints out the count
		System.out.println("there are " + count + " names that are what you searched they are");
		//Goes through the name array and if the corresponding search array is true print out its information
		for (int i = 0; i < name.length; i++) {
			if (fSearch[i] == true) {
				System.out.print(name[i].getTitle());
				System.out.print(name[i].getFirst() + " ");
				System.out.println(name[i].getLast());
			}
		}
		//creates a new temp array then transfers the data from name array then sets name array to the temp array
		Name[] temp = new Name[(int) ((Files.lines(path).count() / 3) + 1)];
		for (int i = 0; i < name.length; i++) {
			temp[i] = name[i];
		}
		name = temp;
		//Gets all of the required information for the new name
		System.out.println("what would you like the title of the new name to be?");
		name[(int) (Files.lines(path).count() / 3)] = new Name();
		name[(int) (Files.lines(path).count() / 3)].setTitle(keyboard.readLine());
		System.out.println("what would you like the first name of the new name to be?");
		name[(int) (Files.lines(path).count() / 3)].setFirst(keyboard.readLine());
		System.out.println("what would you like the last name of the new name to be?");
		name[(int) (Files.lines(path).count() / 3)].setLast(keyboard.readLine());
		//Prints out the final list of names to the console. At the same time record the proper data to the updated lists
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i].getTitle());
			System.out.print(name[i].getFirst() + " ");
			System.out.println(name[i].getLast());
			writer1.write(name[i].getTitle());
			System.out.println(i + ". 1");
			writer1.newLine();
			writer1.write(name[i].getFirst());
			System.out.println(i + ". 2");
			writer1.newLine();
			writer1.write(name[i].getLast());
			System.out.println(i + ". 3");
			if(i + 1<name.length) {
			writer1.newLine();
			}
			writer2.write(name[i].getTitle());
			System.out.println(i + ". 4");
			writer2.newLine();
			writer2.write(name[i].getInitials());
			System.out.println(i + ". 5");
			if(i + 1<name.length) {
			writer2.newLine();
			}
		}
		//Closes the writer
		writer1.close();
		writer2.close();
	}

}
