package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import java.util.Arrays;

public class TweetTemp {


  public static Tweet createTweet(String text, Double lon, Double lat){

    Coordinates coordinates = new Coordinates();
    Tweet tweet = new Tweet();

    coordinates.setCoordinates(Arrays.asList(lon, lat));
    coordinates.setType("Point");
    tweet.setText(text);
    tweet.setCoordinates(coordinates);

    return tweet;
  }

}
