/*There is a n * n grid, where the elements in the row and col are sorted.
 * Now find out if a particular element is present or not.*/
public class NDArraySearching {

	public static void main(String[] args) {
		int a[][] = { { 4, 5, 9 }, { 10, 16, 19 }, { 15, 20, 27 }, { 16, 21, 35 }, { 17, 25, 40 } };
		int num = 28;

		NDArraySearching n = new NDArraySearching();
		n.search(a, 0, 4, 0, 2, num);
	}
	
	/*The idea is to squeeze the search area.
	 * reduce the rows and col where the element is to be searched.*/

	public void search(int a[][], int row_beg, int row_end, int col_beg, int col_end, int num) {
		boolean flag = false;
		
		//loop till only one element is left in the grid
		while(!(row_beg == row_end && col_beg == col_end)) {
			
			//check if number = to the last element of the first row.
			if(num == a[row_beg][col_end]) {
				System.out.println("found: "+ row_beg+" "+col_end);
				flag = true;
				break;
				
				//if not then keep removing rows until the element is bigger than last elemt of row.
				//means it cannot belong to that row.
			} else {
				while(num > a[row_beg][col_end] && row_beg < row_end) {
					row_beg++;
				}
				
				//do the same for col.				
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
