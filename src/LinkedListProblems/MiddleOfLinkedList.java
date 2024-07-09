package LinkedListProblems;
import  LinkedListProblems.LinkedList.Node;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class MiddleOfLinkedList {
    public Node getMiddleOdLinkedList(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null & fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.value);
        return slow;
    }
}
