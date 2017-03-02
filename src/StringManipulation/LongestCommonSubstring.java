/*What is the longest common substring from two strings.
 * ssomya
 * somya*/
package StringManipulation;

public class LongestCommonSubstring {
	//question is about max substring from both, there can be multiple instances.
	//max len will keep a count in that case.
	static int  maxLen = 0;

	// count is the max substring till this char assuming all previous char to this char is matched
	// it returns the max common substring found from this index
	public static int commonSubStr(String str1, String str2, int index1, int index2, int count) {
		if(index1 >= str1.length() || index2 >= str2.length()) {
			return count;
		}

		if(str1.charAt(index1) == str2.charAt(index2)) {
			int v1 = commonSubStr(str1, str2, index1+1, index2+1, count+1);
			int v2 = commonSubStr(str1, str2, index1+1, index2+1, 0);
			int v3 = commonSubStr(str1, str2, index1+1, index2, 0);
			int v4 = commonSubStr(str1, str2, index1, index2 + 1, 0);
			return Math.max(Math.max(v3, v4), Math.max(v1, v2));

		} else {
			// current char doesnn't match
			maxLen = Math.max(maxLen, count);
			return Math.max(commonSubStr(str1, str2, index1+1, index2+1,0),
					Math.max(commonSubStr(str1, str2, index1, index2+1, 0), 
							commonSubStr(str1, str2, index1+1, index2, 0)));
		}
		
	}
	
	public static void main(String[] args) {
		int ret = commonSubStr("ssomyab", "vssomyaa", 0, 0, 0);
		System.out.println(Math.max(maxLen,ret));
	}
}
