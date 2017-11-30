package ie.lyit.hotel;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Customer extends Person /* implements Serializable  //DOES NOT WORK ON HOME MACHINE BUT WORKS FOR COLLEGE ECLIPSE*/ {// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int number;		
	// AND number
	

	private static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		number=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return number + ", " + super.toString() + "," + emailAddress;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}	

	
	public void read() {
		  JTextField customerNo = new JTextField();
	      customerNo.setText("" + this.getNumber());
	      JTextField txtT = new JTextField();
	      txtT.requestFocus();
	      JTextField txtFn = new JTextField();
	      JTextField txtSn = new JTextField();
	      JTextField txtAddress = new JTextField();
	      JTextField txtPhoneNumber = new JTextField();
	      JTextField txtEmailAddress = new JTextField();

	      //POPS OUT BEHIND ECLIPSE WINDOW
	      Object[] message = {
	          "Customer Number:", customerNo,
	          "Title:", txtT,
	          "First Name:", txtFn,
	          "Surname:", txtSn,
	          "Address:", txtAddress,
	          "Phone No:", txtPhoneNumber,
	          "Email Address:", txtEmailAddress,
	      };

	      int option = JOptionPane.showConfirmDialog(null,message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION)
	      {
	    	  String title=txtT.getText();
	  		  String firstName=txtFn.getText();
	  		  String surname= txtSn.getText();
	  		  Name n2 = new Name(title,firstName,surname);
	          this.name = n2;
	          this.address = txtAddress.getText();
	          this.phoneNumber = txtPhoneNumber.getText();
	          this.emailAddress = txtEmailAddress.getText();
	      } 
	      
		
	}	

}
