import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*A person is famous if everyone in a group knows him, but he do not know anyone.
 * Find the famous person among a group of people.*/
public class FindFamousPerson {
	HashMap<Integer, HashSet<Integer>>graph = new HashMap<>();
	public FindFamousPerson() {
		graph.put(1, new HashSet<Integer>());
		graph.put(2, new HashSet<Integer>(Arrays.asList(1,3,6)));
		graph.put(3, new HashSet<Integer>(Arrays.asList(1,5,6)));
		graph.put(4, new HashSet<Integer>(Arrays.asList(1,3,6)));
		graph.put(5, new HashSet<Integer>(Arrays.asList(1,6,3)));
	}
	
	//this fn return true if i knows j
	boolean know(int i, int j) {
		if(graph.containsKey(i)) {
			HashSet<Integer>child = graph.get(i);
			if(child.contains(j))
				return true;
			else
				return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		FindFamousPerson f = new FindFamousPerson();
		int arr[] = {1,2,3,4,5};
		int pt1= 0;
		int pt2 = 1;
		boolean flag = true;
		while(pt2 <= arr.length-1) {
			//if first element knows second, first cannot be famous.
			boolean one = f.know(arr[pt1],arr[pt2]);
			boolean two = f.know(arr[pt2], arr[pt1]);
			//none of them will be famous
			if((one && two) || (!one && !two)) {
				pt1 = pt2 + 1;
				pt2 = pt1 + 1;
			//two can be famous, one knows two, but two do not know one
			} else if(one && !two) {
				pt1 = pt2 + 1;
			} else {
				pt2++;
			}
			
			//swap the pointers in case pt1 is pointing to element ahead of pt1.
			//pt1 will always store the inital element than pt2.
			if(pt1 > pt2) {
				int temp = pt1;
				pt1 = pt2;
				pt2 = temp;
			}
		}		
		System.out.println("Famous person can be: "+arr[pt1]+".Validating more..");
		
		//now pt1 may store the famous person.
		//check pt1 with all the elements before it, if they know him or not.
		for(int i=0; i < pt1; i++) {
			if(!f.know(arr[i], arr[pt1])) {
				System.out.println("No famous person.");
				flag = false;
				break;
			}
		}
		if(flag) 
			System.out.println("Famous person is:"+ arr[pt1]);
	}
}
