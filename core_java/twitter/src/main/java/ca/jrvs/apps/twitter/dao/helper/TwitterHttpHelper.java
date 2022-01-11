package ca.jrvs.apps.twitter.dao.helper;

import java.io.IOException;
import java.net.URI;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;


@Component
public class TwitterHttpHelper implements HttpHelper {

  private OAuthConsumer consumer;
  private HttpClient httpClient;


  /**
   * Constructor
   * Setup dependencies using secrets
   *
   * @param consumerKey
   * @param consumerSecret
   * @param accessToken
   * @param tokenSecret
   */
  public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret){
    consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
    consumer.setTokenWithSecret(accessToken, tokenSecret);

    httpClient = new DefaultHttpClient();
  }


  @Override
  public HttpResponse httpPost(URI uri) {

    try{
      return executeHttpRequest(HttpMethod.POST, uri, null);

    } catch (OAuthMessageSignerException e) {
      e.printStackTrace();
    } catch (OAuthExpectationFailedException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (OAuthCommunicationException e) {
      e.printStackTrace();
    }

    return null;
  }

  private HttpResponse executeHttpRequest(HttpMethod method , URI uri, StringEntity stringEntity)
      throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {

    if (method == method.POST){
      HttpPost request = new HttpPost(uri);

      if (stringEntity != null){
        request.setEntity(stringEntity);
      }
      consumer.sign(request);
      HttpResponse response = httpClient.execute(request);
      return response;

    } else if (method == method.GET){
      HttpGet request = new HttpGet(uri);
      consumer.sign(request);
      HttpResponse response = httpClient.execute(request);
      return response;

    } else {
      throw new IllegalArgumentException("Unknown HTTP method" + method.name());
    }

  }


  @Override
  public HttpResponse httpGet(URI uri) {

    try {
      return executeHttpRequest(HttpMethod.GET, uri, null);

    } catch (OAuthMessageSignerException e) {
      e.printStackTrace();
    } catch (OAuthExpectationFailedException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (OAuthCommunicationException e) {
      e.printStackTrace();
    }

    return null;
  }

}
