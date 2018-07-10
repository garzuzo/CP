package kattis;

import java.io.*;
import java.util.*;

public class balancedDiet {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);
		int n;
		while((n=in.nextInt())!=0) {
			
			int[] arr=new int[n];
			for (int i = 0; i < n; i++) {
				arr[i]=in.nextInt();
				
			}
			Arrays.sort(arr);
			int cont1=0;
			int cont2=0;
			boolean flag=true;
			for (int i = 0; i < arr.length; i++) {
				
				if(flag) {
					cont1+=arr[i];
					flag=false;
				}else {
					cont2+=arr[i];
					flag=true;
				}
				
			}
			System.out.println(cont1+" "+cont2);
		}
	}

}
