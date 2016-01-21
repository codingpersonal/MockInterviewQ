import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*Write a function that will take a Arraylist {1,2,3} and print all its possible subsets.
 * {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}*/
public class PrintAllSubsets {

	public ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> input, int startIndex) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		if (input.size()-1 == startIndex) {
			ArrayList<Integer> op = new ArrayList<>();
			op.add(input.get(startIndex));
			ret.add(op);
		} else {
			ArrayList<ArrayList<Integer>> temp = findSubsets(input, startIndex + 1);
			int element = input.get(startIndex);
			
			//add the current element to each set 
			ret = addCurrentElementToSet(temp, element);
			
			//adding the element itself as a part of set.
			ret.add(new ArrayList<>(Arrays.asList(element)));
		}

		return ret;
	}

	public ArrayList<ArrayList<Integer>> addCurrentElementToSet(ArrayList<ArrayList<Integer>> input, int element) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();		
		int s = input.size();
		
		Iterator<ArrayList<Integer>> it = input.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> set = new ArrayList<>();
			ArrayList<Integer> set_old = new ArrayList<>();
			
			set_old = it.next();
			for(int i = 0; i < set_old.size(); i++) {
				int t;
				t = set_old.get(i);
				set.add(t);
			}
			
			set.add(element);
			ret.add(set);
			ret.add(set_old);
			
		}
		
		return ret;
	}

	public static void main(String[] args) {
		int startIndex = 0;
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		
		ArrayList<ArrayList<Integer>>temp = new ArrayList<>();
		temp.add(input);
		
		PrintAllSubsets ps = new PrintAllSubsets();
		//System.out.println(ps.addCurrentElementToSet(temp, 4));
		
		System.out.println(ps.findSubsets(input, startIndex));
	}

}
