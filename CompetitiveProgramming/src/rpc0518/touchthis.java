package rpc0518;

import java.io.*;
import java.util.*;

public class touchthis {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner(System.in);

		int t = lect.nextInt();

		for (int i = 0; i < t; i++) {
			int n = lect.nextInt();

			point[] puntos = new point[n];

			for (int j = 0; j < n; j++) {

				int x = lect.nextInt();
				int y = lect.nextInt();

				point pAct = new point();
				pAct.x = x;
				pAct.y = y;
				puntos[n] = pAct;

			}

			for (int j = 0; j < n; j++) {

				for (int k = j + 1; k < n - 1; k++) {

					point p1=puntos[j];
					point p2=puntos[k];
					
					line lAct1=new line();
					line lAct2=new line();
					
					lAct1.areIntersect(lAct1, lAct2, p1);
				}
			}
		}
	}

}

class line {
	private final static double EPS = 0.00001;
	int a, b, c;

	public boolean areParallel(line l1, line l2) {

		return (Math.abs(l1.a - l2.a) < EPS) && (Math.abs(l1.b - l2.b) < EPS);
	}

	public boolean areIntersect(line l1, line l2, point p) {

		// returns true (+ intersection point) if two lines are intersect
		if (areParallel(l1, l2))
			return false;

		// no intersection
		// solve system of 2 linear algebraic equations with 2 unknowns
		p.x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);
		// special case: test for vertical line to avoid division by zero
		if (Math.abs(l1.b) > EPS)
			p.y = -(l1.a * p.x + l1.c);
		else
			p.y = -(l2.a * p.x + l2.c);
		return true;
	}
}

class point {
	int x;
	int y;

}
