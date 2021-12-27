package ca.jrvs.apps.twitter.model;

public class UserMentions {


  private String name;
  private Integer[] indices;
  private String screenName;
  private Integer id;
  private String id_str;


  public UserMentions(String name, Integer[] indices, String screenName, Integer id, String id_str){
    this.name = name;
    this.indices = indices;
    this.screenName = screenName;
    this.id = id;
    this.id_str = id_str;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer[] getIndices() {
    return indices;
  }

  public void setIndices(Integer[] indices) {
    this.indices = indices;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getId_str() {
    return id_str;
  }

  public void setId_str(String id_str) {
    this.id_str = id_str;
  }

}
