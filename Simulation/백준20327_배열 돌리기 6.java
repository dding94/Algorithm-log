//백준 20327 배열 돌리기 6
package codingTest1_4;

import java.io.*;
import java.util.*;

public class simulation13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int size = (1<<n); //
		int a[][] =new int[size][size];
		
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(r-->0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken()); //k번연산
			int l = Integer.parseInt(st.nextToken()); //단계
			int sub_size = (1 << l);
            if (1 <= k && k <= 4) {
                for (int i=0; i<size; i+=sub_size) {
                    for (int j=0; j<size; j+=sub_size) {
                        operation_1_to_4(a, k, i, j, sub_size);
                    }
                }
			}else if(5<=k && k<=8) {
				if(k==5) {
					a = oper5(a,l);
				}else if(k==6) {
					a = oper6(a,l);
				}else if(k==7) {
					a = oper7(a,l);
				}else if(k==8) {
					a = oper8(a,l);
				}
			}
		}	
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				sb.append(a[i][j] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void operation_1_to_4(int a[][], int k, int sx, int sy, int len){
		int b[][] = new int[len][len];
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				b[i][j] = a[sx+i][sy+j];
			}
		}	
		
        if (k == 1) {
            b = oper1(b);
        } else if (k == 2) {
            b = oper2(b);
        } else if (k == 3) {
            b = oper3(b);
        } else if (k == 4) {
            b = oper4(b);
        }
		
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                a[sx+i][sy+j] = b[i][j];
            }
        }
	}
	
	//상하반전
	static int[][] oper1(int[][] a){
		int n = a.length;
		int ans[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[n-i-1][j];
			}
		}
		return ans;
	}
	static int[][] oper5(int[][] a,int l){
		int n = a.length;
		int ans[][] = new int[n][n];
		int sub_size = (1<<l);
		int sub_count = n / sub_size;
		for(int i=0; i<sub_count; i++) {
			for(int j=0; j<sub_count; j++) {
				int x1 = i*sub_size;
				int y1 = j*sub_size;
				int x2 = (sub_count-i-1)*sub_size;
				int y2 = j*sub_size;
				for(int x=0; x<sub_size; x++) {
					for(int y=0; y<sub_size; y++) {
						ans[x1+x][y1+y] = a[x2+x][y2+y];
					}
				}
				
			}
		}		
		return ans;
	}
	//좌우반전
	static int[][] oper2(int a[][]){
		int n = a.length;
		int ans[][] =new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[i][n-j-1];
			}
		}
		
		return ans;
	}
	static int[][] oper6(int a[][], int l){
		int n = a.length;
		int ans[][] = new int[n][n];
		int sub_size = (1<<l);
		int sub_count = n / sub_size;
		
		for(int i=0; i<sub_count; i++) {
			for(int j=0; j<sub_count; j++) {
				int x1 = i*sub_size;
				int y1 = j*sub_size;
				int x2 = i*sub_size;
				int y2 = (sub_count-j-1)*sub_size;			
				for(int x=0; x<sub_size; x++) {
					for(int y=0; y<sub_size; y++) {
						ans[x1+x][y1+y] = a[x2+x][y2+y];
					}
				}
			}
		}
		
		return ans;
	}
	//오른쪽 90도 회전
	static int[][] oper3(int a[][]){
		int n = a.length;
		int ans[][] =new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[n-j-1][i];
			}
		}	
		return ans;
	}
	
	static int[][] oper7(int a[][], int l){
		int n = a.length;
		int ans[][] = new int[n][n];
		int sub_size = (1<<l);
		int sub_count = n/sub_size;		
		for(int i=0; i<sub_count; i++) {
			for(int j=0; j<sub_count; j++) {
				int x1 = i*sub_size;
				int y1 = j*sub_size;
				int x2 = (sub_count-j-1)*sub_size;
				int y2 = i*sub_size;
				for(int x=0; x<sub_size; x++) {
					for(int y=0; y<sub_size; y++) {
						ans[x1+x][y1+y] = a[x2+x][y2+y];
					}
				}
			}
		}	
		return ans;
	}
	//왼쪽 90도 회전
	static int[][] oper4(int a[][]){
		int n = a.length;
		int ans[][] =new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ans[i][j] = a[j][n-i-1];
			}
		}	
		return ans;
	}
	
	static int[][] oper8(int a[][],int l){
		int n = a.length;
		int ans[][] =new int[n][n];
		int sub_size = (1<<l);
		int sub_count = n / sub_size;
		for(int i=0; i<sub_count; i++) {
			for(int j=0; j<sub_count; j++) {
				int x1 = i*sub_size;
				int y1 = j*sub_size;
				int x2 = j*sub_size;
				int y2 = (sub_count-i-1)*sub_size;			
				for(int x=0; x<sub_size; x++) {
					for(int y=0; y<sub_size; y++) {
						ans[x1+x][y1+y] = a[x2+x][y2+y];
					}
				}
			}
		}
		return ans;
	}
}
