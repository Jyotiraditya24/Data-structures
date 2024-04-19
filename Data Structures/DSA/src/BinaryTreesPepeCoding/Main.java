package BinaryTreesPepeCoding;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Integer[] arr = {50, 25, 12, null,null, 37, 30, null, null, null, 75,62, null, 70, null,null,57,null,null};
//        Integer[] testArr ={1,2,null,4,null,null,3,null,null};
        tree.insertData(arr);
//        tree.preOrder();
//        tree.display();
//        System.out.println( tree.size());
//        System.out.println(tree.sum());
//        System.out.println(tree.max());
//        tree.levelOrder();
//        tree.iterativePrinting();
//        System.out.println();
//        System.out.println(tree.nodeToRootPaths());
//        System.out.println(tree.nodeExist(37));
//        System.out.println(tree.printKlevelsDown(2));
//         tree.printKlevelDownRecursively(2);
//         tree.distanceK(37,1);
//        System.out.println(tree.distanceK(75,3));
//        tree.leftCloned();
//        tree.removeLeftClone();
        tree.display();
//        System.out.println(tree.isCousins(2,3));
//        tree.printSIngleChildNodes();
        tree.removeLeafs();
        System.out.println("HHHEOIQWHFOHFOQWHOFUHQWOUHOHQWUFHQO");
        tree.display();
    }

}
