//import LRULinkedList.java; 
import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUConstantTime obj = new LRUConstantTime(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUConstantTime {

    public static HashMap<Integer, Node> hmap;
    public LRULinkedList LRULinkedList;
    public LRUConstantTime(int capacity) {
        this.hmap = new HashMap<Integer, Node>();
        this.LRULinkedList = new LRULinkedList(capacity);
    }

    /**
     * Returns the value for the key in data structure.
     * If the value is not in data return -1
     * @param key
     * @return value
     */
    public int get(int key) {
        // TODO: implement this method
        //System.out.println("get: key " + key);
        //this.LRULinkedList.displayCurrentList();
        if (hmap.containsKey(key)) {
            Node node = hmap.get(key);
            //also switch positions around
            LRULinkedList.moveNodeToHead(node);
            return node.value;//change
        }
        else {
            return -1;
        }
    }

    /**
     * Put a key value pair in the cache. It value already exist
     * Override the value otherwise add the key value pair.
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // TODO: implement this method
        //if the node exists, then override the value
        //System.out.println("put: key " + key + " value: value" + value);
        //this.LRULinkedList.displayCurrentList();
    	if (LRULinkedList.capacity == LRULinkedList.size) {
    		int tailKey = LRULinkedList.tail.key;
    		hmap.remove(tailKey);
    	}
        if (hmap.containsKey(key)) {
            Node node = hmap.get(key);
            node.value = value;
            // linkedlist node value not updated
            LRULinkedList.moveNodeToHead(node);
        }
        else {
            Node node = new Node(key, value);
            hmap.put(key, node);
            LRULinkedList.add(key, value); //in the add method the capacity is discussed
        }
    }
    
    public static void main(String[] args) {
    
    	 //LRULinkedList t = new LRULinkedList(2);
    	 //t.test();
    	 
    
    	/*LRUConstantTime t = new LRUConstantTime(2);
    	t.put(1,1);
    	t.LRULinkedList.displayCurrentList();
    	t.put(2,2);
    	t.LRULinkedList.displayCurrentList();
    	System.out.println(t.get(1));
    	t.LRULinkedList.displayCurrentList();
    	t.put(3,3);
    	t.LRULinkedList.displayCurrentList();
    	System.out.println(t.get(2));
    	t.LRULinkedList.displayCurrentList();
    	t.put(4,4);
    	t.LRULinkedList.displayCurrentList();
    	System.out.println(t.get(1));
    	t.LRULinkedList.displayCurrentList();
    	System.out.println(t.get(3));
    	t.LRULinkedList.displayCurrentList();
    	System.out.println(t.get(4));
    	t.LRULinkedList.displayCurrentList();*/
    	
    }

}
