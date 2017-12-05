package lab;
import java.util.LinkedList;
import java.util.List;

public class Audition {
	private List<Performer> performers;
	private int[] ids = new int[1000];
	
	public Audition(){
		performers = new LinkedList<>();		
	}
	
	public int[] getIds() {
		return ids;
	}
	
	public List<Performer> getPerformers(){
		return performers;
	}
	
	public boolean addPerformer(Performer newPerformer) {
		//too many performers in an audition
		if(performers.size() >= 1000) 
			return false;
		
		//if the adding performer is already in the audition, do nothing
		
		//if the adding performer was not in the audition, we add the performer to the 
		//audition and set the audition of the performer to this audition.
		if(newPerformer.getAudition() != this) {
			performers.add(newPerformer);
			newPerformer.setAudition(this);
		}
		return true;
	}
}