import java.util.*; 

public class PA2 {
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Indexer idx = new Indexer(args[0]);
        boolean rc = idx.index();
        idx.dumpList();

        // test find
        //System.out.println("*****************");
        //List<Integer> x = idx.find("PEACE");
        //if ( x!= null)
            //System.out.println(x);

    }
}
