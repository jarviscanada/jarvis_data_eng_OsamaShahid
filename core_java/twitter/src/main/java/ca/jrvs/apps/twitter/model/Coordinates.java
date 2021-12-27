package ca.jrvs.apps.twitter.model;


public class Coordinates {

  private Double[] coordinates;
  private String type;


  public Coordinates(Double[] coordinates, String type){
    this.coordinates = coordinates;
    this.type = type;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Double[] getCoordinates() {
    return coordinates;
  }


  public void setCoordinates(Double[] coordinates) {
    this.coordinates = coordinates;
  }



}
