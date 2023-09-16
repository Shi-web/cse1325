package library;
import java.time.LocalDate;


/**
 * A library resource that can be checked out by a patron
 *
 */
public class Publication{
	
	private String title;
	private String author;
	private int copyright;
	private Patron loanedTo;
	private LocalDate dueDate;

	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		this.copyright = copyright;
		if (this.copyright < 1900 || this.copyright > LocalDate.now().getYear())
			throw new IllegalArgumentException("Copyright year must be between 1900 and " + LocalDate.now().getYear());
		
		this.loanedTo = null;
		this.dueDate = null;
	}
	
	public String checkOut(Patron patron){
		this.loanedTo = patron;
		this.dueDate = LocalDate.now().plusDays(14);
		String patrondata = "\n :: " + title +" by "+ author +" is Loaned to " + loanedTo + " until " + dueDate+ "::";
		return patrondata;
	}
	
	@Override
	public String toString(){
		String publicationData = "\"" + title +"\" by " + author + ", copyright " + copyright;
			 
		return publicationData;
	}
	
	
}
