package week3.week3day2Assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//		Declare a String as PayPal India
		String text = "PayPal India";
		
		//		Convert it into a character array
		char[] charArray = text.toCharArray();
		
		//		Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<Character>();
		
		//		Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		
		//		Iterate character array and add it into charSet
		for (int i = 0; i < charArray.length; i++) {
			if(charSet.contains(charArray[i])) {
				
       //		If the character is already in the charSet then, add it to the dupCharSet
				dupCharSet.add(charArray[i]);
			}
			else {
				charSet.add(charArray[i]);
			}
			
		}
		List<Character> temp = new ArrayList<Character>(charSet);
		
		//		Check the dupCharSet elements and remove those in the charSet
		for (int i = 0; i <= dupCharSet.size(); i++) {
			if(dupCharSet.contains(temp.get(i))){
				dupCharSet.remove(temp.get(i));
			}
			
		}
		//		Iterate using charSet
		for (int i = 0; i < charSet.size(); i++) {
		//		Check the iterator variable isn't equals to an empty space
			if(temp.get(i) != ' ') {
				
		//		print each character for charSet
				System.out.print(temp.get(i));
			}
		}
		
	}

}
