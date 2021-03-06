
public class TaxCalculation extends App{
	
	private double income;
	
   //post: get name of the program
	public void getName() {
		System.out.println("\tTAX SERVICE");
	}
	
   //post: get note
	public void getNote() {
		System.out.println("Caution: This calculation is only correct when the tax payer is single");
	}
	
	public TaxCalculation() {
		this(0);
	}
	
	public TaxCalculation(double incomeInput) {
		setIncome(incomeInput);
	}
   
	//post: set income and also check
	public void setIncome(double incomeInput) {
      if(incomeInput < 0) {
    	  throw new IllegalArgumentException();
      }
      else {
		   this.income = incomeInput;
      }
	}
	
   //post: get the income
	public double getIncome() {
		return this.income;
	}
	
   //pre: client's income
   //post: the amount of tax have to pay
	private static double calculation(double income) {
		double result = 0.0;
		double[] rate = {0.1, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};
		double[] limit = {9875, 40125, 85525, 163300, 207350, 51840};
		int i = 0;
		while(income > 0) {
			if(income >= limit[i]) {
				result += limit[i]*rate[i];
				income -= limit[i];
				i++;
			}
			else { 
				result += income*rate[i];
				income -= limit[i];
			}
		}
		return result;
	}
	
   //pre: client's income
   //post: the amount of effective rate have to pay
	private static double effectiveRate(double income) {
		double rate = 0.0;
		rate = calculation(income)/income *100;
		return rate;
	}
	
   
	public static void getTaxCalculation(double income) {
		System.out.println("\nThe amount of tax you need to pay is: $ " + calculation(income));
	}
	
	public static void getEffectiveRate(double income) {
		System.out.printf("The effective rate is: %.2f",effectiveRate(income));
		System.out.println("%\n--------------------------------");
	}
}
