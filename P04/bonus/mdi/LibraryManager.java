package mdi;
import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Patron;
import library.Video;
import library.InvalidRuntimeException;
public class LibraryManager{
	public static void main(String[] args){
		Library library = new Library("Khushi's Library");
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
		
			System.out.println(library);
		
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the index of the Book/Movie to check out: ");
			int publicationIndex = scanner.nextInt();
			scanner.nextLine();
		
			System.out.println(library.Menu());
			
			System.out.print("Who are you?: ");
			int patronIndex = scanner.nextInt();
			
			
			String currentPatron = library.checkout(publicationIndex, patronIndex);
			System.out.println(library + currentPatron);
		}
			catch(Exception e){
			System.err.println("Unable to check out\n" + e);
			System.exit(-1);
		}				
		
		
	}
}
