package package1;

import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
public class LockedMe {

	static int i;
	public String path="D:\\SimpliLearnProject\\First Project\\LockedMeProject";
	File f=new File(path);
	
	
	public void displayMenu()				// This function Displays the Menu with different options available.
	{
		System.out.println("\t\t 1. Display all File Names.");
		System.out.println("\t\t 2. Add a File.");
		System.out.println("\t\t 3. Delete a File.");
		System.out.println("\t\t 4. Search a File.");
		System.out.println("\t\t 5. Exit");	
	}
	
	public void displayAllFiles()			 //This function displays names of all the files in ascending order already present in the given directory.
	{										 //If no file is present already, it prints a negative message.
		String listoffiles[]=f.list();
			if(listoffiles.length>0)
			{
				TreeSet<String> filenames=new TreeSet<String>();
				for(String l:listoffiles)
				{
						filenames.add(l);
						System.out.println(l);
				}	
			}
			else
			{
				System.out.println("No File Exists in the directory.");
			}
	}
	
	public void addFile() 						// This function is used to add a user specified file in the given directory.
	{
		System.out.println("Enter the file name you want to give");
		Scanner sc=new Scanner(System.in);
		String addfilename=sc.nextLine();
		String path1= path+"\\"+addfilename+".txt";
		
		try 
		{
			File fa=new File(path1);
			fa.createNewFile();
			System.out.println("File created Successfully!!");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void deleteFile() 					//This function is used to delete a user specified file from the given directory.
	{											//If the file is not there, it prints a negative message.
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the filename you want to delete");
		String deletefile=sc.nextLine();
		String path2=path+"\\"+deletefile+".txt";
		File fd=new File(path2);
		
		String listoffiles[]=f.list();
		int flag=0;
		for(int i=0;i<listoffiles.length;i++)
		{
			if(listoffiles[i].equals(deletefile+".txt"))
			{
				fd.delete();
				flag=1;
				System.out.println("File "+deletefile+ ".txt Deleted Successfully!!");
			}
		}
		if(flag==0)
		{
			System.out.println("File "+deletefile+ ".txt does not exist in the given directory.");
		}
	}
		
	public void searchFile() 					//This function is used to search a user specified file in the given directory.
	{											//If the file is not there, it prints a negative message. 
		System.out.println("Enter the file name to be searched");
		Scanner sc=new Scanner(System.in);
		String searchfile=sc.nextLine();
		
//		String path3=path+"\\"+searchfile+".txt";
//		File fs=new File(path3);
		
		String listoffiles[]=f.list();
		int flag=0;
		for(int i=0;i<listoffiles.length;i++)
		{
			if(listoffiles[i].equals(searchfile+".txt"))
			{
				flag=1;
				System.out.println("File "+searchfile+ ".txt found!!");
			}
		}
		if(flag==0)
		{
			System.out.println("File "+searchfile+".txt not available");
		}
	}

	public void exit() 							//This function is used to exit from the Application.
	{
		System.out.println("     ------------------------------------------");	
		System.out.println("\tThank You For Using The Application!");
		System.out.println("     ------------------------------------------");	
	}

	private static void askInput(Scanner sc)
	{
		boolean flag;
		do 
		{
			flag=false;
			try 
			{
				i=Integer.parseInt(sc.nextLine());
				while(i<1 || i>5)
				{
					System.out.println("Invalid Option, please enter the value between 1 to 5.");
					i=Integer.parseInt(sc.nextLine());
				}
			}
			catch(NumberFormatException in)
			{
				System.out.println("Please enter a numeric value!!");
				flag=true;
			}
		}while(flag);
	}
	
	public static void main(String[] args) 		// This is the main method where the welcome message, Developers details and calling to all functions take place.
	{	
		System.out.println("----------------------------------------------");
		System.out.println("\t Welcome to LockedMe.com");
		System.out.println("----------------------------------------------");
		System.out.println("Desinged By : Karan Bhandari");
		System.out.println("Designation : Software Engineer");
		System.out.println("Role\t    : Full Stack Developer");
		System.out.println("**********************************************");	
		
		//System.out.println("Enter the path where you want to save the files: ");
		//enterPath();
		
		LockedMe lm=new LockedMe();	
		lm.displayMenu();
		System.out.println("**********************************************");	
		System.out.println("Enter one option:");
		Scanner sc=new Scanner(System.in);
		
		askInput(sc);
			
		while(i!=5)
		{
			switch(i)
			{
			case 1: lm.displayAllFiles();
					break;		
			case 2: lm.addFile();
					break;
			case 3: lm.deleteFile();
					break;
			case 4: lm.searchFile();
					break;		
			}
			
			System.out.println("********************************************");	
			lm.displayMenu();
			System.out.println("********************************************");	
			System.out.println("Enter your choice again:");
		
			askInput(sc);
		}
	lm.exit();
	}
}
