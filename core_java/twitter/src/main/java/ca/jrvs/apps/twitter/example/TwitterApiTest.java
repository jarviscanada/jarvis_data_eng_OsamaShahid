package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;
import java.util.Arrays;
import javax.swing.text.html.parser.Entity;
import javax.xml.ws.http.HTTPBinding;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class TwitterApiTest {

  private static String CONSUMER_KEY = "";
  private static String CONSUMER_SECRET = "";
  private static String ACCESS_TOKEN = "";
  private static String TOKEN_SECRET ="";


  public static void main(String[] args) throws Exception {

    OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);


    String status = "today is a good day";
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    HttpPost request = new HttpPost(
        "https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(status));

    consumer.sign(request);

    System.out.println("HTTP Request Headers:");
    Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpResponse response = httpClient.execute(request);
    System.out.println(EntityUtils.toString(response.getEntity()));
  }

}