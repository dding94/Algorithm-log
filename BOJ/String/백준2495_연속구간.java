import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0; i<3; i++) 
		{
			String s = br.readLine();

			int result = 1;
			char ch = s.charAt(0);
            
			int temp_result = 1;
			for (int j = 1; j < s.length(); j++){
				if(s.charAt(j) == ch ) {
					temp_result++;
				}
				else { 
					ch = s.charAt(j);
					temp_result = 1;
				}

				if(temp_result >= result) {
					result = temp_result;
				}
			}
			System.out.println(result);
		}
	}
}