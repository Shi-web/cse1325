import java.time.LocalDate

public class Publication{
	
	private String title;
	private author;
	private int copyright;
	private String loanedTo;
	private LOcalDate dueDate;

	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		
		if (this.copyright < 1900 || this.copyright > LocalDate.now().getYear())
			throw new IllegalArgumentException("Copyright year must be between 1900 and " + LocalDate.now().getYear());
		this.copyright = copyright;
		this.loanedTo = null;
		this.dueDate = null;
	}
	
	public void checkOut(String patron){
		this.loanedTo = patron;
		this.dueDate = LOcalDate.now().plusDays(14);
	}
	
	@Override
	public String toString(){
		String publicationData = "\"" + title +"\" by " + author + ", copyright " + copyright;
		
		if (loanedTo!=null)
			 publicationData += "\nloaned to " + loanedTo +" until " + dueDate;
			 
		return publicationData;
	}
}
