package week1.week1Assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
		String[] splitText = test.split(" ");
		int len = splitText.length;
		 for (int i = 0; i < len; i++) { 
			 if(i%2 == 1) {
				 char[] charArray = splitText[i].toCharArray();
				 for (int j = charArray.length - 1; j >=0 ; j--) {
					System.out.print(charArray[j]);
				}
				 System.out.print(" "); 
			}
			 else {
				 for (int j = 0; j < splitText[i].length(); j++) {
					 char[] charArray = splitText[i].toCharArray();
					 System.out.print(charArray[j]);
				} System.out.print(" "); 
			 }
			  
		 }
	}
}
