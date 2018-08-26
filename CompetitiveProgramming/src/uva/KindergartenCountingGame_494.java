package uva;
import java.io.*;
import java.util.*;

public class KindergartenCountingGame_494 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);
		
		while(in.hasNext()) {
			
			String act=in.nextLine();
			
			act=act.replaceAll("[^a-zA-Z]+"," ").trim();
			//System.out.println(act);
			System.out.println(act.split(" ").length);
		}
	}


}
