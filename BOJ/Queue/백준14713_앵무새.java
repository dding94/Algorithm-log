package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0810_14713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int type = Integer.parseInt(br.readLine());
        Queue[] qList = new Queue[type];

        for (int i = 0; i < type; i++) {
            qList[i] = new LinkedList<String>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                qList[i].add(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean flag = false;

        while (st.hasMoreTokens()) {
            boolean cFlag = true;

            String word = st.nextToken();
            for (int i = 0; i < type; i++) {
                if (!qList[i].isEmpty()) {
                    if (qList[i].peek().equals(word)) {
                        qList[i].poll();
                        cFlag = false;
                        break;
                    }
                }
            }

            // 매치하는값이 없을떄
            if (cFlag) {
                flag = true;
                break;
            }
        }

        for (int i = 0; i < type; i++) {
            if (!qList[i].isEmpty()) {
                flag = true;
            }
        }

        System.out.println(flag ? "Impossible" : "Possible");
    }

}
