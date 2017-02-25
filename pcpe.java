import java.io.*;
import java.util.*;
import java.lang.*;

public class pcpe {





	public pcpe() {

		
	}
	

	
	
	public int[] makeArray(int minAge) {
		
		double log;
		int length;
		
		
		log = Math.log(minAge)/Math.log(10);
		//log is the number of digits in the minAge. It is a decimal since I am taking logs.
		length = ((int) log)+1;
		//Length is the number of digits in minAge.
		
		
		int num[] = new int[length];
		//Initialize array of length
		
		int newNum = minAge;
		// What happens after I delete a digit
		
		
		int currPower = length-1;
		//Start off with the largest power and decrease downwards to 0
		
		double power;
		//variable to store double
		int power2;
		//variable to store the previous double as int
		
		int numDigit;
		//variable to store the digit received after dividing
		
		
		
		//Inputting digits into the array (num) of length
		//Letting i be the value in the array, I am entering the digit
		for (int i=0; i<length; i++) {
			if(currPower == 0) {num[i] = newNum;}
			else {
				power = Math.pow(10,currPower);
				power2 = (int) power;
				numDigit = (int) newNum/power2;
				num[i] = numDigit;
				
				newNum = newNum - (power2*numDigit);
				currPower--;

			}

		}
		
	return num;
		
		
	
	}
	

	public int poly(int[] num, int input) {
		int arrLength = num.length;
		
		int currPower;
		double power;
		int power2;
		int numPoly = 0;
		
		
		for (int i=0; i<arrLength; i++) {
			currPower = arrLength - 1 -i;
			power = Math.pow(input, currPower); 
			power2 = (int) power;
			numPoly = numPoly + num[i]*power2;
		}
		
		return numPoly;
	}


	
	public int maxBase(int[] num, int currAge) {
		
		int numPoly = 0;
		int currNum = 0;
		
		while (numPoly < currAge) {
			numPoly = poly(num, currNum);
			currNum++;
		}
		
		return currNum;


		
		
		
	}
	
	


}