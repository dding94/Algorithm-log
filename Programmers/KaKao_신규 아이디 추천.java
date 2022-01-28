package 프로그래머스;

import java.util.*;

public class KaKaoIdRecommend {
    public static void main(String[] args) {

        String new_id ="abcdefghijklmn.p";

        Solution sol = new Solution();
        sol.solution(new_id);
    }

    static class Solution {

        public String solution(String new_id) {
            String answer = "";

            //1단계
            String level1 = new_id.toLowerCase(Locale.ROOT);
//            System.out.println("new_id = " + new_id);
            //2단계
            char[] level1_arr = level1.toCharArray();

            String level2 = "";
            for (char c : level1_arr) {
                if( ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.'){
                    level2 += c;
                }
            }

            System.out.println("level2 = " + level2);

            //3단계
            String level3 = level2.replace("..", ".");
            while(level3.contains("..")) {
                level3 = level3.replace("..", ".");
            }

            System.out.println("level3 = " + level3);

            //4단계

            String level4 = level3;
            if(level4.length()>0){
                if(level4.charAt(0) == '.'){
                    level4 = level4.substring(1, level4.length());
                }
            }
            if(level4.length()>0){
                if (level4.charAt(level4.length() - 1) == '.') {
                    level4 = level4.substring(0, level4.length() - 1);
                }
            }



            //5단계
            String level5 = "";
            if (level4.equals("")) {
                level5 = "a";
            }else{
                level5 = level4;
            }

            System.out.println("level5 = " + level5);

            //6단계
            String level6 = "";
            if (level5.length() >= 16) {
                level6 = level5.substring(0, 15);
                if (level6.charAt(level6.length() - 1) == '.') {
                    level6 = level6.substring(0, level6.length() - 1);
                }
            }else{
                level6 = level5;
            }

             System.out.println("level6 = " + level6);

            //7단계
            String level7 = level6;
            if(level6.length() <= 2){
                while(level7.length() < 3){
                    level7 += level7.charAt(level7.length()-1);
                }
            }

            System.out.println("level7 = " + level7);

            answer = level7;
            return answer;
        }

    }
}
