//백준 14891 톱니바퀴
package codingTest1_4;

import java.io.*;
import java.util.*;

public class simulation5 {

	static int gear[][];
	static int d[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new int[4][8];

		for(int i=0; i<gear.length; i++) {
			String s = br.readLine();
			for(int j=0; j<gear[0].length; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		int ans =0;
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int gearN = Integer.parseInt(st.nextToken()) - 1;
			int turn = Integer.parseInt(st.nextToken());
			
			d = new int[4];
			
			d[gearN] = turn;
			
			checkDir(gearN);
			gearTurn();
			
		}
		
		for(int i=0; i<4; i++) {
			if(gear[i][0] == 1) {
				switch(i) {
				case 0:
					ans+=1;
					break;
				case 1:
					ans+=2;
					break;
				case 2:
					ans+=4;
					break;
				case 3:
					ans+=8;
					break;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void checkDir(int gearN) {
		
		//왼쪽 구하기
		for(int i=gearN-1; i>=0 ; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				d[i] = -d[i+1];
			}else {
				//그 방향으로 회전하지 않는 경우면 더이상 회전 X
				break;
			}
		}
		
		//오른쪽
		for(int i=gearN+1; i<4; i++) {
			if(gear[i][6] != gear[i-1][2]) {
				d[i] = -d[i-1];
			}else {
				break;
			}
		}
		
	}
	
	static void gearTurn(){
		int temp = 0;
		
		for(int i=0; i<4; i++) {
			if(d[i] == -1) { //시계방향 회전
				temp = gear[i][0];
				for(int j=0; j<7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
				
			}else if(d[i] == 1) { //반시계 방향 회전
				temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}
		}
		
	}
}



