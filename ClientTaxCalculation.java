import java.util.Scanner;

public class ClientTaxCalculation {

	public static void main(String[] args) {
		boolean mode = false;
		
		//header of the project
		System.out.println("\tTAX SERVICE");	
		System.out.println("Caution: This calculation is only correct when the tax payer is single");
		
		do {
			//ask for the income 
			System.out.println("--------------------------------");
			System.out.println("How much is your income?");
			System.out.print("$ ");
			Scanner input = new Scanner(System.in);
			double income = input.nextDouble();
			TaxCalculation first = new TaxCalculation(income);
			
			//calculate tax 
			first.getTaxCalculation(income);
			first.getEffectiveRate(income);
		
			//ask if they wanna calculate more
			mode = calculateAgain(input);
		} while(mode);

	}
	
   //a method to check if the client want to keep using the program
	private static boolean calculateAgain(Scanner input) {
		boolean mode = false;
		boolean check = false;
		do {
			System.out.println("Do you want to continue?");
			String answer = input.next();
			answer = answer.toUpperCase();
			
			if(answer.equals("YES")) {
				mode = true;
				check = true;
			}
			
			else if(answer.equals("NO")) {
				mode = false;
				check = true;
				System.out.println("Thank you for using!");
			}
			
			else {
				mode = false;
				check = false;
				System.out.println("The valid answer is: 1.\"Yes\" 2.\"No\"");
			}
		} while (!check);
			System.out.println();
			return mode;
	}

}
