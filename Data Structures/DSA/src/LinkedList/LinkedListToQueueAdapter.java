package LinkedList;

import java.util.LinkedList;

public class LinkedListToQueueAdapter {
    LinkedList<Integer> list = new LinkedList<>();

    public int size(){
        return list.size();
    }
//    Add Last
    public void add(int val){
        list.addFirst(val);
    }
//    remove First
    public int remove(){
        if(list.isEmpty()){
            return  -1;
        }else {
           return list.removeFirst();
        }
    }

    public int peek(){
        if(list.isEmpty()){
            return  -1;
        }else {
            return list.peek();
        }
    }
}
