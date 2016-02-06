/*There are 2 sorted arrays
 * a1 = 1,4,7,8,10,0,0,0,0,0
 * a2 = 2,3,4,5,8
 * 
 * merge them back in a1. use little space and less complexity*/

public class MergeArrays {

	public static void main(String[] args) {
		int a1[] = {1,4,7,8,10,0,0,0,0,0};
		int a2[] = {1,1,1,1,1};
		
		//we know that a1 is only half filled.
		//means it can accomodate a2 elements as well.
		
		int size = a2.length;
		
		//it will point to last element in a1
		int p1 = size - 1;
		//it will point to last element in a2
		int p2 = size - 1;
		
		//will point to last location in a1
		int p3 = a1.length-1;
		
		//start traversing from the back and keep adding in a1 from back only.
		//in place sorting.
		while(p1 >= 0 && p2 >= 0) {
			if(a1[p1] > a2[p2]) {
				a1[p3--] = a1[p1--];
			} else if (a1[p1] < a2[p2]){
				a1[p3--] = a2[p2--];
			} else {
				a1[p3--] = a1[p1--];
				a1[p3--] = a2[p2--];
			}
		}
		
		//copy the remaining elements if any from a1
		while(p1 >= 0) {
			a1[p3--] = a1[p1--];
		}
		
		//copy the remaining elements if any from a2
		while(p2 >= 0) {
			a1[p3--] = a2[p2--]; 
		}
		
		for(int i =0 ; i < a1.length; i++) {
			System.out.print(a1[i]+ " ");
		}
		
	}

}
