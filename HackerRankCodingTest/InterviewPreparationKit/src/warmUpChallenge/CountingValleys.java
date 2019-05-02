package warmUpChallenge;

// link : https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

/*

게리는 욕심많은 등산객입니다.
그는 지형과 같은 작은 세부 사항에 세심한 주의를 기울여 세심하게 추적합니다.
마지막 하이킹을하는 동안 그는 정확히 발걸음을 옮겼습니다.
그가 한 걸음 한 걸음마다 오르막길 U인지 내리막 길 D인지 기록했습니다.
게리의 등산은 해발에서 시작하고 끝나며 위 또는 아래의 각 단계는 고도의 1 단위 변화를 나타냅니다.
우리는 다음 용어를 정의합니다:

* 산은 해발에서 단계적으로 시작하여 해수면으로 내려가는 단계부터 해발 고도의 연속 단계입니다.

* 계곡은 해발에서 한 단계 아래로 시작하여 해수면으로 올라가는 단계로 시작하여
  해수면 아래에서 연속적인 단계의 연속입니다.

마지막 하이킹을 하는 동안 게리가 위아래로 움직이는 순서를 살펴보면
그가 걷는 계곡의 수를 찾아서 인쇄 할 수 있습니다.

예를 들어 Gary의 경로가 s = [DDUUUUDD] 인 경우에는
먼저 2 단위 깊이의 계곡으로 들어갑니다.
그런 다음 그는 2 단위 높이의 산에 올라가서 올라갑니다.
마침내 그는 해발로 돌아가서 하이킹을 끝냅니다.

- 함수 설명

아래의 편집기에서 countingValleys 함수를 작성하세요.
Gary가 가로 지르는 계곡의 수를 나타내는 정수를 반환해야합니다.

countingValleys에는 다음과 같은 매개 변수가 있습니다.

n : 게리가 걸은 걸음의 소요 단계 수
s : 게리의 이동 경로를 설명하는 문자열

- 입력 형식

첫 번째 줄에는 Gary의 하이킹 단계 수인 정수 n이 있습니다.
두 번째 줄에는 경로를 설명하는 n 개의 문자 s 개가 포함됩니다.

- 제약 조건

2 <= n <= 10의 6승
s[i] ∈ {UD}

- 출력 형식

Gary가 하이킹을하는 동안 걸은 계곡의 수를 나타내는 단일 정수를 출력하십시오.

- 입력 예시
8
UDDDUDUU

- 출력 예시
1

- 설명
우리가 해수면을 _으로 표현하고
/로 단계적으로 상승하면 Gary의 하이킹 경로는 다음과 같이 나타낼 수 있습니다.

_/\      _
   \    /
    \/\/

그는 한 계곡에 한번 들어갔다 나옵니다.

* */

import java.util.ArrayList;
import java.util.List;

public class CountingValleys {

    public int solution(int n, String s) {
        int level = 0; // 기준점
        int valleyCnt = 0; // 계곡으로 들어간 수
        boolean flag = true; // true: 계곡에서 나온상태, false: 계곡안에 있는상태
        char[] step = s.toCharArray();

        int cnt = step.length;
        for (int i=0; i < cnt; i++) {
            if (step[i] == 'U') {
               level++;
            } else {
                level--;
            }

            System.out.println(step[i] + ":" + level);

            if (level < 0 && flag) {
                // flag가 true이고 level이 음수다?
                // 그럼 계곡에 빠진거다

                System.out.println("계곡 빠짐");

                valleyCnt++;
                flag = false;
            } else if (level >= 0 && !flag) {
                // flag는 false인데 level은 0이상이다?
                // 그럼 계곡을 탈출한거다

                System.out.println("계곡 탈출");
                flag = true;
            }
        }

        return valleyCnt;
    }

    public void getResult() {
        int n = 8;
        String s = "UUDDDUDDUUUDDUDDUDUUDUUDUDUDDDUUUDDDDUUDUDUUUDDUUDUDUDDDUUUD";
        System.out.println(solution(n, s));
    }


}
