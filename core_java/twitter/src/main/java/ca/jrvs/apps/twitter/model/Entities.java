package ca.jrvs.apps.twitter.model;

public class Entities {

  private Hashtags[] hastags;
  private UserMentions[] userMentions;


  public Entities (Hashtags[] hastags, UserMentions[] userMentions){
    this.hastags = hastags;
    this.userMentions = userMentions;
  }

  public Hashtags[] getHastags() {
    return hastags;
  }

  public void setHastags(Hashtags[] hastags) {
    this.hastags = hastags;
  }


  public UserMentions[] getUserMentions() {
    return userMentions;
  }

  public void setUserMentions(UserMentions[] userMentions) {
    this.userMentions = userMentions;
  }
}
