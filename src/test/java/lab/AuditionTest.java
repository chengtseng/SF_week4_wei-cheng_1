package lab;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AuditionTest {
	Audition audition;
	Performer p1;
	Performer p2;
	
	@Before
	public void init() {
		audition = new Audition();		
	}

	@Test
	public void testAddPerformer() {
		p1 = new Performer(audition);
		p2 = new Performer(audition);
		audition.addPerformer(p1);
		audition.addPerformer(p2);	
		assertEquals("ADD PERFORMER TO AUDITION IS NOT CORRECT", 2, audition.getPerformers().size());
	}
	
	@Test
	public void testGetPerformers() {
		List<String> ids = new LinkedList<>(); 
		assertEquals("THE LIST IS NOT INITIALIZED AS IT SHOULD BE.", 0, audition.getPerformers().size());
		
		p1 = new Performer(audition);
		audition.addPerformer(p1);
		ids.add(p1.getId());
		assertEquals("THE LIST IS NOT BEHAVE PROPERLY.", 1, audition.getPerformers().size());
		
		p2 = new Performer(audition);
		audition.addPerformer(p2);	
		assertEquals("THE LIST IS NOT BEHAVE PROPERLY.", 2, audition.getPerformers().size());
		ids.add(p2.getId());		
		assertEquals("", true, ids.contains(p1.getId()) && ids.contains(p2.getId()) && audition.getPerformers().size() == 2);		
	} 
	
	@Test
	public void testFailToAddPerformerToFullAudition() {
		for(int i = 0; i < 1000; i++) {
			audition.addPerformer(new Performer(audition));
		}
		Performer p = new Performer(audition);
		assertEquals("ADDING 1001th PERFORMER METHOD FAIL", true, 
				!audition.addPerformer(p) &&
				audition.getPerformers().size() == 1000 &&
				p.getAudition() == null);
	}

}
