package lab;
import java.util.Random;

public class Performer {
	protected String id;
	private Audition audition;
			
	Performer(Audition audi){
		boolean addingSuccessfully = audi.addPerformer(this);
		
		if(!addingSuccessfully) return;
		
		this.audition = audi;		
		
		int[] ids = audition.getIds();
		Random rand = new Random();
		int performerId = rand.nextInt(1000);
		
		while(ids[performerId] == 1) {
			performerId = rand.nextInt(1000);
		}
		
		this.id = "" + performerId;		
	}
	
	public Audition getAudition() {
		return audition;
	}	

	public void setAudition(Audition audition) {
		this.audition = audition;
	}

	public void perform() {
		System.out.printf("%s - performer", this.id);		
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
}
