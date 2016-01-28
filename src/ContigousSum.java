
public class ContigousSum {

	public boolean isContigousSum(int arr[], int ip_sum){
		int p1 = 0 , p2 = 0;
		int sum = 0;
		while(p1 >= p2){
			if(sum == ip_sum) {
				return true;
			}
			else if(sum < ip_sum) {
				if(p1 <= arr.length-1) {
					sum = sum + arr[p1];
					p1++;
				} else {
					return false;
				}
			}
			else {
				if(p2 <= arr.length-1) {
					sum = sum - arr[p2];
					p2++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,7,9,10,20};
		ContigousSum c = new ContigousSum();
		if(c.isContigousSum(arr, 33)) {
			System.out.println("Contigous sum digits are present.");
		} else{
			System.out.println("Contigous sum digits are not present.");
		}
	}

}
