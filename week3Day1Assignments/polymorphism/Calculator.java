package week3Day1Assignments.polymorphism;

public class Calculator {
	public void add(int a,int b)
	{
		System.out.println("Add method with 2 arguments");
	}
	public void add(int a,int b,int c)
	{
		System.out.println("Add method with 3 arguments");
	}
	public void multiply(int a,int b)
	{
		System.out.println("Multiply method with 2 arguments");
	}
	public void multiply(int a,double b)
	{
		System.out.println("Multiply method with 2 arguments - Int and double");
	}
	public void subtract(int a,int b)
	{
		System.out.println("Subtract method with 2 arguments");
	}
	public void subtract(int a,double b)
	{
		System.out.println("Subtract method with 2 arguments - Int and double");
	}
	public void divide(int a,int b)
	{
		System.out.println("Divide method with 2 arguments");
	}
	public void divide(int a,double b)
	{
		System.out.println("Divide method with 2 arguments - Int and double");
	}
	
	public static void main(String[] args) {
		Calculator obj = new Calculator();
		obj.add(2, 2);
		obj.add(2, 2, 2);
		obj.multiply(4, 4);
		obj.multiply(4, 4.556633);
		obj.subtract(4, 4);
		obj.subtract(4, 4.556633);
		obj.divide(4, 4);
		obj.divide(4, 4.556633);
	}
	
	
	
}
