class mergeKLists {

    // Function to merge K sorted linked lists
    static Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Insert the head nodes of k lists 
        for (Node head : arr) {
            if (head != null) pq.add(head);
        }

        // Initialize a dummy head 
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (!pq.isEmpty()) {

            // Pop the min node 
            Node top = pq.poll();

            // Append the node into list 
            tail.next = top;
            tail = top;

            // If top node has next node,
            // add it to the heap.
            if (top.next != null) {
                pq.add(top.next);
            }
        }

        return dummy.next;
    }