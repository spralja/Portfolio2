import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    private HashMap<String, Vertex> vertices = new HashMap<>();
    private class Vertex {
        private String key;
        private LinkedList<Vertex> adjacent = new LinkedList<>();
        private LinkedList<Integer> weights = new LinkedList<>();
        public Vertex(String key) {
            this.key = key;
        }

        public void addEdge(Vertex that, int weight) {
            adjacent.add(that);
            weights.add(weight);
        }
    }

    public Graph(String[][] data) {
        for(int i = 0; i < data.length; ++i) {
            getVertex(data[i][0]).addEdge(getVertex(data[i][1]), Integer.parseInt(data[i][2]));
        }
    }

    public Vertex getVertex(String vertex) {
        if(vertices.get(vertex) == null) {
            return addVertex(vertex);
        }
        return vertices.get(vertex);
    }

    public Vertex addVertex(String vertex) {
        return vertices.put(vertex, new Vertex(vertex));
    }

}
