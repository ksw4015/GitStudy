public class IntStack {

    private int size;
    private int index;
    private int[] stackArr;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {

        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {

        }
    }

    public IntStack(int size) {
        index = 0;
        this.size = size;
        try{
            stackArr = new int[this.size];
        } catch (OutOfMemoryError e) {  // 크기가 너무 크면 예외처리
            this.size = 0;
        }
    }

    public void push(int n) {
        if(index >= size)
            throw new OverflowIntStackException();
        stackArr[index++] = n;
    }

    public int pop() {
        if(index <= 0)
            throw new EmptyIntStackException();
        return stackArr[--index];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index <= 0;
    }

}
