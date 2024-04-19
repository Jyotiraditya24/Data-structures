package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    static private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
        public Node(Node next){
            this.next = next;
        }
    }
    public LL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAtEnd(int data){
        Node temp = head;
        Node newNode = new Node(data);
        if(temp == null){
          head = newNode;
          this.size++;
          this.tail = newNode;
          return;
        }
        while(temp.next!=null){
          temp = temp.next;
        }
        newNode.next = null;
        temp.next = newNode;
        this.size++;
        this.tail = newNode;
    }

    public void addAtBeginning(int data){
        Node temp = head;
        Node newNode = new Node(data);
        if(temp == null){
            this.head =  newNode;
            newNode.next = null;
            this.size++;
            this.tail = newNode;
        }else {
            newNode.next = this.head;
            this.head =  newNode;
            this.size++;
        }
    }

    public void print(){
        Node temp = head;
        System.out.print("START->");
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public int getSize() {
        return size;
    }

    public int removeFromEnd(){
        Node temp = head;
        if(temp == null){
            return Integer.MIN_VALUE;
        }
        if(temp.next == null){
            this.head = null;
            this.size = 0;
            this.tail = null;
            return temp.data;
        }
        while(temp.next.next!=null){
            temp = temp.next;
        }
        int removedValue = temp.next.data;
        temp.next = null;
        this.size--;
        tail = temp;
        return removedValue;
    }
}
