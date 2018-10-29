package codeforcesBasedOnTechnocup2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VasyaAndCornfield {
	/*
	 * A utility function to calculate area of triangle formed by (x1, y1), (x2, y2)
	 * and (x3, y3)
	 */
	static float area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (float) Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	/*
	 * A function to check whether point P(x, y) lies inside the rectangle formed by
	 * A(x1, y1), B(x2, y2), C(x3, y3) and D(x4, y4)
	 */
	static boolean check(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x, int y) {

		/* Calculate area of rectangle ABCD */
		float A = area(x1, y1, x2, y2, x3, y3) + area(x1, y1, x4, y4, x3, y3);

		/* Calculate area of triangle PAB */
		float A1 = area(x, y, x1, y1, x2, y2);

		/* Calculate area of triangle PBC */
		float A2 = area(x, y, x2, y2, x3, y3);

		/* Calculate area of triangle PCD */
		float A3 = area(x, y, x3, y3, x4, y4);

		/* Calculate area of triangle PAD */
		float A4 = area(x, y, x1, y1, x4, y4);

		/*
		 * Check if sum of A1, A2, A3 and A4 is same as A
		 */
		return (A == A1 + A2 + A3 + A4);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] nd = in.readLine().split(" ");

		int n = Integer.parseInt(nd[0]);
		int d = Integer.parseInt(nd[1]);

		point p1 = new point(0, d);
		point p2 = new point(d, 0);
		point p3 = new point(n, n - d);
		point p4 = new point(n - d, n);

		int m = Integer.parseInt(in.readLine());
		for (int i = 0; i < m; i++) {

			String[] act = in.readLine().split(" ");
			point pointAct = new point(Integer.parseInt(act[0]), Integer.parseInt(act[1]));

			boolean ret=check(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y, pointAct.x, pointAct.y);

			if(ret)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	static class point {
		int x;
		int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
