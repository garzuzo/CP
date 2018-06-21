package rpc6;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class robot {

	//static boolean[][] matrix;
	static int cont;
	static int n1;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);



int numQ=in.nextInt();
for (int i = 0; i < numQ; i++) {
int n=in.nextInt();	
n1=n;
	 boolean[][] matrix=new boolean[n+1][n+1];
	 cont=0;
	 dfs(0, 0,matrix);
	 System.out.println(cont);
	
	// p.flags();
	//System.out.println(r.matches("[a|b]*"));
}
	}

	static void dfs(int i,int j,boolean[][]matrix) {
		
		if(!matrix[i][j]) {
		//	cont++;
			matrix[i][j]=true;
			//cont++;
			dfs(i, j,matrix);
		}
		 if(i<n1&&!matrix[i+n1][j]) {
			cont++;
			matrix[i+n1][j]=true;
			dfs(i+n1, j,matrix);
			//matrix[i+n1][j]=false;
		} if(j<n1&&!matrix[i][j+n1]) {
			matrix[i][j+n1]=true;
			cont++;
			dfs(i, j+n1,matrix);
			//matrix[i][j+n1]=false;
			
		} if(i>0&&!matrix[i-n1][j]) {
			cont++;
			matrix[i-n1][j]=true;
			dfs(i-n1, j,matrix);
			//matrix[i-n1][j]=false;
		} if(j>0&&!matrix[i][j-n1]) {
			cont++;
			matrix[i][j-n1]=true;
			dfs(i, j-n1,matrix);
			//matrix[i][j-n1]=false;
		}
		//diagonals
		 if(j>0&&i<n1&&!matrix[i+n1][j-n1]) {
			cont++;
			matrix[i+n1][j-n1]=true;
			dfs(i+n1, j-n1,matrix);
			//	matrix[i+n1][j-n1]=false;
		}
		 if(j>0&&i>0&&!matrix[i-n1][j-n1]) {
			cont++;
			matrix[i-n1][j-n1]=true;
			dfs(i-n1, j-n1,matrix);
			//matrix[i-n1][j-n1]=false;
		}
		 if(i>0&&j<n1&&!matrix[i-n1][j+n1]) {
			cont++;
			matrix[i-n1][j+n1]=true;
			dfs(i-n1, j+n1,matrix);
			//	matrix[i-n1][j+n1]=false;
		}
		 if(j<n1&&i<n1&&!matrix[i+n1][j+n1]) {
			cont++;
			matrix[i+n1][j+n1]=true;
			dfs(i+n1, j+n1,matrix);
			//matrix[i+n1][j+n1]=false;
		}
		
	}
}
