import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            rq.enqueue(s);
        }
        int k = Integer.parseInt(args[0]);
        //是用Integer.parseInt()返回一个数，而不是Integer.valueOf()返回一个对象

        while (k > 0) {
            StdOut.println(rq.dequeue());
            k--;
        }
    }
}
