package 백준.PS11월;

import java.io.*;

public class PS1129_2872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(br.readLine());
        }

        int target = n;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (books[i] == target) {
                target--;
            } else {
                ans++;
            }
        }

        System.out.println(ans);

    }

}
