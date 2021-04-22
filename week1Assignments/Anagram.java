package week1.week1Assignments;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "stops";
		String text2 = "potss";
		boolean isAnagram = false;
		if(text1.length() == text2.length())
		{
				char[] charArray1 = new char[text1.length()];
				charArray1 = text1.toCharArray();
				Arrays.sort(charArray1);
				char[] charArray2 = new char[text2.length()];
				charArray2 = text2.toCharArray();
				Arrays.sort(charArray2);
				for (int i = 0; i < charArray1.length; i++) {
				if(charArray1[i]==charArray2[i]) 
				{
					isAnagram = true;
				}
				else {
				isAnagram = false;
				break;
				}
				}
				if(isAnagram)
				System.out.println("The given strings are anagram");	
				else
				System.out.println("The given strings are not anagram");
		}
		else
		{
			System.out.println("The given strings are not anagram");
		}
	}
}
