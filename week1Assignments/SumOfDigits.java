package week1.week1Assignments;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 555;
		int sum = 0;
		int rem = 0;
		while(num>0)
		{
			rem = num%10;
			//System.out.println("Reminder is "+rem);
			sum = sum+rem;
			//System.out.println("Sum is "+sum);
			num = num/10;
			//System.out.println("Quotient is "+num);
		}
		System.out.println("The sum of digits is "+sum);
	}

}
