package 백준.PS7월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PS0703_2303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> nowList = new ArrayList<>();

            for(int j = 0; j < 5; j++) {    // 해당 한 사람의 번호 조합을 nowList로 받아옴
                nowList.add(Integer.parseInt(st.nextToken()));
            }

            int max = 0;
            for(int j = 0; j < 3; j++) {    // 모든 조합을 비교하며 해당 번호의 사람이 만들 수 있는 가장 큰 수를 찾아서 list에 넣음
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        int point = (nowList.get(j) + nowList.get(k) + nowList.get(l)) % 10;
                        if (max < point) {
                            max = point;
                        }
                    }
                }
            }
            list.add(max);
        }
        int result = Collections.max(list);    // list에서 최대값을 구함
        for(int i = list.size()-1; i >= 0; i--) {    // 리스트를 뒤부터 순회하며 최대값이 들어있는 번호가 가장 큰 경우를 찾아서 출력후 종료
            if(result == list.get(i)) {
                System.out.println(i+1);
                return;
            }
        }

    }
}
