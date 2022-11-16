package 백준.PS11월;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PS1116_11507 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Set<String> hs = new HashSet<>();

        char[] cardList = new char[]{'P', 'K', 'H', 'T'};
        int[] cardCount = new int[]{13, 13, 13, 13};

        for (int i = 0; i < s.length(); i += 3) {
            String card = s.substring(i, i + 3);
            if (!hs.add(card)) {
                System.out.println("GRESKA");
                return;
            }

            for (int k = 0; k < cardList.length; k++) {
                if (card.charAt(0) == cardList[k]) {
                    cardCount[k]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : cardCount) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}
