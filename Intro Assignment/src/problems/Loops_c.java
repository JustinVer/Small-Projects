/* Name: Justin Verhoog
 * Date: 2022-09-16
 * Program Title: Loops question c
 * Description: Make a program that will output the odd numbers from 15-25 in descending order twice on the screen using a 'while' loop AND a 'do-while' loop.
 */
package problems;

public class Loops_c {

	public static void main(String[] args) {
		// A while loop checks the condition and then runs if met and do while loops run
		// and then check and see if it should run again
		
		//Declare variables
		int j = 26;
			//Prints the number if it is odd starts at the highest and decreases
			while (j >= 15) {
				j = j - 1;
				if (j % 2 == 1) {
					System.out.print(j + " ");
				}
			}
			//Adds line
			System.out.println("");
			j = 26;
			//Prints the number if it is odd starts at the highest and decreases
			do {
				j = j - 1;
				if (j % 2 == 1) {
					System.out.print(j + " ");
				}
		} while (j >= 15);

	}

}
