package 에프랩스터디.이코테;

import java.io.*;
import java.util.StringTokenizer;

public class ps0214_나무자르기 {

    static int[] wood;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int max = -1;
        wood = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, wood[i]);
        }

        // 찾고자 하는것 => 설정된 절단기의 최댓값
        long left = 0;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;

            long temp = cutWood(mid);
            if (temp < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }


    private static long cutWood(long mid) {
        long result = 0;

        for (int i = 0; i < n; i++) {
            if (wood[i] - mid > 0) {
                result += (wood[i] - mid);
            }
        }

        return result;
    }
}
