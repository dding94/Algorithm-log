//백준 14890 경사로
package Practice;

import java.io.*;
import java.util.*;

public class bj14890 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//행 검사
		int ans =0;
		
		for(int i=0; i<n; i++) {
			int d[] = new int[n]; //1차원 배열 따로 분리하여 검사
			
			for(int j=0; j<n; j++) {
				d[j] = map[i][j];
			}
			if(go(d, l)) ans+=1;
		}
		
		//열 검사
		for(int j=0; j<n; j++) {
			int d[] = new int[n];
			
			for(int i=0; i<n; i++) {
				d[i] = map[i][j];
			}
			if(go(d,l)) ans+=1;
		}
		
		System.out.println(ans);
		
	}
	static boolean go(int a[], int l) {
		int n = a.length;
		boolean c[] = new boolean[n];
		
		for(int i=1; i<n; i++) { //첫칸은 높이상관없이 갈 수 있음.
			if(a[i-1] != a[i]) { //인접한 칸의 높이가 다르면
				int diff = Math.abs(a[i] - a[i-1]);
				
				if(diff != 1) { //높이 차이가 1이 아닐경우
					return false; 
				}
				
				if(a[i-1] < a[i]) { //가야하는 길이 더 높은 경우
					for(int j=1; j<=l; j++) {
						if(i-j <0) return false; //경사로 범위 벗어난경우
						if(a[i-1] != a[i-j]) return false; //경사로 설치할 지점의 높이가 다를경우
						if(c[i-j]) return false; // 경사로가 이미 설치 된 경우
						
						c[i-j] = true; //경사로 설치
					}
				}else {
					for(int j=0; j<l; j++) {
						if(i+j >= n) return false;
						if(a[i] != a[i+j]) return false;
						if(c[i+j]) return false;
						
						c[i+j] = true; //경사로 설치
					}
				}			
			}
		}
		
		return true;
	}
}
