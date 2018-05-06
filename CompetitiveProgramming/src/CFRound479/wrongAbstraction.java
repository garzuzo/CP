package CFRound479;

import java.io.*;
import java.util.*;

public class wrongAbstraction {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
Scanner lect=new Scanner(System.in);


int n=lect.nextInt();
String sn=n+"";
int k=lect.nextInt();
String sk=k+"";
		for (int i = 0; i < k; i++) {
			
			if((sn.charAt(sn.length()-1)+"").equals("0")){
				n/=10;
			}else {
				n-=1;
			}
			sn=n+"";
			
		}
	System.out.println(n);
	}

}
