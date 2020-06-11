public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = {15,27,39,77,92,108,121};
        System.out.println(binarySearch(numbers, 108));
    }

    /**
     * 이진검색
     * 이미 오름차순으로 정렬된 배열에서 검색하는 알고리즘
     * @param a = 정렬된 배열, key = 찾아야 하는 값
     * @return 검색하는 값이 있는 배열의 인덱스값 반환
     */
    public static int binarySearch(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {  // 반복문 종료조건은 검색할 배열의 길이가 0이하일 경우 종료
            int center = (start + end) / 2;   // 배열의 가운데 인덱스 값
            if(a[center] == key)
                return center;   // 값을 찾은경우 인덱스 반환 후 종료
            else if (a[center] < key)  // 중앙값보다 키값이 큰 경우 오른쪽 검색
                start = center + 1;
            else                       // 중앙값보다 키값이 작은 경우 왼쪽 검색
                end = center - 1;
        }
        return -1;
    }

    /*
     연습문제
     찾는 요소값이 여러개일 경우 가장 앞의 인덱스값을 반환하도록 구현
     */
    public static int binarySearchX(int[] a, int key) {
        int result = -1;
        return result;
    }

}
