import java.util.ArrayList;

public class LMH {

	int array[] = {0,1,1,2,2,2,2,2,1,1,1,0,1,0,1,0,0,2,2};	
	public void sortLMHList() {
		int beg = 0; 
		int end = array.length - 1;
		
		while(beg <= end) {
			if(array[beg] == 2 && array[beg] > array[end]) {
				int temp = array[beg];
				array[beg] = array[end];
				array[end] = temp;
				
				beg++;
				end--;
			}
			else if(array[beg] < 2) {
				beg++;
			}
			else if(array[end] == 2){
				end--;
			}
		}
		
		end = beg - 1;
		beg = 0;
		
		while(beg <= end) {
			if(array[beg] > array[end]) {
				int temp = array[beg];
				array[beg] = array[end];
				array[end] = temp;
				
				beg++;
				end--;
			}
			else if(array[beg] <= array[end] && array[beg] == 0) {
				beg++;
			}
			else {
				end--;
			}
		}
		
		System.out.println(array);
		
	}
	
	public static void main(String[] args) {
		LMH lmh = new LMH();
		lmh.sortLMHList();
	}

}
