//Merge sort in decreasing order
public class Merge {
	public int[] merge_sorted_arr(int arr1[], int beg1, int end1, int arr2[], int beg2, int end2) {
		int i = beg1;
		int j = beg2;
		int k = 0;
		int size = end1 - beg1 + 1 + end2 - beg2 + 1;
		int arr_merged[] = new int[size];

		while (i <= end1 && j <= end2) {
			if (arr1[i] >= arr2[j]) {
				arr_merged[k++] = arr1[i++];
			} else {
				arr_merged[k++] = arr2[j++];
			}
		}

		// copy the remaining elements from arr1 to arr3
		while (i <= end1) {
			arr_merged[k++] = arr1[i++];
		}

		// copy the remaining elements from arr2 to arr3
		while (j <= end2) {
			arr_merged[k++] = arr2[j++];
		}

		return arr_merged;
	}
	
	// it takes an array and sorts it from beg to end location.
	public void mergeSort(int arr[], int beg, int end) {
		int size = end - beg + 1;
				
		//terminating condition. If one element is left, just return
		if(size == 1) {
			return;
		}
		else {
			// + beg is necessary to align the mid from the beg pos, say beg = 3, end = 4, so mid = 0 
			//to align mid as per the new list it is incremented by 3
			int mid = (end - beg) / 2 + beg;
			mergeSort(arr, beg, mid);
			mergeSort(arr, mid + 1, end);
			
			int arr_ret[] = merge_sorted_arr(arr, beg, mid, arr, mid + 1, end);
			// assign back to the array
			int count = 0;
			for(int i = beg; i <= end; i++) {
				arr[i] = arr_ret[count++];
			}
		}
	}
}