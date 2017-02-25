import java.lang.Math.*;

public class tester {

	public static void main(String[] args) {
		int currAge = Integer.parseInt(args[0]);
		int minAge =  Integer.parseInt(args[1]);

		
		pcpe first = new pcpe();
		int[] numArr = first.makeArray(minAge);
		
		//System.out.println(numArr[0]);
		//System.out.println(numArr[1]);
		//System.out.println(numArr[2]);

		//int maxb = first.maxBase(numArr, 2016);
		//int output = first.poly(numArr, 4);
		
		
		
		int maxbase;
		maxbase = first.maxBase(numArr, currAge);
		
		boolean haveDecimals = true;
		ProgrammingChallenges test = new ProgrammingChallenges();
		
		
		
		while (haveDecimals) {
			int x = test.getinBase(currAge, maxbase);
			if( x == -1){maxbase--;}
			else {haveDecimals=false;}
			
			
		}
		
		System.out.println(maxbase);
		
		
		
		
		
		
		
	}


}