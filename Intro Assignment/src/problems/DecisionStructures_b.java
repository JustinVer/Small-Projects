/* Name: Justin Verhoog
 * Date: 2022-09-16
 * Program Title: decision structures b
 * Description: Make a program that will create an array of size 15 and fill it with randomly generated integers from 10 to 50 inclusively (use the code from a).  Display these numbers on the screen on a single line separated by a comma and a space. (i.e. 34, 11, 23, 29, ....).  On the next line display these numbers in ascending order using the same formatting.
 */
package problems;

public class DecisionStructures_b {

	public static void main(String[] args) {
		//Declares array
		int[] numbers = new int [15];
		//Adds the random numbers to the elements of the array and then prints them
		for(int i = 0;i<numbers.length;i++) {
			numbers[i]=(int) Math.floor(Math.random() * (50 - 10 + 1) + 10);
			System.out.print(numbers[i] + ", ");
			}
		//Starts a new line
		System.out.println("");
		//Starts at 10 (the lowest possible number) and checks to see if it is in the array and if it is it prints it otherwise it continues to the next number
		for (int i = 10; i<=50;i++) {
			for (int j = 0; j<numbers.length;j++) {
			if(i==numbers[j]) {
				System.out.print(numbers[j] + ", ");
			}
			}
		}
	}

}
