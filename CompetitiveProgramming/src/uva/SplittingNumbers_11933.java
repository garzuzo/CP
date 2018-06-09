package uva;

import java.util.BitSet;
import java.io.*;
import java.util.*;

public class SplittingNumbers_11933 {

	public static void main(String[] args) throws Exception {
	

		// System.out.println(Integer.parseInt("11111010101", 2));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n != 0) {

			int a = 0;
			int b = 0;
			String nAct = Integer.toBinaryString(n);

			boolean change = false;
			for (int i = nAct.length() - 1, j = 0; i >= 0; i--, j++) {

				String act = nAct.charAt(i) + "";
				if (act.equals("1")) {
					if (!change) {

						a |= 1 << j;
						change = true;
					} else {
						b |= 1 << j;
						change = false;

					}
				}

			}

			System.out.println(a + " " + b);

			n = in.nextInt();
		}

	}

}
