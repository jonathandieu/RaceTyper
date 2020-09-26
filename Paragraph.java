import java.util.*;

public class Paragraph
{
  private LinkedList<String> block;
  private String title;

  public Paragraph(String s)
  {
    block = new LinkedList<>();
    setTitle(s);
  }

  public Paragraph()
  {
    block = new LinkedList<String>();
    title = "RandomTitle";
  }

  public LinkedList getBlock()
  {
    return block;
  }

  public void add(String sentence)
  {
    block.add(sentence);
  }

  public void setTitle(String s) {
    title = s;
  }

  public String getTitle()
  {
    return title;
  }

  public void printAllSentences()
  {
    int i = 1;

    for (String sentence : block)
    {
      System.out.println(i++ + ": " + sentence);
    }
  }
}

