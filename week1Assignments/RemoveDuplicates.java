package week1.week1Assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "We learn java basics as part of java sessions in java week1";
		String[] splitText = text.split(" ");
		int count;
		int len = splitText.length;
		 for (int i = 0; i < len; i++) { 
			 count = 0;
			 for (int j = i+1; j < len; j++) { 
				 if (splitText[i].equals(splitText[j])) {
					 splitText[j] = "";	
					 count = count+1;
					 }				 
		      }
			 if(count>0){
				 splitText[i] = "";
		      }
			 
	    }
		 System.out.print("Output string - ");
		 for (int i = 0; i < len; i++) {
			 System.out.print(splitText[i]+" ");
		     }
		 }
}
