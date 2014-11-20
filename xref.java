import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {
    static boolean d = false;
    static void processFile(String filename, boolean debug) throws IOException {
        Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word : scan.nextLine().split ("\\W+")) {
                tree.insert(word, linenr);
            }
        }
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
        if (args[0].equals("-d")) {
            d = true;
            String file = args[1];
            try {
                processFile(file, d);
            } catch (IOException error) {
                auxlib.warn(error.getMessage());
            }
            auxlib.exit();
        } else {
            String filename = args[0];
            try {
                processFile(filename, d);
            } catch (IOException error) {
                auxlib.warn (error.getMessage());
            }
            auxlib.exit();
        }
    }

}

