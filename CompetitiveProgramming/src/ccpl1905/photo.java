package ccpl1905;
import java.io.*;
import java.util.*;

public class photo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		//String linea=br.readLine();
		
		//int n=Integer.parseInt(linea);
		int n=100;
		long D[]=new long[n];
		D[0]=D[1]=D[2]=1;
		D[3]=D[4]=2;
		
				for (int i = 5; i <D.length; i++) {
					D[i]=D[i-1]+D[i-3]+D[i-5];
				}
				
				for (int i = 0; i < D.length; i++) {
					System.out.println(i+":"+D[i]);
				}
	}

}
