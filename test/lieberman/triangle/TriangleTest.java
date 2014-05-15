package lieberman.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void test() {
		Triangle tri = new Triangle(5);
		String test = tri.toString();

		String expected = "    *" + "\n" + "   * *" + "\n" + "  *   *" + "\n"
				+ " *     *" + "\n" + "*********";
		Assert.assertEquals(expected, test);
	}

}
