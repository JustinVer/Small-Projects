/* Name: Justin Verhoog
 * Date: 2022-09-16
 * Program Title: Loops question a
 * Description: prints the even numbers between 0 and 20 twice each on separate lines
 */
package problems;

public class Loops_a {

	public static void main(String[] args) {
		//Declare variables
		int j = 1;
		//Makes the printing of the numbers happen twice
		for (int i = 0; i <= 1; i++) {
			j = 1;
			//Prints the numbers if they are divisible by two
			for (; j <= 20; j++) {
				if (j % 2 == 0) {
					System.out.println(j);
				}
			}
		}

	}

}
