
public class LongestIncreasingSequence {

	public void findLongestSeq_Continous(int arr[]) {
	}
	
	//this fn will find the longest seq in arr starting from index and the current element arr[index]
	//should be greater than number.
	/*{1,3,2,3,4,2,2,1,5} -> 5 {1,2,3,4,5}*/
	public int findLongSeq_inline(int arr[], int index, int number) {
		if(index > arr.length-1)
			return 0;
		
		if(arr[index] > number) {
			return Math.max(1+findLongSeq_inline(arr, index+1, arr[index]),  
					findLongSeq_inline(arr, index+1, number));
		}
		else
			return findLongSeq_inline(arr, index+1, number);
	}
	
	public static void main(String[] args) {
		LongestIncreasingSequence l = new LongestIncreasingSequence();
		int arr[] = {1,2,3,4,5,6,5,2,1,3,9,10,11};
		
		int arr1[] = {1,2,3,1,1,2,4};
		System.out.println(l.findLongSeq_inline(arr1, 0,-1));
		
	}

}
