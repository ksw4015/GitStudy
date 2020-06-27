import java.util.ArrayList;
import java.util.Collections;

/**
 * HackerRank
 * Category : Greedy
 * Easy
 *
 */
public class LuckBalance {

    /**
     *
     * @param k = 져도되는 중요한 대회의 횟수
     * @param contest 2차원 배열로 1열에는 LuckBalance값 2열에는 대회의 중요도
     *                대회의 중요도는 1이면 중요 0이면 안 중요
     * @return
     *
     * 모든 테스트 케이스는 통과했으나 지문이 영어라 파악하기 매우 힘들었고,
     * 문제를 이해하고 나서도 구현하기까지 한참 걸림
     *
     * 총 걸린 시간 1시간 10분 남짓......
     */
    public static int luckBalance(int k, int[][] contest) {

        // 중요한 대회의 횟수 체크
        int importants = 0;
        for(int i = 0 ; i < contest.length ; i++) {
            if(contest[i][1] == 1)
                importants++;
        }

        // Return할 최대 Luck bal 값
        int luck = 0;
        if(importants <= k) {    // 중요한 대회의 개수가 져도 되는 대회 수 보다 작으면 전부 져도 됨.
            // 따라서 모든 Luck Baclance값을 더함
            for(int i = 0 ; i < contest.length ; i++) {
                luck += contest[i][0];
            }
        } else {
            /*
             그게 아니라면 중요한 대회에서 져도 되는 횟수를 제외한 나머지만큼은 꼭 이겨야 함.
             따라서, Luck Balance가 적은 값 순으로 이겨버리면 됨.
             */
            ArrayList<Integer> imp_contests = new ArrayList<>();   // 중요한 대회의 Luck Balance값을 담기위한 ArrayList 선언
            for(int i = 0 ; i < contest.length ; i++) {
                if(contest[i][1] == 1)  // 중요한 대회의 Luck Balance값을 List에 담는다.
                    imp_contests.add(contest[i][0]);
                else
                    luck += contest[i][0];  // 중요하지 않은 대회의 Luck Balance값은 미리 더해놈.
            }

            Collections.sort(imp_contests);  // 중요한 대회의 Luck Balance값을 오름차 순으로 정렬
            for(int i = 0 ; i < imp_contests.size() ; i++) {
                if(i < importants - k)    // 이겨야 하는 횟수를 채울때까지는 이겨야 하고 그만큼 Luck Balance 차감
                    luck -= imp_contests.get(i);
                else                      // 나머지는 전부 합
                    luck += imp_contests.get(i);
            }
        }
        return luck;
    }

    public static void main(String[] args) {
        int[][] contest = {{5,1},{2,1},{1,1},{8,1},{10,0},{5,0}};
        System.out.println(luckBalance(3, contest));
    }

}
