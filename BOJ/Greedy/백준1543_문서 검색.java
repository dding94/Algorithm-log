package 백준.PS3월;

import java.io.*;

public class PS0307_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String search = br.readLine();

        String answer = document.replaceAll(search, "0");

        int ans = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '0') {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
