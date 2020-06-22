/**
 * 단순 삽입정렬
 *
 * 알 듯 말 듯 하면서 잘 모르겠다
 *
 * 우선 작성 70%정도만 이해가됐음
 *
 * 알맞은 위치를 찾기 전까지 계속해서 배열의 값을 오른쪽으로 이동동 *
 */
public class InsertionSort {

    public static int[] insertsionSort(int[] arr, int size) {

        for(int i = 1 ; i < size ; i++) {
            // 선택한 요소 값을 임시로 저장
            int temp = arr[i];
            int j;
            for(j = i ; j > 0 ; j--) {
                // 선택한 요소보다 크면 계속해서 값을 오른쪽으로 이동
                if(arr[j-1] > temp) {
                    arr[j] = arr[j-1];
                } else
                    // 선택한 요소보다 작으면 반복문 탈출
                    break;
            }
            // 알맞은 위치에 선택한 요소를 삽입
            arr[j] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = {6,4,8,7,3,1,9};
        numbers = insertsionSort(numbers, numbers.length);
        for(int i = 0 ; i < numbers.length ; i++)
            System.out.println(numbers[i]);
    }

}
