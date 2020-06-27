import java.util.LinkedList;
import java.util.Queue;

public class StringReverse {

    public static void main(String[] args) {
        String s = "Reverse";
        System.out.println(swap(s));

        Queue<String> queue = new LinkedList<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.size());
    }

    /*
     * 문자열 뒤집기 (배열 역순으로 재정렬)
     */
    public static String swap(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < s.length()/2 ; i++) {
            char a = s.charAt(i);
            char b = s.charAt(s.length() - 1 - i);
            sb.setCharAt(i, b);
            sb.setCharAt(s.length()-1-i , a);
        }
        return sb.toString();
    }

}
