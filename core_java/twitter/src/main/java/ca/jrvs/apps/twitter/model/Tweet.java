package ca.jrvs.apps.twitter.model;

public class Tweet {

  private String createdAt;
  private Integer id;
  private String id_str;
  private String text;
  private Entities entity;
  private Coordinates coordinates = null;
  private int retweetCount = 0;
  private int favoriteCount = 0;
  private Boolean favorited = false;
  private Boolean retweeted = false;

  public Tweet(String createdAt, Integer id, String id_str, String text, Entities entity, Coordinates coordinates){
    this.createdAt = createdAt;
    this.id = id;
    this.id_str = id_str;
    this.text = text;
    this.entity = entity;
    this.coordinates = coordinates;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Entities getEntity() {
    return entity;
  }

  public void setEntity(Entities entity) {
    this.entity = entity;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public int getRetweetCount() {
    return retweetCount;
  }

  public void setRetweetCount(int retweetCount) {
    this.retweetCount = retweetCount;
  }

  public int getFavoriteCount() {
    return favoriteCount;
  }

  public void setFavoriteCount(int favoriteCount) {
    this.favoriteCount = favoriteCount;
  }

  public Boolean getFavorited() {
    return favorited;
  }

  public void setFavorited(Boolean favorited) {
    this.favorited = favorited;
  }

  public Boolean getRetweeted() {
    return retweeted;
  }

  public void setRetweeted(Boolean retweeted) {
    this.retweeted = retweeted;
  }

}
