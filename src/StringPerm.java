
public class StringPerm {

	public static void main(String[] args) {
		char[] str = {'s','o','m','y','a'};
		System.out.println(countPerm(str,0));
	}
	
	public static void print(char c[]) {
		for(int i =0; i < c.length;i++) {
			System.out.print(c[i]);
		}
		System.out.println("\n");
	}
	
	public static int countPerm(char arr[], int index) {
		int size = arr.length;
		if(index == size -1)
			return 1;
		
		int id = index;
		int count = 0;
		while(id <= size - 1) {
			//swap
			char c = arr[index];
			arr[index] = arr[id];
			arr[id]=c;
			
			count += countPerm(arr, index+1);
			
			//swap
			c = arr[index];
			arr[index] = arr[id];
			arr[id]=c;
			id++;
		}
		
		return count;
	}
	
	public static int countAllPerm(char[] inp, int beg, int end) {
		int count = 0;
		//if there is only one element, return 1
		if(end - beg == 0) {
			print(inp);
			return 1;
		}
		else {
			//count all the perm from curr index to end for that string
			count = count + countAllPerm(inp, beg+1, end);
			int index = beg + 1;
			
			//now start swapping the array element at beg from every element and then find permutations
			while(index <= end) {	
				
				//swap
				char c = inp[beg];
				inp[beg] = inp[index];
				inp[index]=c;
				
				//find with new string
				count = count + countAllPerm(inp, beg+1, end);
				
				//swap back
				c = inp[beg];
				inp[beg] = inp[index];
				inp[index]=c;
				index++;
			}
		}
		return count;
	}

}
