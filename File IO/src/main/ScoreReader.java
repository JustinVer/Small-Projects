/* Name: Justin Verhoog
 * Date: 2022-10-21
 * Program Title: ScoreReader
 * Description: Create a program that will read in the information from the file and perform the following tasks:
	-output the name of the entry with the highest total score, their total score and their average score
	-output the name of the entry with the lowest total score, their total  score and their average score
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ScoreReader {

	public static void main(String[] args) {
		//Declares variables
		String[] name= new String[0];
		float[] score= new float[0];
		File inFile = new File("results.txt");
		float lastHScore = 0;
		float hNumber = 0;
		float lastLScore = 100;
		float lNumber = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		try {
			Scanner freader = new Scanner(inFile);
			Path path = Paths.get("results.txt");
			try {
				for(int i = 0; i< (Files.lines(path).count()/7);i++) {
					String new_array[] = new String[name.length + 1];
					for (int j = 0; j < name.length; j++) {
						new_array[j] = name[j];
					}
					name = new_array;
					// Sets the array to the new name
					name[name.length - 1] = freader.nextLine();
					
					float new_array2[] = new float[score.length + 1];
					for (int j = 0; j < score.length; j++) {
						new_array2[j] = score[j];
					}
					score = new_array2;
					
					freader.nextLine();
					//Adds each separate score to together to get a total score
					for(int k = 0; k<5;k++) {
					score[score.length - 1] = score[score.length-1] + Float.parseFloat(freader.nextLine());
					}
				}
			} catch (IOException e) {
			}
			//Closes reader
			freader.close();
		} catch (FileNotFoundException e) {
		}
		//Finds the highest and lowest score by comparing to a variable that has the highest or lowest found number so far
		for(int i = 0; i< name.length; i++) {
			if(score[i] >= lastHScore) {
				lastHScore = score[i];
				hNumber = i;
			}
			if(score[i] <= lastLScore) {
				lastLScore = score[i];
				lNumber = i;
			}
		}
		//Prints all of the required information
		System.out.println("The person with the highest score is " + name[(int) hNumber] + " with a score of " + df.format(score[(int) hNumber]) + " with an average of " + df.format((score[(int) hNumber]/5)));
		System.out.println("The person with the lowest score is " + name[(int) lNumber] + " with a score of " + df.format(score[(int) lNumber]) + " with an average of " + df.format((score[(int) lNumber]/5)));
		
	}

}
