package Assignment2;

import java.util.Scanner;

public class PatientDriverApp {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Patient p1 = new Patient(); // NO ARG CONSTRUCTOR USED FOR THIS OBJECT, WILL BE USED WITH SETPATIENTINFO METHOD
		
		Procedure pro1 = new Procedure(); // THREE PROCEDURE OBJECTS TO FULFILL THE THREE PROCEDURES PERFORMED, INFO IS SET WITH SETPROCEDURE INFO
		Procedure pro2 = new Procedure();
		Procedure pro3 = new Procedure();
		
		setPatientInfo(p1);
		
		setProcedureInfo(pro1);
		setProcedureInfo(pro2);
		setProcedureInfo(pro3);
		
		displayPatient(p1);
		
		displayProcedure(pro1);
		displayProcedure(pro2);
		displayProcedure(pro3);
		
		System.out.println(calculateTotalCharges(pro1, pro2, pro3));
		
		
		
		
		
		System.out.println("This program was developed by a Student: Jonathan Vassell, 09/25/2024");
	}
	
	//************************************//
	
	public static void displayPatient(Patient n) { // METHOD TO DISPLAY ALL PATIENT INFORMATION
		System.out.println("\n"+n.toString());
	}
	public static void displayProcedure(Procedure n) { // METHOD TO DISPLAY ALL PROCEDURE INFORMATION
		System.out.println("\n"+n.toString());
	}
	public static String calculateTotalCharges(Procedure one, Procedure two, Procedure three) { // METHOD TO DISPLAY TOTAL COST OF PROCEDURES
		double total = one.getCost()+two.getCost()+three.getCost();
		return ("\nTotal Charges: $"+total);
	}
	
	//************************************//
	
	public static void setPatientInfo(Patient p) { // METHOD TO OBTAIN INFO FOR PATIENT 
		
		System.out.println("*********************\nPatient Information\n*********************");
		System.out.println("Patient's first name: ");
		p.setFname(in.nextLine());
		
		System.out.println("Patient's middle name: ");
		p.setMname(in.nextLine());
		
		System.out.println("Patient's last name: ");
		p.setLname(in.nextLine());
		
		System.out.println("Patient's street address: ");
		p.setStreet(in.nextLine());
		
		System.out.println("Patient's city: ");
		p.setCity(in.nextLine());
		
		System.out.println("Patient's state: ");
		p.setState(in.nextLine());
		
		System.out.println("Patient's zip: ");
		p.setZip(in.nextInt());
		
		System.out.println("Patient's phone number: ");
		in.nextLine();
		p.setPhoneNum(in.nextLine());
		
		System.out.println("Emergency Contact's name: ");
		p.setEmergName(in.nextLine());
		
		System.out.println("Emergency Contact's phone number: ");
		p.setEmergPhoneNum(in.nextLine());
	}
	
	public static void setProcedureInfo(Procedure p) { // METHOD TO OBTAIN INFORMATION FOR PROCEDURES DONE
		
		System.out.println("*********************\nProcedure Information\n*********************");
		System.out.println("Procedure type: ");
		p.setProcName(in.nextLine());
		
		System.out.println("Date of procedure: ");
		p.setDate(in.nextLine());
		
		System.out.println("Practicioner's name: ");
		p.setPractName(in.nextLine());
		
		System.out.println("Cost of procedure: ");
		p.setCost(in.nextDouble());
		in.nextLine();
		
	}
}
