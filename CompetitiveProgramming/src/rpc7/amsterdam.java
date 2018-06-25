package rpc7;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class amsterdam {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int m = in.nextInt();
		int n = in.nextInt();
		double r = in.nextFloat() / n;

		if (r <= 0 || m <= 0 || n <= 0)
			System.out.println(0);
		else {
			point source = new point(in.nextInt(), in.nextInt());
			point end = new point(in.nextInt(), in.nextInt());

			double manhattan = Math.abs(end.y - source.y) * r;// Math.abs(source.x - manh.x) + Math.abs(source.y -
																// manh.y);

			double segm = 180 / m;

			double angle = Math.abs(end.x - source.x) * segm;

			double radius = r * end.y;
			double arc = (Math.PI * angle * radius) / 180;

			double opt2 = (source.y + end.y) * r;
			double answ = manhattan + arc;
			// DecimalFormat df = new DecimalFormat("0.000000000000000");
			if (opt2 < answ) {
				if (opt2 == 0)
					System.out.println(0);
				else
					System.out.println(opt2);
			} else {
				if (answ == 0)
					System.out.println(0);
				else
					System.out.println(answ);
			}
		}

	}

	static class point {

		int x;
		int y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
