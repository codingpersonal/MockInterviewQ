
public class StringPerm {

	public static void main(String[] args) {
		char[] str = {'s','o','m','y'};
		System.out.println(countAllPerm(str,0,str.length-1));
	}
	
	public static void print(char c[]) {
		for(int i =0; i < c.length;i++) {
			System.out.print(c[i]);
		}
		System.out.println("\n");
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
