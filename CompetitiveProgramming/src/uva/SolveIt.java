package uva;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SolveIt {

	static double eps=0.00000001;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;
		while ((line = in.readLine()) != null) {
			String[] act = line.split(" ");

			double ans = bisection(act);
			DecimalFormat df = new DecimalFormat("0.0000");

			out.write(ans == -1 ? "No solution\n" : df.format(ans)+"\n");
			System.out.print(ans == -1 ? "No solution\n" : df.format(ans)+"\n");
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

	
		//DecimalFormat df = new DecimalFormat("0.0000");
		//String ant = ".";
		int cont = 0;
		while (inf <= sup) {
			cont++;
			double x = (sup + inf) / 2;

			double f = (p * Math.exp(-x)) + (q * Math.sin(x)) + (r * Math.cos(x)) + (s * Math.tan(x)) + (t * (x * x))
					+ u;
		//	String answer = df.format(f);

			if (cont==40 || f == 0) {
			//	System.out.println("answ:"+f+"cont:"+cont);
if(f<1)
				return x;
else return -1;

			} else if (f > 0) {

				inf = x;
			} else {
				sup = x;

			}
			//ant = answer;
		}

		return -1;
	}

}
