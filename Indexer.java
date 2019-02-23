import java.io.*;
import java.util.*;
import java.lang.*;

public class Indexer {
  private List<Word> index;
  private String fn;

  public Indexer(String filename) {
    index = new ArrayList<Word>();
    fn = filename;
  }

  public Boolean index() {
    indexfile();
    return true;
  }

  private void lineSplitter(String line, int lineno) {
    String[] words = line.split("\\W+");
    for (int i=0; i<words.length; i++) {
      words[i] = words[i].toLowerCase();
      Word word = new Word(words[i]);
      for (int j=0; j<index.size(); j++) {
        if (words[i].equals(index.get(j).getWord())) {
          word.addLine(lineno);
        } else {
          index.add(word);
          word.addLine(lineno);
        }
      }
    }
  }

  private void indexfile() {
    int counter = 1;
    BufferedReader br = null;
      try {
      br = new BufferedReader(new FileReader(fn));

      String line;
      while ((line = br.readLine()) != null) {
        lineSplitter(line, counter);
        counter++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try{
        if (br != null)
      br.close(); } catch (IOException ex) {
        ex.printStackTrace();
      }
  }}

  public void dumpList() {
    //for(int i=0; i<index.size(); i++) {
    //System.out.println(index.get(i).getWord());
    for (int i=0; i<index.size(); i++) {
      List<Integer> lines = index.get(i).getLines();
      System.out.println(lines.toString());
  }
  }

  //public List<Integer> find(String w) {
  //}
}
