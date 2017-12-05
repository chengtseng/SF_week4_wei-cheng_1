package lab;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VovalistTest {
	int vol = 7;
	Audition audition;
	Vocalist v1;
	Vocalist v2;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void init() {
		audition = new Audition();
		v1 = new Vocalist(audition, "A");
		v2 = new Vocalist(audition, "B", 5);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void testPerform1() {
		v1.perform();
		String expect = "I sing in the key of - " + v1.getKey() + " - " + v1.id;
		assertEquals("test_perform1" , expect.trim(), outContent.toString().trim());
	}
	
	@Test
	public void testPerform1_volume() {
		v1.perform(vol);
		String expect = "I sing in the key of - " + v1.getKey() + "- at the volume - " + v1.getVolume() + " - " + v1.id;
		assertEquals("test_perform 1.5" , expect.trim(), outContent.toString().trim());		
	}
	
	@Test
	public void testPerform2() {
		v2.perform();
		String expect = "I sing in the key of - " + v2.getKey() + "- at the volume - " + v2.getVolume() + " - " + v2.id;
		assertEquals("test_perform2" , expect.trim(), outContent.toString().trim());		
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}
