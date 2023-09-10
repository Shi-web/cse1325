
import java.util.ArrayList;

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
	
	public void addPublication(Publication publication)
	{
		publications.add(publication);	
	}
	
	public void addPatron(Patron patron)
	{
		patrons.add(patron);
	
	}
	
	public String Menu()
	{
		StringBuilder pm = new StringBuilder();
		pm.append("\n\n").append("Patrons\n");
		for (int i = 0; i < patrons.size();i++){
			pm.append(i).append(". ").append(patrons.get(i)).append("\n");
		}
		return pm.toString();
	}
	
	public void checkout(int publicationIndex, int patronIndex)
	{
		if (publicationIndex >= 0 && publicationIndex < publications.size()){
			Publication publication = publications.get(publicationIndex);
			publication.checkOut(patrons.get(patronIndex));
		}
		else
			throw new IndexOutOfBoundsException("Invalid Publication Index");
	}
	
	@Override
	
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(name).append("\n").append("\n");
		for ( int i = 0; i < publications.size();i++){
			sb.append(i).append(". ").append(publications.get(i)).append("\n");
		}
		return sb.toString();
	
	}
}

