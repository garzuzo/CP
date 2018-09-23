package uva;

import java.io.*;
import java.util.*;

public class intersection_191 {

	static double eps = 0.00000001;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();

			line l1 = new line(x1, y1, 0);

			int x21 = in.nextInt();
			int y21 = in.nextInt();
			int x22 = in.nextInt();
			int y22 = in.nextInt();
			line l21 = new line(x21, y21, 0);
			line l22 = new line(x22, y22, 0);
			line l23 = new line(x22, y21, 0);
			line l24 = new line(x21, y22, 0);

			boolean answ = areIntersect(l1, l21, new point(x1, y1)) || areIntersect(l1, l22, new point(x1, y1))
					|| areIntersect(l1, l23, new point(x1, y1)) || areIntersect(l1, l24, new point(x1, y1));
			System.out.println(answ?"Y":"N");
		}

	}

	static boolean areIntersect(line l1, line l2, point p) {

		if (areParallel(l1, l2))
			return false;

		p.x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);

		if (Math.abs(l1.b) > eps)
			p.y = -(l1.a * p.x + l1.c);
		else
			p.y = -(l2.a * p.x + l2.c);

		return true;
	}

	static boolean areParallel(line l1, line l2) {
		return (Math.abs(l1.a - l2.a) < eps) && (Math.abs(l1.b - l2.b) < eps);
	}

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class line {

		int a;
		int b;
		int c;

		public line(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;

		}

	}
}
