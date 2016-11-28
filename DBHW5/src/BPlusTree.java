import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author rvhirsch
 */
public class BPlusTree {
    public static Scanner scanner = new Scanner(System.in);   // scanner to read user input

    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
    public static int d = 0;    //

    public static void main(String[] args) {
        System.out.println("Enter file name to read from:");
        String filename = scanner.nextLine();
        filename = "./" + filename;
        try {
            File file = new File (filename);
            scanner = new Scanner(file);    // set up scanner to read from file
        }
        catch (FileNotFoundException f) {
            System.out.println("File Not Found!");
            System.exit(1);
        }

        // get d value from first line of file
        d = scanner.nextInt();
        if (d < 3) {    // make sure d value is valid
            System.out.println("d value must bc greater than or equal to 3!");
            System.exit(3);
        }

        int val;    // value of int to look for/insert into tree
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.charAt(0) == 'p') {
                printTree();
            }
            else if (str.charAt(0) == 'i') {
                str = str.substring(1);
                val = Integer.parseInt(str);
                insertIntoTree(val);
            }
            else if (str.charAt(0) == 's') {
                str = str.substring(1);
                val = Integer.parseInt(str);
                findValue(val);
            }
        }

        System.out.println("Do you want to enter a new file?");
        // TODO: FINISH THIS
    }

    public static void insertIntoTree(int val) {
        // TODO: FINISH THIS

        if (tree.isEmpty()) {
            ArrayList<Integer> root = new ArrayList<Integer>();
            root.add(val);
            tree.set(0, root);       // val becomes new root node
            return;
        }
        else if (findValue(val)) {  // if val already in tree
            return;
        }
        else {
            // insert value into tree
        }

    }

    public static boolean findValue(int val) {
        // TODO: FINISH THIS

        boolean found = false;
        int i = 0;
        int isize;
        while (!found && i < tree.get(0).size()) {
            isize = tree.get(i).size();
            if (val < tree.get(i).get(0)) {     // val on left side of tree

            } else if (val < tree.get(i).get(isize)) {   // val on right side of tree

            } else {
                for (int j=0; j<isize; j++) {
                    if (tree.get(i).get(j) == val) {
                        found = true;
                    }
                }
            }

            i++;
        }

        if (found) {
            System.out.println(val + " FOUND");     // if in tree
        }
        else {
            System.out.println(val + " NOT FOUND");     // if not in tree
        }
        return found;
    }


    public static void printTree() {
        // TODO: fix this to accurately reflect node setup

        int numRows = tree.get(0).size();
        int numNodes = 0;
        for (int i=0; i<numRows; i++) {
            numNodes = tree.get(i).size();
            for (int j=0; j<numNodes; j++) {
                System.out.println(tree.get(i).get(j));
            }
        }
    }
}
