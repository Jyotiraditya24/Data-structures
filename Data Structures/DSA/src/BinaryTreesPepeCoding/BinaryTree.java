package BinaryTreesPepeCoding;

import java.lang.reflect.Array;
import java.util.*;

public class BinaryTree {
    private Node root;
    ArrayList<Integer> classList = new ArrayList<>();

    private static class Node {
        Node left;
        Node right;

        int data;


        private Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        private Node(int data) {
            this.data = data;
        }

        private Node() {

        }
    }

    private static class Pair {
        Node node;
        int state;

        private Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public BinaryTree() {
        root = new Node();
    }

    public void insertData(Integer[] arr) {
        // Added a check to ensure the input array is not null or empty.
        if (arr == null || arr.length == 0) {
            return; // handle empty array case
        }

        Stack<Pair> st = new Stack<>();
        int index = 0;
        Node node = new Node(arr[index]);
        root = node;
        Pair pair = new Pair(node, 1);
        st.push(pair);

        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) {
                index++;
                // Modified the condition for checking null values in the array inside the while loop to prevent index out of bounds errors.
                if (index < arr.length && arr[index] != null) {
                    Node ln = new Node(arr[index]);
                    top.node.left = ln;
                    st.push(new Pair(ln, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                index++;
                // Modified the condition for checking null values in the array inside the while loop to prevent index out of bounds errors.
                if (index < arr.length && arr[index] != null) {
                    Node rn = new Node(arr[index]);
                    top.node.right = rn;
                    st.push(new Pair(rn, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        String leftData = (node.left != null) ? String.valueOf(node.left.data) : ".";
        String rightData = (node.right != null) ? String.valueOf(node.right.data) : ".";
        System.out.println(leftData + " <- " + node.data + " -> " + rightData);
        display(node.left);
        display(node.right);
    }

    public void display() {
        display(this.root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        int sizeLeft = size(node.left);
        int sizeRight = size(node.right);
        return 1 + sizeLeft + sizeRight;
    }

    public int size() {
        return size(this.root);
    }

    private int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return node.data + leftSum + rightSum;
    }

    public int sum() {
        return sum(this.root);
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node root) {
        if (root == null) {
            return 0;
        }
        int leftMax = max(root.left);
        int rightMax = max(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));

    }

    private int height(Node root) {
        if (root == null) {
            return 0;  //-1 for edges and 0 for  nodes
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public void inorder() {
        inorder(this.root);
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public void preorder() {
        preorder(this.root);
    }

    private void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder() {
        postorder(this.root);
    }

    private void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    private void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node remove = queue.remove();
                System.out.println(remove.data);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            System.out.println();
        }
    }

    public void levelOrder() {
        levelOrder(this.root);
    }


    public void iterativePrinting() {
        iterativePrinting(root);
    }

    private void iterativePrinting(Node root) {
        if (root == null) {
            System.out.println("Null");
            return;
        }

        Stack<Pair> st = new Stack<>(); // Use a local stack here
        st.push(new Pair(root, 1)); // Push the root node with initial state 1
        while (!st.isEmpty()) {
            Pair current = st.peek(); // Peek at the top of the stack
            if (current.state == 1) { // State 1: PreOrder traversal
                System.out.print("PreOrder: " + current.node.data + " "); // Print the current node
                current.state++; // Move to the next state
                if (current.node.left != null) {
                    st.push(new Pair(current.node.left, 1)); // Push left child with state 1
                }
            } else if (current.state == 2) { // State 2: InOrder traversal
                System.out.print("InOrder: " + current.node.data + " "); // Print the current node
                current.state++; // Move to the next state
                if (current.node.right != null) {
                    st.push(new Pair(current.node.right, 1)); // Push right child with state 1
                }
            } else { // State 3: PostOrder traversal
                System.out.print("PostOrder: " + current.node.data + " "); // Print the current node
                st.pop(); // Pop the node as all its children are processed
            }
        }
    }

    public List<String> nodeToRootPaths() {
        return nodeToRootPaths(this.root);
    }

    private List<String> nodeToRootPaths(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        List<String> leftList = nodeToRootPaths(root.left);
        List<String> rightList = nodeToRootPaths(root.right);

        if (!leftList.isEmpty()) {
            for (String str : leftList) {
                int currentDat = root.data;
                String ans = currentDat + "->" + str;
                list.add(ans);
            }
        }
        if (!rightList.isEmpty()) {
            for (String str : rightList) {
                int currentDat = root.data;
                String ans = currentDat + "->" + str;
                list.add(ans);
            }
        }
        if (leftList.isEmpty() && rightList.isEmpty()) {
            list.add(root.data + "");
        }

        return list;
    }

    public boolean nodeExist(int data) {
        boolean ans = nodeExist(data, this.root);
        System.out.println(classList);
        return ans;

    }

    private boolean nodeExist(int data, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            classList.add(data);
            classList2.add(root);
            return true;
        }
        boolean leftCalls = nodeExist(data, root.left);
        if (leftCalls) {
            classList.add(root.data);
            classList2.add(root);
            return true;
        }
        boolean rightCalls = nodeExist(data, root.right);
        if (rightCalls) {
            classList.add(root.data);
            classList2.add(root);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> printKlevelsDown(int level) {
        return printKlevelsDown(this.root, level);
    }

    private ArrayList<Integer> printKlevelsDown(Node node, int level) {
        if (node == null || level < 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        int i = 0;
        queue.add(node);

        while (!queue.isEmpty() && i <= level) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Node n = queue.remove();
                if (i == level) {
                    list.add(n.data);
                }
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            i++;
        }
        return list;
    }

    public void printKlevelDownRecursively(int k) {
        printKlevelDownRecursively(this.root, k);
    }

    private void printKlevelDownRecursively(Node node, int k) {
        if (k < 0 || node == null) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
        }
        printKlevelDownRecursively(node.left, k - 1);
        printKlevelDownRecursively(node.right, k - 1);
    }


    ArrayList<Integer> localList = new ArrayList<>();
    ArrayList<Node>classList2 = new ArrayList<>();
    public ArrayList<Integer> distanceK(int target, int k) {
        return distanceK(this.root, target, k);
    }

    private ArrayList<Integer> distanceK(Node node, int target, int k) {
        boolean tORf = nodeExist(target);
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Node> list =  this.classList2;
       for (int i = 0;i<list.size() && i<= k;i++){
           printKLevelDownWithBlocker(list.get(i),k-i,i==0?null:list.get(i-1));
           ans.addAll(localList);
           localList.clear();
       }
       return ans;
    }
    private void  printKLevelDownWithBlocker(Node node,int level,Node blocker){
        if(node == null || level< 0 || node == blocker){
            return;
        }
        if(level == 0){
            localList.add(node.data);
        }
            printKLevelDownWithBlocker(node.left,level -1,blocker);
            printKLevelDownWithBlocker(node.right,level - 1,blocker);
    }

    public void leftCloned(){
       Node newHead =  leftCloned(this.root);
       this.root = newHead;
    }

    private Node leftCloned(Node node){
        if(node == null){
            return null;
        }

        // Recursively clone the left and right subtrees
        Node leftClone = leftCloned(node.left);
        Node rightClone = leftCloned(node.right);

        // Create a new node with the same data as the current node
        Node newNode = new Node(node.data);

        // Connect the cloned left subtree to the new node
        newNode.left = leftClone;

        // Connect the original right subtree to the new node's right child
        node.right = rightClone;

        // Connect the new node to the original node's left child
        node.left = newNode;

        // Return the modified original node
        return node;
    }

    private Node removeLeftClone(Node root){
        if(root == null){
            return null;
        }

        Node leftCall = removeLeftClone(root.left.left);
        Node rightCall = removeLeftClone(root.right);


        root.left = leftCall;
        root.right = rightCall;

        return root;
    }

    public void removeLeftClone(){
       Node newHead =  removeLeftClone(this.root);
       this.root = newHead;
    }

    private boolean isCousins(Node root, int x, int y) {
        nodeExist(x,root);
        ArrayList<Node> pathList1 = new ArrayList<>(classList2);
        classList2.clear();
        nodeExist(y,root);
        ArrayList<Node> pathList2 = new ArrayList<>(classList2);


        int depth1 = 0;
        int depth2 = 0;
        for(int i= pathList1.size()-1;i>=0;i--){
            if(pathList1.get(i).data == x){
                break;
            }
            depth1++;
        }
        for(int j= pathList2.size()-1;j>=0;j--){
            if(pathList2.get(j).data == y){
                break;
            }
            depth2++;
        }
        int index1 =pathList1.size() -  depth1;
        int index2 = pathList1.size()- depth2;
        int a = pathList1.get(index1).data;
        int b =  pathList2.get(index2).data;

        return (a!=b &&pathList1.get(depth1 - 1).data != pathList2.get(depth2 - 1).data) && depth2 != 0 && depth1 == depth2;
    }

    public boolean isCousins(int x , int y){
        return isCousins(this.root,x,y);
    }

    private void printSingleChildNodes(Node node){
        if(node == null){
            return;
        }

        if((node.left != null && node.right == null)  ||  (node.left==null && node.right!=null )){
            System.out.println(node.data);
            return;
        }
         printSingleChildNodes(node.left);
         printSingleChildNodes(node.right);
    }

    public void printSIngleChildNodes(){
        printSingleChildNodes(this.root);
    }

    public void removeLeafs(){
        this.root = removeLeafs(this.root);
    }

    private Node removeLeafs(Node node){
        if(node == null){
            return null;
        }
        if(node.right == null && node.left == null){
            return null;
        }
        node.left = removeLeafs(node.left);
        node.right = removeLeafs(node.right);

        return node;
    }


}
