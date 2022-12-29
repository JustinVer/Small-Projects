/* Name: Justin Verhoog
 * Date: 2022-09-16
 * Program Title: decision structures a
 * Description: Make a program that will create an array of size 15 and fill it with randomly generated integers from 10 to 50 inclusively.  Display these numbers on the screen on a single line separated by a comma and a space. (i.e. 34, 11, 23, 29, ....).  On separate lines indicate and display the following pieces of information: 
 */
package problems;

public class DecisionStructures_a {

	public static void main(String[] args) {
		//Declare variables and arrays
		int Mean = 0;
		int Sum = 0;
		int LN = 0;
		int SN = 0;
		boolean found = false;
		int[] numbers = new int [15];
		//Sets the array equal to the random numbers
		for(int i = 0;i<numbers.length;i++) {
		numbers[i]=(int) Math.floor(Math.random() * (50 - 10 + 1) + 10);
		System.out.print(numbers[i] + ", ");
		}
		//Finds the largest number by counting down from 50 and if one is found print that
		for(int j = 50; found == false;j--) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]==j) {
				found = true;
			}
		}
		if(found == true) {
			LN = j;
		}
		}
		found = false;
		System.out.println("");
		System.out.println("The largest number is " + LN);
		
		//Finds the smallest number by counting up from 10 and if one is found print that
		for(int j = 10; found == false;j++) {
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i]==j) {
					found = true;
				}
			}
			if(found == true) {
				SN = j;
			}
			}
			System.out.println("The smallest number is " + SN);
			//Adds all the numbers together for the sum
			for (int i = 0; i < numbers.length; i++) {
				Sum = Sum + numbers[i];
			}
			System.out.println("The sum is " + Sum);
			
			//Takes the sum and divides it by 15 to find the mean
			Mean = Sum/15;
			System.out.println("The mean is " + Mean);
			
			//Finds the mode
			int  maxCount = 0;
			int[] numbersCount = new int [15];
			
			//Finds the count of each number but doesn't count numbers before so they don't repeat
	        for (int i = 0; i < numbers.length; ++i){
	            int count = 0;
	            for (int j = i; j < numbers.length; ++j){
	                if (numbers[j] == numbers[i])
	                    ++count;
	            }
	            //Sets the count into an array
	            numbersCount[i]=count;
	            //If the new count is bigger than the last known biggest count update it to the new count
	            if (count > maxCount){
	                maxCount = count;
	            }
	            
	        }
	        //Prints out all of the numbers with the the highest count
	       int count = 0;
	       //if there is no mode print no mode
	       if(maxCount==1) {
	    	   System.out.println("there is no mode");
	       }else{
	    	   //Prints all of the numbers
			System.out.print("the mode is ");
			for(int i = 0; i<numbersCount.length;i++) {
				if(numbersCount[i]==maxCount) {
					count++;
					if(count == 1) {
						//The first one doesn't have a comma so it looks right
						System.out.print( numbers[i] );
					}else {
				System.out.print( ", " + numbers[i] );
					}
				}
			}
	       }

	}

}
