package HackerCup;

import java.io.*;
import java.util.*;

public class ProgressPie {

	static double eps=10e-6;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for (int i = 1; i <= n; i++) {

			double p = in.nextInt();
			double x = in.nextInt();
			double y = in.nextInt();

			double angle = ((double) p / 100) * 360;
			double op = (double) (Math.tan((Math.PI/180)*angle));
			op *= x;
			System.out.print("Case #" + i + ": ");
			System.out.println(op-y>=eps ? "black" : "white");
		}
	}

}
