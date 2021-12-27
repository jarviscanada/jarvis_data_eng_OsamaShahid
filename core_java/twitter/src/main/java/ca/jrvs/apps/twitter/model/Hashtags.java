package ca.jrvs.apps.twitter.model;

public class Hashtags {


  private Integer[] indices;
  private String text;


  public Hashtags(Integer[] indices, String text){
    this.indices = indices;
    this.text = text;
  }


  public Integer[] getIndices() {
    return indices;
  }

  public void setIndices(Integer[] indices) {
    this.indices = indices;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


}
