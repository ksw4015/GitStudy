/**
 * 유클리드 호제법
 * (재귀함수로 최대공약수 구하기)
 *
 * X가 큰 수 Y가 작은 수 라고 가정
 *
 * 1) X를 Y로 나누고 나머지가 0인가 확인
 *
 * 2) 나머지가 0이면 Y가 최대공약수
 *
 * 3) 나머지가 0이 아니면 X(큰 수) 자리에 Y를 대입하고 Y(작은 수)자리에 N(나머지)를 대입해서 위의 과정을 반복한다
 *
 */

public class EuclidGCD {

    static int gcd(int x, int y) {
        if(x % y == 0)
            return y;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] arg) {
        System.out.println(gcd(22,8));
    }

}
