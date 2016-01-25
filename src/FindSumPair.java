import java.util.HashMap;

/*You have an array of n elements, and a sum. Check if any 2 elements in the array sum to the given sum*/
/*Approach1 : pick a number , and search for sum - number from n-1 elements using binary search
 * Approach2: insert all the element and their occurences in a hashmap.*/
 
public class FindSumPair {

	public static void main(String[] args) {
		int arr[] = {12,6,3,2,5,4,7,12,11,8,10};
		int sum = 12;
		boolean flag = false;
		int rem_val;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map = createMapFromArray(arr);
		
		for(int i = 0; i < arr.length; i++) {
			rem_val = sum - arr[i];
			if(map.containsKey(rem_val)) {
				if(map.get(rem_val) > 1) {
					System.out.println("Pair found:" + rem_val + " " + arr[i]);
					flag = true;
					break;
				}
			}
		}
		if(!flag)
			System.out.println("No pair found");
	}
	
	private static HashMap<Integer, Integer> createMapFromArray(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int val;
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				val = map.get(arr[i]);
				val += 1;
				map.put(arr[i], val);
			}
			map.put(arr[i], 0);
		}
		return map;
	}

}
