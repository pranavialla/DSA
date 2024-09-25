package Stack;
import java.util.*;
public class StackUsingQueue {
        private Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);

            //pushing all elements to the back of the inserted element
            for (int i=1; i<queue.size(); i++)
                queue.add(queue.remove());

        }

        public void pop() {
            queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

}
