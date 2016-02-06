package BitManipulation;

public class Count1s {
/*1011 ,so and this with 0001, always 1. if the rhs digit is 1, then output will come out to be 1 else 0.
 * so u can check for one digit, rhs. now shift the number to the right.
 * 0101, now you can check for digit second from the right. keep on doing this until number = 0*/
	public static void main(String[] args) {
		int i = 11;
		int count = 0;
		
		while(i != 0) {
			if((i & 1) == 1) 
				count++;
			i = i>>1;
		}
		System.out.println(count);
			
	}

}
