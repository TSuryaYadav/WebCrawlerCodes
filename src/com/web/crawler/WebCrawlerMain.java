package com.web.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class WebCrawlerMain {

    private HashSet<String> links;

    public WebCrawlerMain() {
        links = new HashSet<String>();
    }

    public void getPageLinks(String URL) {
        // Check if you have already crawled the URLs 
        //(we are intentionally not checking for duplicate content in this example)
        if (!links.contains(URL)) {
            try {
                // If not add it to the index
                if (links.add(URL)) {
                	if(URL.contains("wipro")) {
                		 System.out.println(URL);
                	}
                }

                // Fetch the HTML code
                Document document = Jsoup.connect(URL).get();
                // Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("a[href]");

                // For each extracted URL.
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"));
                }
            } catch (IOException e) {
                //System.err.println("For '" + URL + "': " + e.getMessage());
            }
			catch (IllegalArgumentException e) {
                //System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Pick a URL from the frontier
        new WebCrawlerMain().getPageLinks("https://www.wipro.com/");
    }

}