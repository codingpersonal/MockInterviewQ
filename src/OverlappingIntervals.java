import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*you are given the start time and finish time of n intervals. 
 * You have to write a a function that returns boolean value 
 * indicating if there was any overlapping interval in the set of existing intervals. */
public class OverlappingIntervals {

	
	public static void main(String[] args) {
		Numbers[] input = new Numbers[10];
		input[0] = (new Numbers(1,2));
		input[1] = (new Numbers(14,20));
		input[2] = (new Numbers(6,7));
		input[3] = (new Numbers(2,9));
		input[4] = (new Numbers(11,12));
		input[5] = (new Numbers(10,12));
		input[6] = (new Numbers(11,20));
		input[7] = (new Numbers(1,4));
		input[8] = (new Numbers(21,22));
		input[9] = (new Numbers(30,50));
		
		HashSet<Numbers> op = new HashSet<Numbers>();
		
		sort(input);
		int beg = input[0].n1, end = input[0].n2;
		for(int i=0; i < input.length-1;i++) {
			if(end >= input[i+1].n1) {
				op.add(input[i]);
				op.add(input[i+1]);
				end = Math.max(end, input[i+1].n2);
			} else {
				beg = input[i+1].n1;
				end = input[i+1].n2;
			}
			
		}
		
		Iterator iter = op.iterator();
		while (iter.hasNext()) {
		    Numbers n = (Numbers) iter.next();
		    System.out.print("["+n.n1+" "+n.n2+"]"+" ");
		}
	}

	public static void sort(Numbers[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j].n1 > arr[j+1].n1) {
					Numbers temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
}


class Numbers{
	int n1;
	int n2;
	public Numbers(int a,int b) {
		n1 = a;
		n2 = b;
	}
}
