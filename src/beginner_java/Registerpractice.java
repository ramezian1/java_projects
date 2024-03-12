package beginner_java;

import java.util.Scanner;

public class Registerpractice {
	public static void main (String [] args) {
		
		System.out.println("Please enter your total amount and press Enter when finished: ");
		Scanner input = new Scanner(System.in);
		
		double value = input.nextDouble();
		
		int valueIntegral = (int) value;
		int valueFractional = (int) Math.round(100 * value - 100 * valueIntegral);
		
		//ValueIntegrals (Whole Dollars)
		int hundred = valueIntegral / 100;
		int fifty = (valueIntegral % 100) / 50;
		int twenty = ((valueIntegral % 100) % 50) / 20;
		int ten = (((valueIntegral % 100) % 50) % 20) / 10; 
		int five = ((((valueIntegral % 100) % 50) % 20) % 10) / 5;
		int one = (((((valueIntegral % 100) % 50) % 20) % 10) % 5) / 1;
		
		//Fractional Values
		int quarter = valueFractional / 25;
		int dime = (valueFractional % 25) / 10;
		int nickel = ((valueFractional % 25) % 10) / 5;
		int penny = (((((valueFractional % 100) % 50) % 20) % 10) % 5) / 1;
		
		System.out.println("\nThank you: your total amount in bills and cents comes out to the folowing: ");
		System.out.println();
		
		System.out.println("Dollar Change:");
		System.out.println();
		System.out.println(hundred + " Hundred Dollar Bills ");
		System.out.println(fifty + " Fifty Dollar Bills");
		System.out.println(twenty + " Twenty Dollar Bills");
		System.out.println(ten + " Ten Dollar Bills");
		System.out.println(five + " Five Dollar Bills");
		System.out.println(one + " One Dollar Bills");
		
		System.out.println("--------------------------------");
		
		System.out.println("Cents: ");
		System.out.println();
		System.out.println (quarter + " Quarters");
		System.out.println (dime + " Dimes");
		System.out.println (nickel + " Nickels");
		System.out.println (penny +  " Pennies");
		
		input.close();
		

	}
	

}