/*check if one string is a sub sequence of other string or not.
 * Take 2 pointers, one for src and other for destination,
 * then move the pointers as per you match characters in the string.*/

package StringManipulation;

public class CheckIfSubsequence {

	public static void main(String[] args) {
		String source = "somyaaggarwal";
		String destination = "somya";
		int i = 0;
		int j = 0;
		int count = destination.length();
		
		while(i < source.length() && j < destination.length()) {
			if(source.charAt(i) == destination.charAt(j)) {
				j++;
				count--;
			} 
			i++;
		}
		
		if(count == 0) {
			System.out.println("source contains a subsequence of destination string.");
		} else {
			System.out.println("source does not contain a subsequence of destination string.");
		}
		
	}

}
