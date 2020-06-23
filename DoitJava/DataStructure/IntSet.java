/**
 *  배열로 집합 (Set) 구현하기
 *
 *  기본 메서드인 size, indexOf, contains 등 구현
 */
public class IntSet {

    int max;      // 집합 최대 크기
    int num;      // 현재 요소의 개수
    int set[];    // 실제 집합

    public IntSet(int capa) {
        max = capa;
        num = 0;
        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int size() {
        return this.num;
    }

    public int indexOf(int n) {
        for(int i = 0 ; i < set.length ; i++) {
            if(set[i] == n)
                return i;    // 검색 성공시 해당 값이 있는 배열의 Index값 반환
        }
        return -1;  // 검색 실패 시 -1 반환
    }

    public boolean contains(int n) {
        return indexOf(n) != -1 ? true : false;
    }

    public boolean add(int n) {
        if(num >= max || contains(n) == true)
            return false;
        set[num++] = n;
        return true;
    }

    public boolean remove(int n) {
        int index = indexOf(n);
        if(index == -1 || num <= 0)
            return false;
        set[index] = set[--num];   //  해당 요소가 들어있던 자리에 마지막 요소삽입
        return true;
    }

}
