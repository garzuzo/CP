package uva;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SolveIt {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;
		while ((line = in.readLine()) != null) {
			String[] act = line.split(" ");
			double ans = bisection(act);
			DecimalFormat df = new DecimalFormat("0.0000");
			out.write(ans == -1 ? "No solution\n" : df.format(ans) + "\n");
		}
		out.close();
	}

	static double bisection(String[] act) {
		int p = Integer.parseInt(act[0]);
		int q = Integer.parseInt(act[1]);
		int r = Integer.parseInt(act[2]);
		int s = Integer.parseInt(act[3]);
		int t = Integer.parseInt(act[4]);
		int u = Integer.parseInt(act[5]);
		double inf = 0, sup = 1;
		double x = -1;
		double f = 0;
		while (sup - inf > 1E-9) {
			x = (sup + inf) / 2;
			f = (p * Math.exp(-x)) + (q * Math.sin(x)) + (r * Math.cos(x)) + (s * Math.tan(x)) + (t * (x * x)) + u;
			if (f == 0)
				return x;
			else if (f > 0)
				inf = x;
			else
				sup = x;
		}
		if (Math.abs(f) > 1E-6)
			return -1;
		return x;
	}

}
