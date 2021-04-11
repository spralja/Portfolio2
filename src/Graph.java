import javax.print.DocFlavor;
import java.util.*;
import java.util.function.BinaryOperator;

public class Graph {
    private HashMap<String, Vertex> vertices = new HashMap<>();
    private class Vertex {
        private String key;
        private ArrayList<Vertex> adjacent = new ArrayList<>();
        private ArrayList<Integer> weights = new ArrayList<>();
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

    public Graph(String[][] data) {
        for(int i = 0; i < data.length; ++i) {
            if(data[i][0] == null || data[i][1] == null || data[i][2] == null) continue;
            getVertex(data[i][0]).addEdge(getVertex(data[i][1]), Integer.parseInt(data[i][2]));
        }
    }

    public Graph() {}


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

    public static void printMSTPrims(Graph g) {
        Object[] vertices = g.vertices.keySet().toArray();
        String[] keys = new String[vertices.length];
        for (int i = 0; i < keys.length; ++i) {
            keys[i] = (String) vertices[i];
        }

        String curr = keys[0];
        PriorityQueue pq = new MinHeap();
        HashMap<String, Integer> dist = new HashMap<>();
        for (int i = 0; i < keys.length; ++i) {
            dist.put(keys[i], Integer.MAX_VALUE);
            pq.insert(keys[i], dist.get(keys[i]));
        }

        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Boolean> explored = new HashMap<>();
        for(int i = 0 ; i < keys.length; ++i) {
            explored.put(keys[i], false);
        }

        dist.put(curr, 0);
        pq.update(curr, dist.get(curr));
        while (!pq.isEmpty()) {
            curr = pq.removeMin().getKey();
            explored.put(curr, true);
            //System.out.println(curr + " -> " + parent.get(curr) + " = " + dist.get(curr));
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

        for(int i = 0; i < keys.length; ++i) {
            if(parent.get(keys[i]) == null) continue;
            System.out.println(keys[i] + " " + parent.get(keys[i]) + " " + dist.get(keys[i]));
        }

        int r = 0;
        for(int i = 0; i < keys.length; ++i) {
            r += dist.get(keys[i]);
        }

        System.out.println("Total cost: " + r + " DKK");
    }
}
