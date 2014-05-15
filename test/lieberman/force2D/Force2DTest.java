package lieberman.force2D;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetMagnitude() {
		Force2D force = new Force2D(3, 4);
		double mag = force.getMagnitude();
		double expected = 5.0;

		Assert.assertEquals(expected, mag, .001);
	}

	@Test
	public void testGetAngle() {
		Force2D force = new Force2D(3, 4);
		double angle = force.getAngle();
		double expected = 53.13;
		Assert.assertEquals(expected, angle, .001);
	}

	@Test
	public void testAdd() {
		Force2D force1 = new Force2D(2, 6);
		Force2D force2 = new Force2D(3, 6);
		Force2D other = force1.add(force2);
		double bothXs = force1.getX() + force2.getX();
		double bothYs = force1.getY() + force2.getY();
		double otherX = other.getX();
		double otherY = other.getY();

		Assert.assertEquals(bothXs, otherX, .001);
		Assert.assertEquals(bothYs, otherY, .001);

	}
}
