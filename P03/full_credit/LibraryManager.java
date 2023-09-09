import java.util.Scanner;
public class LibraryManager{
	public static void main(String[] args){
		Library library = new Library("Khushi's Library");
		
		Publication book1 = new Publication("To Kill a Mockingbird", "Harper Lee", 1960);
		Publication book2 = new Publication("Harry Potter and the Order of the Phoenix", "J.K Rowling", 											2002);
		Publication book3 = new Publication("The Alchemist", "Paulo Coelho", 1990);
		
		library.addPublication(book1);
		library.addPublication(book2);
		library.addPublication(book3);
		
		System.out.println(library);
		
			
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the index of the book to check out: ");
		int publicationIndex = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Please enter your name:");
		String patron = scanner.nextLine();
		
		try{
			library.checkout(publicationIndex, patron);
		}	catch(IndexOutOfBoundsException e){
			System.err.println(e.getMessage());
			System.exit(-1);
		}		
		
		System.out.println(library);
	}
}
