import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for Netflix analysis
 * @author rhirsch
 */
public class NetflixAnalyzer {
    public static Scanner scanner = new Scanner(System.in);

    public static Graph graph;
    public static ArrayList <String> fileList;

    public static void main(String[] args) {
        fileList = new ArrayList<String>();

        System.out.println("========== Welcome to Netflix Analyzer ==========");

        System.out.println("Input path to file you want to analyze: ");
        String ans = "y";
        while (ans.toLowerCase().equals("y")) {
            fileList.add(scanner.nextLine());
            System.out.println("Input another file? (y/n)");
            ans = scanner.nextLine();
        }

        System.out.println("The files being analyzed are:");
        for (int i=0; i<fileList.size(); i++) {
            System.out.println(fileList.get(i));
        }

        System.out.println("There are 3 choices for defining adjacency: ");
        System.out.println("[Option 1] u and v are adjacent if at least 3 users gave the same rating to a movie");
        System.out.println("[Option 2] u and v are adjacent if at least 3 users watched both movies (regardless of rating)");
        System.out.println("[Option 3] u and v are adjacent if at least 60% of users that rated u gave the same rating to v");
        System.out.println("Choose an option to build the graph (1-3)");
        int answer = getOption();


        switch (answer) {
            case 1:
                // make graph for opt 1
                graph = new Graph(1);
                break;
            case 2:
                // make graph for opt 2
                graph = new Graph(2);
                break;
            case 3:
                // make graph for opt 3
                graph = new Graph(3);
                break;
            default:
                // shouldn't be needed, but just in case
                break;
        }

        answer = -1;

        while (answer != 3) {
            System.out.println("[Option 1] Print out statistics about the graph");
            System.out.println("[Option 2] Display shortest path between two nodes");
            System.out.println("[Option 3] Quit Program");
            System.out.println("Choose an option to build the graph (1-3)");
            answer = getOption();

            switch (answer) {
                case 1:
                    printStats();
                    break;
                case 2:
                    System.out.println(getShortestPath());
                    break;
                default:
                    // shouldn't be needed, but just in case
                    System.out.println("Unknown option " + answer + ". Please enter 1, 2, or 3");
                    break;
            }
        }

        System.out.println("Goodbye - thank you for using Netflix Analyzer!");
    }

    /*
     * Prints statistics about shortest path
     */
    public static void printStats() {
        // TODO - finish graph stats methods
        // num nodes
        System.out.println(graph.numNodes);
        // num edges
        System.out.println(graph.numEdges);
        // graph density
        System.out.println(graph.getDensity());
        // max degree (largest num of outgoing edges of any node
        System.out.println(graph.getMaxDegree());
        // diameter of graph (longest shortest path using F-W Alg)
        System.out.println(getDiameter());
        // avg length of shortest paths in graph (using F-W Alg)
        System.out.println(getAvgShortestPath());
    }

    /*
     * Gives string representation of shortest path between u and v
     */
    public static String getShortestPath() {
        System.out.println("Input start node:");
        int u = scanner.nextInt();

        System.out.println("Input end node:");
        int v = scanner.nextInt();

        // TODO - find shortest path in graph from u to v

        return "";
    }

    /*
     * Returns graph diameter - longest shortest path using F-W Alg
     */
    public static int getDiameter() {
        // TODO - finish this - or completely rewrite idk
        int shortest = 0;

        // find all pairs of nodes

        int path = 0;
        // run F-W on all pairs

        if (path > shortest) {
            shortest = path;
        }

        return 0;
    }

    /*
     * Returns avg shortest path length for all nodes using D's Alg
     */
    public static double getAvgShortestPath() {
        // TODO - test this ??

        // find total length of shortest paths for each node
        int nodes = graph.numNodes;
        int total = 0;
        int [] ans;
        for (int i=0; i<nodes; i++) {
            ans = GraphAlgorithms.dijkstrasAlgorithm(graph, i);
            total += ans.length;
        }

        // divide total by number of nodes
        return total / nodes;
    }

    /*
     * Only scans for options 1, 2, 3
     */
    public static int getOption() {
        int ans = scanner.nextInt();

        while (ans != 1 && ans != 2 && ans != 3) {
            System.out.println("Unknown option " + ans + ". Please enter 1, 2, or 3");
            ans = scanner.nextInt();
        }

        return ans;
    }
}