package BitManipulation;

public class PowerOf2 {
/*1000 = 8 and 0111 = 7, so on doing & operation, all 0 should come.
 * else number is not power of 2.*/
	public static void main(String[] args) {
		int num = 64;
		if((num & num-1) == 0)
			System.out.println("Yes");
		else
			System.out.println("No.");
	}

}
