package BitManipulation;

public class PowerOf2 {

	public static void main(String[] args) {
		int num = 64;
		if((num & num-1) == 0)
			System.out.println("Yes");
		else
			System.out.println("No.");
	}

}
