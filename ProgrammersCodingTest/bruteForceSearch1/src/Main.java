import java.util.*;

public class Main {
/*

# 문제 설명
수포자는 수학을 포기한 사람의 준말입니다.
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

# 제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

# 입출력 예
answers	        return
[1,2,3,4,5]	    [1]
[1,3,2,4,2]	    [1,2,3]

# 입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

수포자 1은 [1, 4]번 문제를 맞혔습니다.
수포자 2는 다섯 번째 문제를 맞혔습니다.

* */

    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] supoza1 = {1,2,3,4,5};
        int[] supoza2 = {2,1,2,3,2,4,2,5};
        int[] supoza3 = {3,3,1,1,2,2,4,4,5,5};

        // 수포자들의 정답 카운팅 변수
        int[] supozasCount = {0,0,0};

        // 수포자들의 인덱스용 변수
        int first = 0;
        int second = 0;
        int third = 0;

        // 최대값 저장용 변수
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < answers.length; i++) {
            // 정답 체크
            if(supoza1[first] == answers[i]) {
                supozasCount[0] += 1;
            }
            if(supoza2[second] == answers[i]) {
                supozasCount[1] += 1;
            }
            if(supoza3[third] == answers[i]) {
                supozasCount[2] += 1;
            }

            // 인덱싱
            if(first == supoza1.length - 1) {
                first = 0;
            } else {
                first++;
            }
            if(second == supoza2.length - 1) {
                second = 0;
            } else {
                second++;
            }
            if(third == supoza3.length - 1) {
                third = 0;
            } else {
                third++;
            }
        }

        // 최대값 확인
        int max = 0;
        for(int i = 0; i < 3; i++) {
            if(supozasCount[i] > max) {
                list.clear();
                max = supozasCount[i];
                list.add(i+1);
            }else if(max == supozasCount[i]) {
                list.add(i+1);
            }
        }

        Map<String, Integer> m = new HashMap<>();

        // list에 쌓은 최대정답자들을 answer 배열에 옮기기
        answer = new int[list.size()];
        int cnt = 0;
        for(int tmp : list) {
            answer[cnt++] = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[] case1 = {1,2,3,4,5};
        int[] case2 = {1,3,2,4,2};

        int[] result1 = m.solution(case1);
        int[] result2 = m.solution(case2);


        System.out.println("=================================");
        for(int item : result1) {
            System.out.println(item);
        }
        System.out.println("=================================");
        for(int item : result2) {
            System.out.println(item);
        }

    }
}
