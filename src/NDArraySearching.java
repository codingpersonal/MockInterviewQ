
public class NDArraySearching {

	public static void main(String[] args) {
		int a[][] = { { 4, 5, 9 }, { 10, 16, 19 }, { 15, 20, 27 }, { 16, 21, 35 }, { 17, 25, 40 } };
		int num = 28;

		NDArraySearching n = new NDArraySearching();
		n.search(a, 0, 4, 0, 2, num);
	}

	public void search(int a[][], int row_beg, int row_end, int col_beg, int col_end, int num) {
		boolean flag = false;
		while(!(row_beg == row_end && col_beg == col_end)) {
			if(num == a[row_beg][col_end]) {
				System.out.println("found: "+ row_beg+" "+col_end);
				flag = true;
				break;
			} else {
				while(num > a[row_beg][col_end] && row_beg < row_end) {
					row_beg++;
				}
				
				if(num == a[row_beg][col_end]) {
					System.out.println("found: "+ row_beg + " "+ col_end);
					flag = true;
					break;
				} else {
					while(num < a[row_beg][col_end] && col_beg < col_end) {
						col_end--;
					}
				}
			}
		}
		if(!flag)
			System.out.println("Not found");
	}

}
