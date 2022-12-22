package 에프랩스터디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ps1222_파일명정렬 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new String[]{
                "F-5 Freedom Fighter",
                "B-50 Superfortress",
                "A-10 Thunderbolt II",
                "F-14 Tomcat"
            }
        );

//        sol.solution(new String[]{
//                "img12.png",
//                "img10.png",
//                "img02.png",
//                "img1.png",
//                "IMG01.GIF",
//                "img2.JPG"
//            }
//        );
    }

    private static class Solution {

        public String[] solution(String[] files) {
            String[] answer = {};
            List<File> fileList = new ArrayList<>();

            //O(files :1000 * file :100)
            for (String file : files) {
                StringBuilder head = new StringBuilder();
                StringBuilder number = new StringBuilder();
                StringBuilder tail = new StringBuilder();

                int index = 0;

                for (int i = 0; i < file.length(); i++) {
                    if (!Character.isDigit(file.charAt(i))) {
                        head.append(file.charAt(i));
                    } else {
                        index = i;
                        break;
                    }
                }

                for (int i = index; i < file.length(); i++) {
                    if (Character.isDigit(file.charAt(i))) {
                        number.append(file.charAt(i));
                    } else {
                        break;
                    }
                }

                fileList.add(
                    new File(
                        file,
                        head.toString().toLowerCase(),
                        Integer.parseInt(number.toString())
                    )
                );
            }

            //O(timsort: nlogn => 1000*log*1000)
            Collections.sort(fileList, (o1, o2) -> {
                    if (o1.head.equals(o2.head)) {
                        return o1.number - o2.number;
                    }
                    return o1.head.compareTo(o2.head);
                }
            );

            answer = new String[fileList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = fileList.get(i).origin;
            }

            return answer;
        }

        private static class File {

            String origin;
            String head;
            Integer number;

            public File(String origin, String head, Integer number) {
                this.origin = origin;
                this.head = head;
                this.number = number;
            }
        }
    }



}
