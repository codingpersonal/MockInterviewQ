/*You have an array of n sorted elements, and a sum. Check if any 2 elements in the array sum to the given sum*/
/*Approach1 : pick a number , and search for sum - number from n-1 elements using binary search
 * Approach2: insert all the element and their occurences in a hashmap.*/
 
public class FindSumPair_Sorted {

	public static void main(String[] args) {
		int arr[] = {1,3,4,6,8,9,10,12,15,20};
		int sum = 19;
		int beg = 0;
		int end = arr.length -1;
		
		while(beg < end) {
			int s = arr[beg] + arr[end];
			if(s == sum) {
				System.out.println("Pair found:" + arr[beg] + " " + arr[end]);
				break;
			} else if(s > sum) {
				end--;
			} else {
				beg++;
			}
				
		}
	}
}
