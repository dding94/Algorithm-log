//백준 2133 타일 채우기
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int d[] = new int[n+1];
		
		d[0] = 1; 
		for(int i=2; i<=n; i++) {
			d[i] = d[i-2] *3;
			for(int j=i-4; j>=0; j-=2) {
				d[i] += d[j] * 2;
			}
		}
		
		System.out.println(d[n]);
	}

}
