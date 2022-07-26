package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0726_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int count = 0;

        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    break;
                }

                if (str1.charAt(i) == '8') count++;
            }
        }
        System.out.println(count);
    }
}
