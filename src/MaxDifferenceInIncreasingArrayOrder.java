/*There is a list of prices given in the array for a stock.
 * Tell which day a person should buy and sell, so as to have max profit.
 * 
 * a = {15,14,12,1,3,7,9,20,4,19}
 * buy price = 1
 * sell price = 20*/

public class MaxDifferenceInIncreasingArrayOrder {

	public static void main(String[] args) {
		int a[] = {3,6,4,8,5,9,10,12,11,20,5,19};
		int min = a[0];
		int profit = 0;
		int maxP = profit;
		
		for(int i = 0; i < a.length; i++) {
			profit = a[i] - min;
			if(maxP < profit){
				maxP = profit;
			}
			
			if(a[i] < min) {
				min = a[i];
			}
		}
		System.out.println(maxP);
		
		
	}

}
