package CFRound479;

import java.io.*;
import java.util.*;

public class friendsAndCookies {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for (int i = 0; i < n; i++) {

			double x = in.nextInt();
			double a = in.nextInt();

			int answ =(int) Math.ceil(x / a);

			for (int j = 0; j < a; j++) {
				while (answ > x)
					answ--;

				if (j + 1 != a) {

					System.out.print(answ + " ");
					x -= answ;
				} else
					System.out.print(answ);

			}
			System.out.println();

		}
	}

}
