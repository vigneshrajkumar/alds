package LinkedList;


public class LinkedList {

    private static void print(Node head){
        Node iter = head;
        while(iter != null){
            System.out.print(iter.getVal() + " -> ");
            iter = iter.getNext();
        }

        System.out.print("null \n");
    }

    public static void run(){
        Node n1 = new Node(4, null);    
        Node n2 = new Node(3, null);    
        Node n3 = new Node(2, null);    
        Node n4 = new Node(1, null);    
        Node n5 = new Node(0, null);    

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        // print(reverse(n1));

    }

    // private static Node reverseIteratively(Node head){

    // }

    // private static Node reverse(Node head){
    //     return reverseIteratively(head);
    // }
    
}