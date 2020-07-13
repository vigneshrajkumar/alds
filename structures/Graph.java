package structures;
import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> adjList;
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList = new ArrayList<ArrayList<Integer>>(vertexCount);
        for (int ix = 0; ix < vertexCount; ix++)
            adjList.add(new ArrayList<Integer>());

    }

    public void addEdge(int fromVertex, int toVertex) {
        adjList.get(fromVertex).add(toVertex);
    }

    public int vertexCount(){
        return this.vertexCount;
    }

    public ArrayList<ArrayList<Integer>> adjList(){
        return this.adjList;
    }

}