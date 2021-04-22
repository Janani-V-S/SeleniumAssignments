package week1.week1Assignments;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Tes12Le79af65";
		int sum = 0;
		int temp;
		char[] charArray = text.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			temp = 0;
			if(Character.isDigit(charArray[i])) {
				temp = Character.getNumericValue(charArray[i]);
				sum = sum+temp;
			}	
		}
		System.out.println("The sum of digits from the given string is "+sum);
	}
}
