package rpc0518;
import java.io.*;
import java.util.*;

public class tboxes {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		int x=2100000555;
		BufferedReader lect=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(lect.readLine());
		String[] ar=lect.readLine().split(" ");
		ArrayList<Long> arr =new ArrayList<Long>();
		long menor=1000000000;
		long mayor=-1;
		for (int i = 0; i < n; i++) {
			long act=Long.parseLong(ar[i]);
	
			if(act<menor)
				menor=act;
			if(act>mayor)
				mayor=act;
			
			esc.write(mayor+menor+"\n");
		}
		esc.flush();
		
	}

}
