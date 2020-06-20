/**
 * 버블 정렬 (오름차순)
 * 이웃한 두 요소의 대소를 비교해서 교환을 반복
 *
 */
public class BubbleSort {

    /**
     * 일반 버블 정렬
     * @param arr = 정렬할 int 자료형의 배열
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        int size = arr.length;
        boolean swap = true;
        while (swap) {
            for(int i = 0 ; i < size - 1 ; i++) {
                if(arr[i+1] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swap = true;   // 한 번의 반복에서 값이 교환된 적이있으면 true (while문 반복)
                    continue;
                }
                swap = false;  // 정렬이 끝났으면 false (while문 종료)
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] beforeSort = {4,2,3,9,5,7,8};
        int[] afterSort = bubbleSort(beforeSort);

        for(int i = 0 ; i < afterSort.length ; i++) {
            System.out.println(afterSort[i]);
        }
    }

}
