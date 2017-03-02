/*[1,2,3] and [2,3,4] = [3,5,7]
 * [1,2,3] and [2,3,5,5] = [2,4,7,8] means add from the end
 * [9,9,2] and [0,1,3] = [1,0,0,5] means consider carry as well.*/

package ArrayManipulation;

import java.util.Stack;

public class AddTwoArrays {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		int a1[] = {2,1,8,2,9};
		int a2[] = {2,3,4};
		
		int p1 = a1.length - 1;
		int p2 = a2.length - 1;
		int carry = 0;
		int currSum = 0;
		
		while(p1 >= 0 && p2 >= 0) {
			currSum = a1[p1--] + a2[p2--] + carry;
			carry = currSum / 10;
			currSum = currSum % 10;
			
			s.push(currSum);
		}
		
		//in case both arrays are of equal length and only carry is left over
		if(carry != 0 && p1 < 0 && p2 < 0)
			s.push(carry);
		
		while(p1 >= 0) {
			if(carry != 0) {
				s.push(a1[p1] + carry);
				carry = 0;
			} else {
				s.push(a1[p1]);
			}
			p1--;
		}
		
		while(p2 >= 0) {
			if(carry != 0) {
				s.push(a2[p2] + carry);
				carry = 0;
			} else {
				s.push(a2[p2]);
			}
			p2--;
		}
		
		System.out.println(s);
	}

}
