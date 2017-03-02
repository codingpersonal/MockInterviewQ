import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnagramsBucket {
	
	/*Write a function that takes a list of words as input, and returns a list of those words bucketized by anagrams.
	Example:
	Input: ["star", "rats", "car", "arc", "arts", "stars"]
	Output: [["star", "rats", "arts"], ["car", "arc"], ["stars"]] 
	
	Two other optimized solutions are shared as well.
	
	1. Create a dense array and set the array locations where chars exist.
	ex: abc = 1110000.. upto 26 chars
	c = 001000.. upto 26 chars
	
	convert it to string and store it in a map.
	
	2. create a unique code out of the series of alphabets
	create an array of primes. 26 array length size.
	
	2,3,5,7,11,13....
	
	if ab is received, the unique code is 2 * 3 = 6 and so on.
	
	Multiplication of primes is unique code always.
	*/

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


	public ArrayList<ArrayList<String>> AnagramsBucket_opt(ArrayList<String> input){
		ArrayList<ArrayList<String>> out = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(int i = 0; i < input.size(); i++) {
			String currStr = input.get(i);
			String codedStr = getCodedStr_prime(currStr);
			if(map.containsKey(codedStr)) {
				ArrayList<String> mappedList = map.get(codedStr);
				mappedList.add(currStr);
			} else {
				ArrayList<String> mappedList = new ArrayList<>();
				mappedList.add(currStr);
				map.put(codedStr, mappedList);
			}
		}
		
		//fill in the list of list of string from hashmap
	    Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Object val = pair.getValue();
	        out.add((ArrayList<String>) val);
	    }
	    
	    return out;
	}

	public static String getCodedStr_prime(String str) {
		int [] arr_primes = new int[26];
		arr_primes[0] = 2;
		int num = 3;
		
		for(int i = 1; i < 26; i++) {
			while(num % 2 == 0){
				num++;
			}
			arr_primes[i] = num;
			num++;
		}
		
		int code = 1;
		for(int id = 0; id < str.length(); id++) {
			char ch = str.charAt(id);
			int ch_i = (int)ch - 97;
			code = code * arr_primes[ch_i];
		}
		return String.valueOf(code);
	}
	
	//solution using the dense array
	public static String getCodedStr_denseArray(String str) {
		
		int[] arr = new int[26];
		for(int i = 0; i < 26; i++) {
			arr[i] = 0;
		}
		
		for(int id = 0; id < str.length(); id++) {
			char ch = str.charAt(id);
			int ch_i = (int)ch - 97;
			arr[ch_i] += 1;
		}
		return (Arrays.toString(arr));
		
	}
	
	public static void main(String[] args) {
		AnagramsBucket ab = new AnagramsBucket();
		ArrayList<String> input = new ArrayList<String>(
			    Arrays.asList("star", "stars", "rats", "arc", "car", "arts"));
		
		//ab.bucketizeAnagrams(input);
		
		ArrayList<ArrayList<String>> out = ab.AnagramsBucket_opt(input);
		System.out.println(out);
		
		
		
	}

}
