package com.app.demo.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by doanappdev@gmail.com on 27/5/17.
 */

public class StringUnitTest {
  @Test public void shouldCreateHtmlLinkGivenUrl() throws Exception {
    String url = "http://www.nytimes.com/2016/08/12/opinion/slow-to-show.html";
    String newUrl = url.replace("\"", "");

    assertEquals("http://www.nytimes.com/2016/08/12/opinion/slow-to-show.html", newUrl);

    //txtTest.setText( Html.fromHtml("<a href=\"http://www.google.com\">Google</a>"));
    String htmlLink = "<a href=\"" + url + "\">Link</a>";
    String expected = "<a href=\"http://www.nytimes.com/2016/08/12/opinion/slow-to-show.html\">Link</a>";
    assertEquals(expected, htmlLink);
    System.out.println(htmlLink);
  }
}
