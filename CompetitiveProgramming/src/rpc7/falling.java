package rpc7;

import java.io.*;
import java.util.*;

public class falling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr.add(in.nextInt());
		}
		Collections.sort(arr, Collections.reverseOrder());

		int a = 0;
		int b = 0;
		boolean flag = true;
		for (int i = 0; i < arr.size(); i++) {

			if (flag) {
				a += arr.get(i);
				flag = false;
			} else {
				b += arr.get(i);

				flag = true;
			}

		}
		System.out.println(a+" "+b);
	}

}
