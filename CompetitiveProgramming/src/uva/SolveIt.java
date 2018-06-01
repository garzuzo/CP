package uva;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SolveIt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;
		while ((line = in.readLine()) != null) {
			String[] act = line.split(" ");

			String ans = bisection(act);

			System.out.println(ans);
		}

	}

	static String bisection(String[] act) {

		int p = Integer.parseInt(act[0]);
		int q = Integer.parseInt(act[1]);
		int r = Integer.parseInt(act[2]);
		int s = Integer.parseInt(act[3]);
		int t = Integer.parseInt(act[4]);
		int u = Integer.parseInt(act[5]);
		double inf = 0, sup = 1;
		
DecimalFormat df=new DecimalFormat("#.####");
String ant=".";
		while (inf <= sup) {

			double x = (sup + inf) / 2;

			double f = (p * Math.exp(-x)) + (q * Math.sin(x)) + (r * Math.cos(x)) + (s * Math.tan(x)) + (t * (x * x)) + u;
			String answer=df.format(f);
			
			if (answer.equals(ant))
				return x+"";
			else if (f > 0) {

				inf = x;
			} else {
				sup = x;
				
			}
			 ant=answer;
		}

		return "No solution";
	}

}
