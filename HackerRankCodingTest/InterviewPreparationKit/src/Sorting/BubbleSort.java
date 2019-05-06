package Sorting;

/*

link : https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting


Bubble Sort의 다음 버전을 고려하십시오.

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - 1; j++) {
        // 인접한 요소가 내림차순인 경우 Swap 합니다.
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
        }
    }
}

주어진 정수 배열을 사용하여 위의 버블정렬 알고리즘을 사용하여 오름차순으로 배열을 정렬하십시오.
일단 정렬되면 다음 세 줄을 인쇄하십시오.

배열은 numSwaps 스왑에 정렬됩니다. 여기서 numSwaps는 발생한 스왑의 수입니다.

첫 번째 요소 : firstElement입니다. 여기서 firstElement는 정렬 된 배열의 첫 번째 요소입니다.
마지막 요소 : lastElement. lastElement는 정렬 된 배열의 마지막 요소입니다.
힌트 :이 과제를 완료하려면 실행 중에 발생하는 모든 스왑의 실행 집계를 유지하는 변수를 추가해야합니다.

예를 들어 최악의 경우이지만 작은 배열을 정렬하면 a = [6,4,1] 다음 단계를 수행합니다.

swap    a
0       [6,4,1]
1       [4,6,1]
2       [4,1,6]
3       [1,4,6]

배열을 정렬하는데 3회의 Swap이 필요했습니다. 출력은 다음과 같습니다.

Array is sorted in 3 swaps.
First Element: 1
Last Element: 6


- 함수 설명

아래 편집기에서 countSwaps 함수를 완성하십시오.
필요한 세 줄을 인쇄 한 다음 반환해야합니다.

countSwaps에는 다음과 같은 매개 변수가 있습니다.

a : 정수의 배열.


- 입력 형식

첫 번째 줄에는 배열의 크기 인 정수 n이 들어 있습니다.
두 번째 줄에는 공백으로 구분 된 정수 a [i]가 들어 있습니다.

- 제약 조건
2 <= n <= 600
1 <= a[i] <= 2 * 1000000


- 출력 형식

다음 세 줄의 출력을 인쇄해야합니다.

배열은 numSwaps 스왑에 정렬됩니다. 여기서 numSwaps는 발생한 스왑의 수입니다.
첫 번째 요소 : firstElement입니다. 여기서 firstElement는 정렬 된 배열의 첫 번째 요소입니다.
마지막 요소 : lastElement. lastElement는 정렬 된 배열의 마지막 요소입니다.


- 샘플 입력0
3
1 2 3

- 샘플 출력0

Array is sorted in 0 swaps.
First Element: 1
Last Element: 3

- 샘플0 해설

배열은 이미 정렬되어 있으므로 swap이 발생하지않고 위에 표시된 3 행의 출력을 출력합니다.


- 샘플 입력1
3
3 2 1

- 샘플 출력1

Array is sorted in 3 swaps.
First Element: 1
Last Element: 3

- 샘플1 해설

배열은 정렬되지 않으며 초기 값은 {3,2,1}입니다. 다음 3 번의 스왑이 수행됩니다.

{3,2,1} -> {2,3,1}
{2,3,1} -> {2,1,3}
{2,1,3} -> {1,2,3}

이 시점에서 배열이 정렬되고 위에 표시된 출력의 필요한 세 줄을 인쇄합니다.


* */
public class BubbleSort {
    static void countSwaps(int[] a) {
        int swapCnt = 0;

        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 인접한 요소가 내림차순인 경우 Swap 합니다.
                if (a[j] > a[j + 1]) {
                    int imsi = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = imsi;
                    swapCnt++;
                }
            }
        }

        System.out.println("Array is sorted in "+swapCnt+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);

    }

    public void getResult() {
        countSwaps(new int[]{1,2,3});
        countSwaps(new int[]{3,2,1});
    }
}
