/**
 * 퀵 정렬
 *
 * 그룹을 나누는 기준이되는 pivot값을 설정하고
 * pivot값을 기준으로 그룹 나눔을 반복하면서 정렬
 *
 */
public class QuickSort {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void quickSort(int[] arr, int left, int right) {

        int pl = left;               // 왼쪽 끝 인덱스
        int pr = right;        // 오른쪽 끝 인덱스
        int pivot = arr[(pl+pr) / 2];  // Pivot 값

        do{
            while (arr[pl] < pivot) pl++;   // Pivot값 보다 큰 값이 나올 때까지 인덱스 증가
            while (arr[pr] > pivot) pr--;   // Pivot값 보다 작은 값이 나올 때까지 인덱스 감소
            // 인덱스 값이 서로 교차되지 않았으면 값을 교환
            if(pl <= pr) {
                // 값 교환 후 다시 인덱스 증가 및 감소
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if(left < pr) quickSort(arr, left, pr);
        if(pl < right) quickSort(arr, pl, right);
    }

    public static void main(String[] args) {
        int[] x = {5,8,4,2,6,1,3,9,7};
        quickSort(x,0,x.length-1);
        for(int i = 0 ; i < x.length ; i++) {
            System.out.println(x[i]);
        }
    }

}
