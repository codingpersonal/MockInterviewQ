/*Find the sequence which gives the max sum.
 *Sol: incrememnt the p1 till it comes on a +ve number since a seq cannot start with -ve number.
 *now increment the p2 and update sum if greater than max.
 *In case sum goes less than 0 then discard the sum and the sequence,
 *try again with new indexes.*/
package ArrayManipulation;

public class FindMaxSumSequence {

	public static void main(String[] args) {

		int min_start_id = 0;
		int min_end_id = 0;
		int max = -9999;
		
		int arr[] = {-1,2,-3,1,1,5,-4,2};
		
		//assuming array has min 2 elements.
		int p1 = 0, p2 = 1;
		
		//incrememnt p1 so that it begins with +ve number.
		while(arr[p1] < 0 && p2 < arr.length) {
			p1++;
			p2++;
		}
		
		int sum = arr[p1];
		max = sum;
		
		while(p2 < arr.length) {			
			sum = sum + arr[p2];
			
			//it means a positive number came
			if(sum >= max) {
				max = sum;
				min_end_id = p2;
				min_start_id = p1;
				
				//now sum goes less than 0, so discard and begin again
			} else if (sum < 0){
				p1 = p2 + 1;
				p2++;
				sum = arr[p1];
			}	
			
			//p2 will always be incrememted.
			p2++;
		}
		
		System.out.println(min_start_id+" "+ min_end_id+ " "+max);
		
	}

	
}
