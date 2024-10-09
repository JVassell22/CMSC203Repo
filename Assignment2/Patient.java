package Assignment2;

public class Patient {
	
	private String fname, mname, lname, emergName, street, city, state, phoneNum, emergPhoneNum;
	private int zip;
	
	
	public Patient(){ // NO ARG CONSTRUCTOR
		fname = " ";
		mname = " ";
		lname = " ";
		emergName = " ";
		street = "1600 Pennsylvania Ave";
		city = "Washington";
		state = "D.C.";
		zip = 20500;
		phoneNum = "000-000-00000";
		emergPhoneNum = "000-000-0000";
	}
	
	public Patient(String fname, String mname, String lname) { // CONSTRUCTOR FOR FIRST, MIDDLE, AND LAST NAME FIELDS
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		emergName = " ";
		street = "1600 Pennsylvania Ave";
		city = "Washington";
		state = "D.C.";
		zip = 20500;
		phoneNum = "000-000-00000";
		emergPhoneNum = "000-000-0000";
	}
	public Patient(String fname, String mname, String lname, String emergName, String street, String city, String state, int zip, String phoneNum, String emergPhoneNum){ // FULL ARG CONSTRUCTOR
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.emergName = emergName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNum = phoneNum;
		this.emergPhoneNum = emergPhoneNum;
	}
	
	//************************************// // ALL ACCESSORS FOR FIELDS
	
	public String getFname() {
		return fname;
	}
	public String getMname() {
		return mname;
	}
	public String getLname() {
		return lname;
	}
	public String getEmergName() {
		return emergName;
	}
	public String getStreet() {
		return street;
	}
	public String getcity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZip() {
		return zip;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getEmergPhoneNum() {
		return emergPhoneNum;
	}
	
	//************************************// // ALL MUTATORS FOR FIELDS
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setEmergName(String emergName) {
		this.emergName = emergName;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setEmergPhoneNum(String emergPhoneNum) {
		this.emergPhoneNum = emergPhoneNum;
	}
	
	//************************************// // STRING CONCATONATIONS FOR FULL NAME, FULL ADDRESS, FULL EMERGENCY CONTACT, AND ALL NECESSARY INFO IN TOSTRING METHOD
	
	public String buildFullName() {
		return(fname+" "+mname+ " "+lname);
	}
	public String buildAddress() {
		return(street+" "+city+" "+state+" "+zip);
	}
	public String buildEmergencyContact() {
		return(emergName+" "+emergPhoneNum);
	}
	public String toString() {
		return("Name: "+buildFullName()+"\nAddress: "+buildAddress()+"\nEmergency Contact: "+buildEmergencyContact());
	}
}

