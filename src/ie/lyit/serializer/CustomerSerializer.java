package ie.lyit.serializer;
import ie.lyit.hotel.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class CustomerSerializer {
	// Constant FILENAME for the file to be created
	final String FILENAME = "Customers.bin";

	// Declare ArrayList called Customer - for storing a list of customers
	private ArrayList<Customer> customerList;
	

	// Default Constructor
	public CustomerSerializer(){
		// Construct Customers ArrayList
		customerList = new ArrayList<Customer>();
	}

	//Reads one Customer record from the user and adds it to the ArrayList customerList
	public void add(){
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();
		// And add it to the books ArrayList
		customerList.add(customer);
	}

	//Lists all Customer records in the ArrayList
	public void list(){
		// for every Customer object in CustomerList
      for(Customer tmpCustomer:customerList) {
			// display it
			System.out.println(tmpCustomer);
			
      }
	}
	
	//Displays the required Customer record on screen: And returns it, or null if not found         //   
	
	public Customer view(){
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the Customer to be viewed from the user
		System.out.println("ENTER CUSTOMER NUMBERK : ");
		int customerToView=keyboard.nextInt();
		
		// for every Customer object in CustomerList
		 for(Customer tmpCustomer:customerList) {
		   // if it's number equals the number of the customerToView
		   if(tmpCustomer.getNumber() == customerToView){
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    // if we reach this code the book was not found so return null
	    return null;		
	}

	// Deletes the required Customer record from customers 
	public void delete(){	
		// Call view() to find, display, & return the book to delete
		Customer tempCustomer = view();
		// If the Customer != null, i.e. it was found then...
	    if(tempCustomer != null)
		   // ...remove it from CustomerList
	       customerList.remove(tempCustomer);
	}
	
	//Edits the required Customer record in CustomerList
	public void edit(){	
		// Call view() to find, display, & return the Customer to edit
		Customer tempCustomer = view();
		// If the Customer != null, i.e. it was found then...
	    if(tempCustomer != null){
		   // get it's index
		   int index=customerList.indexOf(tempCustomer);
		   // read in a new Customer and...
		   tempCustomer.read();
		   // reset the object in CustomerList
		   customerList.set(index, tempCustomer);
	    }
	}
	
	//Writes the ArrayList Customers to the File CustomerList.bin before closing the File
	public void writeRecordsToFile(){
		try{
			// Serialize the ArrayList...
						FileOutputStream fileStream = new FileOutputStream(FILENAME);
				
						ObjectOutputStream os = new ObjectOutputStream(fileStream);
				
						os.writeObject(customerList);
				
						os.close();
					}
					catch(FileNotFoundException fNFE){
						System.out.println("Cannot create file to store books.");
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
		}

//Reads the ArrayList from the File back into Customers before closing the File	
	public void readRecordsFromFile(){
		try{
			// Deserialize the ArrayList...
			Path p=Paths.get(FILENAME);
			 // Call Files static exists() method to ensure p exists
			 if(Files.exists(p)){
			 // Make a FileInputStream that connects to number.bin
			FileInputStream fs = new FileInputStream(p.toString());
			// Chain an ObjectInputStream to it
			ObjectInputStream is = new ObjectInputStream(fs);
			// and tell ObjectInputStream to read array List
			try {
				customerList = (ArrayList<Customer>)is.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			is.close();
			 }
			 else // file doesn't exist
			 System.out.println("Customer File "+p.getFileName()+" doesn’t exist");
			 }catch(IOException e){
			 System.out.println("Input Output Error" + e.getMessage());
			 }
		}
		
						
}	
