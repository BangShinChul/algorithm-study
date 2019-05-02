package warmUpChallenge;

// link : https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

/*

John은 옷가게에서 일합니다.
그는 판매를 위해 색으로 쌍을 만들어야하는 양말 더미가 있습니다.
각 양말의 색상을 나타내는 정수 배열을 감안할 때, 일치하는 색상이있는 양말 쌍을 결정하십시오.

예를 들어, 색상이 ar = [1,2,1,2,1,3,2]인 n = 7 양말이 있습니다.
색상 1과 색상 2 중 한 쌍이 있습니다.
이상한 양말이 3 개 남아 있는데, 각 색상 중 하나입니다.
즉, 양말이 짝으로 이루어지는 쌍 수는 2입니다.


- 함수 설명

아래 에디터에서 sockMerchant 함수를 완성하십시오.
사용 가능한 양말 쌍의 수를 나타내는 정수를 리턴해야합니다.

sockMerchant의 매개 변수는 다음과 같습니다.

n : 양말의 수
ar : 각 양말의 색깔

- 입력 형식

첫 번째 줄에는 정수 n, ar에 표시된 양말 수를 포함합니다.
두 번째 줄에는 더미에있는 양말의 색상 ar[i]를 설명하는
n 개의 공백으로 구분 된 정수가 들어 있습니다.


- 제약 조건

1 <= n <= 100
1 <= ar[i] <= 100 이고, 0 <= i < n

- 출력 형식

John이 판매할 수 있는 양말의 일치 쌍 수를 반환합니다.

- 입력 예시
9
10 20 20 10 10 30 50 10 20

- 출력 예시
3


* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SockMerchant {
    public int solution(int n, int[] ar) {
        // n : 양말의 갯수
        // ar : 양말 컬러의 배열
        int result = 0; // 짝이 맞는 양말의 갯수(리턴값)
        HashMap<Integer, Integer> socks = new HashMap<>();


        for (int sock : ar) {
            int colorCnt = socks.get(sock) != null ? socks.get(sock) : 0;
            if (colorCnt > 0) {
                int cnt = socks.get(sock) + 1;
                socks.put(sock, cnt);
            } else {
                socks.put(sock, 1);
            }
        }

        Iterator<Integer> keys = socks.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println(key + " : " +socks.get(key)/2);
            result += socks.get(key)/2;
        }

        return result;
    }

    public int solution2(int n, int[] ar) {
        // n : 양말의 갯수
        // ar : 양말 컬러의 배열

        int result = 0; // 짝이 맞는 양말의 갯수(리턴값)
        Set<Integer> socks = new HashSet<>();

        for (int sock : ar) {
            if(!socks.contains(sock)) {
                socks.add(sock);
            } else {
                result++;
                socks.remove(sock);
            }
        }
        return result;
    }

    public void getResult() {
        int[] ar = {
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                10, 20, 20, 10, 10, 30, 50, 10, 20,
                1, 1, 3, 1, 2, 1, 3, 3, 3, 3, 4, 5,
                7, 5, 4, 7, 3, 5, 3, 4, 6, 7, 8, 5,
                14, 5, 45, 6, 4,3, 6, 36,37, 7,48, 68
        };
        int n = ar.length;
        SockMerchant socks = new SockMerchant();
        System.out.println(socks.solution(n, ar));
    }
}
