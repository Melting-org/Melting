package com.melting.util;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownConverter {
	
	 public static String convertMarkdownToHtml(String markdownContent) {
	        Parser parser = Parser.builder().build();
	        Node document = parser.parse(markdownContent);
	        HtmlRenderer renderer = HtmlRenderer.builder()
	        		.softbreak("<br>")
	                .build();
	        return renderer.render(document);
	    }

}
