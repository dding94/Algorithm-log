package 백준.PS3월;

import java.io.*;

public class PS0309_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String boom = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() >= boom.length()) {
                boolean isCheck = true;

                for (int j = 0; j < boom.length(); j++) {
                    if (sb.charAt(sb.length() - boom.length() + j) != boom.charAt(j)) {
                        isCheck = false;
                        break;
                    }
                }
                if(isCheck){
                    for (int j = 0; j < boom.length(); j++) {
                        sb.deleteCharAt(sb.length() - boom.length() + j);
                    }
                }
            }
        }

        System.out.println(sb.length() != 0 ? sb : "FRULA");
    }
}
