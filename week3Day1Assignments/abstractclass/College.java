package week3Day1Assignments.abstractclass;

public class College extends University{

	@Override
	public void ug() {
		// TODO Auto-generated method stub
		System.out.println("UG Method");
	}
	public static void main(String[] args) {
		College obj = new College();
		obj.pg();
		obj.ug();
	}
	
	}
