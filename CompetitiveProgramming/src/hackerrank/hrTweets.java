package hackerrank;
import java.io.*;
import java.util.*;

public class hrTweets {

    public static void main(String[] args)throws Exception {
       
    	 BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
         int n=Integer.parseInt(in.readLine());
         int cont=0;
         for(int i=0;i<n;i++){
             
            boolean line=(in.readLine().toLowerCase()).matches(".*hackerrank.*");
             
             if(line)
             cont++;
         }
         System.out.println(cont);
     }
}