package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class alienUsername {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {

			boolean act = in.readLine().matches("^[\\_|\\.]\\d+[a-zA-Z]*\\_?$");
			if (act)
				System.out.println("VALID");
			else
				System.out.println("INVALID");
		}
		
	}

}
