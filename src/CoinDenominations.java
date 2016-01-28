//there are few coin denominations given
//also given is a sum.
//form the sum using the given denominations such that min coins are used.
import java.util.HashMap;

public class CoinDenominations {
	HashMap<Pair, Integer>dp = new HashMap<>();
	
	//below function will take an array of integers and will scan that from index to find the sum in it.
	//it will then return the min count
	public int findCount(double arr[], int index, double sum) {
		Pair key = new Pair(sum, index);
		
		//here hashmap will store the index-sum to min count value.
		//if present return it.
		if(dp.containsKey(key)) {
			System.out.println("found in dp");
			return dp.get(key);
		}
		
		//if whole array has been parsed, then probable no count is good enough to form the sum.
		//so return infitinte.
		if(index >= arr.length) {
			return 99999;
		}
		if(sum == arr[index]) {
			System.out.println("-->");
			return 1;
		}
		
		//if array index element is big than count, then pass the list from next location
		if(sum < arr[index]) {
			return findCount(arr, index+1, sum);
		}
		else {
			//case1: if the current Pair is nt used to find the sum.
			int count1 = findCount(arr, index+1, sum);
			
			//if current Pair is used to find the sum
			//pass the list again coz it can be used again as well.
			int count2 = 1 + findCount(arr, index, sum-arr[index]);
			int min_count = Math.min(count1, count2);
			dp.put(new Pair(sum, index), min_count);
			return min_count;
		}
	}
	
	class Pair{
		double sum;
		int index;
		public Pair(double s, int i) {
			sum = s;
			index = i;
		}
		
		//it finds the hashcode where the key will be stored in hashmap.
		//it is needed coz we are overriding equal as well.
		@Override
		public int hashCode() {
			return (int) (this.sum * 100 + this.index);
		}
		
		//here we override the equals for the hashmap.
		//so when you can containKey, then it finds hash,
		//after finding hash, it checks the number on that location.
		//now it needs to check if both n1 and n2 are equal then it shud return true;
		@Override
		public boolean equals(Object p) {
			if (p instanceof Pair) {
				Pair obj = (Pair)p;
				return (this.sum == obj.sum && this.index == obj.index);
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		double arr[] = {20, 17, 11, 7, 1};
		//double arr[] = {17,10,4,0.25};
		CoinDenominations cd = new CoinDenominations();
		System.out.println(cd.findCount(arr, 0, 43));
		
	}

}
