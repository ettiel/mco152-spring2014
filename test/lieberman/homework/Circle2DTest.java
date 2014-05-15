package lieberman.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testGetArea() {
		Circle2D circle = new Circle2D(0, 0, 1);
		Double area = circle.getArea();
		Double expected = 3.14159265358979323846;

		Assert.assertEquals(area, expected);
	}

	@Test
	public void testGetPerimeter() {
		Circle2D circle = new Circle2D(0, 0, .5);
		Double perimeter = circle.getPerimeter();
		Double expected = 3.14159265358979323846;

		Assert.assertEquals(perimeter, expected);
	}

	@Test
	public void testContainsTrue() {
		Circle2D circle = new Circle2D(0, 0, 4);
		Boolean answer = circle.contains(2, 2);

		Assert.assertTrue(answer);
	}

	@Test
	public void testContainsFalse() {
		Circle2D circle = new Circle2D(0, 0, 1);
		Boolean answer = circle.contains(3, 3);

		Assert.assertFalse(answer);
	}

	@Test
	public void testContainsCircle() {
		Circle2D circle = new Circle2D(0, 0, 6);
		Circle2D circle2 = new Circle2D();
		Boolean answer = circle.contains(circle2);

		Assert.assertTrue(answer);
	}

	@Test
	public void testOverlaps() {
		Circle2D circle = new Circle2D(0, 0, 4);
		Circle2D circle2 = new Circle2D(0, 0, 1);
		Boolean answer = circle.overlaps(circle2);

		Assert.assertTrue(answer);
	}

}
