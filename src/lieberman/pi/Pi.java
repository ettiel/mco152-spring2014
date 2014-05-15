package lieberman.pi;

public class Pi {

	public Pi() {
		// TODO Auto-generated constructor stub
	}

	public double computePi(int times) {
		double total = 0.0;
		for (int i = 1; i < times; i++) {
			total += ((Math.pow(-1, i + 1)) / (2 * i - 1));
		}
		return total * 4;
	}

	public static void main(String[] args) {
		Pi pi = new Pi();
		System.out.println(pi.computePi(1000000000));

	}

}
