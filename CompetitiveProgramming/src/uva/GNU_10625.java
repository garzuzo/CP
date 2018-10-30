package uva;

import java.io.*;
import java.util.*;

public class GNU_10625 {

	static LinkedHashMap<String, String> hm;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nCases = Integer.parseInt(in.readLine());
		for (int i = 0; i < nCases; i++) {
			hm = new LinkedHashMap<String, String>();

			int nAct = Integer.parseInt(in.readLine());
			for (int j = 0; j < nAct; j++) {
				String act[] = in.readLine().split("->");
				hm.put(act[0], act[1]);

			}
			int q = Integer.parseInt(in.readLine());
			for (int j = 0; j < q; j++) {

				String qAct[] = in.readLine().split(" ");

				String s = qAct[0];
				String x = qAct[1];
				int n = Integer.parseInt(qAct[2]);
				System.out.println(re(s, x, n));
			}
		}
	}

	static long re(String s, String x, int n) {

		int size = hm.size();
		for (int i = 0; i < n; i++) {
			for (String act : hm.keySet()) {
				char a=1;
				char b=2;
				s = s.replaceAll("["+act+"]", hm.get(act));
				
			}
			System.out.println(s);
		}
		
		return s.split(x).length;
	}

}
