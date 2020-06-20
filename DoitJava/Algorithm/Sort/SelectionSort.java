public class SelectionSort {

    /**
     * 단순 선택 정렬
     *
     * 배열의 가장 작은 값을 정렬되지 않은 부분의 제일 왼쪽으로
     * 옮기면서 정렬
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {

        for(int i = 0 ; i < arr.length ; i++) {
            int min = i;        //  정렬되지 않은 부분의 맨 왼쪽 인덱스 값으로 초기화
            for(int j = i+1 ; j < arr.length ; j++) {  // 정렬되지 않은 부분의 제일 왼쪽을 제외한 나머지 부분 반복
                if(arr[j] < arr[min])
                    min = j;    // 정렬되지 않은 부분의 제일 작은 값의 인덱스로 교환
            }

            // 정렬되지 않은 부분 제일 왼쪽값과 가장 작은 값 교환
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,3,1};
        arr = selectionSort(arr);
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

}
