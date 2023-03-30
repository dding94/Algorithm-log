package 프로그래머스.kakao;

public class 이모티콘할인행사 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            new int[][]{
                {40, 2900},
                {23, 10000},
                {11, 5200},
                {5, 5900},
                {40, 3100},
                {27, 9200},
                {32, 6900}},
            new int[]{1300, 1500, 1600, 4900}
        );

//        sol.solution(
//            new int[][]{
//                {40, 10000},
//                {25, 10000}},
//            new int[]{7000, 9000}
//        );
    }

    private static class Solution {

        static int[] discount = {10, 20, 30, 40};
        static int plusMember = 0;
        static int totalPurchase = 0;

        public int[] solution(int[][] users, int[] emoticons) {
            int[] answer = new int[2];
            int l = emoticons.length;
            dfs(0, emoticons, new int[l], users);

            answer[0] = plusMember;
            answer[1] = totalPurchase;

            return answer;
        }

        private static void dfs(int depth, int[] emoticons, int[] selectDisCounts, int[][] users) {
            if (depth == emoticons.length) {
                cal(selectDisCounts, emoticons, users);
                return;
            }

            for (int select : discount) {
                selectDisCounts[depth] = select;
                dfs(depth + 1, emoticons, selectDisCounts, users);
            }
        }

        private static void cal(int[] selectDisCounts, int[] emoticons, int[][] users) {
            int tempMember = 0;
            int resultTotal = 0;

            for (int[] user : users) {
                int userDiscount = user[0];
                int userThreshold = user[1];
                int tempTotal = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (selectDisCounts[i] >= userDiscount) {
                        double percent = selectDisCounts[i] * 0.01;
                        tempTotal += (emoticons[i] - (emoticons[i] * percent));
                    }
                }

                if (tempTotal >= userThreshold) {
                    tempMember++;
                } else {
                    resultTotal += tempTotal;
                }
            }

            if (tempMember > plusMember) {
                plusMember = tempMember;
                totalPurchase = resultTotal;
                return;
            }

            if (tempMember == plusMember) {
                totalPurchase = Math.max(totalPurchase, resultTotal);
            }
        }
    }
}
