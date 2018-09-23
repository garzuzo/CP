package CFRound479;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class consecutiveSubsequence {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(lect.readLine());
		int[] arr = new int[n];
		String[] sArr = lect.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sArr[i]);
		}
		System.out.println(lis(arr, n));
	}

	static int lis(int arr[], int n) {

		int lis[] = new int[n];
		int max = 0;

		Arrays.fill(lis, 1);

		HashSet<Integer> solution = new HashSet<Integer>();
		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] >arr[j] && lis[i] < lis[j] + 1) {

					if (arr[i] == arr[j]+1) {
						solution.add(arr[j]);
						lis[i] = lis[j] + 1;
					} else {
						for (int k:solution) {
							if (k == arr[j]) {
								solution.add(arr[j]);
								lis[i] = lis[j] + 1;
								break;
							}
						}
					}

				}

			}
		}

		for (int i = 0; i < lis.length; i++) {
			max = Math.max(lis[i], max);
		}
		for (int i :solution) {
			System.out.print(i+" ");
		}
		System.out.println();

		return max;
	}
}
