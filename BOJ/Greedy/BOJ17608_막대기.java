import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
        
		for(int i=0; i<list.length; i++){
		    list[i] = Integer.parseInt(br.readLine());
        }
        
		int count = 1;
		int maxHeight = list[list.length-1];
	
		for(int i=list.length - 2; i>=0; i--) {
			if(list[i] > maxHeight) {
				count ++;
				maxHeight = list[i];
			}
		}
		
		System.out.println(count);
	}
}