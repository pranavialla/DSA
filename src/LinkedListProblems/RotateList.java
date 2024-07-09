package LinkedListProblems;

public class RotateList {
    public void RotateList(LinkedList.Node head, int k){
        {
            if(head == null) //return null;
            LinkedList.size = 1;
            LinkedList.Node  tail = head;

            //find tail and count listNum
            while(tail.next != null){
                LinkedList.size++;
                tail = tail.next;
            }
            tail.next = head;
            int newHeadIndex = LinkedList.size - k % LinkedList.size;

            for(int i = 0; i < newHeadIndex; i++){
                tail = tail.next;
            }

            head = tail.next;
            tail.next = null;

            //return head
        }
    }
}
