import java.io.*;
import java.util.*;
import java.lang.*;

public class Indexer {
  private List<Word> index;
  private String fn;

  public Indexer(String filename) {
    index = new ArrayList<Word>();
    fn = filename;
    indexfile();
  }

  public Boolean index() {
    return true;
  }

  private void lineSplitter(String line, int lineno) {
    String[] words = line.split("\\W+");
    for (int i=0; i<words.length; i++) {
      words[i] = words[i].toLowerCase();
      index.add(new Word(words[i]));
    }
  }

  private void indexfile() {
    int counter = 0;
    BufferedReader br = null;
      try {
      br = new BufferedReader(new FileReader(fn));

      String line;
      while ((line = br.readLine()) != null) {
        lineSplitter(line, counter++);
        System.out.println(line + counter);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try{
        if (br != null)
      br.close(); }catch (IOException ex) {
        ex.printStackTrace();
      }
  }}
  public void dumpList() {
    for(int i=0; i<index.size(); i++) {
    System.out.println(index.get(i).getWord());
  }
  }

  //public List<Integer> find(String w) {
  //}
}
