/*In an array replace every element with the next largest element in the list.
 * [7,5,6,3,4,1,2,9,11]
 * [9,6,9,4,9,2,9,11,11]*/

package ArrayManipulation;

import java.util.Stack;

public class ReplaceWithNextLargest {

	public static void main(String[] args) {
		int arr[]  = {7,5,6,3,4,1,2,9,11};
		Stack<Integer>num = new Stack<>();
		num.push(arr[arr.length-1]);
		
		for(int i = arr.length-2 ; i >=0 ; i--) {
			int currElem = arr[i];
			while(num.peek() < arr[i]) {
				num.pop();
			}
			arr[i] = num.peek();
			num.push(currElem);
		}
	
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}
}
