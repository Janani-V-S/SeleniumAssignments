package week1.week1Assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "changeme";
		char[] charArray = test.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(i%2 == 1)
			{
				String str1 = ""+charArray[i];
				String str2 = str1.toUpperCase();
				System.out.print(str2);
			}
			else
				System.out.print(charArray[i]);
		}		
	}
}
