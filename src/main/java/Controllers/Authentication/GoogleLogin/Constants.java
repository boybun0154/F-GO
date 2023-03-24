package Controllers.Authentication.GoogleLogin;

/**
 *
 * @author Bin
 */
public class Constants {
  public static String GOOGLE_CLIENT_ID = "207223522866-t903tlahfetmc1hdi4h0bgoarumaec3c.apps.googleusercontent.com";
  public static String GOOGLE_CLIENT_SECRET = "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";
  public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/F-Go/GoogleLoginServlet";
  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
  public static String GOOGLE_GRANT_TYPE = "authorization_code";
}