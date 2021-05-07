package week3.week3day2Assignments;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOccurance {

	public static void main(String[] args) {
		
		//1. Create a String with your name as value
		String text = "welcome to Selenium automation";
		
		//2. Convert the string into a char array
		char[] charArray = text.toCharArray();
		
		//3. Create an empty Map<Character,Integer>
		Map<Character,Integer> charMap = new LinkedHashMap<Character,Integer>();
		
		//4. Iterate over the array
		for (int i = 0; i < charArray.length; i++) {
			
			//5. Check whether the Map contains the Character
			if(charMap.containsKey(charArray[i])) {
			//6. If it contains then increment the key (+1)	
			int value = charMap.get(charArray[i]);
			int newValue = value+1;
			charMap.put(charArray[i],newValue);
			}
			
			else
			{
				//7. Add the character in the map & set the value as 1
				charMap.put(charArray[i], 1);
			}
		}	
		
		//8. Print the Map
		System.out.println(charMap);
	}

}
