package Assignment6;

import java.util.Scanner;

public class BevShopDriverApp {
	static Scanner in = new Scanner(System.in);
	static Day day;
	static BevShop shop = new BevShop();
	
	//************************************//
	
	public static void greeting() {
		String name;
		int age,time, dayInt;
		System.out.println("*".repeat(10)+"Welcome to our store program!"+"*".repeat(10));
		System.out.println("Please Enter Your name: ");
		name = in.nextLine();
		System.out.println("Please enter your age: ");
		age = in.nextInt();
		System.out.println("Please enter the time of day: ");
		time = in.nextInt();
		while(!shop.isValidTime(time)) {
			System.out.println("Enter a correct time!");
			time = in.nextInt();
		}
		System.out.println("Please enter the day of the week by its number: \n1) Monday"
				+"\n2) Tuesday"
				+"\n3) Wedensday"
				+"\n4) Thursday"
				+"\n5) Friday"
				+"\n6) Saturday"
				+"\n7) Sunday");
		dayInt = in.nextInt()-1;
		while(dayInt < 0 || dayInt > 6) {
			System.out.println("Invalid day! Please re-enter: ");
			dayInt = in.nextInt();
		}
		day = Day.values()[dayInt];
		shop.startNewOrder(time, day, name, age);
	}

	//************************************//
	
	public static void alcohol() {
		String name;
		Size size = null;
		boolean isWeekend = false;
		int sizeInt;
		if(day.equals(Day.SATURDAY) || day.equals(Day.SUNDAY)) {
			isWeekend =true;
		}
		System.out.println("Please Enter your beverage name: ");
		name = in.nextLine();
		System.out.println("Enter the size of your drink by its number: "
				+ "\n1) small"
				+ "\n2) medium"
				+ "\n3) large");
		sizeInt = in.nextInt()-1;
		while(sizeInt < 0 || sizeInt > 2) {
			System.out.println("Invalid size! Please re-enter: ");
			sizeInt = in.nextInt();
		}
		size = Size.values()[sizeInt];
		in.nextLine();
		shop.processAlcoholOrder(name, size);
	}
	
	//************************************//
	
	public static void coffee() {
		String name;
		Size size = null;
		int sizeInt;
		boolean exShot = false, exSyrup = false;
		System.out.println("Please Enter your beverage name: ");
		name = in.nextLine();
		System.out.println("Enter the size of your drink by its number: "
				+ "\n1) small"
				+ "\n2) medium"
				+ "\n3) large");
		sizeInt = in.nextInt()-1;
		while(sizeInt < 0 || sizeInt > 2) {
			System.out.println("Invalid size! Please re-enter: ");
			sizeInt = in.nextInt();
		}
		size = Size.values()[sizeInt];
		System.out.println("Please enter 1 if you have an extra shot: ");
		if(in.nextInt() == 1) {
			exShot = true;
		}
		System.out.println("Please enter 1 if you have extra syrup: ");
		if(in.nextInt() == 1) {
			exSyrup = true;
		}
		in.nextLine();
		shop.processCoffeeOrder(name, size, exShot, exSyrup);
	}
	
	//************************************//
	
	public static void smoothie() {
		String name;
		Size size = null;
		int numOfFruits, sizeInt;
		boolean protein = false;
		System.out.println("Please Enter your beverage name: ");
		name = in.nextLine();
		System.out.println("Enter the size of your drink by its number: "
				+ "\n1) small"
				+ "\n2) medium"
				+ "\n3) large");
		sizeInt = in.nextInt()-1;
		while(sizeInt < 0 || sizeInt > 2) {
			System.out.println("Invalid size! Please re-enter: ");
			sizeInt = in.nextInt();
		}
		size = Size.values()[sizeInt];
		System.out.println("Enter the amount of fruits in your drink: ");
		numOfFruits = in.nextInt();
		while(shop.isMaxFruit(numOfFruits)) {
			System.out.println("You have enetered too many fruits! Enter a correct amount: ");
			numOfFruits = in.nextInt();
		}
		System.out.println("Please enter 1 if you added protein:");
		if(in.nextInt() == 1) {
			protein = true;
		}
		in.nextLine();
		shop.processSmoothieOrder(name, size, numOfFruits, protein);
	}
	
	//************************************//
	
	public static void orderUp() {
		String sent = "";
		do {
			int drink;
			System.out.println("Please select the type of beverage you will be having today "
					+ "by entering the associated number!"
					+ "\n1) Coffee"
					+ "\n2) Smoothie"
					+ "\n3) Alcohol");
			drink = in.nextInt();
			in.nextLine();
			switch(drink) {
				case 1:
				{
					coffee();
					break;
				}
				case 2:
				{
					smoothie();
					break;
				}
				case 3:
				{
					if(!shop.isValidAge(shop.getCurrentOrder().getCustomer().getAge())) {
						System.out.println("You are not allowed alcohol!");
						return;
					}
					if(!shop.isEligibleForMore()) {
						System.out.println("You are not eligible for more alcoholic drinks!");
						return;
					}
					alcohol();
					break;
				}
				default:
				{
					System.out.println("You have entered an incorrect type of beverage!");
					return;
				}
			}
			System.out.println("Press enter to add another drink, or type quit to finish your order!");
			sent = in.nextLine();
		}while(!sent.toLowerCase().equals("quit"));
	}
	
	//************************************//
	
	public static void main(String[] args) {	
			String end = "";
			int funds;
			double cost;
			do {
				greeting();
				orderUp();
				cost = shop.getCurrentOrder().calcOrderTotal();
				System.out.println("Your total for your order is: $"+cost+
						"\nPlease enter your funds now: ");
				funds = in.nextInt();
				while(funds < cost) {
					System.out.println("You have entered an incorrect number of funds! Enter a correct number: ");
					funds = in.nextInt();
				}
				if(funds > cost) {
					System.out.println("Please accept your change: \n$"+(funds-cost));
				}
				System.out.println("thank you for shopping with us."
						+ "\nIf you would like to place another order, press any key,"
						+ "\notherwise, type quit to end the program.");
				in.nextLine();
				end = in.nextLine();
			}while(!end.toLowerCase().equals("quit"));
			System.out.println("*".repeat(10)+"End of store program"+"*".repeat(10));
	}
	
}

