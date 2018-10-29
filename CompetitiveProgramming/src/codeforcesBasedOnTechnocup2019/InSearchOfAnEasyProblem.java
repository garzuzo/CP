package codeforcesBasedOnTechnocup2019;
import java.io.*;
import java.util.*;

public class InSearchOfAnEasyProblem {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(in.readLine());
		
		String arr=in.readLine();
		if(arr.contains("1"))
			System.out.println("HARD");
		else
			System.out.println("EASY");
		
	}

}
