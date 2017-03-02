/*If there is a string, apple, check if an anagram is possible where you can have all characters in the distinct manner.
 * Say, aplep is the solution.
 * Other example: aab, so sol is aba
 * say, aaa, so no anagram is possible.
 * 
 * Sol: One possible solution is recursion.
 * Other possible solution is:
 * 
 * Make a frequenncy map
 * 1 - a, l, e
 * 2 - p
 * 
 * Then create a string considering possible spaces for each character.
 * put a -> _a_
 * put l -> _a_l_
 * put e -> _e_a_l_
 * now possible spaces where p can fit is 4, and p freq is 2, so it is possible.*/

package StringManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReShuffleForDistinctNeighbors {

	public static void main(String[] args) {
		char[] str = {'a','a','b'};
		System.out.println(isShufflingPossible("appleffffff"));
	}
	
	/**************Solution - 2 - Non Recursive*********************/
	public static boolean isShufflingPossible(String str) {
		HashMap<Integer, ArrayList<Character>>freqMap = new HashMap<>();
		int asciiMap[] = new int[125];
		
		//create a freq map using dense array
		for(int i=0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(asciiMap[ch] == 0)
				asciiMap[ch] = 1;
			else {
				int freq = asciiMap[ch];
				asciiMap[ch] = freq+1;
			}
		}
		
		//convert the dense array to the hashmap freqmap.
		for(int i = 0; i < 125; i++) {
			int freq = asciiMap[i]; 
			if(freq != 0) {
				ArrayList<Character> items;
				if(freqMap.containsKey(freq)) {
					items = freqMap.get(freq);
					items.add((char) i);
				} else {
					items = new ArrayList<>();
					items.add((char)i);
					freqMap.put(freq, items);
				}
			}
		}
		
		System.out.println(freqMap);
		
		//now iterate to find if a string is possible.
		Iterator it = freqMap.entrySet().iterator();
		int placesToFill = 1;
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        int freq = (int) pair.getKey();
	        ArrayList<Character> items =  (ArrayList<Character>) pair.getValue();
	        
	        if(freq > placesToFill)
	        	return false;
	        
	        for(int i = 0; i < items.size(); i++) {
	        	placesToFill += freq;
	        }
	    }
		return true;
	}
	/***********************************************************/
	
	public static void print(char c[]) {
		for(int i =0; i < c.length;i++) {
			System.out.print(c[i]);
		}
		System.out.println("\n");
	}
	
	//returns true if possible, ch represents the prev character
	public static boolean countPerm(char arr[], int index, char ch) {
		int size = arr.length;
		if(index == size - 1) {
		//here one permutation is complete.
			if(arr[index] == ch) {
				return false;
			} else 
				return true;
		}
		
		int id = index;
		int count = 0;
		boolean flag = false;
		
		while(id <= size - 1) {
			//swap
			char c = arr[index];
			arr[index] = arr[id];
			arr[id]=c;
			
			flag = countPerm(arr, index+1, arr[index]);
			
			//swap
			c = arr[index];
			arr[index] = arr[id];
			arr[id]=c;
			id++;
		}
		
		return flag;
	}
	
	public static int countAllPerm(char[] inp, int beg, int end) {
		int count = 0;
		//if there is only one element, return 1
		if(end - beg == 0) {
			print(inp);
			return 1;
		}
		else {
			//count all the perm from curr index to end for that string
			count = count + countAllPerm(inp, beg+1, end);
			int index = beg + 1;
			
			//now start swapping the array element at beg from every element and then find permutations
			while(index <= end) {	
				
				//swap
				char c = inp[beg];
				inp[beg] = inp[index];
				inp[index]=c;
				
				//find with new string
				count = count + countAllPerm(inp, beg+1, end);
				
				//swap back
				c = inp[beg];
				inp[beg] = inp[index];
				inp[index]=c;
				index++;
			}
		}
		return count;
	}

}
