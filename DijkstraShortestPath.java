public class DijkstraShortestPath {

    private static int minCost(int[] distances, Boolean[] sptSet){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int ix = 0; ix < distances.length; ix++) {
            if (!sptSet[ix] && distances[ix] <= minValue) {
                minValue = distances[ix];
                minIndex = ix;
            }
        }
        return minIndex;
    }

    private static void printGraph(int[] distances){
        System.out.println("Vertex dist from source:");
        for (int ix = 0; ix < distances.length; ix++) {
            System.out.println(ix + "\t" + distances[ix]);
        }
    }

    public static void find(int[][] graph, int source){
        // distances holds distances from the src to other nodes
        int[] distances = new int[graph.length];

        //sptSet holds visitation state
        Boolean[] sptSet = new Boolean[graph.length];

        // setting null values
        for (int ix = 0; ix < graph.length; ix++) {
            distances[ix] = Integer.MAX_VALUE;
            sptSet[ix] = false;
        }
        
        // dist to source is 0
        distances[source] = 0;
        
        for (int ix = 0; ix < graph.length; ix++) {

            // picks a node at min distance from src
            int u = minCost(distances, sptSet);
            sptSet[u] = true;
            
            for (int v = 0; v < graph.length; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }
        printGraph(distances);
    }
}