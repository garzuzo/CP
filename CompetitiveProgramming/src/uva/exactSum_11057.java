package uva;

import java.io.*;
import java.util.*;

public class exactSum_11057 {

	static HashSet<pair> hs;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}

			int val = in.nextInt();
			Arrays.sort(arr);
			binarySearch(arr, val);
			int min = 1000000000;
			pair answ=null;
			for (pair act : hs) {
				if(Math.abs(act.x-act.y)<min) {
					answ=act;
					min=Math.abs(act.x-act.y);
				}
				

			}
			System.out.println("Peter should buy books whose prices are "+answ.x+" and "+answ.y+".");
			System.out.println();
			in.nextLine();

		}
	}

	static void binarySearch(int[] arr, int val) {

		hs = new HashSet<pair>();

		for (int i = 0; i < arr.length; i++) {
			int max = arr.length-1;
			int min = 0;
			int act = arr[i];
			while (min <= max) {

				int mid = (max + min) / 2;

				if (arr[mid] + act == val && mid!=i) {
					hs.add(new pair(arr[mid],act));
					break;
				} else if (arr[mid] + act < val) {

					min = mid + 1;

				} else {
					max = mid - 1;
				}

			}
		}
	}

	static class pair {
		int x;
		int y;

		pair(int x, int y) {
			if(x<y) {
				this.x = x;
				this.y = y;
			}else {
				this.x = y;
				this.y = x;
			}
			
		}
	}

}
