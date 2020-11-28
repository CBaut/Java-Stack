public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove() {
        // remove a node from the end of list
        if(head == null) {
            return;
        } else {
            Node runner = head;
            while(runner.next.next != null) {
                runner = runner.next;
            }
            runner.next = null;
        }
    }
    public printValues() {
        // print all values of each node in the list in order
        if(head == null) {
            return;
        } else {
            Node runner = head;
            while(runner != null) {
                System.out.println(runner.value);
                runner = runner.next;
            }
        }
        return;
    }
    public find(int value) {
        // return the first node with the value in the parameter
        if(head == null) {
            return null;
        } else {
            Node runner = head;
            while runner != null) {
                if(runner.value == value) {
                    return runner;
                }
                runner = runner.next;
            }
        }
            return null;
    }
    public removeAt(int index) {
        // remove the node after n nodes where n is the parameter
        if(head == null) {
            return null;
        }else {
            Node runner = head;
            for(int i = 0; i < index - 1; i++) {
                runner = runner.next;
            }
            // store the location of the node after the one we want to remove
            Node afterIndex = runner.next.next;
            // point the node tho this index before to the node at index after
            runner.next = afterIndx
        }
    }