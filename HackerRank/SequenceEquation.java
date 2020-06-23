public class SequenceEquation {

    /**
     *
     * ex) p = {2,3,1} 이 경우 p(1) = 2, p(2) = 3, p(3) = 1 각 값과 1:1 매칭
     *    이 때, 1부터 배열의 크기만큼 반복 하면 x = 1 = p(3) = p(p(y))
     *    p(2) = 3 이므로 y = 2가 성립
     *    y값을 차례 대로 출력 (줄바꿈)
     *
     * int형 배열이 있고
     * 1 부터 n 까지 순환하면서 (x값)
     * 배열에서 x값을 가지고 있는 Index를 찾고
     * 해당 Index값을 가지고 있는 배열의 Index를 찾는다.
     *
     */
    public static int[] solution(int[] p) {
        int[] result = new int[p.length];
        int a;
        for(int x = 1 ; x < p.length+1 ; x++) {
            for(int i = 0 ; i < p.length ; i++) {
                if(p[i] == x) {
                    a = i+1;
                    for(int j = 0 ; j < p.length ; j++) {
                        if (p[j] == a) {
                            result[x-1] = j+1;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testCase1 = {2,3,1};
        int[] testCase2 = {4,3,5,1,2};

        solution(testCase2);
    }

}
