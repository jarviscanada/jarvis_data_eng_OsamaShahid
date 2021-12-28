package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import com.google.gdata.util.common.base.PercentEscaper;
import com.sun.jndi.toolkit.url.Uri;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import ca.jrvs.apps.twitter.util.JsonParsing;


public class TwitterDao implements CrdDao<Tweet, String> {

  //URI constants
  private static final String API_BASE_URI = "https://api.twitter.com";
  private static final String POST_PATH = "/1.1/statuses/update.json";
  private static final String SHOW_PATH = "/1.1/statuses/show.json";
  private static final String DELETE_PATH = "/1.1/statuses/destroy";

  //URI Symbols
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";

  //Http Response Code
  private static final int HTTP_OK = 200;
  private HttpHelper httpHelper;


  /**
   * Constructor
   * @param httpHelper
   */
  public TwitterDao (HttpHelper httpHelper){
    this.httpHelper = httpHelper;
  }



  @Override
  public Tweet create(Tweet entity) {
    URI uri;

    PercentEscaper percentEscaper = new PercentEscaper("", false);
    String statusText = "status" + EQUAL + percentEscaper.escape(entity.getText());
    uri = URI.create(API_BASE_URI + POST_PATH + QUERY_SYM + statusText);

    HttpResponse response = httpHelper.httpPost(uri);

    return parseResponseBody(response, HTTP_OK);
  }


  public Tweet parseResponseBody (HttpResponse response, int statusCode){
    Tweet tweet = null;
    String jsonStr;

    if (statusCode != 200){
      try {
        System.out.println(EntityUtils.toString(response.getEntity()));
      } catch (IOException e){
        e.printStackTrace();
      }
      throw new RuntimeException("Unexpected Http Status: " + statusCode);
    }

    if (response.getEntity() == null){
      throw new RuntimeException("Empty Response");
    }


    try {
      jsonStr = EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Unable to convert Json to String: ", e);
    }

    try {
      tweet = JsonParsing.toObjectFromJson(jsonStr, Tweet.class);
    } catch (IOException e){
      throw new RuntimeException("Unable to convert JSON str to Object", e);
    }

    return tweet;
  }


  @Override
  public Tweet findById(String s) {
    URI uri;

    PercentEscaper percentEscaper = new PercentEscaper("", false);
    String id = "id" + EQUAL + s;
    uri = URI.create(API_BASE_URI + SHOW_PATH + QUERY_SYM + id);
    HttpResponse response = httpHelper.httpGet(uri);

    return parseResponseBody(response, HTTP_OK);
  }


  @Override
  public Tweet deleteById(String s) {
    URI uri;

    PercentEscaper percentEscaper = new PercentEscaper("", false);
    uri = URI.create(API_BASE_URI + DELETE_PATH + "/" + s + ".json");
    HttpResponse response = httpHelper.httpPost(uri);

    return parseResponseBody(response, HTTP_OK);
  }


}