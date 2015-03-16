package main;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTimeTest {

	@Test
	public void test() {
		DateTime dt = new DateTime(1988, 3, 9, 12, 0, 0, 0);
		String dowStr = dt.dayOfWeek().getAsText();
		System.out.println(dowStr);
		assertEquals(dowStr, "수요일");
	}

}
