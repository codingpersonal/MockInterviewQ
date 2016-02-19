
public class Palindrome {
	public static void isPalindrome(String inp) {
		int beg = 0;
		int end = inp.length()-1;
		boolean flag = true;
		
		while(beg <= end) {
			if(inp.charAt(beg) == inp.charAt(end)) {
				beg++;
				end--;
			} else {
				System.out.println("Not a palindrome.");
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("string is a palindrome.");
	}
	
	public static boolean isPalindrome_rec(String inp) {
	
		if(inp.length() <= 1) 
			return true;
		
		if(inp.charAt(0) == inp.charAt(inp.length()-1)) {
			return isPalindrome_rec(inp.substring(1, inp.length()-1));
		} else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome_rec("nomyymon"));
	}

}
