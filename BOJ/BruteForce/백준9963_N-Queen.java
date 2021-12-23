//น้มุ 9963 N-Queen
package codingTest2_1;

import java.io.*;

public class BackTracking1 {

	static int n;
	static int count;
	static int a[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		
		nQueen(0);
		System.out.println(count);
		
	}

	static void nQueen(int index) {
		if(index == n) {
			count++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			a[index] = i;
			if(checkQueen(index)) nQueen(index+1);
		}
	}
	static boolean checkQueen(int col) {
		for(int i=0; i<col; i++) {
			if(a[i] == a[col]) {
				return false;
			}
			
			if(Math.abs(i - col) == Math.abs(a[i] - a[col])) {
				return false;
			}
		}
		
		return true;
	}
	
}
