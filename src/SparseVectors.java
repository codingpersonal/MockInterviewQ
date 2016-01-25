import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SparseVectors {

	public static void main(String[] args) {
		ArrayList<Integer> v1 = new ArrayList<Integer>(25);
		v1.add(0);
		v1.add(0);
		v1.add(0);
		v1.add(0);		
		v1.add(1);
		v1.add(2);		
		v1.add(0);
		v1.add(0);		
		v1.add(0);
		v1.add(3);

		
		ArrayList<Integer> v2 = new ArrayList<Integer>(25);
		v2.add(1);
		v2.add(0);
		v2.add(2);
		v2.add(0);		
		v2.add(0);
		v2.add(2);		
		v2.add(0);
		v2.add(0);		
		v2.add(0);
		v2.add(3);
		
		HashMap<Integer, Integer> map1= new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		
		map1 = createMapfromVector(v1);
		map2 = createMapfromVector(v2);
		int key;
		int val1 = 0, val2 = 0;
		int output = 0;
		
		for (Entry<Integer, Integer> entry : map1.entrySet()) {
		    key = entry.getKey();
		    val1 = entry.getValue();
		    
		    if(map2.containsKey(key)) {
		    	val2 = map2.get(key);
		    }
		    output += (val1 * val2);
		}
		System.out.println(output);
	}
	
	private static HashMap<Integer, Integer> createMapfromVector(ArrayList<Integer>input) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < input.size(); i++) {
			int value = input.get(i);
			if(value != 0) {
				map.put(i, value);
			}
		}
		return map;
	}
}
