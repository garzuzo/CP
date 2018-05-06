package CFRound479;

import java.io.*;
import java.util.*;

public class lessOrEqual {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nk = lect.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		long[] arr = new long[n];
		String[] sArr = lect.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(sArr[i]);
		}
		Arrays.sort(arr);

		long resp = arr[k] ;
		boolean term = false;
		while (true) {

			if (k + 1 < arr.length && resp < arr[k + 1]) {
				System.out.println(arr[k]);
				esc.write(resp + "\n");
				esc.close();
				break;
			} else if (k + 1 == arr.length) {
				esc.write(-1 + "\n");
				esc.close();
				break;
			}
			k += 1;

		}

		// esc.write(binarySearch(arr, k) + "\n");

	}

	// static int binarySearch(long arr[], int k) {
	//
	// int pos = 0;
	//
	// int inicio = 0;
	// int fin = arr.length - 1;
	//
	// while (inicio < fin) {
	// int mid = (inicio + fin) / 2;
	// if (arr[mid] == k) {
	//
	// return mid;
	// } else if (arr[mid] < k) {
	// inicio = mid + 1;
	// } else {
	// fin = mid - 1;
	// }
	//
	// }
	//
	// return -1;
	// }

}
