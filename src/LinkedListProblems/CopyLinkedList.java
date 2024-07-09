package LinkedListProblems;

import LinkedListProblems.LinkedList;

import java.util.Map;

public class CopyLinkedList {
    public CopyLinkedList(){
        System.out.println("trail");
    }

    public LinkedList.Node callingMyself(Map<LinkedList.Node, LinkedList.Node> memory, LinkedList.Node head){
        if(head!=null){
            if(memory.containsKey(head)){
                return memory.get(head);
            }else{
                LinkedList.Node newNode=new LinkedList.Node(head.value);
                memory.put(head, newNode);
                if (head.next!=null){
                    newNode.next=callingMyself(memory, head.next);
                }
                if(head.random!=null){
                    newNode.random=callingMyself(memory, head.random);
                }
                return newNode;
            }
        }
        return null;
    }

    public LinkedList.Node copyRandomList(LinkedList.Node head) {
        LinkedList.Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            LinkedList.Node copy = new LinkedList.Node(iter.value);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        LinkedList.Node pseudoHead = new LinkedList.Node(0);
        LinkedList.Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}
