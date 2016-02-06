
public class RegexMatch {

	public static void main(String[] args) {
		String input = "somyagarwala";
		String regex = "somya.arw?ala";
		
		input = input.toLowerCase();
		int id = 0;
		int id1 = 0;
		while(id <= input.length()-1 && id1 <= regex.length()-1) {
			char curr_regex = regex.charAt(id1);
			char curr_input = input.charAt(id);
			
			//if curr character is alphabet, then it should match with string
			if(curr_regex >= 'a' && curr_regex <= 'z') {
				if(curr_input != curr_regex) {
					System.out.println("Not possible.");
					return;
				} else {
					id++;
					id1++;
				}
			}
			
			//the curr regex is something else, ? . *
			else {
				switch(curr_regex) {
				
				// the char is a . so exactly one match at this place.
				case '.' : //do nothing, let the next iteration increment
					//assuming this character will be same as in the input string
					id++;
					id1++;
					break;
					
				case '*' :
					break;
				
				//so either one or no character can match.
				case '?' :
					boolean match1 = false;
					boolean match2 = false;
					
					// if zero characters are placed for ?
					char next_regex_char = regex.charAt(id1+1);
					if(curr_input == next_regex_char) {
						match1 = true;
						id1++;
					} 
					
					//if one character is placed for ?
					char next_input_char = input.charAt(id+1);
					if(next_input_char == next_regex_char) {
						match2 = true;
						id++;
						id1++;
					}
					
					//assuming that only one of them will be true.
					//else there will be many many cases.
					if(match1 || match2) {
						//fine.
					} else {
						System.out.println("Not found.");
						break;
					}
					break;
				}
			}
		}
	}

}
