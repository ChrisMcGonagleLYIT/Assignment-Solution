package ie.lyit.testers;

import ie.lyit.serializer.CustomerSerializer;
import ie.lyit.hotel.Menu;
import javax.swing.*;

public class customerSerializerTester {

		public static void main(String[] args) {
			CustomerSerializer customerSerializer = new CustomerSerializer();		
			/*		
			// Add two records to the ArrayList
			customerSerializer.add();
			customerSerializer.add();
					
			// Write the ArrayList to File
			customerSerializer.writeRecordsToFile();

			
			// Read the ArrayList from the File
			customerSerializer.readRecordsFromFile();
			
			// List all the customers in the ArrayList
			customerSerializer.list();
			
			*/
			
			// i.e. read the customerList ArrayList from the file back into the ArrayList
			customerSerializer.readRecordsFromFile();
			
		    // Create a Menu Object
			Menu menuObj = new Menu();
			
			do{
				// Call it's display() method
				menuObj.display();
				// Call it's readOption() method
				menuObj.readOption();
				// switch on the option and call the appropriate method
				switch(menuObj.getOption()){
				   case 1:customerSerializer.add();break;
				   case 2:customerSerializer.list();break;
				   case 3:customerSerializer.view();break;
				   case 4:customerSerializer.edit();break;
				   case 5:customerSerializer.delete();break;
				   case 6:break;				
				   default:
					   JOptionPane.showMessageDialog(null, "Enter a number between 1 and 6");
				  
				   								System.out.println("INVALID OPTION...");
				}
			}while(menuObj.getOption() != 6);	
																				
			// Serialize the ArrayList to the File
			// i.e. write the CustomerList ArrayList back into the the file		
			customerSerializer.writeRecordsToFile();
		}
	}