package com.melting.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class bestCrawlingTest {

	public static void main(String[] args) {
		String url = "https://www.dcinside.com/";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			System.out.println(doc.toString());
			

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
