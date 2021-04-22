package week1.week1Assignments;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 370;
		int calculated = 0;
		int reminder;
		int original;
		original = input;
		while(input>0)
		{
			reminder = input%10;
			System.out.println(reminder);
			input = input/10;
			System.out.println(input);
			calculated = calculated + (reminder*reminder*reminder);
			System.out.println(calculated);
		}
		if(calculated == original)
			System.out.println("This number is an amstrong number");
		else
			System.out.println("This number is not an amstrong number");
	}

}
