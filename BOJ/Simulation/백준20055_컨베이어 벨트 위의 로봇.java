//백준 20055 컨베이어 벨트 위의 로봇
package codingTest1_4;


import java.io.*;
import java.util.*;

public class simulation14 {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int a[] = new int[2*n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n*2; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int robot[] = new int[2*n];
		int zero = 0;
		int cnt=0;
		while(true) {
			cnt++;
			rotate(a);
			rotate(robot);
			if(robot[n-1] == 1) {
				robot[n-1] =0;
			}
			
			for(int i=n-2; i>=0; i--) {
				if(robot[i]==1) {
					if(a[i+1] > 0 && robot[i+1] == 0) {
						robot[i+1] = robot[i];
						robot[i] = 0;		
						a[i+1] -= 1;
						if(a[i+1] == 0) {
							zero += 1;
						}
					}
				}
			}
			
			if(robot[n-1] == 1) {
				robot[n-1] =0;
			}
			
			if(a[0] > 0) {
				robot[0] = 1;
				a[0] -= 1;
				if(a[0] == 0) {
					zero += 1;
				}
			}
			
			if(zero>=k) {
				System.out.println(cnt);
				break;
			}
		}
		
	}
	static void rotate(int[] a) {
		int n = a.length;
		int temp = a[n-1];
		
		for(int i=n-1; i>0; i--) {
			a[i] = a[i-1];
		}
		a[0] = temp;
	}
	
}
