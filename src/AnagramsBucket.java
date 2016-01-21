import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramsBucket {
	
	/*Write a function that takes a list of words as input, and returns a list of those words bucketized by anagrams.
	Example:
	Input: ["star", "rats", "car", "arc", "arts", "stars"]
	Output: [["star", "rats", "arts"], ["car", "arc"], ["stars"]] */

	HashMap<String,ArrayList<String>> bucketizeAnagrams(ArrayList<String> input) {
		ArrayList<ArrayList<String>> out = new ArrayList<>();
		HashMap<String,ArrayList<String>> sorted = new HashMap<>();
		
		for(int i = 0; i < input.size(); i++) {
			String str = input.get(i);
			char[] chars = str.toCharArray();
	        Arrays.sort(chars);
	        String sortedStr = new String(chars);
	        
	       if(sorted.containsKey(sortedStr)) {
	    	   ArrayList<String> temp = sorted.get(sortedStr);
	    	   temp.add(str);
	       }
	       else {
	    	   ArrayList<String> temp = new ArrayList<>();
	    	   temp.add(str);
	    	   sorted.put(sortedStr, temp);
	       }
		}
		
		return sorted;
		
	}

	public static void main(String[] args) {
		AnagramsBucket ab = new AnagramsBucket();
		ArrayList<String> input = new ArrayList<String>(
			    Arrays.asList("star", "stars", "rats", "arc", "car", "arts"));
		ab.bucketizeAnagrams(input);
	}

}
