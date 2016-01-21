import java.util.ArrayList;
import java.util.HashSet;

/*you are given a string of lowercase characters. 
 * you are given a dictionary of meaningful words. 
 * you need to output all the possible substrings of the string which has meaning*/

public class StringDictionary {

	public ArrayList<String> findMeaningfulSubStrings(String inString, HashSet<String> dict) {
		int startindex = 0;
		int len = inString.length();
		ArrayList<String> out = new ArrayList<>();

		while (startindex < len) {
			int loop = startindex;
			while (loop < len) {
				String temp = inString.substring(startindex, loop+1);
				// checking for if the substring is present in the hashset.
				if (dict.contains(temp)) {
					out.add(temp);
				}
				loop++;
			}
			startindex++;
		}
		return out;
	}
	
	public static void main(String args[]) {
		StringDictionary str = new StringDictionary();
		String input = "apartments";
		
		HashSet<String> dict = new HashSet<>();
		dict.add("part");
		dict.add("apart");
		dict.add("art");
		dict.add("apartment");
		dict.add("apartments");
		dict.add("somya");
		
		ArrayList<String>out = new ArrayList<>();
		out = str.findMeaningfulSubStrings(input, dict);
		
		System.out.println(out);
	}

}
