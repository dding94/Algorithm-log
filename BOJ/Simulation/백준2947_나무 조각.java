import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int len = 5;
        int[] num = new int[len];
		int tmp=0;
        
		for (int i = 0; i < 5; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1; j++) {
				if(num[j] > num[j+1]) {
					tmp = num[j];
					num[j]=num[j+1];
					num[j+1]=tmp;
					for (int k = 0; k < len; k++) {
						sb.append(num[k]+" ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}