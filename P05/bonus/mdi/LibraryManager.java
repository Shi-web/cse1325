package mdi;
import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Patron;
import library.Video;
import library.InvalidRuntimeException;
public class LibraryManager{
	public static void main(String[] args){
		Library library = new Library("Khushi's Small Library");
		int choice;
		try{
			Publication book1 = new Publication("To Kill a Mockingbird", "Harper Lee", 1960);
			Publication book2 = new Publication("Harry Potter and the Order of the Phoenix", "J.K Rowling", 												2002);
			Publication book3 = new Publication("The Alchemist", "Paulo Coelho", 1990);
			
			Video video1 = new Video("The Matrix", "The Wachowskis", 1999, 136);
			Video video2 = new Video("Inception","Christopher Nolan",2010, 148);
			Video video3 = new Video("Avatar"," James Cameron",2009, 162);
		
		
		
			Patron patron1 = new Patron("Sunny Gauli", "sunnygauli@gmail.com");
			Patron patron2 = new Patron("Elon Musk", "spaceX@hotmail.com"); 
			Patron patron3 = new Patron("Aaron Sanchez", "axs2344@yahoo.com");
			Patron patron4 = new Patron("Linda Vista", "leslie766@gmail.com");
		
		
		
			library.addPatron(patron1);
			library.addPatron(patron2);
			library.addPatron(patron3);
			library.addPatron(patron4);
		
			library.addPublication(book1);
			library.addPublication(book2);
			library.addPublication(book3);
		
			library.addPublication(video1);
			library.addPublication(video2);
			library.addPublication(video3);
		
		
			
			
			 StringBuilder currentPatron = new StringBuilder();
			
			 Scanner scanner = new Scanner(System.in);
			 do {
            		System.out.println("\nLibrary Menu:");
            		System.out.println("1. Add Publication");
            		System.out.println("2. Add Video");
            		System.out.println("3. Add Patron");
            		System.out.println("4. Check Out Publication");
            		System.out.println("5. Check In Publication");
            		System.out.println("6. List Patrons");
            		System.out.println("7. List Publications");
            		System.out.println("0. Exit");
            		System.out.print("Enter your choice: ");

            		choice = scanner.nextInt();
            		scanner.nextLine();
            		
            		switch (choice){
            			case 1:
            				  System.out.println("Enter new publication's title: ");
            				  String pTitle = scanner.nextLine();
            				  
            				  System.out.println("Enter new publication's author: "); 
            				  String pAuthor = scanner.nextLine();
            				  
            				  System.out.println("Enter new publication's copyright: "); 
            				  int publicationCR = scanner.nextInt();
            				  scanner.nextLine();
            				  
            				  Publication book = new Publication(pTitle,pAuthor,publicationCR);
            				  library.addPublication(book);
            				  break;
            				  
            		   case 2:
            		         System.out.println("Enter new Video's title: ");
            				 String vTitle = scanner.nextLine();
            				  
            				 System.out.println("Enter new Video's's director: "); 
            				 String vAuthor = scanner.nextLine();
            				  
            				 System.out.println("Enter new Video's copyright: "); 
            				 int VidCR = scanner.nextInt();
            				 
            				 System.out.println("Enter new Video's playtime in minutes: "); 
            				 int Vidtime = scanner.nextInt();
            				 scanner.nextLine();
            				  
            				 Video vid = new Video(vTitle,vAuthor,VidCR, Vidtime);
            				 library.addPublication(vid);
            				 break;
            		   
            		   
            		   case 3:
            		         System.out.println("Enter new patron's name: ");
            				 String name = scanner.nextLine();
            				  
            				 System.out.println("Enter new patron's email address: "); 
            				 String email = scanner.nextLine();
            				 
            				 Patron patron = new Patron(name, email);
            				 library.addPatron(patron);
            				 break;
            				 
            				 
            		   
            		   
            		   
            		   case 4:
            		   		 System.out.println(library);
            		         System.out.print("Enter the index of the publication to check out: ");
			                 int publicationIndex = scanner.nextInt();
			                 scanner.nextLine();
		
			                 System.out.println(library.Menu());
			                 System.out.print("Who are you?(Enter index): ");
			                 int patronIndex = scanner.nextInt();
			                 scanner.nextLine();
			
			                 currentPatron.append(library.checkout(publicationIndex, patronIndex)).append("\n");
			                 System.out.println(currentPatron);
			                 break;
            		   
            		   
            		   case 5:
            		         System.out.println(library);
            		         System.out.print("Enter the index of the publication to check in: ");
			                 int pubIndex = scanner.nextInt();
			                 scanner.nextLine();
			                 
			                 System.out.println(library.Menu());
			                 System.out.print("Who are you?(Enter index): ");
			                 int patIndex = scanner.nextInt();
			                 scanner.nextLine();
			                 
			                 String substring = library.checkout(pubIndex,patIndex);//find the position of the string                   
			              
			                 
			                 
			                 int start = currentPatron.indexOf(substring);
			                 int end = start + substring.length();// calculate the length of the string
			                 // use string builder to delete 
			                 if (start != -1){
			                 	currentPatron.delete(start, start+end);
			                 }
			                 else 
			                 {
			                 	 System.out.println("Sentence not found.");
			                 }
			                 
			                 String prevPatron = library.checkin(pubIndex, patIndex);
			                 System.out.println(prevPatron);
			                 break;
			              
            		   
            		   case 6:
            		         System.out.println(library.Menu());
            		         break;
            			
            				  
            		   case 7:
            		         System.out.println(library + currentPatron.toString());
            		         break;
            		     
            		   case 0:
            		         System.out.println("Exiting...");
                             break;
                       
                        default:
                               System.out.println("Invalid choice. Please enter a valid option.");
            		   				  
            			
            		}
            		
            		
            		
            	}while (choice != 0);
			
			
			
		}
			catch(Exception e){
			System.err.println("Unable to check out\n" + e);
			System.exit(-1);
		}				
		
		
	}
}
