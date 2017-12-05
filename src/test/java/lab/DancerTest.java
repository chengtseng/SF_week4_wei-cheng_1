package lab;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DancerTest {

	Audition audition;
	Dancer dancer;
	String style;	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void init() {
		audition = new Audition();
		dancer = new Dancer(audition, "Ballet");
		style = dancer.getStyle();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@Test
	public void testPerform() {
		String expected = dancer.getStyle() + " - " + dancer.id + " - dancer";
		dancer.perform();
		assertEquals("test_perform" ,outContent.toString(), expected);
	}
	
	@Test
	public void testGetStyle() {		
		String theStyle = dancer.getStyle();
		assertEquals("test_getStyle" , "Ballet", theStyle);
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}
