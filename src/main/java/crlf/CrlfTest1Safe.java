package crlf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.reference.DefaultHTTPUtilities;

public class CrlfTest1Safe {
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    unsafe(request, response);
  }

  private void unsafe(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    Cookie cookie = new Cookie("name", name);
    cookie.setPath("/");
    cookie.setDomain("");
    cookie.setComment("cookie description");
    cookie.setMaxAge(900);
    cookie.setSecure(false);
    DefaultHTTPUtilities.getInstance().addCookie(response, cookie);
  }
}
