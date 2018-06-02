package kattis;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class needForSpeed {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nt = in.readLine().split(" ");

		int n = Integer.parseInt(nt[0]);
		int t = Integer.parseInt(nt[1]);

		ds[] arr = new ds[n];
	
		double min=-1e9;
		for (int i = 0; i < n; i++) {
			String[] act = in.readLine().split(" ");
			arr[i] = new ds(Integer.parseInt(act[0]), Integer.parseInt(act[1]));
			min =Math.max(min, -arr[i].s);
		}

		out.write(new DecimalFormat("0.000000000").format(binarySearch(arr, t, min)) + "\n");
		out.close();
	}

	static double binarySearch(ds[] arr, int t,double min) {

		 double max = 1e9;

		double c = (min + max) / 2;

		while (max - min >= 1e-9) {
			c = (min + max) / 2;

			double answ = 0;
			for (int i = 0; i < arr.length; i++) {
				ds dsAct = arr[i];
				int di = dsAct.d;
				int si = dsAct.s;
				answ += di / (si + c);
			}
			if (answ == t)
				return c;
			else if (answ < t) {
				max = c;
			} else {
				min = c;
			}

		}

		return c;
	}

}

class ds {

	int d;
	int s;

	public ds(int d, int s) {
		this.d = d;
		this.s = s;
	}

}
