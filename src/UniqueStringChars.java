/*Determine if a string has all unique character- true or false
 * if false then find out which characters repeat and which are unique
 * no of repeating occurences for the characters.*/

public class UniqueStringChars {

	int str[] = new int[125];

	public boolean checkIfUnique(String input) {
		boolean flag = true;
		for (int i = 0; i < input.length(); i++) {
			int id = input.charAt(i);
			if (str[id] >= 1) {
				str[id] = str[id] + 1;
				flag = false;
			} else {
				str[id] = 1;
			}
		}
		return flag;
	}

	public void printNonUnique(String str) {
		// simply print the array elements with more than one occurence.
	}

	public void removeDup(String input) {
		char[] charArray = input.toCharArray();
		int size = charArray.length;
		for (int i = 0; i < size ; i++) {
			int id = charArray[i];
			if (str[id] >= 1) {
				//shift all the characters ahead.
				for(int j = i; j < charArray.length-1; j++) {
					charArray[j] = charArray[j+1];
				}
				charArray[charArray.length-1] = ' ';
				i--;
				size--;
			} else {
				str[id] = 1;
			}
		}
		System.out.println(charArray);
	}

	public static void main(String[] args) {
		UniqueStringChars u = new UniqueStringChars();
		u.removeDup("somyaaggarwal");
	}

}
