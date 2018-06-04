package uva;

import java.io.*;
import java.util.*;

public class TellMeTheFrequencies {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
int cont=0;
		while (in.hasNext()) {
			if(cont!=0)
				System.out.println();
			TreeMap<Character, Integer> hm = new TreeMap<Character, Integer>();
			char[] act = in.nextLine().toCharArray();
			for (char cAct : act) {
				if (hm.containsKey(cAct)) {
					hm.replace(cAct, hm.get(cAct) + 1);
				} else {
					hm.put(cAct, 1);
				}
			}
		ArrayList<pair> arr=new ArrayList<pair>();
		
			
			for (char cAct : hm.keySet()) {
				pair pAct=new pair(cAct,hm.get(cAct));
				arr.add(pAct);
				
			}
			Collections.sort(arr);
			for (int i = 0; i < arr.size(); i++) {
pair pAct=arr.get(i);				
				System.out.println((int)pAct.val.charValue() + " " + pAct.freq);
			}
			
cont++;
		}
	}
	static class pair implements Comparable<pair>{
		
		Character val;
		int freq;
	
		public pair(Character val, int freq) {
			this.val=val;
			this.freq=freq;
		}
		@Override
		public int compareTo(pair p1) {
			// TODO Auto-generated method stub
			return freq>p1.freq?1:freq>p1.freq?-1:val>p1.val?-1:1;
		}
		
		
	}

}
