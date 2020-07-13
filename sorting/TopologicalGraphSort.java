package sorting;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import structures.Graph;

public class TopologicalGraphSort {

    private static void sortUtil(int vID, boolean[] visited, Deque<Integer> stack, Graph gr) {
        visited[vID] = true;
        System.out.println("set current node as visited");
        Iterator<Integer> iter = gr.adjList().get(vID).iterator();

        while (iter.hasNext()) {
            Integer jx = iter.next();
            System.out.println(jx + " is connected");
            if (!visited[jx]) {
                System.out.println("node not visited, calling util with this id");
                sortUtil(jx, visited, stack, gr);
            }else{
                System.out.println("node already visited, skipping");
            }
        }
        System.out.println("pushing node to stack");
        stack.push(vID);
    }

    public static void sort(Graph gr) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[gr.vertexCount()];
        for (int ix = 0; ix < gr.vertexCount(); ix++) {
            visited[ix] = false;
        }
        System.out.println("created a boolean array of size " + gr.vertexCount() + " and set every slot to false");

        for (int ix = 0; ix < gr.vertexCount(); ix++) {
            System.out.println("inspecting node  " + ix);
            if (!visited[ix]) {
                System.out.println("node not visited, passing to util");
                sortUtil(ix, visited, stack, gr);
            }else{
                System.out.println("node already visited, skipping");
            }
        }

        System.out.println("sort done, printing all elements");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}