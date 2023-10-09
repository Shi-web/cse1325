package library;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;

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
	
	public void save(BufferedWriter bw) throws  IOException
	{	
		bw.write(name);
		bw.newLine();
		
		 bw.write(Integer.toString(publications.size()));
         bw.newLine();	
         
         for (Publication publication : publications) {
                // Write the type of the publication (either "publication" or "video")
                if (publication instanceof Video) {
                    bw.write("video");
                } else {
                    bw.write("publication");
                }
                bw.newLine();

                // Tell the publication to save itself
                publication.save(bw);
            }

            // (Bonus only) Save patrons if needed
            // Write the number of patrons
            bw.write(Integer.toString(patrons.size()));
            bw.newLine();
             for (Patron patron : patrons) {
                // Tell the patron to save itself
                patron.save(bw);
            }
   
		
	}
	
	public Library(BufferedReader br) throws IOException
	{
		this.publications = new ArrayList<>();
		this.patrons = new ArrayList<>();
		this.name = br.readLine();
		int numPublications = Integer.parseInt(br.readLine());
		 for (int i = 0; i < numPublications; i++) {
                String type = br.readLine();
                Publication publication;
                if (type.equals("video")) {
                    publication = new Video(br);
                } else {
                    publication = new Publication(br);
                }
                addPublication(publication);
            }

            // (Bonus only) Read and reconstruct patrons if needed
            // Read the number of patrons
            int numPatrons = Integer.parseInt(br.readLine());
            

            // Read and reconstruct the patrons
            for (int i = 0; i < numPatrons; i++) {
                Patron patron = new Patron(br);
                addPatron(patron);
            }
            //System.out.println("Here is the size of the Patrons arraylist"+ patrons.size());
            
	}
	
		
/**
* Displays the list of patrons
*/	
	public String Menu()
	{
		StringBuilder pm = new StringBuilder();
		pm.append("\n\n").append("Patrons\n");
		//System.out.println("Here is the size" + patrons.size());
		for (int i = 0; i < patrons.size();i++){
			pm.append(i).append(". ").append(patrons.get(i)).append("\n");
			//System.out.println(patrons.get(i));
		}
		//System.out.println("Here is the PAtrons"+ pm.toString());
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
 * Records the check-in of a publication by a patron
 */
	public String checkin(int publicationIndex, int patronIndex) {
    	if (publicationIndex >= 0 && publicationIndex < publications.size() &&
        	patronIndex >= 0 && patronIndex < patrons.size()) {
        
        	Publication publication = publications.get(publicationIndex);
        	Patron patron = patrons.get(patronIndex);
    
    	        // Perform the check-in
    	        String s = publication.checkIn(patron);
            
    	        // Return a message indicating successful check-in
    	     return  publications.get(publicationIndex)+ s;
    	    }
    	else {
    	    throw new IndexOutOfBoundsException("Invalid Publication or Patron Index");
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

