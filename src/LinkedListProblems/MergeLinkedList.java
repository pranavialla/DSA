package LinkedListProblems;

public class MergeLinkedList {


    public LinkedList.Node mergeTwoLists(LinkedList.Node l1, LinkedList.Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.value < l2.value){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public LinkedList.Node mergeTwoLists2(LinkedList.Node l1, LinkedList.Node l2) {
        LinkedList.Node head = new LinkedList.Node(0);
        LinkedList.Node handler = head;
        while(l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        return head.next;
    }

    public LinkedList.Node insert(LinkedList.Node prev, LinkedList.Node nextNode, LinkedList.Node nodeToInsert){
        prev.next=nodeToInsert;
        nodeToInsert.next=nextNode;
        return nodeToInsert;
    }
    public LinkedList.Node getMergedLinkedList(LinkedList.Node list1, LinkedList.Node list2){
        if(list2==null)
            return list1;
        else if(list2==null)
            return list2;

        LinkedList.Node dummy= new LinkedList.Node(Integer.MIN_VALUE);
        dummy.next=list1;
        list1=dummy;

        LinkedList.Node prev=null;
        while (list1!=null && list2!=null){
            if(list1.value< list2.value){
                prev=list1;
                list1=list1.next;
            }
            else {
                LinkedList.Node tempNext=list2.next;
                prev=insert(prev, list1, list2);
                list2=tempNext;
            }
        }

        if(list1==null && list2!=null)
            prev.next=list2;
        LinkedList.traverseLinkedList(dummy.next);
        return dummy.next;

    }
}
