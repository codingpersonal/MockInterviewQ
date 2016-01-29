import java.util.ArrayList;

/*You will be given a set of integers, find the average for window_size number of intergers at once.
 * Read the incoming integers from an input stream.*/

public class MovingAverage {
	//imagine the input coming from user in a live buffer instead of an intarr here.
	public void printMovingAvg(int[] intarr, int window_size){
		int id = 0;
		//size of this output array will always be window_size
		int op_arr[] = new int[window_size];		
		int old_ptr = 0;
		int sum = 0;
		int beg = 0;
		
		while(id < intarr.length) {
			sum = sum + intarr[id];
			//it check if there are not even 2 elements in the array to be processed.
			if(beg < window_size-1){
				op_arr[beg] = intarr[id];
				beg++;
				//for 3 element, 3 being the window size
			} else if(beg == window_size - 1) {
				op_arr[beg] = intarr[id];
				System.out.println("Avg:"+sum/window_size);
				beg++;
			}
			//for more than 3 elements
			else {
				sum = sum - op_arr[old_ptr];
				op_arr[old_ptr] = intarr[id];
				old_ptr = (old_ptr + 1)%window_size;
				System.out.println("Average:"+sum/window_size);
			}
			id++;
		}
	}

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage();
		int arr[] = {1,2,3,4,5};
		m.printMovingAvg(arr, 3);
	}

}
