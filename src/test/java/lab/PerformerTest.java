package lab;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PerformerTest {
	Audition audition;
	Performer performer;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void init() {
		audition = new Audition();
		performer = new Performer(audition);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}	
	
	@Test
	public void testConstructor() {
		assertEquals("AUDITION REFERENCE IS NOT CORRECT", audition, performer.getAudition());
	}
	
	@Test
	public void testPerform() {
		performer.perform();
		String expected =  performer.id + " - performer";
		assertEquals("test_perform" ,outContent.toString(), expected);
	}
	
	@Test
	public void testNoMoreThan1000PerformerInAuditionList() {		
		for(int i = 0; i < 999; i++) {
			Performer p = new Performer(audition);			
		}
		
		assertEquals("test_over_1000 performers" ,
				1000, audition.getPerformers().size());	
	}
	@Test
	public void testFailureOfAddingPerformerToFullAuditon() {
		for(int i = 0; i < 1000; i++) {
			Performer p = new Performer(audition);			
		}
		Performer notAcceptablePerformer = new Performer(audition);
		
		assertEquals("test_over_1000 performers" ,
				true, audition.getPerformers().size() == 1000 &&
				notAcceptablePerformer.getAudition() == null);	
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}
