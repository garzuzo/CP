package uva;

import java.io.*;
import java.util.*;

public class PrimeFactory_10789 {

	static boolean[] sieve;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sieve = new boolean[2002];
		sieve();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
in.nextLine();
		for (int i = 0; i < n; i++) {
			LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();
			char[] act = in.nextLine().toCharArray();

			for (char a : act)
				if (lhm.containsKey(a))
					lhm.replace(a, lhm.get(a) + 1);
				else
					lhm.put(a, 1);

			boolean empty = true;
			System.out.print("Case " + (i + 1) + ": ");
			ArrayList<Character> arr=new ArrayList<Character>();
			for (char a : lhm.keySet()) {

				int nAct = lhm.get(a);

				if (!sieve[nAct]) {
					arr.add(a);
					empty = false;
				}

			}
			Collections.sort(arr);
			if (empty)
				System.out.println("empty");
			else {
				
				for(char a:arr)
					System.out.print(a);
				System.out.println();
			}
				

		}
	}

	static public void sieve() {
		sieve[0] = sieve[1] = true;

		for (int i = 2; i < sieve.length; i++) {

			if (!sieve[i])
				for (int j = i * i; j < sieve.length; j += i) {
					sieve[j] = true;
				}
		}

	}

}
