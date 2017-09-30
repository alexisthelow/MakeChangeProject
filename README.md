# Make Change Project

## By Alexis Low
### 9/29/2017

First week project for Skill Distillery
Demonstrates:
* Basic Java language skills.
* Using Eclipse for project development.
* et cetera

This project reads a price an amount tendered, and prints the change due in each denomination.

from the github repo at https://github.com/SkillDistillery/SD13/tree/master/unit1/week1/makeChange

Overview

In the cash register we will calculate the amount of change returned to a customer based on the purchase price and the amount tendered. We will also notify the attendant how many of each piece of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer. Change should be provided using the largest bill and coin denominations as possible. Denominations that are not used should not be displayed.

Hint: Mod operator. also convert to pennies

User Story #1

The user is prompted asking for the price of the item.

User Story #2

The user is then prompted asking how much money was tendered by the customer.

User Story #3

Display an appropriate message if the customer provided too little money or the exact amount.

User Story #4

If the amount tendered is more than the cost of the item, display the number of bills and coins that should be given to the customer.

Grading

This is a graded project. You are expected to have your project completed by the start of class on Monday morning.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

Amount: .67, Tendered: .50, Result: Error message
Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
Amount: any amount less than 20.00, Tendered: anything greater than amount: correct denominations for correct change.

If the project does work with all of the above test conditions, you will be given a 1 for this week's project.

If the project does not work with the above test conditions, you will be given a 0 for this week's project.

If you get a zero on the project, you can upgrade to a score of .5 if you turn in a working project by the start of class on the following Monday morning AND notify an instructor that you wish to get partial credit.

To turn in a project, you must push it to GitHub. You must include a README.md that describes how to run your program.