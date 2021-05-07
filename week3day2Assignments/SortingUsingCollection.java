package week3.week3day2Assignments;

import java.util.Arrays;

public class SortingUsingCollection {
	
	public static void main(String[] args) {
	
	//	Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)	
	String[] strArray = {"HCL","Wipro","Aspire Systems","CTS"};
	
	//	get the length of the array	
	int length = strArray.length;

	//	sort the array		
	Arrays.sort(strArray);
	
	//	Iterate it in the reverse order
	for (int i = length-1; i >= 0; i--) {
		//		print the array
		System.out.print(strArray[i]+", ");	
	}
  }
}