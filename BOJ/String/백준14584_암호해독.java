package 백준.PS9월;

import java.io.*;

public class PS0918_14584 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String s[] = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        for(int i=0; i<26; i++) {
            String temp = "";
            for (int j = 0; j < input.length(); j++) {
                temp += (char) ((input.charAt(j) - 'a' + i) % 26 + 'a');
            }

            for(int j=0; j<n; j++) {
                if (temp.contains(s[j])) {
                    System.out.println(temp);
                    return;
                }
            }
        }
    }

}
