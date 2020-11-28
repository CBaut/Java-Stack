public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.remove();
        sll.remove();
        sll.printValues();
    }
}
// Objectives:
// [] Practice creating classes and objects.

// [] Learn and implement a singly linked list in Java.

// Tasks:
// [x] Create a Node class like the above.

// [x] Fill in the constructor method that sets the value to a given number and next to null of your Node objects.

// [x] Create a SinglyLinkedList class like the above.

// [x] Create a constructor method that sets the head to null of your SinglyLinkedList objects

// [x] Create a remove() method that will remove a node from the end of your list

// [x] Create printValues() method that will print all the values of each node in the list in order

// [x] Create a ListTester class like the above.

// Optional Challenges:
// [x] Implement a find(int) method that will return the first node with the value in the parameter

// [x] Implement a removeAt(int) method that will remove the node after n nodes, where n is the parameter. For example, if n is 0, remove the first node. If n is 1, remove the second node. Similar to Arrays.