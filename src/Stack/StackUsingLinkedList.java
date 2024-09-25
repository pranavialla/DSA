package Stack;

import LinkedListProblems.LinkedList.Node;

public class StackUsingLinkedList {
    Node top;
    int size;
    StackUsingLinkedList(){
        this.top = null;
        this.size = 0;
    }
    Node pop(){
        if(top == null){
            return top;
        }
        else{
            Node temp = top;
            top = top.next;
            size--;
            return temp;
        }
    }

    boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    boolean push(int data){
        if(top == null){
            top = new Node(data);
            size++;
            return true;
        }
        Node prevTop = top;
        top = new Node(data);
        top.next = prevTop;
        size++;
        return true;
    }


}
