package org.bank;

public class AxisBank extends BankInfo{
	public void deposit() {
		System.out.println("Deposit - AxisBank Class");
	}
	public static void main(String[] args) {
		AxisBank obj = new AxisBank();
		obj.deposit();
		
	}

}
