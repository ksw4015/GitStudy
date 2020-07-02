import java.util.Scanner;

/**
 * 유레카 이론
 * 백준 문제번호 10448
 *
 * 알고리즘 분류 : 완전탐색
 *
 * 세상의 모든 자연수는 최대 3개의 삼각수의 합으로 표현가능 하다고 한다.
 * 하지만, 실제로 그런지 의문이 들어 증명해 보기로한다.
 *
 * 삼각수란 Tn = n(n + 1) / 2
 *
 * 문제 이해를 잘못해서 해매다가 풀이보고 왜 완전탐색문제인지 암....
 *
 */
public class EurekaTheory {

    /**
     *
     * @param num
     */
    public static boolean checkTriSum(int[] triNumbers, int num) {
        for(int a = 0 ; a < triNumbers.length ; a++) {
            for(int b = 0 ; b < triNumbers.length ; b++) {
                for(int c = 0 ; c < triNumbers.length ; c++) {
                    int triSum = triNumbers[a] + triNumbers[b] + triNumbers[c];
                    if(triSum == num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int triNum(int n) {
        return n*(n+1)/2;
    }

    public static void main(String[] args) {
        // 입력 조건이 3 <= k <= 1000 이므로 먼저 최대 삼각수의 n값을 구함
        // n * (n+1) = 2000 이므로 n은 44가 최대
        int[] triNumbers = new int[44];
        for(int n = 1 ; n <= 44 ; n++) {
            triNumbers[n-1] = triNum(n);
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] chkNums = new int[n];
        for(int i = 0 ; i < n ; i++) {
            chkNums[i] = sc.nextInt();
        }
        sc.close();

        for(int i = 0 ; i < n ; i++) {
            if(checkTriSum(triNumbers, chkNums[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

}
