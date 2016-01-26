import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*you are given the start time and finish time of n intervals. 
 * You have to write a a function that returns boolean value 
 * indicating if there was any overlapping interval in the set of existing intervals. */
public class OverlappingIntervals {

	
	public static void main(String[] args) {
		ArrayList<Numbers> input = new ArrayList<>();
		input.add(new Numbers(1,2));
		input.add(new Numbers(14,20));
		input.add(new Numbers(6,7));
		input.add(new Numbers(2,9));
		input.add(new Numbers(11,12));
		
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
