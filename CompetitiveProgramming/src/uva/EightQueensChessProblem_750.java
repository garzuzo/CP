package uva;

import java.io.*;
import java.util.*;

public class EightQueensChessProblem_750 {

	static TreeSet<String> ts;
	static int actQueen;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			
			
			in.readLine();
			out.write("SOLN       COLUMN\n");
			out.write(" #      1 2 3 4 5 6 7 8\n\n");
			String qAct[] = in.readLine().split(" ");

			int rowAct = Integer.parseInt(qAct[0]) - 1;
			int colAct = Integer.parseInt(qAct[1]) - 1;

			int[] board = new int[8];
			Arrays.fill(board, -1);
			board[colAct] = rowAct;
			actQueen = colAct;
			ts = new TreeSet<String>();
			backtracking(board, 0, false);
			int cont = 1;
			for (String ret : ts) {
				if(cont<10)
				out.write(" ");
				out.write(cont + "      " + ret + "\n");
				cont++;
			}
			if(i+1!=n)
				out.write("\n");
			

		}
		out.close();

	}

	static void backtracking(int[] board, int etapa, boolean finished) {

		if (finished) {

			StringBuilder answ = new StringBuilder();
			for (int i = 0; i < board.length; i++) {
				if (i + 1 != board.length)
					answ.append(board[i] + 1 + " ");
				else
					answ.append(board[i] + 1);
			}
			ts.add(answ.toString());
		} else {

			int col1 = etapa;

			for (int i = 0; i < board.length; i++) {
				if (etapa != actQueen)
					board[etapa] = i;
				//else
					//i = board.length - 1;

				int row1 = i;

				boolean flag = false;
				int cont = 0;
				for (int j = 0; j < board.length && !flag; j++) {

					int col2 = j;
					int row2 = board[j];
					if (row2 != -1 && col1 != col2)
						if ((row2 == row1 || (Math.abs(col2 - col1) == Math.abs(row1 - row2)))) {
							flag = true;

						} else {
							cont++;
						}

				}

				if (!flag)
					if (etapa + 1 != board.length && cont != board.length - 1) {
						backtracking(board, etapa + 1, finished);
					} else if (cont == board.length - 1) {
						backtracking(board, etapa, true);
					}

			}
			if (etapa != actQueen)
				board[etapa] = -1;
		}
	}

}
