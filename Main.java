import sorting.*;
import structures.*;



public class Main {

    public static void main(String[] args) {

        Graph gr = new Graph(6);
        gr.addEdge(5, 2);
        gr.addEdge(5, 0);
        gr.addEdge(4, 0);
        gr.addEdge(4, 1);
        gr.addEdge(2, 3);
        gr.addEdge(3, 1);
        TopologicalGraphSort.sort(gr);
    }
}
