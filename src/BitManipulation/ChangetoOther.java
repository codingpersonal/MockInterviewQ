/*Write a Java method that will return the number of bits 
 * that will need to be changed in order to convert an integer, X, 
 * into another integer, Y and vice versa. 
 * The method should accept two different integers as input. 
 * For example, if your method is passed the integers 12 and 16 then your method should return a 3*/

package BitManipulation;

public class ChangetoOther {

	public static void main(String[] args) {
		int a = 12;	// 01100
		int b = 16; //`10000
		
		int c = a ^ b; //11100
		//count no of 1s in c. that will be the answer.
		int count = 0;
		while(c != 0) {
			if((c & 1) == 1) 
				count++;
			c = c>>1;
		}
		System.out.println(count);
		
		
	}

}
