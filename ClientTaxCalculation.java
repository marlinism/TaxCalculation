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
			mode = first.calculateAgain(input);
		} while(mode);

	}
}
