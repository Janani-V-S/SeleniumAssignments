package week1.week1Assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int range = 8;
		int firstNum = 0;
		int secNum = 1;
		int sum;
		System.out.print(firstNum+" ");
		System.out.print(secNum+" ");
		for (int i = 1; i <= range; i++) {
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
			System.out.print(sum+" ");
		}
	}

}
