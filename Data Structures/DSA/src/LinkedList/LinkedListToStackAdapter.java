package LinkedList;

import java.util.LinkedList;

public class LinkedListToStackAdapter {
    LinkedList<Integer> list;

    public int size(){
        return list.size();
    }

    public void push(int val){
        list.addFirst(val);
    }

    public int pop(){
        if(size() == 0){
            return -1;
        }else {
            return list.removeFirst();
        }
    }
    public int top(){
        if(list.isEmpty()){
            return -1;
        }else {
            return list.peek();
        }
    }
}
