package lieberman.homework;

public class Circle2D {

	private final Double x;
	private final Double y;
	private final Double radius;

	public Circle2D() {
		this.x = 0.0;
		this.y = 0.0;
		this.radius = 1.0;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public String getCenter() {
		return getX() + "," + getY();
	}

	public double getRadius() {
		return this.radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	public boolean contains(double x, double y) {
		double pointA = (x - this.x) * (x - this.x);
		double pointB = (y - this.y) * (y - this.y);
		return Math.sqrt(pointA + pointB) < radius;
	}

	public boolean contains(Circle2D circle) {
		double pointA = (x - circle.x) * (x - circle.x);
		double pointB = (y - circle.y) * (y - circle.y);
		double sum = pointA + pointB;
		return Math.sqrt(sum) + circle.getRadius() < this.radius;
	}

	public boolean overlaps(Circle2D circle) {
		double pointA = (x - circle.x) * (x - circle.x);
		double pointB = (y - circle.y) * (y - circle.y);
		double sum = pointA + pointB;
		return Math.sqrt(sum) < circle.radius + this.radius;
	}

}
