/*Check if anagram of a string is substring(consecutive chars in other string) of other string or not.
 * solution involves creating a map of freqcount.
 * then keep decrementing the characters from the list which are found.
 * 
 * additionally you can use dense array to perform this. Less space wastage.
 * 
 * 2. generate a unique code word from original string.
 * Hence all its anagrams will produce the same code.
 * Traverse the other string to see if its substrings produce the same code or not*/

package StringManipulation;

import java.util.HashMap;

public class CheckIfAnagramIsSubstring {
	
	public static boolean checkAna(String inp, HashMap<Character, Integer>freq_count, int count) {
		HashMap<Character, Integer>temp = freq_count;
		int tempCount = count;
		
		for(int i = 0; i < inp.length(); i++) {
			if(tempCount == 0) {
				return true;
			} else {
				Character currChar = inp.charAt(i);
				if(temp.containsKey(currChar)) {
					int currCount = temp.get(currChar);
					currCount -= 1;
					if(currCount == 0) {
						temp.remove(currChar);
					} else {
						temp.put(currChar, currCount);
					}
					tempCount--;
				} else {
					temp = freq_count;
					tempCount = count;
				}
			}
		}
		if(tempCount == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		HashMap<Character, Integer>freq_count = new HashMap<>();
		freq_count.put('a', 3);
		freq_count.put('g', 2);
		freq_count.put('r', 1);
		int count = 6;

		String inp = "somaaagrgsom";
		System.out.println(checkAna(inp, freq_count, count));
	}

}