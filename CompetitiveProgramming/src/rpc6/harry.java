package rpc6;

import java.io.*;
import java.util.*;

public class harry {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			if (i > 0)
				out.write("\n");
			String act = in.nextLine();
			while (!act.equals("*")) {

				String[] arrAct = act.split("");

				StringTokenizer st = new StringTokenizer(act);
				int upper = 0;
				StringBuilder outAct = new StringBuilder();
				String stAct = "";
				for (int j = 0; j < arrAct.length; j++) {
					if (arrAct[j].equals(" ")) {
						outAct.append(" ");
					} else {
						while(j<arrAct.length &&!arrAct[j].equals(" ")){
							j++;
						}
						j--;
						stAct = st.nextToken();

						if (upper == 0) {
							stAct = stAct.toLowerCase();

							upper++;
							if (stAct.contains("’")) {
								String[] stActCase = stAct.split("’");

								StringBuilder sb = new StringBuilder(stActCase[0]);
								stAct = sb.reverse().replace(0, 1, (sb.charAt(0) + "").toUpperCase()).toString();
								outAct.append(stAct + "’");
								if (stActCase.length > 1) {
									sb = new StringBuilder(stActCase[1]);

									if (stActCase[1].contains(",")) {
										stActCase[1] = stActCase[1].replace(",", "");
										sb = new StringBuilder(stActCase[1]);
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1 + ",");

									} else if (stActCase[1].contains(".")) {
										stActCase[1] = stActCase[1].replace(".", "");
										sb = new StringBuilder(stActCase[1]);
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1 + ".");

									} else if (stActCase[1].contains(";")) {
										stActCase[1] = stActCase[1].replace(";", "");
										sb = new StringBuilder(stActCase[1]);
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1 + ";");

									} else {
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1);
									}
								}

							} else if (stAct.contains(",")) {
								String[] stActCase = stAct.split(",");

								StringBuilder sb = new StringBuilder(stActCase[0]);
								stAct = sb.reverse().replace(0, 1, (sb.charAt(0) + "").toUpperCase()).toString();
								outAct.append(stAct + ",");

							} else if (stAct.contains(";")) {
								String[] stActCase = stAct.split(";");

								StringBuilder sb = new StringBuilder(stActCase[0]);
								stAct = sb.reverse().replace(0, 1, (sb.charAt(0) + "").toUpperCase()).toString();
								outAct.append(stAct + ";");

							} else if (stAct.contains(".")) {

								stAct = stAct.replace(".", "");

								StringBuilder sb = new StringBuilder(stAct);
								stAct = sb.reverse().replace(0, 1, (sb.charAt(0) + "").toUpperCase()).toString();
								outAct.append(stAct + ".");
							} else {
								StringBuilder sb = new StringBuilder(stAct);
								stAct = sb.reverse().replace(0, 1, (sb.charAt(0) + "").toUpperCase()).toString();
								outAct.append(stAct);

							}
						} else {
							if (stAct.contains("’")) {
								String[] stActCase = stAct.split("’");

								StringBuilder sb = new StringBuilder(stActCase[0]);

								stAct = sb.reverse().toString();
								outAct.append(stAct + "’");
								if (stActCase.length > 1) {
									sb = new StringBuilder(stActCase[1]);

									if (stActCase[1].contains(",")) {
										stActCase[1] = stActCase[1].replace(",", "");
										sb = new StringBuilder(stActCase[1]);
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1 + ",");

									} else if (stActCase[1].contains(".")) {
										stActCase[1] = stActCase[1].replace(".", "");
										sb = new StringBuilder(stActCase[1]);
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1 + ".");

									} else if (stActCase[1].contains(";")) {
										stActCase[1] = stActCase[1].replace(";", "");
										sb = new StringBuilder(stActCase[1]);
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1 + ";");

									} else {
										String stAct1 = sb.reverse().toString();
										outAct.append(stAct1);
									}
								}

							} else if (stAct.contains(",")) {
								String[] stActCase = stAct.split(",");

								StringBuilder sb = new StringBuilder(stActCase[0]);
								stAct = sb.reverse().toString();
								outAct.append(stAct + ",");

							} else if (stAct.contains(";")) {
								String[] stActCase = stAct.split(";");

								StringBuilder sb = new StringBuilder(stActCase[0]);
								stAct = sb.reverse().toString();
								outAct.append(stAct + ";");

							} else if (stAct.contains(".")) {

								stAct = stAct.replace(".", "");

								StringBuilder sb = new StringBuilder(stAct);
								stAct = sb.reverse().toString();
								outAct.append(stAct + ".");
							} else {
								StringBuilder sb = new StringBuilder(stAct);
								stAct = sb.reverse().toString();
								outAct.append(stAct);

							}

						}
					}

				}
				// outAct.append(stAct.trim());
				out.write(outAct + "\n");
				act = in.nextLine();
			}
			out.flush();

		}

	}

}
