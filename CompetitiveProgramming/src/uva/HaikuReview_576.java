package uva;

import java.io.*;
import java.util.*;

public class HaikuReview_576 {

	public static void main(String[] args) throws Exception {
	

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String answ = in.nextLine();
			if (answ.equals("e/o/i"))
				break;
			answ = answ.replaceAll("[\\sa-z&&[^aeiouy]]", " ");
			answ = answ.replaceAll("\\s+", " ");
			String[] act = answ.split("/");
			String[] act1 = act[0].split(" ");
			String[] act2 = act[1].split(" ");
			String[] act3 = act[2].split(" ");
			int cont1 = 0;
			int cont2 = 0;
			int cont3 = 0;
			for (String cAct : act1) {

				if (cAct.matches("[aeiouy]+"))
					cont1++;
			}

			for (String cAct : act2) {

				if (cAct.matches("[aeiouy]+"))
					cont2++;
			}
			for (String cAct : act3) {

				if (cAct.matches("[aeiouy]+"))
					cont3++;
			}
			if (cont1 != 5) {
				System.out.println("1");
			} else if (cont2 != 7)
				System.out.println("2");
			else if (cont3 != 5)
				System.out.println("3");
			else
				System.out.println("Y");
		}
	}

}
