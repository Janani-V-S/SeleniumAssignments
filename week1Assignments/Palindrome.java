package week1.week1Assignments;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "madam";
		String reversed = "";
		
		//without char array
		
		 for (int i = input.length()-1; i >= 0; i--) {
			reversed = reversed + input.charAt(i);
		 }
		 System.out.println("Actual String - "+input);
		 System.out.println("Reversed String - "+reversed);
		 if (input.equals(reversed))
			 System.out.println("Result - The String is a Palindrome");
		 else
			 System.out.println("Result - The String is not a Palindrome"); 
	}

}
