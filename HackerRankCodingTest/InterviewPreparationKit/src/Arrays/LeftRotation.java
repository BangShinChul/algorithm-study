package Arrays;


/*

link : https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays


배열에 대한 자세한 내용은 페이지의 오른쪽에있는 리소스를 확인하십시오.
비디오 자습서는 Gayle Laakmann McDowell이 저술 한 베스트 셀러 인터뷰 책인 Coding Interview 입니다.

배열의 왼쪽 회전 조작은 배열의 각 요소를 왼쪽으로 1 단위 이동합니다.
예를 들어 배열 [1,2,3,4,5]에서 왼쪽 왼쪽 회전이 2 번 수행되면 배열은 [3,4,5,1,2]가 됩니다.

n 개의 정수로 구성된 배열 a와 숫자 d가 주어진다면 배열에 d 개의 왼쪽 회전을 수행하십시오.
공백으로 단락 지어진 1 행의 정수로서 출력되도록 (듯이), 갱신 된 배열을 돌려줍니다.


- 함수 설명

아래 편집기에서 rotLeft 함수를 완성하십시오.
결과 정수 배열을 반환해야합니다.

rotLeft에는 다음과 같은 매개 변수가 있습니다.

정수 배열 a.
정수 d는 회전 수입니다.


- 입력 형식

첫 번째 줄에는 두 개의 공백으로 구분 된 정수 n과 d, a의 크기 및 수행해야하는 왼쪽 회전 수가 들어 있습니다.
두 번째 줄에는 공백으로 구분 된 정수 a[i]가 들어 있습니다.


- 제약 조건

1 <= n <= 10의 5승
1 <= d <= n
1 <= a[i] <= 10의 6승


- 출력 형식

공백으로 단락 지어진 1 행의 정수를 출력 해,
좌상 회전을 실행 한 후에 배열의 최종 상태를 표시합니다.


- 입력 예시

5 4
1 2 3 4 5


- 출력 예시

5 1 2 3 4


- 해설

d = 4 왼쪽 회전을 수행하면 배열은 다음과 같은 순서로 변경됩니다.

[1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]

[1,2,3,4,5,6,7] -> [2,3,4,5,6,7,1] -> [3,4,5,6,7,1,2] -> [4,5,6,7,1,2,3] -> [5,6,7,1,2,3,4]

* */
public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        // a : 배열
        // d : 회전 수 (왼쪽)

        int arLength = a.length;
        int rotateCnt = d/arLength > 1 ? d%arLength : d; // 한바퀴 돌면 원위치이므로 반복횟수를 줄이기 위해 나머지만큼을 추려냄.
        int[] result = new int[arLength];

        for (int i=0; i<arLength; i++) {
            // 현재인덱스에서 왼쪽으로 이동횟수만큼 배열의 전체길이에서 빼야함
            // 만약 이동횟수 > 현재인덱스 일 경우에는
            // 배열 전체길이 - (이동횟수 - 현재인덱스)
            // 5-(4-0) = 1
            // 5-(4-1) = 2
            // 5-(4-2) = 3
            // 5-(4-3) = 4
            // 만약 이동횟수 = 현재인덱스 일 경우에는
            // 그냥 현재인덱스 - 이동횟수 한다.
            // 4-4 = 0

            // 7-(4-0) = 3 => 1의위치
            // 7-(4-1) = 4 => 2의위치
            // 7-(4-2) = 5 => 3의위치
            // 7-(4-3) = 6 => 4의위치
            // 4-4 = 0 => 5의위치
            // 5-4 = 1 => 6의위치
            // 6-4 = 2 => 7의위치

            int newIndex = 0;
            if (rotateCnt > i) {
                newIndex = arLength - (rotateCnt-i);
            } else {
                newIndex = i - rotateCnt;
            }
            result[newIndex] = a[i];
        }

        return result;
    }

    public void getResult() {
//        int[] result = rotLeft(new int[]{1,2,3,4,5}, 4); // 5,1,2,3,4
//        int[] result = rotLeft(new int[]{1,2,3,4,5,6,7}, 4); // 5,6,7,1,2,3,4
        int[] result = rotLeft(new int[]{41,73,89,7,10,1,59,58,84,77,77,97,58,1,86,58,26,10,86,51},10);
        // 77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77
        int rLength = result.length;

        for (int i=0; i<rLength; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
