package ArrayManipulation;

public class BinaryArraySort {

	int array[] = {0,0,1,1,1,0,1,0,1,0,0,0,0,0,1,1,1,0,0};
	
	public void sortArray() {
		int beg = 0;
		int end = array.length - 1;
		
		while(beg <= end) {
			if(array[beg] == 0 && array[end] == 0) {
				beg = beg + 1;
			}
			
			else if(array[beg] == 0 && array[end] == 1) {
				beg += 1;
				end -= 1;
			}
			
			else if(array[beg] == 1 && array[end] == 0) {
				int temp = array[beg];
				array[beg] = array[end];
				array[end] = temp;
				
				beg += 1;
				end -= 1;
			}
			
			else {
				end -= 1;
			}
		}
	}
	
	public void display() {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		BinaryArraySort b = new BinaryArraySort();
		b.sortArray();
		b.display();
	}

}
