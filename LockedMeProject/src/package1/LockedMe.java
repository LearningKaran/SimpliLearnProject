package package1;

import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
public class LockedMe {

	static int i;
	public String path="D:\\SimpliLearnProject\\First Project\\LockedMeProject";
	File f=new File(path);
	
	public void displayMenu()
	{
		
		System.out.println("\t\t 1. Display all File Names.");
		System.out.println("\t\t 2. Add a File.");
		System.out.println("\t\t 3. Delete a File.");
		System.out.println("\t\t 4. Search a File.");
		//System.out.println("5. Navigate to Main Menu");
		System.out.println("\t\t 5. Exit");
		
	}
	
	public void displayAllFiles()
	{
		Scanner sc=new Scanner(System.in);
		//while(i==1) 
		//{
			//File f=new File(path);
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
			
//			if(listoffiles.length>0)
//			{
//				for(String a: listoffiles)
//				System.out.println(a);
//			}
//			else
//			{
//				System.out.println("No File Exists in the directory."); // Type yes if you want to add a new file");
//				
//				String addfile=sc.nextLine();
//				if(addfile.equalsIgnoreCase("yes"))
//				{
//					addFile();
//				}
				
//				String filename=sc.nextLine();
//				String path= "D:\\SimpliLearnProject\\First Project\\LockedMeProject"+"\\"+filename+".txt";
//				try 
//				{
//					File fr=new File(path);
//					fr.createNewFile();
//					System.out.println("File created Successfully");
//					//String filescreated[]=fr.list();
//					//for(String a: filescreated)
//					//System.out.println(filescreated);
//				} 
//				catch (IOException e) {
//					
//					e.printStackTrace();
//				}
			}
			

	
	public void addFile() 
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
			//String filescreated[]=fr.list();
			//for(String a: filescreated)
			//System.out.println(filescreated);
		
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void deleteFile() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the filename you want to delete");
		String deletefile=sc.nextLine();
		String path2=path+"\\"+deletefile+".txt";
		File fd=new File(path2);
		//System.out.println(fd.getName().equals(deletefile+".txt")); 		condition is giving as true. Why?
		if(fd.exists())										// && fd.getName().equals(deletefile+".txt"))
		{
			fd.delete();
			System.out.println("File "+deletefile+ ".txt Deleted Successfully!!");
		}
		else
		{
			System.out.println("File "+deletefile+ ".txt does not exist in the given directory.");
		}	
	}
		
	public void searchFile() 
	{
		System.out.println("Enter the file name to be searched");
		Scanner sc=new Scanner(System.in);
		String searchfile=sc.nextLine();
		String path3=path+"\\"+searchfile+".txt";
		File fs=new File(path3);
		if(fs.exists())
		{
			System.out.println("File "+searchfile+".txt found!!");
		}
		else
		{
			System.out.println("File "+searchfile+".txt not available");
		}
	}
	
	
	public void exit() 
	{
		System.out.println("     ******************************************");	
		System.out.println("\tThank You For Using The Application!");
		System.out.println("     ******************************************");	
	}

	
	public static void main(String[] args) 
	{	
		System.out.println("----------------------------------------------");
		System.out.println("\t Welcome to LockedMe.com");
		System.out.println("----------------------------------------------");
		//String s="Desinged By:";
		//System.out.println(String.format("<b>%s</b>",s));
		System.out.println("Desinged By : Karan Bhandari");
		System.out.println("Designation : Software Engineer");
		System.out.println("Role\t    : Full Stack Developer");
		System.out.println("**********************************************");	
		
		LockedMe lm=new LockedMe();
		lm.displayMenu();
		
		
		
		System.out.println("Enter one option:");
		Scanner sc=new Scanner(System.in);
		
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
				i=Integer.parseInt(sc.nextLine());
				while(i<1 || i>5)
				{
					System.out.println("Invalid Option, please enter the value between 1 to 5.");
					i=Integer.parseInt(sc.nextLine());
				}
			}
			
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
//			case 5: lm.navigateToMainMenu();
//					break;
//			case 5: lm.exit();
//					break;
			}
			System.out.println("********************************************");	
			
			lm.displayMenu();
			
			System.out.println("Enter your choice again:");
			
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
				i=Integer.parseInt(sc.nextLine());
				while(i<1 || i>5)
				{
					System.out.println("Invalid Option, please enter the value between 1 to 5.");
					i=Integer.parseInt(sc.nextLine());
				}
			}
		}
	lm.exit();
	}
	
}
