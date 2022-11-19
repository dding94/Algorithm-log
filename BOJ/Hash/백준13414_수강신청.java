package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1119_13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수강 가능 인원
        int k = Integer.parseInt(st.nextToken());
        //학생이 버튼을 클릭한 순서
        int l = Integer.parseInt(st.nextToken());

        Set<String> hs = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            String student = br.readLine();

            if (!hs.add(student)) {
                hs.remove(student);
                hs.add(student);
            }
        }

        StringBuilder sb = new StringBuilder();

        int point = 0;
        for (String h : hs) {
            sb.append(h + "\n");

            point++;
            if (point == k) {
                break;
            }
        }

        System.out.println(sb);

    }

}
