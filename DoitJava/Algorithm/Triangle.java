public class Triangle {

    public static void main(String[] args) {
        spira(4);
        npira(4);
    }

    /**
     * Ex) n = 4
     *       *
     *      ***
     *     *****
     *    *******
     * @param n = 피라미드 층수
     */
    public static void spira(int n) {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n-i ; j++) {
                System.out.print(" ");
            }
            for(int k = 1 ; k <= (i-1)*2+1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Ex) n = 4
     *       1
     *      222
     *     33333
     *    4444444
     * @param n = 피라미드 층수
     */
    public static void npira(int n) {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n-i ; j++) {
                System.out.print(" ");
            }
            for(int k = 1 ; k <= (i*2)-1 ; k++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
