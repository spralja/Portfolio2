import java.util.*;

public class Graph {
    private final HashMap<String, Vertex> vertices = new HashMap<>();

    private static class Vertex {
        private final String key;
        private final ArrayList<Vertex> adjacent = new ArrayList<>();
        private final ArrayList<Integer> weights = new ArrayList<>();
        public Vertex(String key) {
            this.key = key;
        }

        public void addEdge(Vertex that, int weight) {
            this.adjacent.add(that);
            this.weights.add(weight);
            that.adjacent.add(this);
            that.weights.add(weight);
        }

        public String getKey() {
            return this.key;
        }

    }

    /**
     * Generates a Graph from some data (like presented in the portfolio2 assignment)
     * @param data
     */
    public Graph(String[][] data) {
        for(String[] datum : data) {
            if (datum[0] == null || datum[1] == null || datum[2] == null) continue;
            getVertex(datum[0]).addEdge(getVertex(datum[1]), Integer.parseInt(datum[2]));
        }

    }

    /**
     * Get Vertex from vertex's name (if the vertex does not exist it creates it)
     * @param vertex
     * @return the associated vertex
     */
    public Vertex getVertex(String vertex) {
        if(vertices.get(vertex) == null) {
            return addVertex(vertex);
        }

        return vertices.get(vertex);
    }

    private Vertex addVertex(String vertex) {
        vertices.put(vertex, new Vertex(vertex));
        return this.getVertex(vertex);
    }

    /**
     * Prints the MST of the Graph g, and the total cost in DKK (uses prims algorithm)
     * @param g
     */
    public static void printMSTPrims(Graph g, int cost) {
        Object[] vertices = g.vertices.keySet().toArray();
        String[] keys = new String[vertices.length];
        for(int i = 0; i < keys.length; ++i) keys[i] = (String) vertices[i];

        String curr = keys[0];
        PriorityQueue pq = new MinHeap();
        HashMap<String, Integer> dist = new HashMap<>();
        for(String key : keys) {
            dist.put(key, Integer.MAX_VALUE);
            pq.insert(key, dist.get(key));
        }

        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Boolean> explored = new HashMap<>();
        for(String key : keys) explored.put(key, false);


        dist.put(curr, 0);
        pq.update(curr, dist.get(curr));
        while (!pq.isEmpty()) {
            curr = pq.removeMin().getKey();
            explored.put(curr, true);
            for (int i = 0; i < g.vertices.get(curr).adjacent.size(); ++i) {
                if(explored.get(g.vertices.get(curr).adjacent.get(i).getKey())) continue;
                if (g.vertices.get(curr).weights.get(i) >= dist.get(g.vertices.get(curr).adjacent.get(i).getKey()))
                    continue;

                dist.put(g.vertices.get(curr).adjacent.get(i).getKey(), g.vertices.get(curr).weights.get(i));
                parent.put(g.vertices.get(curr).adjacent.get(i).getKey(), curr);
                pq.update(
                        g.vertices.get(curr).adjacent.get(i).getKey(),
                        dist.get(g.vertices.get(curr).adjacent.get(i).getKey())
                );

            }

        }

        for(String key : keys) {
            if (parent.get(key) == null) continue;
            System.out.println(key + " " + parent.get(key) + " " + dist.get(key));
        }

        int r = 0;
        for(String key : keys) r += dist.get(key);

        System.out.println("Total cost: " + r * cost + " DKK");
    }

}
