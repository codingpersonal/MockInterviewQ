/*Given a number n, find the largest number just smaller than n that can be formed using the same digits as n. */
public class SmallestWithSameDigits {

	public static void main(String[] args) {
		int arr[] = {3,2,4,9,7};
		boolean flag = false;
		for(int i = arr.length - 2; i >= 0; i--) {
			int index = findSmallest(arr[i],arr,i + 1,arr.length-1);
			//means it itself is the smallest, then do nothing
			if(index == -1) {
				//do nothing
			}
			else {
				//swap the numbers
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				flag = true;
				Merge m = new Merge();
				m.mergeSort(arr, i + 1, arr.length - 1);
				break;
			}
		}

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static int findSmallest(int number, int arr[], int beg, int end) {
		int min = -1;
		int min_id = -1;
		for(int i = beg; i <= end; i++) {
			if((arr[i] < number) && (arr[i] > min)) {
				min = arr[i];
				min_id = i;
			}
		}
		return min_id;
	}
}
