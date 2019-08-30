package java_20190807;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://sports.news.naver.com/wbaseball/index.nhn");
		URLConnection urlCon = url.openConnection();
		
		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		
		System.out.println(contentType);
	}
}
