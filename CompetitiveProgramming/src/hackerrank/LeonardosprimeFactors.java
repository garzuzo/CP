package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class LeonardosprimeFactors {

	static boolean sieve[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		sieve();
		prime[] arr = new prime[17];
		for (int i = 0, j = 0; i < 60; i++) {
			if (!sieve[i]) {
				prime act = new prime(i, new BigInteger(i + ""));
				arr[j] = act;
				if (j > 0)
					arr[j].mult = arr[j].mult.multiply(arr[j - 1].mult);
				// System.out.println(arr[j].mult);
				j++;
			}
		}

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			BigInteger act = in.nextBigInteger();
			for (int j = arr.length - 1; j >= 0; j--) {
				if (act.equals(BigInteger.ONE)) {
					System.out.println(0);
					break;
				} else if (arr[j].mult.compareTo(act) <= 0) {
					System.out.println(j + 1);
					break;
				}
			}
		}
	}

	static void sieve() {
		sieve = new boolean[1000001];
		sieve[0] = sieve[1] = true;
		for (int i = 2; i * i < sieve.length; i++) {

			if (!sieve[i])
				for (int j = i * i; j < sieve.length; j += i)
					sieve[j] = true;

		}
	}

	static class prime {

		long primeNum;
		BigInteger mult;

		public prime(long primeNum, BigInteger mult) {
			this.primeNum = primeNum;
			this.mult = mult;
		}

	}

}
