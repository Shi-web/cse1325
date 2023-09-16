package library;
import java.util.ArrayList;
/**
* Models a library containing various publications
*/

public class Library{
	
	private String name;
	private ArrayList<Publication> publications;
	private ArrayList<Patron> patrons;
	
	public Library(String name)	
	{
		this.name = name;
		this.publications = new ArrayList<>();
		this.patrons = new ArrayList<>();
	}
/**
* Adds book/video in publication the array list
*/	
	public void addPublication(Publication publication)
	{
		publications.add(publication);	
	}
/**
* Adds patron in patron the array list
*/	
	public void addPatron(Patron patron)
	{
		patrons.add(patron);
	
	}
/**
* Displays the list of patrons
*/	
	public String Menu()
	{
		StringBuilder pm = new StringBuilder();
		pm.append("\n\n").append("Patrons\n");
		for (int i = 0; i < patrons.size();i++){
			pm.append(i).append(". ").append(patrons.get(i)).append("\n");
		}
		return pm.toString();
	}
	
/**
* Records the checkout book and patron
*/	
	public String checkout(int publicationIndex, int patronIndex)
	{
		if (publicationIndex >= 0 && publicationIndex < publications.size()){
			Publication publication = publications.get(publicationIndex);
			String data = publication.checkOut(patrons.get(patronIndex));
			return data;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid Publication Index");
		}
		
	}

/**
* Returns string
*/		
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(name).append("\n").append("\n");
		for ( int i = 0; i < publications.size();i++){
			sb.append(i).append(".").append(publications.get(i)).append("\n");
		}
		return sb.toString();
	
	}
	
}

