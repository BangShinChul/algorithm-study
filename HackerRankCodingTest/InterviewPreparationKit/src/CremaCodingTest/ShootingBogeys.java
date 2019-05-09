package CremaCodingTest;

import java.lang.reflect.Array;
import java.util.*;

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
1 <= n <= 100000 (bogey 개수)
1 <= startingPos <= 1000000000 (bogey의 높이)
1 <= speed <= 100000 (0<= i < n) (bogey의 속도)

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
2 -> bogey의 갯수
4
3
2 -> bogey의 속도 2개
2
2

- 샘플 출력 1
2

- 샘플 0 설명
아더는 둘중 어떤 bogey를 먼저 쏠지 고를 수 있습니다.
총 2개를 맞출 수 있습니다.


---
설명


15 위치인 폭탄이 초당 4의 속도로 떨어질 때
위치가 0이 되는 시간이 몇초인지?

15/4 = 3
15%4 = 3

3초가되면 위치가 3이 되고
4초에는 위치가 -1이 되므로

4초뒤 폭탄이 지면에 떨어짐

즉 (startingPos / speed) 별로 list에 넣고
정렬한 뒤 같은 값이 가장 많이 있는 곳. 즉 몇초에 해당하는 값이 많이 있는지
확인해보고 그걸 리턴하면됨.


* */
public class ShootingBogeys {

    public static int protectionTime2(List<Integer> startingPos, List<Integer> speed) {
        int time = 0;
        int listLength = startingPos.size();
        Integer[] bombTimes = new Integer[listLength];

        for (int i=0; i<listLength; i++) {
            int moc = startingPos.get(i)/speed.get(i);
            int nam = startingPos.get(i)%speed.get(i);

            bombTimes[i] = nam > 0 ? moc+1 : moc;
        }

        Arrays.sort(bombTimes); // 오름차순 정렬

        for (int j=0; j<listLength; j++) {
            if (time != bombTimes[j]) {
               time = bombTimes[j]; // 시간이 다음번째로 넘어가면 리셋
            } else {
                return time;
            }
//            System.out.print(startingPos.get(j)+"/"+speed.get(j)+":"+bombTimes[j] + " ");
        }
        return time; // 끝까지 가면 결국 배열의 마지막 번째 인덱스의 시간이 결과로 리턴. -> 모든 폭탄을 쐈을경우
    }

    public static int protectionTime(List<Integer> startingPos, List<Integer> speed) {
        // Write your code here

        int time = 0; // 시간
        System.out.println("init time : "+time);

        while (startingPos.size() > 0) { // bogey가 다 소진될 때 까지 round second 반복
            int listLength = startingPos.size();
            int maxIndexValue = (startingPos.get(0) - (speed.get(0)*time)) - (speed.get(0));
            int maxIndex = 0;
            int shotCnt = 0; // 이번 second에 bogey를 쏜 횟수

            System.out.println("\n=============================");
            System.out.println("남은 bogey의 갯수 : "+listLength);
            System.out.println();
            System.out.println("> "+time+"번째 second");

            for(int i=0; i<listLength; i++) { // bogey 순차적으로 연산
                int currentPos = startingPos.get(i) - (speed.get(i)*time); // 속도를 적용한 현재위치
                int maxPos = currentPos - (speed.get(i));

                if (maxIndexValue > maxPos) { // 다음라운드에 지면에 가장 가까이 닿을것같은 index를 뽑음
                    maxIndex = i;
                }
                System.out.println(i+"번째 bogey의 위치: "+currentPos+" / 속도: "+speed.get(i)+" / time: "+time);


                if (currentPos == 0) {
                    // 이미 땅에 떨어진 bogey가 있을 경우
                    return time;
                } else if (currentPos <= 1 && shotCnt >= 1) {
                    // 이미 하나를 쏘았는데 또 쏘아야할게 있을 경우 (다음 second에 기지 파괴)
                    System.out.println("이미 한번 총을 쏘았으므로 "+i+"번째 때문에 다음 second에 기지파괴");
                    return time+1;
                } else if (currentPos <= 1 && shotCnt == 0){
                    // 하나도 안쏜 상태에서 쏠것이 발견되었을 경우 (bogey 파괴)
                    shotCnt++; // 쏜것 카운트
                    System.out.println(i+"번째 bogey SHOT! / shotCnt: "+shotCnt);
                    startingPos.remove(i); // bogey삭제
                    speed.remove(i); // bogey삭제
                    listLength = startingPos.size(); // listLength Update

                    if (listLength > 0) {
                        --i;
                    }
                }
            }
            if (shotCnt == 0) {
                // 이번 라운드에서 쏜게 없엇을 경우 가장 위험해보이는 bogey를 쏜다.
                System.out.println(maxIndex+"번째 bogey SHOT! / shotCnt: "+shotCnt);
                startingPos.remove(maxIndex); // bogey삭제
                speed.remove(maxIndex); // bogey삭제
                // 이 다음부터는 어차피 위의 for 문에서 i가 0부터 돌것이니 --i를 해줄 필요가 없음.
                // 또한 listLength도 while문이 다시 돌면서 새롭게 초기화 될 것이므로 update 해 줄 필요 없음.
            }
            time++;
        }
        return time;

    }

    public void test() {
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        System.out.println(test.get(2));
        test.remove(2);
        System.out.println(test.get(2));
    }

    public void getResult() {

        List<Integer> startingPos = new ArrayList<Integer>();
//        startingPos.add(4);
//        startingPos.add(3);

//        startingPos.add(4);
//        startingPos.add(3);
//        startingPos.add(1);

        startingPos.add(4);
        startingPos.add(15);
        startingPos.add(15);
        startingPos.add(12);
        startingPos.add(18);
        startingPos.add(3);
        startingPos.add(8);

        List<Integer> speed = new ArrayList<Integer>();
//        speed.add(2);
//        speed.add(2);

        // 2
//        speed.add(3);
//        speed.add(2);
//        speed.add(1);

        // 6
        speed.add(2);
        speed.add(5);
        speed.add(3);
        speed.add(2);
        speed.add(3);
        speed.add(3);
        speed.add(2);




        System.out.println("\n\n정답 : "+protectionTime2(startingPos, speed));
    }
}
