import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		
		if(num%2 == 0) {
			System.out.println("CY");
		}
		else {
			System.out.println("SK");
		}
	}
}