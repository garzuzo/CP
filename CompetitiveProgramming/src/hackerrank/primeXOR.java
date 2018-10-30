package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class primeXOR {

	static boolean[] sieve;
	static long mod=1000000007;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		HashMap<Long,Long> hm=new HashMap<Long,Long>();
		
		
		int n=21313;
		n^=43;
		
	}
	
	
	static void sieve() {
		sieve=new boolean[4600];
		sieve[0]=sieve[1]=true;
		
		for (int i = 2; i*i < sieve.length; i++) {
			
			if(sieve[i])
			for (int j = i; j < sieve.length; j+=i) {
				sieve[j]=true;
			}
		}
		
		
	}

}
