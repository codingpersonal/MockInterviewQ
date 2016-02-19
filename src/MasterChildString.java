/*There is a master string abcdefghi and there is a child string.
 * Find if child string is a sub sequence of master string or not.
 * means child string afhi can be formed from master with characters coming in the same increasing seq.*/
public class MasterChildString {
	
	public boolean isExists(String master, String slave) {
		if(slave.length() < 1) {
			return true;
		}
		
		int indexFound = -1;
		char currChar = slave.charAt(0);
		boolean flag = false;
		for(int j = 0; j < master.length(); j++) {
			if(master.charAt(j) == currChar) {
				indexFound = j;
				flag = true;
				break;
			}
		}
		
		return flag && isExists(master.substring(indexFound, master.length()), slave.substring(1,slave.length()));
	}

	int findCharInString(String str, int index, char c) {
		for(int j = index; j < str.length(); j++) {
			if(str.charAt(j) == c)
				return j;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String master = "loaooervveerov";
		String child = "love";
		int index = -1;
		boolean flag = true;
		MasterChildString m = new MasterChildString();
		
		for(int i=0; i < child.length(); i++) {
			index = m.findCharInString(master, index+1, child.charAt(i));
			if(index == -1) {
				System.out.println("Its not possible.");
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("Possible sub sequence is there.");
		}
		
		System.out.println(m.isExists(master, child));
	}

}
