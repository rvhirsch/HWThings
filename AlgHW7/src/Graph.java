import java.util.ArrayList;

/**
 * @author rhirsch
 */
public class Graph {
    ArrayList<ArrayList<Integer>> movieList;
    int option = -1;
    int numNodes = -1;
    int numEdges = -1;

    /*
     * Graph constructor - integer values are movie IDs
     * Initializes option to be used in add, edge, adj methods
     */
    public Graph(int option) {
        // TODO - FINISH THIS

        this.movieList.add(new ArrayList<Integer>());    // set up row 0
        this.option = option;
        this.numNodes = 0;
        this.numEdges = 0;
    }

    /*
     * Add node to graph
     */
    public void addNode(int u) {
        // TODO - finish this

        if (this.movieList.get(0).size() == 0) {     // if no start node
            this.movieList.get(0).add(u);
        }

        this.numNodes++;
    }

    /*
     * Add directed edge from u ~> v in graph
     */
    public void addEdge(int u, int v) {
        // TODO - actually write things??

        this.numEdges++;
    }

    /*
     * Return adjacency list for u
     */
    public String getAdjacency(int u) {
        // TODO - should probs print out movie name, not just ID

        String str = "";
        int num = movieList.get(u).size();
        for (int i=0; i<num; i++) {
            str += (movieList.get(u) + " ");
        }
        return str;
    }


    /*
     * Returns graph density - directed or undirected
     */
    public double getDensity() {
        // TODO - figure out how to know directed vs undirected

        // D = E/(V*(V-1)) for directed graph
        // D = 2E/(V*(V-1)) for undirected graph

        // undirected equation
        return (2.0 * this.numEdges) / (numNodes * (numNodes - 1));
    }

    /*
     * Returns max degree - largest num of outgoing edges of a node
     */
    public int getMaxDegree() {
        //TODO - test this ??

        int max = -1;

        for (int i=0; i<numNodes; i++) {
            int num = 0;    // zero out outgoing edge count
            int endj = this.movieList.get(i).size();
            for (int j=0; j<endj; j++) {
                num ++;     // count each edge in adj list for each node
            }

            if (num > max) {    // update max with new max value, if necessary
                max = num;
            }
        }

        return max;
    }
}
