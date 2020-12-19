import java.util.Scanner;

public class App {
	
	//a method to check if the client want to keep using the program
	public static boolean calculateAgain(Scanner input) {
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
