package linearSearch;

/**
 * <h1>Linear Search</h1> Gets 1500 random numbers from 0-2500 inclusive and
 * searches for 50 random numbers using a linear search
 * 
 * @author Justin Verhoog
 * @date 2011-11-25
 */
public class Main {

	public static void main(String[] args) {
		// Declares variables
		int max = 2500;
		int min = 0;
		int largest = 0;
		int total = 0;
		boolean found = false;
		boolean notRepeat = false;
		int[] ints = new int[1500];
		int[] searchInts = new int[50];
		int[] searchCount = new int[searchInts.length];
		// Gets the 1500 random numbers between 0-2500 inclusive
		for (int i = 0; i < ints.length; i++) {
			ints[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
		}
		// Gets the 50 random numbers then searches for them
		for (int i = 0; i < searchInts.length; i++) {
			found = false;
			// Gets the number and makes sure it isn't a repeat
			while (notRepeat == false) {
				int searchIntCount = 0;
				searchInts[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
				for (int j = 0; j < i; j++) {
					if (searchInts[i] == searchInts[j]) {
						searchIntCount++;
					}
				}
				if (searchIntCount == 0) {
					notRepeat = true;
				}
			}
			notRepeat = false;
			// Searches for the number
			for (int j = 0; found == false; j++) {
				if (searchInts[i] == ints[j] || j == 1499) {
					found = true;
				}
				searchCount[i]++;
			}
			// Increases the total and finds the largest
			total += searchCount[i];
			if (searchCount[i] > largest) {
				largest = searchCount[i];
			}

		}
		// Prints out the required information
		System.out.println("The most comparisons was " + largest);
		System.out.println("The average comparison was " + total / searchInts.length);

	}

}
