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
			if (price >= paid) {//if they didn't pay enough, say so
				System.out.println(paid + " accepted. Remaining balance is " + (price - paid) + "."); //display message if not enough or exact amount tendered.
			} else {//otherwise, display the change due
				int changeDue = ((int)((paid * 100) - (price * 100))); //figure out the change due in pennies
				System.out.println((double)(changeDue * 0.01) + " due in change.");
				findChange(changeDue);
			}
		} while (price > paid); //keep going until customer has paid at least an amount equal to the price
		
		scanner.close();
	}
	
	public static void findChange(int changeDue) {
		//display number of bills and coins in change if tendered was greater than price
		System.out.println("Please give the customer: ");
		//20's
		if ((changeDue / 2000) > 0) {
			System.out.println((changeDue / 2000) + " 20 dollar bills ");
			changeDue = changeDue % 2000;
		}
		//10's
		if ((changeDue / 1000) > 0) {
			System.out.println((changeDue / 1000) + " 10 dollar bills ");
			changeDue = changeDue % 1000;
		}
		//5's
		if ((changeDue / 500) > 0) {
			System.out.println((changeDue / 500) + " 5 dollar bills ");
			changeDue = changeDue % 500;
		}
		//1's
		if ((changeDue / 100) > 0) {
			System.out.println((changeDue / 100) + " 1 dollar bills ");
			changeDue = changeDue % 100;
		}
		//.25's
		if ((changeDue / 25) > 0) {
			System.out.println((changeDue / 25) + " quarters ");
			changeDue = changeDue % 25;
		}
		//.10's
		if ((changeDue / 10) > 0) {
			System.out.println((changeDue / 10) + " dimes ");
			changeDue = changeDue % 10;
		}
		//.05's
		if ((changeDue / 5) > 0) {
			System.out.println((changeDue / 5) + " nickels ");
			changeDue = changeDue % 5;
		}
		//.01's
		if ((changeDue / 1) > 0) {
			System.out.println((changeDue / 1) + " pennies ");
			changeDue = changeDue % 2000;
		}
	}
}
