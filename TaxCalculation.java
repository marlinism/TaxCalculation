
public class TaxCalculation {

	private double income;

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


	public static double getTaxCalculation(double income) {
		return calculation(income);
	}

	public static double getEffectiveRate(double income) {
		return effectiveRate(income);
	}
}
