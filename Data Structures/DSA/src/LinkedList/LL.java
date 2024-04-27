package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    // Node class for LinkedList
    private static class Node {
        int data;
        Node next;

        public Node(){

        }
        public Node(int data) {
            this.data = data;
        }
    }

    // Constructor to initialize LinkedList
    public LL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add a new node at the end of the LinkedList
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode; // Update tail to the new node
        size++; // Increment size
    }

    // Add a new node at the beginning of the LinkedList
    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            tail = newNode; // Update tail when adding the first node
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Print the elements of the LinkedList
    public void print() {
        Node temp = head;
        System.out.print("START->");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    // Get the size of the LinkedList
    public int getSize() {
        return size;
    }

    // Remove the last node from the LinkedList
    public int removeFromEnd() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        int removedData;
        if (head == tail) {
            removedData = head.data;
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            removedData = tail.data;
            temp.next = null;
            tail = temp;
        }
        size--;
        return removedData;
    }

    // Get the data of the node at a given index in the LinkedList
    public int getNodeData(int index) {
        if (index < 0 || index >= size || head == null) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Add a new node at a specific index in the LinkedList
    public void addAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addAtBeginning(data);
        } else if (index == size) {
            addAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    // Reverse the LinkedList
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

    // Remove the first node from the LinkedList
    public int removeAtFirst() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        int removedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return removedData;
    }

    // Remove the node at a specific index from the LinkedList
    public int removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            return removeAtFirst();
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        int removedData = temp.next.data;
        temp.next = temp.next.next;
        if (temp.next == null) {
            tail = temp;
        }
        size--;
        return removedData;
    }

    // Get the data of the k-th element from the end of the LinkedList
    public int kElementFromEnd(int k) {
        if (k < 0 || k >= size) {
            throw new IllegalArgumentException("Invalid k");
        }
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    // Get the data of the middle element of the LinkedList
    public int middleOfLinkedList() {
        if (head == null || head.next == null) {
            throw new IllegalStateException("List is empty or has only one element");
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }
    // Delete duplicate nodes from the LinkedList
    public void deleteDuplicates() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

//    public void mergeSort(){
//        mergeSort(this.head,this.tail);
//    }
//    private Node mergeSort(Node head,Node tail){
//       Node mid = findMindNode(head,tail);
//
//       Node leftCall = mergeSort(head,mid);
//       Node rightCall = mergeSort(mid.next,tail);
//
//    }

    private Node findMindNode(Node head,Node tail){
        Node slow = head;
        Node fast = head;

        if (head == null || head.next == null) {
            throw new IllegalStateException("List is empty or has only one element");
        }

        while(fast != tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

        private Node oddEvenListIndex(Node head) {

            if (head == null || head.next == null){
                return head;
            }


            Node evenHead = head.next;
            Node oddHead = head;

            Node currentOdd = oddHead ;
            Node currentEven = evenHead;



            while(currentEven!=null && currentEven.next!=null){
                currentOdd.next = currentEven.next;
                currentOdd = currentOdd.next;
                currentEven.next = currentOdd.next;
                currentEven = currentEven.next;
            }

            currentOdd.next = evenHead;

            return oddHead;

        }


    public void oddEvenListIndex(){
            this.head = oddEvenListIndex(this.head);
    }

    public void reverseLinkedListRecursively(){
        reverseLinkedListRecursively(this.head);
        head.next = null;
        Node temp = head;
        head = tail;
        tail = temp;
    }

    private void reverseLinkedListRecursively(Node node){
       if(node == null || node.next==null){
           return;
       }

       reverseLinkedListRecursively(node.next);
       node.next.next = node;
    }

    public void reverseUsingData


}
