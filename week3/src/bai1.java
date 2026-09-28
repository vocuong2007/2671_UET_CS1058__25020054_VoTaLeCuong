import java.io.*;
import java.util.*;

public class bai1 {

    static class MyQueue<T> {

        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        void enqueue(T value) {
            stack1.push(value);
        }

        void transfer() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        void dequeue() {
            transfer();
            stack2.pop();
        }

        T peek() {
            transfer();
            return stack2.peek();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int q = Integer.parseInt(br.readLine());

        MyQueue<Integer> queue = new MyQueue<>();

        while (q-- > 0) {

            String[] parts = br.readLine().split(" ");

            int type = Integer.parseInt(parts[0]);

            if (type == 1) {
                int value = Integer.parseInt(parts[1]);
                queue.enqueue(value);

            } else if (type == 2) {
                queue.dequeue();

            } else if (type == 3) {
                System.out.println(queue.peek());
            }
        }
    }
}