package uva;


import java.io.*;
import java.util.*;

public class IdentifyingLegalPascalRealConstants {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			
			String act=in.nextLine();
			
			if(act.equals("*"))break;
			act=act.trim();
			boolean answ=act.matches("[+-]?\\d+(\\.\\d+([eE][+-]?\\d+)?|[eE][+-]?\\d+)");
			System.out.println(act+(answ?" is legal.":" is illegal."));
		}
		
	}

}
