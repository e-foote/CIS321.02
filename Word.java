import java.util.*;
/**
*
*/
public class Word{
  private String w;
  private List<Integer> lines;

  public Word(String word){
    w = word.toLowerCase();
  }

  public boolean addLine(int lineno) {
    lines.add(lineno);
    return true;
  }

  public String getWord() {
    return w;
  }
  public List<Integer> getLines() {
    return lines;
  }
}
