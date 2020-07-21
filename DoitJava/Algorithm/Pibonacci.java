public class Pibonacci {

    /**
     * n크기의 피보나치 수열 만들기
     * @param n 조건 1보다 크거나 같음
     * @return
     */
    private static int[] pibonacci(int n) {

        int[] pibo = new int[n];
        if(n == 1) {
            pibo[0] = 1;
        } else if(n == 2) {
            pibo[0] = 1;
            pibo[1] = 1;
        } else {
            pibo[0] = 1;
            pibo[1] = 1;
            for(int i = 2; i < n ; i++) {
                pibo[i] = pibo[i-2] + pibo[i-1];
            }
        }
        return pibo;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] pibo = pibonacci(n);
        for(int i = 0 ; i < n ; i++) {
            if(i != n-1) {
                System.out.print(pibo[i] + ",");
            } else {
                System.out.print(pibo[i]);
            }
        }
    }

}
