package LinkedListProblems;
import  LinkedListProblems.LinkedList.Node;

public class ReverseLinkedList {
    public Node getReverseLinkedList(Node head){
            Node prev=null;
            Node cur=head;
            Node curNext;
            while (cur!=null ){
                curNext=cur.next;
                cur.next=prev;
                prev=cur;
                cur=curNext;
            }
            LinkedList.traverseLinkedList(prev);
            return prev;
    }
}
