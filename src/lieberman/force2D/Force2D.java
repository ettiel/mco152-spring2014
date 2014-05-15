package lieberman.force2D;

public class Force2D {

	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		double sum = (x * x) + (y * y);
		return Math.sqrt(sum);

	}

	public double getAngle() {
		double angle = Math.toDegrees(Math.atan2(y, x));
		return angle;
	}

	public Force2D add(Force2D force) {
		double a = this.x + force.x;
		double b = this.y + force.y;
		Force2D newForce = new Force2D(a, b);
		return newForce;
	}

}
