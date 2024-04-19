package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.addAtEnd(10);
        list.addAtBeginning(20);
        list.print();
        System.out.println('\n'+list.getSize());
        int d = list.removeFromEnd();
        System.out.println(d);
    }
}
