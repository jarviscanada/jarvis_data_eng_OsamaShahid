package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;



public class TwitterDao implements CrdDao<Tweet, String> {

  //URI constants
  private static final String API_BASE_URI = "";
  private static final String POST_PATH = "";
  private static final String SHOW_PATH = "";
  private static final String DELETE_PATH = "";

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




    return null;
  }


  @Override
  public Tweet findById(String s) {


    return null;
  }


  @Override
  public Tweet deleteById(String s) {



    return null;
  }


}