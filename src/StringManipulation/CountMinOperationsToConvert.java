/*A string needs to be  transformed to other string
 * Possible operations are-
 * add a character
 * remove a character
 * flip the character to the match the destination.
 * Find min no of operations.*/

package StringManipulation;

public class CountMinOperationsToConvert {

	public static int findMinOper(String src, int src_index, String destination, int des_index) {
		// if source is finished, then no of operations will be the number of
		// characters remaining in the other string.
		if (src_index >= src.length() && des_index >= destination.length()) {
			return 0;
		}
		// same for destination.
		if (des_index >= destination.length()) {
			return (src.length() - src_index);
		} 
		if(src_index >= src.length()) {
			return (destination.length() - des_index);
		} else {
			// if there first character is same, then call in recursion for rest of
			// the strings.
			if (src.charAt(src_index) == destination.charAt(des_index)) {
				return findMinOper(src, src_index + 1, destination, des_index + 1);
			} else {
				// else you can do 3 operations on this- add, delete or change.
				int add_oper = 1 + findMinOper(src, src_index, destination, des_index + 1);
				int del_oper = 1 + findMinOper(src, src_index + 1, destination, des_index);
				int change_oper = 1 + findMinOper(src, src_index + 1, destination, des_index + 1);
	
				return Math.min(add_oper, Math.min(del_oper, change_oper));
			}
		}
	}

	public static void main(String[] args) {
		String str = "mlo";
		String des = "mpmk";

		System.out.println(findMinOper(str, 0, des, 0));
	}

}
