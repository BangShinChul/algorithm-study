package CremaCodingTest;

import java.util.ArrayList;
import java.util.List;

/*

군대 기지를 파괴하기 위해 여러 개의보기가 내려 가고 있습니다.
각보기는 1 초에 한 번씩 총을 쏠 수있는 지면 위의 특정 시작 위치와 속도를 가집니다.
아서는 기지를 얼마나 오래 보호 할 수 있는지 알고 싶어합니다.

- 함수 설명

아래 편집기에서 protectionTime 함수를 완성하십시오.
함수는 아서가 기본을 보호 할 수 있는 최대 시간 인 정수를 반환해야합니다.

protectionTime의 매개 변수는 다음과 같습니다.
startingPos [startingPos [0], ... startingPos [n-1]] : 모든 bogeys의 시작 위치를 나타내는 정수의 배열.
speed [speed [0], ... speed [n-1]] : bogeys가 내려가는 속도를 나타내는 정수의 배열.

- 제약 조건
1 <= n <= 100000
1 <= startingPos <= 1000000000
1 <= speed <= 100000 (0<= i < n)

첫 번째 라인은 bogeys의 수를 나타내는 정수 n을 포함합니다.
n 개의 후속 행 (0 <= i <n)의 각 행 i는 startingPos를 설명하는 정수를 포함합니다.
다음 행은 정수 n을 포함합니다. n 개의 후속 행 (0 <= i <n)의 각 행 i는 speed를 설명하는 정수를 포함합니다.

- 샘플 입력 0
3
4
3
1
3
3
2
1

- 샘플 출력 0
2

- 샘플 0 설명
아더는 1 초 만에 마지막 bogey를 쏘고, 2초 만에 첫번째 bogey를 쏜 다음 두 번째 bogey가 군사 기지를 파괴합니다.
문제 성명서의 이미지를 참조하십시오.


- 샘플 입력 1
2
4
3
2
2
2

- 샘플 출력 1
2

- 샘플 0 설명
아더는 둘중 어떤 bogey를 먼저 쏠지 고를 수 있습니다.
총 2개를 맞출 수 있습니다.

* */
public class ShootingBogeys {

    public static int protectionTime(List<Integer> startingPos, List<Integer> speed) {
        // Write your code here
        return 0;
    }

    public void getResult() {
        List<Integer> startingPos = new ArrayList<Integer>();
        List<Integer> speed = new ArrayList<Integer>();



        System.out.println(protectionTime(startingPos, speed));
    }
}
