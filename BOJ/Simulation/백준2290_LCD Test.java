//백준 2290 LCD Test
package Practice;

import java.io.*;
import java.util.*;

public class bj2290 {

	static final int c[][] = {
			{1,1,1,0,1,1,1}, //0
			{0,0,1,0,0,1,0}, //1
			{1,0,1,1,1,0,1}, //2
			{1,0,1,1,0,1,1}, //3
			{0,1,1,1,0,1,0}, //4
			{1,1,0,1,0,1,1}, //5
			{1,1,0,1,1,1,1}, //6
			{1,0,1,0,0,1,0}, //7
			{1,1,1,1,1,1,1}, //8
			{1,1,1,1,0,1,1} //9
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

		  for (int i=0; i<5; i++) { 
			  if(i==0 || i==2 || i==4 ) { //row 부분 처리
				  for(int j=0; j<n.length(); j++) {
					  int now = n.charAt(j) - '0';
					  if(j != 0) {
						  System.out.print(" ");
					  }
					  System.out.print(" ");
					  if((i== 0 && c[now][0] == 1) || (i==2 && c[now][3] == 1) ||(i==4 && c[now][6] == 1)) {
						  for(int k=0; k<s; k++) {
							System.out.print("-");  
						  }
					  }else {
						 for(int k=0; k<s; k++) {
							 System.out.print(" ");
						 }
					  }
					  System.out.print(" ");
				  }
				  System.out.println();
			  }else { //col부분 처리
				  for(int l=0; l<s; l++) {
					  for(int j=0; j<n.length(); j++) {
						  int now = n.charAt(j) -'0';
						  if(j != 0) {
							  System.out.print(" ");
						  }
						  if((i==1 && c[now][1] == 1) || (i==3 && c[now][4] == 1)) {
							  System.out.print("|");
						  }else {
							  System.out.print(" ");
						  }
						  for(int k=0; k<s; k++) {
							  System.out.print(" ");
						  }
						  if((i==1 && c[now][2] == 1) || (i==3 && c[now][5] == 1)) {
							  System.out.print("|");
						  }else {
							  System.out.print(" ");
						  }
					  }
					  System.out.println();
				  }
			  }

		  }//for문 끝
	}			

}
