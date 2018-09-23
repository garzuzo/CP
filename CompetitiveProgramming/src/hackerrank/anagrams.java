package hackerrank;
import java.io.*;
import java.util.*;
public class anagrams {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);
		char[] a=in.nextLine().toLowerCase().toCharArray();
		char[] b=in.nextLine().toLowerCase().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		boolean flag=true;
		if(a.length!=b.length)
			System.out.println("Not Anagrams");
		else
		for (int i = 0; i < b.length; i++) {
			if(a[i]!=b[i]) {
				System.out.println("Not Anagrams");
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("Anagrams");
	}

}
