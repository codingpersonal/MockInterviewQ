import java.util.ArrayList;

/*There are certain coin denominations given.
 * Also there is a sum value
 *Find all coin denominations that equals the sum here*/
public class CoinDeno_All {
	ArrayList<Double>op = new ArrayList<>();
	public int findCount(double arr[], int index, double sum) {
		if(index >=arr.length) {
			return 9999;
		}
		
		if(sum == arr[index]) {
			op.add(arr[index]);
			for(int i=0; i<op.size(); i++) {
				System.out.print(op.get(i)+",");
			}
			System.out.println("\n");
			op.remove(op.size()-1);
			return 1;
		}
		
		if(arr[index] > sum) {
			return findCount(arr, index+1, sum);
		} else {
			op.add(arr[index]);
			int count1 = 1 + findCount(arr, index, sum-arr[index]);
			op.remove(op.size()-1);

			int count2 = findCount(arr, index+1, sum);
			return Math.min(count1, count2);
		}
	}
	
	public static void main(String[] args) {
		double arr[] = {1,2};
		//double arr[] = {17,10,4,0.25};
		CoinDeno_All cd = new CoinDeno_All();
		System.out.println(cd.findCount(arr, 0, 5));
	}

}
