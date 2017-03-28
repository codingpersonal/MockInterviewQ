/* Replace every number with the count of the numbers which are larger than it in the whole array.
 * input = [7,5,6,3,4,1,2,9,11]
 * output = [2,3,2,3,2,3,2,1,0]
 * */

package ArrayManipulation;

import java.util.Stack;

public class ReplaceWithCountOfMaxNumberAfterIt {

	public void replaceFn(int arr[]) {
		Stack<Integer> order = new Stack<>();
		int len = arr.length;
		int id = len - 1;
		
		order.push(arr[len - 1]);
		arr[id] = 0;
		
		while(--id >= 0) {
			int currItem = arr[id];
			if(currItem < order.peek()) {
				arr[id] = order.size();
				order.push(currItem);
			} else {
				while(order.peek() <= currItem) {
					order.pop();
				}
				arr[id] = order.size();
				order.push(currItem);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 7,5,6,3,4,1,2,9,11 };
		ReplaceWithCountOfMaxNumberAfterIt r = new ReplaceWithCountOfMaxNumberAfterIt();
		r.replaceFn(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

}
