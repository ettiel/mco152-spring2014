package lieberman.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testConstructor() throws Exception {
		new AmexData();
	}

	@Test
	public void testContains() throws IOException, ParseException {
		AmexData data = new AmexData();
		Assert.assertTrue(data.contains("CXM"));
		Assert.assertFalse(data.contains("AAA"));
	}

	@Test
	public void testGetSymbol() throws IOException, ParseException {
		AmexData data = new AmexData();
		ArrayList<DailyPrice> testEmpty = (ArrayList<DailyPrice>) data
				.getPrices("AAA");
		ArrayList<DailyPrice> expected = new ArrayList<>();
		Assert.assertEquals(testEmpty, expected);

		ArrayList<DailyPrice> test = (ArrayList<DailyPrice>) data
				.getPrices("BHO");

		Assert.assertNotNull(test);
		Assert.assertNotSame(0, test.size());
	}

	@Test
	public void testGetDate() throws IOException, ParseException {
		AmexData data = new AmexData();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		ArrayList<DailyPrice> testEmpty = (ArrayList<DailyPrice>) data
				.getPrices("AAA", formatter.parse("2009-05-05"),
						formatter.parse("2009-05-21"));
		ArrayList<DailyPrice> expected = new ArrayList<>();
		Assert.assertEquals(testEmpty, expected);

		ArrayList<DailyPrice> test = (ArrayList<DailyPrice>) data.getPrices(
				"BWV", formatter.parse("2009-05-05"),
				formatter.parse("2009-05-21"));

		Assert.assertNotNull(test);
		Assert.assertNotSame(0, test.size());
	}

}
