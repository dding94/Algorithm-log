//πÈ¡ÿ 12100 2048 (Easy)
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BruteForce8 {

	static int n,ans;
	static int map[][];
	static boolean isMove;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(0);
		
		System.out.println(ans);
	}

	static void go(int index) {
		if(index == 5) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					ans = Math.max(ans, map[i][j]);
				}
			}
			return;
		}
		
		int copy[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			copy[i] = map[i].clone();
		}
		
		for(int k=0; k<4; k++) {
			
			move(k);
			go(index+1);
		
			for(int i=0; i<n; i++) {
				map[i] = copy[i].clone();
			}
		}
	}
	
	static void move(int dir) {
		
		boolean merge[][] = new boolean[n][n];
		while(true) {
			boolean isMove = false;//øÚ¡˜¿”
			
			if(dir==0) { //æ∆∑°
				for(int i=n-2; i>=0; i--) {
					for(int j=0; j<n; j++) {
						if(map[i][j] == 0) continue; //∫Ûƒ≠¿Ã∏È ∞«≥ ∂‹
						if(map[i+1][j] == 0) {
							map[i+1][j] = map[i][j];
							merge[i+1][j] = merge[i][j];
							map[i][j] = 0;
							isMove = true;
						}else if(map[i+1][j] == map[i][j]) {
							if(!merge[i+1][j] && !merge[i][j]) {
								map[i+1][j] *= 2;
								merge[i+1][j] = true;
								map[i][j] = 0;
								isMove = true;
							}
						}
					}
				}
			}else if(dir == 1) { //¿ß
				for(int i=1; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(map[i][j] == 0) continue;
						if(map[i-1][j] == 0) {
							map[i-1][j] = map[i][j];
							merge[i-1][j] = merge[i][j];
							map[i][j] = 0;
							isMove = true;
						}else if(map[i-1][j] == map[i][j]) {
							if(!merge[i-1][j] && !merge[i][j]) {
								map[i-1][j] *= 2;
								merge[i-1][j] = true;
								map[i][j] = 0;
								isMove = true;
							}
						}
					}
				}
			}else if(dir == 2) { //øﬁ
				for(int j=1; j<n; j++) {
					for(int i=0; i<n; i++) {
						if(map[i][j] == 0) continue;
						if(map[i][j-1] == 0) {
							map[i][j-1] = map[i][j];
							merge[i][j-1] = merge[i][j];
							map[i][j] = 0;
							isMove = true;
						}else if(map[i][j-1] == map[i][j]) {
							if(!merge[i][j-1] && !merge[i][j]) {
								map[i][j-1] *= 2;
								merge[i][j-1] = true;
								map[i][j] = 0;
								isMove = true;
							}
						}
					}
				}					
			}else if(dir == 3) { //ø¿
				for(int j=n-2; j>=0; j--) {
					for(int i=0; i<n; i++) {					
						if(map[i][j] == 0) continue;
						if(map[i][j+1] == 0) {
							map[i][j+1] = map[i][j];
							merge[i][j+1] = merge[i][j];
							map[i][j] = 0;
							isMove = true;
						}else if(map[i][j+1] == map[i][j]) {
							if(!merge[i][j+1] && !merge[i][j]) {
								map[i][j+1] *= 2;
								merge[i][j+1] = true;
								map[i][j] = 0;
								isMove = true;
							}
						}
					}
				}
			}
			
			if(isMove == false) break; //øÚ¡˜¿”¿Ã æ¯¿∏∏È ≥°≥ø
		}
		
	}
}
