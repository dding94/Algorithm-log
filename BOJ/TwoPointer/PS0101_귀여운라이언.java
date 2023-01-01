package 백준23.PS1월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0101_귀여운라이언 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;

        int dolls[] = new int[n + 1];

        int start = k;
        int last = n;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        while (start <= last) {
            // mid 크기의 윈도우에 k개가 있는가?
            int mid = (start + last) / 2;

            int cnt[] = new int[3];

            for (int i = 0; i < mid - 1; i++) {
                cnt[dolls[i]]++;
            }

            boolean isFind = false;

            for (int i = mid - 1; i < n; i++) {
                cnt[dolls[i]]++;

                if (cnt[1] >= k) {
                    last = mid - 1;
                    result = Integer.min(result, mid);
                    isFind = true;
                    break;
                }
                cnt[dolls[i + 1 - mid]]--;
            }

            if (!isFind) {
                start = mid + 1;
            }

        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        System.out.println(result);
    }

}

