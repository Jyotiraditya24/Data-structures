package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    static private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(Node next) {
            this.next = next;
        }
    }

    public LL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAtEnd(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp == null) {
            head = newNode;
            this.size++;
            this.tail = newNode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.next = null;
        temp.next = newNode;
        this.size++;
        this.tail = newNode;
    }

    public void addAtBeginning(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp == null) {
            this.head = newNode;
            newNode.next = null;
            this.size++;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
            this.size++;
        }
    }

    public void print() {
        Node temp = head;
        System.out.print("START->");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public int getSize() {
        return size;
    }

    public int removeFromEnd() {
        Node temp = head;
        if (temp == null) {
            return Integer.MIN_VALUE;
        }
        if (temp.next == null) {
            this.head = null;
            this.size = 0;
            this.tail = null;
            return temp.data;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int removedValue = temp.next.data;
        temp.next = null;
        this.size--;
        tail = temp;
        return removedValue;
    }

    public int getNodeData(int index) {
        if (head == null) {
            System.out.println("No LinkedList Available");
            return Integer.MIN_VALUE;
        }

        if (index < 0 || index >= size) {
            System.out.println("OUT OF BOUNDS");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void addAtIndex(int data, int index) {
        if (head == null && index != 0) {
            System.out.println("CANNOT ADD AT INDEX" + index + "When null");
            return;
        }
        if (index == 0) {
            addAtBeginning(data);
            return;
        }
        if (index == size + 1) {
            addAtEnd(data);
            return;
        }
        if (index > size || index < 0) { // Invalid index
            System.out.println("INVALID INDEX: " + index);
            return;
        }
        Node temp1 = head;

        for (int i = 0; i < index - 1; i++) {
            temp1 = temp1.next;
        }

        Node node = new Node(data);
        node.next = temp1.next;
        temp1.next = node;
        this.size++;
    }

    public void reverse1() {
        if (head == null || head.next == null) {
            System.out.println("INVALID: CANNOT REVERSE EMPTY LIST OR LIST WITH ONLY ONE ELEMENT");
            return;
        }
        Node temp1 = head.next;
        Node temp2 = head;
        Node temp3 = null;

        while (temp1 != null) {
            temp2.next = temp3;
//                temp1.next = temp2;
            temp3 = temp2;
            temp2 = temp1;
            temp1 = temp1.next;
        }
        temp2.next = temp3;
        head = temp2;

    }

    public int removeAtFirst() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        if (head.next == null) {
            int removedData = head.data;
            this.head = this.tail = null;
            size--;
            return removedData;
        }
        int removedData = head.data;
        head = head.next;
        this.size--;
        return removedData;
    }

    public int removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            return Integer.MIN_VALUE;
        } else if (index == 0) {
            return removeAtFirst();
        } else if (index == size - 1) {
            return removeFromEnd();
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            int removedData = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return removedData;
        }
    }

//    K-th element from the end ,the end element index is 0
    public int kElementFromEnd(int k){
//        slow fast pointer maintaining a distance of k;
         Node slow  = head;
         Node fast = head;

         for (int i=0;i<k;i++){
             fast = fast.next;
         }
         while(fast.next!=null){
             fast = fast.next;
             slow = slow.next;
         }

         return slow.data;
    }

    public int middleOfLinkedList(){
        Node slow = this.head;
        Node fast = this.head;

//        if no linked list
        if(head == null ){
            return -1;
        }

//        if size is one no middle
        if(head.next == null){
            return -1;
        }

//        if size 2 then also  no middle
        if (head.next.next == null){
            return -1;
        }

//        minimum lenght 3
//        while(fast != null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        OR

//        IF DOING THIS DONOT CHECK THE 3 CONDITIONS ABOVE

        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }
    public void deleteDuplicates() {
        if(this.head == null){
            return;
        }
        if(this.head.next == null){
            return;
        }
        Node slow = head;
        Node fast = head.next;

        while(fast!= null){
            if(slow.data == fast.data){
                slow.next = fast.next;
            }else {
                slow = slow.next;
            }
            fast = fast.next;
        }

    }
}

