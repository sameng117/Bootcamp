package com.lockedme;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class welcome {

	public static void main(String[] args) throws IOException {
		// WELCOME
		
		// Welcoming user & prompting 
		// **************************
		System.out.println("Welcome to the LockedMe application");
		System.out.println("This application is written in Java and can be used to perform file specific \noperations on a local machine.");
		System.out.println("This application is developed by Samuel Aslam, a mathematician \nand full stack java developer.");
		System.out.println("\n");
		System.out.println("This application displays a selection of options while assigning \na unique number to each option.");
		System.out.println("A user can choose the operation they wish to perform by inputting its \nassociated number when prompted.");
		System.out.println("\n");
		System.out.println("Choose an option from the main menu:");
		System.out.println("1. Enlist all files in the program's root directory");
		System.out.println("2. Perform special operations like add, delete, or search");
		System.out.println("3. Close program");
		System.out.println("\n");
		System.out.println("Which operation would you like to perform ?\n");
		
		// Getting user input
		// ***********************************
		
		BufferedReader keyInStream = new BufferedReader( new InputStreamReader(System.in));
		
		String entry = keyInStream.readLine();
		
		
		while(!(entry.equals("1") || entry.equals("2") || entry.equals("3"))) {
			
			System.out.println("Please enter a valid option\n");
			
			entry = keyInStream.readLine();
		}
		
		// Setting up root directory
		// *************************
		
		File dir = new File("FileOpsDir");
		dir.mkdir();
		
		// Beginning main menu loop
		// **********************
		
		while(!entry.equals("3")) {
				
			if (entry.equals("1")) {
				
				//OPTION 1 (Enlisting)
				//********************
				
				String filesArr[] = dir.list();
				
				Arrays.sort(filesArr);
				
				System.out.println("Here is a list of all files in the root directory \n");
				
				for (String file : filesArr) {
					System.out.println("File: " + file);
				}
				
				System.out.println("\n");
				
				
			} else if (entry.equals("2")) {
			
				// OPTION 2 (Sub-Menu)
				// *******************
				System.out.println("Choose an option from the sub-menu: \n");
					
				System.out.println("1. Add a file");
				System.out.println("2. Delete a file (case-sensitive)");
				System.out.println("3. Search for a file");
				System.out.println("4. Return to the main menu \n");
				
				//Getting user input
				//******************
				
				BufferedReader subMenuKeyInStream = new BufferedReader(new InputStreamReader(System.in));
				
				String subMenuEntry = subMenuKeyInStream.readLine();
				
				while (!(subMenuEntry.equals("1") || subMenuEntry.equals("2") || subMenuEntry.equals("3") || subMenuEntry.equals("4"))) {
					
					System.out.println("Please enter a valid option \n");	
					subMenuEntry = subMenuKeyInStream.readLine();
				}
				
				//Beginning sub-menu loop
				//***********************
				while(!subMenuEntry.equals("4")) {
						
					if (subMenuEntry.equals("1")) {
						
						//Adding a file
						//*************
						
						System.out.println("Please enter the name of the new file you would like to create \n");
						String newFileName = subMenuKeyInStream.readLine();
						File newFile = new File(dir,newFileName);
						
						if(newFile.createNewFile()) {
							
							System.out.println("File Added.");
							System.out.println("Operation successful \n");
							
						} else {
							
							System.out.println("File already exists. \n");
						}
						
						
						
					} else if (subMenuEntry.equals("2")) {
						
						//Deleting a file
						//***************
						
						System.out.println("Please enter the name of the new file you would like to delete \n");
						String delFileName = subMenuKeyInStream.readLine();
						File delFile = new File(dir,delFileName);
						
						if(delFile.delete()) {
							
							System.out.println("File Deleted.");
							System.out.println("Operation successful \n");
							
						} else {
							
							System.out.println("\n File not found \n");
						}
						
					} else if (subMenuEntry.equals("3")) {
						
						//Searching a file
						//*****************
						
						System.out.println("Please enter the name of the file you would like to search \n");
						String searchFileName = subMenuKeyInStream.readLine();
						boolean found = false;
						
						String filesArr[] = dir.list();
						Arrays.sort(filesArr);
						
						for (String file:filesArr) {
							
							if(file.equals(searchFileName)) {
								
								System.out.println(searchFileName + " found in program's root directory \n");
								found = true;
							}
						}
						
						if (found != true) {
							
							System.out.println("\n File not found \n");
						}
						
						
					}
					
					System.out.println("Choose an option from the sub-menu:");
					
					System.out.println("1. Add a file");
					System.out.println("2. Delete a file (case-sensitive)");
					System.out.println("3. Search for a file");
					System.out.println("4. Return to the main menu \n");
					
					subMenuEntry = subMenuKeyInStream.readLine();
				
				}
				
				System.out.println("Exiting to main menu \n");
				
			}
			
			System.out.println("Choose an option from the main menu:");
			System.out.println("1. Enlist all files in the program's root directory");
			System.out.println("2. Perform special operations like add, delete, or search");
			System.out.println("3. Close program \n");
			
			entry = keyInStream.readLine();
		}
		
		System.out.println("Thank you for using the LockedMe application");
		System.out.println("Goodbye");
		
		System.exit(0);
		
		
		
		

		
		
		
		
		
	}

}
