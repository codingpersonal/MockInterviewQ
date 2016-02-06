/*An array contains both positive and negative number.
 * find a pair with max multiplication output.
 * sol: find 2 max numbers and 2 min numbers.
 * a = 1,2,3,4,5,-9,-8
 * max = 4,5
 * min = -9, -8
 * max output will be max multiplication of this pairs.*/
public class MaxMulOfPairInArray {

	public static void main(String[] args) {

		int arr[] = { 10, 9, 0, 1, 2, 3, 4, 5, -7 };
		int max1 = arr[0];
		int max2 = arr[1];
		int min1 = arr[0];
		int min2 = arr[1];

		// max1 always holds the highest number
		if (max1 < max2) {
			int t = max1;
			max1 = max2;
			max2 = t;
		}

		// traverse to find 2 max elements
		for (int i = 3; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = arr[i];
				int t = max1;
				max1 = max2;
				max2 = t;
			} else if (arr[i] < max2) {
				// do nothing
			} else if (arr[i] > max2 && arr[i] < max1) {
				max2 = arr[i];
			}
		}

		System.out.println(max1 + " " + max2);

		// traverse to find 2 min elements
		if (min1 > min2) {
			int t = min1;
			min1 = min2;
			min2 = t;
		}

		// traverse to find 2 max elements
		for (int i = 3; i < arr.length; i++) {
			if (arr[i] < min1) {
				min2 = arr[i];
				int t = min1;
				min1 = min2;
				min2 = t;
			} else if (arr[i] > min2) {
				// do nothing
			} else if (arr[i] > min1 && arr[i] < min2) {
				min2 = arr[i];
			}
		}
		
		System.out.println(min1+" "+min2);
		
		System.out.println(Math.max(min1*min2, max1*max2));
	}

	public static void swap(int a, int b) {

	}

}
