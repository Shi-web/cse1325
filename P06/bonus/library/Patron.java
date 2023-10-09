package library;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
/**
 *  A person authorized to check out a library resource
 *
 */
public class Patron{
	private String name;
	private String email;
/**
 * Contructs Patron class
 *
 */	
	public Patron(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	public void save(BufferedWriter bw) throws IOException {
        // Write the name and email fields to the BufferedWriter
        bw.write(name + '\n');
        bw.write(email + '\n');
        
        // Flush the BufferedWriter to ensure the data is written immediately
        //bw.flush();
    }
    
    public Patron(BufferedReader br) throws IOException {
        // Read and restore the name and email fields from the BufferedReader
        this.name = br.readLine();
        //System.out.println("Name of the patron"+ name);
        this.email = br.readLine();
    }
/**
 * Returns patron name and email
 *
 */	
	@Override
	public String toString(){
		String patronData = name+ " (" + email +")";
		return patronData; 
	}
}
