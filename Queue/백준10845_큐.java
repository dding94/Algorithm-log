//น้มุ 10845 ลฅ
package codingTest1_3;

import java.io.*;
import java.util.*;

public class Queue1 {

	static int begin =0;
	static int end =0;
	static int q[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		q = new int[10001];

		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			
			switch(s) {
			case "push":
				int data = Integer.parseInt(st.nextToken());
				push(data);
				break;
			case "pop":
				System.out.println(pop());
				//sb.append(pop()).append('\n');
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "front":
				System.out.println(front());
				break;
			case "back":
				System.out.println(back());
				break;			
			}
		}
	
	}

	static void push(int data) {
		q[end] = data;
		end++;
	}
	static int pop() {
		if(begin == end) return -1;
		
		int data = q[begin];
		q[begin] = 0;
		begin++;
		return data;
	}
	static int size() {
		return end - begin;
	}
	static int empty() {
		if(begin == end) return 1;
		else return 0;
	}
	static int front() {
		if(begin == end) return -1;
		else return q[begin];
	}
	static int back() {
		if(begin == end) return -1;
		else return q[end-1];
	}
}
