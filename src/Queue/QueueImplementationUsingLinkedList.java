package Queue;

import LinkedListProblems.LinkedList.Node;


public class QueueImplementationUsingLinkedList {
    Node front, rear;
    int size;
    QueueImplementationUsingLinkedList(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    Node dequeue(){
        if(front == null){
            return front;
        }
        else{
            Node temp = front;
            front = front.next;
            size--;
            return temp;
        }
    }

    boolean isEmpty(){
        if(front == null){
            return true;
        }
        return false;
    }

    boolean enQueue(int data){
        if(rear == null){
            front = new Node(data);
            size++;
            return true;
        }
        Node newNode = new Node(data);
        rear.next = newNode;
        size++;
        rear = rear.next;
        return true;
    }
}
