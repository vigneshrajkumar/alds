package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void run(){
        Node n2 = new Node(2, null, null);
        Node n1 = new Node(1, null, n2);
        Node n4 = new Node(4, null, null);
        Node n3 = new Node(3, n1, n4);

        System.out.println(Tree.inorderTraversal(n3));
    }

    private static void inorderWalk(Node root, List<Integer> list){
        if (root == null)
            return;
        inorderWalk(root.left, list);
        list.add(root.val);
        inorderWalk(root.right, list);
    }
    // Left, Root & Right
    public static List<Integer> inorderTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        inorderWalk(root, list);
        return list;
    }
}