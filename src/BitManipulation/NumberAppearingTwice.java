/*/*Problem: In an array, all numbers appear three times except one which only appears only once. 
 * Please find the unique number.
 */

/*Do a XOR for every number in the list.
 * Since it appears twice, all will be done to zero.
 * Left one will be the op*/
package BitManipulation;

public class NumberAppearingTwice {

	public static void main(String[] args) {
		int arr[] = {4,3,7,2,1,1,2,3,4};
		int op = arr[0];
		for(int i = 1; i < arr.length; i++) {
			op = op ^ arr[i];
		}
		System.out.println(op);
	}

}
