package lieberman.prime;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	public Prime() {

	}

	public boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false; // number is divisible so its not prime
			}
		}
		return true;

	}

	public List<Integer> computePrime(int times) {

		List<Integer> primes = new ArrayList<>();

		for (int i = 1; i < times; i++) {
			if (isPrime(i)) {
				primes.add(i);

			}
		}
		return primes;

	}

	public static void main(String[] args) {
		Prime prime = new Prime();
		System.out.println(prime.computePrime(100000));

	}

}
