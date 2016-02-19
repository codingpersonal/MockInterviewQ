/*array contains ht of a bar chart. How much water can it store.*/
public class BarChartWaterProblem {
/*              |
 *            | |
 *            | |
 *          | | |     |
 *          | | |     |
 *        | | | |     |
 *|       | | | |     |
 *| |     | | | |   | |
 *| | |   | | | |   | |
 *| | | | | | | | | | |
 * */
	public static void main(String[] args) {
		int arr[] = {4,3,2,1,5,7,9,10,1,3,7};
		int low_id = 0, high_id = 0;
		int max_vol = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i+ 1] <= arr[i]) {
				low_id = i;
				int j = i + 1;
				while(arr[low_id] >= arr[j] && j < arr.length -1)  {
					j++;
				}
				high_id = j;
				
				System.out.println(arr[low_id]+ " "+ arr[high_id]);
				
				int max_height = Math.min(arr[low_id], arr[high_id]);
				int vol = 0;
				for(int id = low_id + 1; id < high_id; id++) {
					vol = vol + (max_height - arr[id]);
				}
				System.out.println("Vol is:"+vol);
				if(vol > max_vol) {
					max_vol = vol;
				}
				i = high_id;
			}
		}
		System.out.println("\nMax Vol is:"+max_vol);
	}
}
