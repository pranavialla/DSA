package LinkedListProblems;

class IntersectPoint {
  /*

  The Two-Pointer Trick
    You initialize:

    p1 at the head of List A

    p2 at the head of List B

    Then:

    Traverse both lists one node at a time.

    When p1 reaches the end of List A, redirect it to the head of List B.

    When p2 reaches the end of List B, redirect it to the head of List A.

    Eventually, both pointers will either:

    Meet at the intersection node, or

    Reach the end (null) at the same time if there's no intersection.

    ✅ Why It Works
        Each pointer travels:

        p1: a + c + b

        p2: b + c + a

        So both pointers cover the same total distance. By switching heads after the first pass, they align their traversal paths.

        🎯 If there's an intersection:
        They’ll meet at the shared node after a + b + c steps.

        🚫 If there's no intersection:
        Both will reach null after a + b steps and exit the loop.

  */
    // Function to get the intersection point of two linked lists
    static Node intersectPoint(Node head1, Node head2) {

        // Maintaining two pointers ptr1 and ptr2 
        // at the heads of the lists
        Node ptr1 = head1;
        Node ptr2 = head2;

        // If any one of the heads is NULL, there is no intersection
        if (ptr1 == null || ptr2 == null)
            return null;

        // Traverse through the lists until both pointers meet
        while (ptr1 != ptr2) {
          
            // Move to the next node in each list and if the one 
            // pointer reaches NULL, start from the other linked list
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }

        // Return the intersection node, or null if no intersection
        return ptr1;
    }