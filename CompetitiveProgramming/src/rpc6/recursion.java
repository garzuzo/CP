package rpc6;



import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class recursion {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// String r = "";
		// Pattern p = Pattern.compile("[amor]*");
		// Matcher m = p.matcher(r);
		// System.out.println(m.groupCount());
		// while(m.find()) {
		// System.out.print("s:"+m.start());
		// System.out.print(" e:"+m.end());
		// System.out.println();

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for (int i = 0; i < n; i++) {

			double r = in.nextInt();
			double k = in.nextInt();
			double a = 0;
			boolean circle = true;
			if(k==1)
				System.out.println((int)(r*r)+ "PI");
			for (int j = 1; j < k; j++) {

				if (circle) {
					a = 2 * r * 2 * r;

					circle = false;
					if (j + 1 == k)
						System.out.println((long)a);
				} else {
					double newR = 2 * r;

					double aCircle = newR * newR + newR * newR;
					r=Math.sqrt(aCircle)/2;
					
					aCircle /= 4;

					circle = true;
					if (j + 1 == k)
						System.out.println((long)(aCircle) + "PI");
				}

			}

		}

	}

}