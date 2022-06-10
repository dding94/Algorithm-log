package 백준.PS6월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PS0610_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxWeight = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxWeight.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, (o1, o2) -> o2 - o1);
        Collections.sort(boxWeight, (o1, o2) -> o2 - o1);

        if (crane.get(0) < boxWeight.get(0)) {
            System.out.println(-1);
            System.exit(0);
        }

        int ans = 0;

        while (!boxWeight.isEmpty()) {
            int craneIdx = 0;
            int boxIdx = 0;

            while (craneIdx < n) {
                if (boxIdx == boxWeight.size()) {
                    break;
                }

                if (boxWeight.get(boxIdx) <= crane.get(craneIdx)) {
                    boxWeight.remove(boxIdx);
                    craneIdx++;
                }else{
                    boxIdx++;
                }
            }
            ans++;
        }

        System.out.println(ans);
    }
}
