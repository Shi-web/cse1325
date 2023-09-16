package library;
/**
 *  A person authorized to check out a library resource
 *
 */
public class Patron{
	private String name;
	private String email;
	
	public Patron(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString(){
		String patronData = name+ " (" + email +")";
		return patronData; 
	}
}
