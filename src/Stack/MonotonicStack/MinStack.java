package Stack.MonotonicStack;

public class MinStack {
    Stack head;
    class Stack{
        int min;
        int data;
        Stack next;
        Stack(int min, int data, Stack next){
            this.min = min;
            this.data = data;
            this.next = next;
        }
    }
    public MinStack() {

    }

    public void push(int val) {
        if(head==null) head = new Stack(val, val, null);
        head = new Stack(Math.min(val, head.min), val, head);
    }

    public void pop() {
        head= head.next;

    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;

    }
}
