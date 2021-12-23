//백준1547 공
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int m = Integer.parseInt(br.readLine());
		
		int cup[] = {0,1,0,0};
		int temp = 0;

		while(m-->0){
			st = new StringTokenizer(br.readLine());
            
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			temp = cup[x];
			cup[x] = cup[y];
			cup[y] = temp;
		}
		
		
		for(int i=1; i<cup.length; i++){
			if(cup[i]==1){
				System.out.println(i);
				break;
			}
		}
	}

}