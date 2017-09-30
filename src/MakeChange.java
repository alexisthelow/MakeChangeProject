import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//ask user for price of item
		boolean priceEntry = false;
		do {
			System.out.print("Please enter the price of the item: ");
			if (scanner.hasNextDouble()) { // check to make sure it's a double
				double price = scanner.nextDouble(); // if so, put it in the price variable
				priceEntry = true; //and set the priceFlag to true
			}
			else {
				scanner.next(); // if not, clear the scanner and tell the user they messed up
				System.out.println("You didn't enter a valid amount. Please try again.");
			}
		} while (!priceEntry); //keep going until priceFlag is true
		//ask how much money was tendered by customer
		boolean paidEntry = false;
		do {
			System.out.print("Please enter the amount tendered by the customer: ");
			if (scanner.hasNextDouble()) { // check to make sure it's a double
				double paid = scanner.nextDouble(); // if so, put it in the paid variable
				paidEntry = true; //and set the paid flag to true
			}
			else {
				scanner.next(); // if not, clear the scanner and tell the user they messed up
				System.out.println("You didn't enter a valid amount. Please try again.");
			}
		} while (!paidEntry); //keep going until priceFlag is true
		//display message if tendered was less than or equal to price
		//display number of bills and coins in change if tendered was greater than price
		scanner.close();
	}

}
