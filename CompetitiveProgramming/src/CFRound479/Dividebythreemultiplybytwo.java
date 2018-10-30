package CFRound479;

import java.io.*;
import java.util.*;

public class Dividebythreemultiplybytwo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		lect.readLine();
		String[] ar = lect.readLine().split(" ");
		num[] resp = new num[ar.length];
		for (int i = 0; i < ar.length; i++) {

			int act = Integer.parseInt(ar[i]);
			if (act % 3 == 0)
				act /= 3;
			act *= 2;
			resp[i] = new num(act);
		}
	
		//Arrays.sort(resp);

		for (int i = 0; i < resp.length; i++) {
			System.out.print(resp[i].act+" ");
			if (i + 1 != resp.length)
				esc.write(resp[i].act + " ");
			else
				esc.write(resp[i].act);
		}
		//esc.close();

	}

}

class num implements Comparable<num> {

	int act;

	public num(int act) {
		this.act = act;
	}

	

	@Override
	public int compareTo(num o2) {
		// TODO Auto-generated method stub
		return o2.act / 3 ==act ? 1 : act * 2 == o2.act ? 1 : -1;
	}
}
