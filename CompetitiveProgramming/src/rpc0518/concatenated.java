package rpc0518;

import java.io.*;
import java.util.*;

public class concatenated {

	static boolean[] sieve = new boolean[10000001];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		String caso;
		sieve();
		while((caso=lect.readLine())!=null) {
			
			String casoAct[]=caso.split(" ");
			int k=Integer.parseInt(casoAct[0]);
						
			StringBuilder sb=new StringBuilder((casoAct[1]));
			boolean cumple=true;
			for (int i = 0; i < sb.length() && cumple; i+=k) {
				String act=sb.subSequence(i, k+i).toString();
				
				//System.out.println(sieve[Integer.parseInt(act)]);
				if(sieve[Integer.parseInt(act)]) {
					cumple=false;
				}
			}
		
			esc.write(cumple?":)\n":":(\n");
		
			//System.out.println("______");
			
			
		}
		esc.flush();
	}

	static void sieve() {

		sieve[0] = true;
		sieve[1] = true;

		for (int i = 2; i * i <= sieve.length; i++) {

			if (!sieve[i]) {
				for (int j = i * i; j <= sieve.length; j += i) {
					sieve[j] = true;
				}
			}
		}

	}

}
