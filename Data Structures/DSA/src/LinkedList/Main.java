package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.addAtEnd(10);
        list.addAtBeginning(20);
        list.addAtEnd(40);
        list.addAtEnd(100);
        list.print();
        System.out.println();
//        System.out.println('\n'+list.getSize());
//        int d = list.removeFromEnd();
//        list.addAtIndex(600,3);
//        list.reverse1();
//        list.print();

        System.out.println(list.kElementFromEnd(0));
        System.out.println(list.middleOfLinkedList());
    }
}
