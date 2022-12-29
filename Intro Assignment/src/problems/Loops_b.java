/* Name: Justin Verhoog
 * Date: 2022-09-16
 * Program Title: Loops question b
 * Description: Make a program that will produce the following output using nested loops (you must use a loop to print out the ‘ace’ as well, do not print it as a single String)
 */
package problems;

public class Loops_b {

	public static void main(String[] args) {
		//Declare variables
		int A = 97;
		//Makes everything happen 4 times
		for(int i=1;i<=4;i++) {
			//Resets A to 97 every time it loops
			A=97;
			//Prints the correct number
			System.out.println(i);
			//Prints the word ace using ASCII numbers
			for(int j =0;j<3;j++) {
				char aInASCII = ((char) (A+(j*2)));
				System.out.print(aInASCII);
			}
			//Goes to the next line after printing ace
			System.out.println("");
		}

	}

}
