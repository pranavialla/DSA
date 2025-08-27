public class segregateEvenOdd {

    // Function to segregate even and odd nodes
    // and return the head of the new list.
    public static Node segregateEvenOdd(Node head) {

        // We create dummy nodes to avoid extra 
        // condition checks in the while loop.
        Node eStart = new Node(0);
        Node oStart = new Node(0);

        // Pointers to the end of the even and odd lists
        Node eEnd = eStart;
        Node oEnd = oStart;

        // Node to traverse the list
        Node curr = head;

        while (curr != null) {
            int val = curr.data;

            // If current value is even, add it to the even list
            if (val % 2 == 0) {
                eEnd.next = curr;
                eEnd = eEnd.next;
            } else { // Else to the odd list
                oEnd.next = curr;
                oEnd = oEnd.next;
            }

            // Move to the next node
            curr = curr.next;
        }

        // Terminate the odd list
        oEnd.next = null;

        // Combine even and odd lists
        eEnd.next = oStart.next;

        // Return the new head of the combined list (even head)
        return eStart.next;
    }
