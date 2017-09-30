import java.util.Scanner;
import java.text.DecimalFormat;

public class MakeChange {
	public static DecimalFormat money = new DecimalFormat("$0.00");
//TODO add transaction repeat
//TODO accept only two decimal places in tender and price
//TODO truncate display of decimal places if paid < price
//TODO add 100's and 50's + remind user to mark w/ counterfeit pen
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//declare variables needed in scope
		double price = 0.0;
		double paid = 0.0;
		double tendered = 0.0;
		
		//ask user for price of item
		char again;
		boolean againIsValidEntry;
		do {
			again = '0';
			againIsValidEntry = false;
			boolean priceEntry = false;
			do {
				System.out.print("Please enter the price of the item: ");
				if (scanner.hasNextDouble()) { // check to make sure it's a double
					price = scanner.nextDouble(); // if so, put it in the price variable
					priceEntry = true; //and set the priceFlag to true
					if (!decimalCheck(price)) { //check to see if the entry is longer than expected
						System.out.println("Invalid entry. " + price + " has too many decimal places.");
						priceEntry = false; //return false if so and tell user
					}
				}
				else {
					scanner.next(); // if not, clear the scanner and tell the user they messed up
					System.out.println("You didn't enter a number. Please try again.");
				}
			} while (!priceEntry); //keep going until priceFlag is true
			System.out.println(money.format(price) + " due.");
			//ask how much money was tendered by customer
			boolean paidEntry;
			do {
				do {
					paidEntry = false;
					System.out.print("Please enter the amount tendered by the customer: ");
					if (scanner.hasNextDouble()) { // check to make sure it's a double
						tendered = scanner.nextDouble(); // if so, put it in the tendered variable
						paidEntry = true; //and set the paid flag to true
						if (!decimalCheck(tendered)) { //check to see if tendered is longer than expected
							System.out.println("Invalid entry. " + tendered + " has too many decimal places.");
							paidEntry = false; //set paid flag to false and tell user
						}
						else {
							paid += tendered; //add tendered to paid
						}
					}
					else {
						scanner.next(); // if not, clear the scanner and tell the user they messed up
						System.out.println("You didn't enter a valid amount. Please try again.");
					}
				} while (!paidEntry); //keep going until priceFlag is true
				if (price >= paid) {//if they didn't pay enough, say so
					System.out.println(money.format(paid) + " accepted. Remaining balance is " + money.format((price - paid)) + "."); //display message if not enough or exact amount tendered.
				} else {//otherwise, display the change due
					int changeDue = ((int)((paid * 100) - (price * 100))); //figure out the change due in pennies
					System.out.println((money.format(((double)(changeDue)) * 0.01)) + " due in change.");
					findChange(changeDue);
				}
			} while (price > paid); //keep going until customer has paid at least an amount equal to the price
			System.out.print("Start a new transaction? (y/n): ");
			
			do {
				if (scanner.hasNext()) {
					again = scanner.next().charAt(0);
				}
				if (again != 'Y' && again != 'y' && again != 'N' && again != 'n') {
					System.out.println("Invalid entry. Please try again.");
					scanner.next(); //clear scanner
					againIsValidEntry = false;//set flag to false
				}
				else {
					againIsValidEntry = true;
				}
			} while(!againIsValidEntry);
		} while (again == 'y' || again == 'Y');
		scanner.close();
	}
	
	public static boolean decimalCheck(Double number) {//checks a double to see if there are too many decimals, returns false if so
		String numberString = number.toString(); //gets the string of number, puts in numberString
		int decimalIndex = numberString.indexOf("."); //finds the index of the first decimal place
		if (numberString.substring(decimalIndex).length() > 3) { //checks to see if the string has more than three indices starting at the decimal to the end of the string
			return false; //returns false if so
		}
		return true;
	}
	
	public static void findChange(int changeDue) { //takes amount of change due in pennies and displays change due in each denomination
		//display number of bills and coins in change if tendered was greater than price
		System.out.println("Please give the customer: ");
		//100's
		if ((changeDue / 10000) > 0) {
			System.out.print((changeDue / 10000) + " 100 dollar bill");
			if ((changeDue / 10000) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 10000;
		}
		// 50's
		if ((changeDue / 5000) > 0) {
			System.out.print((changeDue / 5000) + " 50 dollar bill");
			if ((changeDue / 5000) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 5000;
		}
		//20's
		if ((changeDue / 2000) > 0) {
			System.out.print((changeDue / 2000) + " 20 dollar bill");
			if ((changeDue / 2000) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 2000;
		}
		//10's
		if ((changeDue / 1000) > 0) {
			System.out.print((changeDue / 1000) + " 10 dollar bill");
			if ((changeDue / 1000) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 1000;
		}
		//5's
		if ((changeDue / 500) > 0) {
			System.out.print((changeDue / 500) + " 5 dollar bill");
			if ((changeDue / 500) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 500;
		}
		//1's
		if ((changeDue / 100) > 0) {
			System.out.print((changeDue / 100) + " 1 dollar bill");
			if ((changeDue / 100) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 100;
		}
		//.25's
		if ((changeDue / 25) > 0) {
			System.out.print((changeDue / 25) + " quarter");
			if ((changeDue / 25) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 25;
		}
		//.10's
		if ((changeDue / 10) > 0) {
			System.out.print((changeDue / 10) + " dime");
			if ((changeDue / 10) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 10;
		}
		//.05's
		if ((changeDue / 5) > 0) {
			System.out.print((changeDue / 5) + " nickel");
			if ((changeDue / 5) > 1) {
				System.out.print("s");
			}
			System.out.println();
			changeDue = changeDue % 5;
		}
		//.01's
		if ((changeDue / 1) > 0) {
			System.out.print((changeDue / 1) + " penn");
			if ((changeDue / 1) > 1) {
				System.out.println("ies");
			}
			else {
				System.out.println("y");
			}
			changeDue = changeDue % 1;
		}
	}
}
