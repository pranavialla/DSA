package LinkedListProblems;

public class LinkedList {
    public Node head;

    Node tail;
    static int size;

    public static class Node {
        public int value;
        public Node next;

        public Node random;
        public Node(int value) {
            this.value=value;
            this.next=null;
            this.random=null;
        }

    }

    public static void traverseLinkedList(Node head){
        while(head!=null){
            System.out.print(head+ ", "+ head.value+ ", "+head.random);
            System.out.println();
            head=head.next;
        }

    }
}
