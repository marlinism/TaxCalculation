import java.util.Scanner;

public class ClientTaxCalculation {

	public static void main(String[] args) {
		boolean mode = false;
		
		TaxCalculation first = new TaxCalculation();
		
		//header of the project
		first.getName();
		first.getNote();
		
		do {
			//ask for the income 
			System.out.println("--------------------------------");
			System.out.println("How much is your income?");
			System.out.print("$ ");
			Scanner input = new Scanner(System.in);
			double income = input.nextDouble();
			first.setIncome(income);
			
			//calculate tax 
			first.getTaxCalculation(income);
			first.getEffectiveRate(income);
		
			//ask if they wanna calculate more
			mode = first.calculateAgain(input);
		} while(mode);

	}
}
