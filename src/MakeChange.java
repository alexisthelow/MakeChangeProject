import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//declare variables needed in scope
		double price = 0.0;
		double paid = 0.0;
		double change;
		
		//ask user for price of item
		boolean priceEntry = false;
		do {
			System.out.print("Please enter the price of the item: ");
			if (scanner.hasNextDouble()) { // check to make sure it's a double
				price = scanner.nextDouble(); // if so, put it in the price variable
				priceEntry = true; //and set the priceFlag to true
			}
			else {
				scanner.next(); // if not, clear the scanner and tell the user they messed up
				System.out.println("You didn't enter a valid amount. Please try again.");
			}
		} while (!priceEntry); //keep going until priceFlag is true
		//ask how much money was tendered by customer
		boolean paidEntry;
		do {
			do {
				paidEntry = false;
				System.out.print("Please enter the amount tendered by the customer: ");
				if (scanner.hasNextDouble()) { // check to make sure it's a double
					paid += scanner.nextDouble(); // if so, put it in the paid variable
					paidEntry = true; //and set the paid flag to true
				}
				else {
					scanner.next(); // if not, clear the scanner and tell the user they messed up
					System.out.println("You didn't enter a valid amount. Please try again.");
				}
			} while (!paidEntry); //keep going until priceFlag is true
			if (price > paid) {
				System.out.println(paid + " accepted. Remaining balance is " + (price - paid));
			}
		} while (price > paid); //keep going until customer has paid at least an amount equal to the price
		//display message if tendered was less than or equal to price
		//display number of bills and coins in change if tendered was greater than price
		scanner.close();
	}

}
