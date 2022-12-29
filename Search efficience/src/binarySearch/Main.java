package binarySearch;

/**
 * <h1>Binary Search</h1> Gets 1500 random numbers from 0-2500 inclusive and
 * searches for 50 random numbers using a binary search
 * 
 * @author Justin Verhoog
 * @date 2011-11-25
 */
public class Main {

	public static void main(String[] args) {
		// Declares variables
		int max = 2500;
		int min = 0;
		int total = 0;
		int largest = 0;
		int[] searchInts = new int[50];
		int[] searchCount = new int[searchInts.length];
		int[] ints = new int[1500];
		boolean notRepeat = false;
		// Gets the 1500 random numbers between 0-2500 inclusive
		for (int i = 0; i < ints.length; i++) {
			ints[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
		}
		// Gets 50 random numbers between 0-2500 inclusive to search for. Also checks to
		// make sure none of them repeat
		for (int i = 0; i < searchInts.length; i++) {
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
		}
		// Sorts the numbers
		ints = MyMethods.sortAscending(ints);
		// Searches all 50 times
		for (int i = 0; i < searchInts.length; i++) {
			searchCount[i] = MyMethods.binarySearch(ints, searchInts[i]);
			// Increases the total and finds the largest
			total = total + searchCount[i];
			if (searchCount[i] > largest) {
				largest = searchCount[i];
			}
		}
		// Prints out the required information
		System.out.println("The most comparisons was " + largest);
		System.out.println("The average comparison was " + total / searchInts.length);
	}

}
