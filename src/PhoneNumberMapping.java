import java.util.ArrayList;
import java.util.HashMap;

/*Every digit is mapped to some alphabets.
 * Find the combinations for all the digits entered in a phone number.*/
public class PhoneNumberMapping {
	ArrayList<String>op = new ArrayList<>();
	HashMap<Integer, String>inp = new HashMap<>();
	
	public PhoneNumberMapping() {
		inp.put(1, "ABC");
		inp.put(2, "DEF");
		inp.put(3, "GHI");
		inp.put(4, "JKL");
		inp.put(5, "MNO");
		inp.put(6, "PQR");
		inp.put(7, "STU");
		inp.put(8, "VWX");
		inp.put(9, "YZ");
		inp.put(0, null);
	}
	
	//this fn will take an arr and from index location, find all the combinations and fill in output
	public void findComb(int arr[], int index) {
		
		//if incoming index is invalid
		if(index >= arr.length) {
			return;
		}
		
		//if only one element is there in the array to process
		if((arr.length-1) == index) {
			String currList = inp.get(arr[index]);
			int id = 0;
			while(id < currList.length()) {
				String list = (currList.substring(id,id+1));
				op.add(list);
				id++;
			}
		}
		
		else {
			findComb(arr, index+1);
			String ch = inp.get(arr[index]);
			int id = 0;
			int size = op.size();
			
			/*TODO:Here append the letters in curr index to each element in arraylist.
			 * so if current list is d,e,f; then add a,b,c to d,e,f*/
			for(int i=0 ; i < size; i++) {
				String currPerm = op.get(0);
				id = 0;
				while(id < ch.length()) {
					String c = ch.substring(id, id+1);
					c = c.concat(currPerm);
					op.add(c);
					id++;
				}
				op.remove(0);
			}
			
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3};
		PhoneNumberMapping ph = new PhoneNumberMapping();
		ph.findComb(arr, 0);
		System.out.println("Count : "+ ph.op.size()+ "\n"+ ph.op);
	}

}
