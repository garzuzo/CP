package codeforces;
import java.io.*;
import java.util.*;

public class IntenseBitWheel {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);

int n=in.nextInt();
int m=in.nextInt();
BitSet bs=new BitSet(n);
BitSet bs1=new BitSet(n);
bs1.set(n,true);

bs.set(2);
for (int i = 0; i < m; i++) {
	
	String num=Long.toBinaryString(in.nextLong());
	int num1=Integer.parseInt(num);
	for (int j = 0; j < num.length(); j++) {
		if(num.charAt(j)=='1') 
			bs.set(j);	
	}

	int k=in.nextInt()%n;
	for (int j = 0; j < k; j++) {
		num1=num1<<1;
	}
	String ret=Integer.toString(num1, 10);
	
	bs.clear();
}





	}

}
