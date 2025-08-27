class CloneLinkedListWithRandomPointer {
    
    // Function to clone the linked list
    static Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        
        // Create new nodes and insert them next to the original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        // Set the random pointers of the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Separate the new nodes from the original nodes
        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;
        while (clone.next != null) {
            // Update the next nodes of original node
          	// and cloned node
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            
            // Move pointers of original and cloned
          	// linked list to their next nodes
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;
        
        return clonedHead;
    }
  