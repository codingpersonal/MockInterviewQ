/*You have an array of n sorted elements, and a sum. Check if any 3 elements in the array sum to the given sum*/
 
public class FindSumTriplet {

	public static void main(String[] args) {
		int arr[] = {1,3,4,6,8,9,10,12,15,20};
		int sum = 23;
		int end = arr.length -1;
		NumberPair n = new NumberPair();
		
		for(int i= 0; i < arr.length; i++) {
			int s = sum - arr[i];
			getPairForSum(s, arr, i+1,end, n);
			if(n.n1 != -1 && n.n2 != -1) {
				System.out.println("\nNumbers are:" + arr[i] + " " + n.n1 + " " + n.n2);
				break;
			}
		}
	}
	
	public static NumberPair getPairForSum(int sum, int arr[], int beg, int end, NumberPair n){
		while(beg < end) {
			int s = arr[beg] + arr[end];
			if(s == sum) {
				n.n1 = arr[beg];
				n.n2 = arr[end];
				return n;
			} else if(s > sum) {
				end--;
			} else {
				beg++;
			}
		}
		return n;
	}

	
}

class NumberPair{
	int n1 = -1;
	int n2 = -1;
}