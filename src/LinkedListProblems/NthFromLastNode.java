package LinkedListProblems;

public class NthFromLastNode {
    public void getnthFromLastNode(LinkedList.Node head, int n){
        System.out.println("-----------gettign nth node from last-----------");
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;
        n=n+1;
        while (n!=0 && fast!=null){
            fast=fast.next;
            n-=1;
        }
        if(n!=0){
            LinkedList.traverseLinkedList(head.next);
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        LinkedList.traverseLinkedList(head);
    }
}
