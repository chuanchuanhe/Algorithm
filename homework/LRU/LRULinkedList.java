//import Node.java; 

public class LRULinkedList {
    public Node head;
    public Node tail;
    public int capacity =0;
    public int size =0;

    /**
     * Constructor creates a double linked list with a single value.
     */
    public LRULinkedList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Add a node to the linked list.
     * @param key
     * @param value
     * @return new node
     */
    public Node add(int key, int value) {
        // TODO: implement this method
        // size < capacity, just add the node if the key is not already present, update head to the new key and update old head.prev pointing to new head
        // size 3,   A B insert C
        //     c a b, TODO: A.prev point to C, c.next = A, head = C
        // size = capacity, delete tail then add node ABC, insert D , head.next = B, D.prev = NULL, head = D, D.next = B.prev 
        // delete tail, update head (create new node, new node.next = )
        // A B cap 2 insert C
        // delete tail, A is head and tail now
        // if size 1, replace head tail, done
        // if size 2, tail.prev = tail, head = new node, set pointers
      
            if (size < capacity) {

                Node newNode = new Node(key, value);
                // edge case on size 01 and 2
                if (size == 0) {
                    newNode.previous = null;
                    newNode.next = null;
                    tail = newNode;
                }
                else if (size == 1) {
                    newNode.next = tail;
                    newNode.previous = null;
                    tail.previous = newNode;
                }
                else {
                    // A B,   null<-C
                    // size 2 above
                    newNode.previous = null;
                    newNode.next = head;
                    head.previous = newNode;
                }
                head = newNode;
                size++;
            }
            else {
                // at capacity
                if (capacity > 0) {
                    deleteTail();
                    add(key, value);
                }

            }
        
        return head;
    }

    /**
     * Remove the last item in the linked list.
     */
    public void deleteTail(){ //delete and update the tail
        // TODO: implement this method
        /*tail.previous.previous.next = tail;
        tail.previous = tail.previous.previous;*/
        // not sure
        if (size>1) {
            tail.previous.next = null;
            tail = tail.previous;
            size--;
        }
        else {
            head = null;
            tail = null;
            size = 0;
        }

        // size 3 , A B C.   A is the most recently used node, head
        // C is the least recently used node
        // B.next->NULL
        // HEAD  TAIL
        //  NULL<-A -><-  B  -> NULL

        // NULL<-A->NULL

        // NULL <-A->NULL

    }

    /**
     * Get the node that corresponds to the passed in key.
     * @param key
     * @return node that matches key
     */
    public Node getNode(int key){
        // TODO: implement this method
        Node node = head;
        while (node.next != null) {
            if (node.key == key) {
            	moveNodeToHead(node);
                return node;
            }
            else {
                node = node.next;
            }
        }
        if (node.key == key) {
        	moveNodeToHead(node);
            return node;
        }
        // not found
        //Node newNode = new Node(-1,-1);
        return null; //if not exist? ??? how to throw exception error ?
    }

    /**
     * Move the passed in node to the head position.
     * @param node
     */
    public void moveNodeToHead(Node node){
    	// assume node already exist in the list
    	// A B C 
    	// A B
    	// A
        if (node.key == head.key) {
          // if size one, then it will be head
          head.value = node.value;
        }
        else if (size == 2) {
            node.next = head;
            node.previous = null;
            head.next = null;
            head.previous = node;
            tail = head;
            head = node;          
        } 
        else {
            Node temp = node;
             // size 3 or above and not head
            // if it is tail
            if (temp.next == null) {
                
                    // assign new tail
                    //System.out.println("temp.next == null");
                    tail.previous.next = null;
                    tail = tail.previous;
                    // assign new head
                    node.previous = null;
                    node.next = head;
                    node.next.previous = node; //new: what I added
                    head = node;
                

            }
            else {
                //displayCurrentList();
                //System.out.println("move "+node.key + "with value "+node.value);
                  //System.out.println("else");
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                    node.next = head;
                    node.next.previous = node; //
                    node.previous = null;
                    head = node;
                    
            }
      }



    	/*Node temp = node;
    	// node is a tail
        if (size == 0) {
            head = node;
            tail = node;
            node.next = null;
            node.previous = null; 
        }
        else if (size == 1) {
            node.next = head;
            head.previous = node; 
            node.previous = null;
            head = node;
            tail = node.next; 
        }
    	if (temp.next == null) {
    		// assign new tail
            //System.out.println("temp.next == null");
    		tail.previous.next = null;
    		tail = tail.previous;
    		// assign new head
        	node.previous = null;
    		node.next = head;
    		head = node;
    		if (tail.previous == null) {
    			// means tail was the head
                //System.out.println("tail.previous == null");
    			tail.previous = head;
    		}
    	}
    	else if (temp.previous == null) {
    		// already head
    	}
    	else {
            //System.out.println("else");
			node.previous.next = node.next;
			node.next.previous = node.previous;
			node.next = head;
	    	node.previous = null;
			head = node;
    	}*/
    }
    /*public void test() {
    	System.out.println("test");
    	add(1,1);
    	displayCurrentList();
    	add(2,2);
    	displayCurrentList();
    	Node temp = getNode(1);
    	System.out.println(temp.value);
    	displayCurrentList();
    	add(3,3);
    	displayCurrentList();
    	temp = getNode(2);
    	System.out.println(temp.value);
    	displayCurrentList();
    	add(4,4);
    	displayCurrentList();
    	temp = getNode(1);
    	System.out.println(temp.value);
    	displayCurrentList();
    	temp = getNode(3);
    	System.out.println(temp.value);
    	displayCurrentList();
    	temp = getNode(4);
    	System.out.println(temp.value);
    	displayCurrentList();
    }*/
    
    /*public void displayCurrentList() {
    	Node current = head;
        while (current.next!=null) {
            System.out.print(current.value+" ");
            current = current.next;
        }

        //System.out.println(current.value);
    }*/
}
