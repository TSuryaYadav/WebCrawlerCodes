package com.web.crawler;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrawlerTest {

	WebCrawlerMain webCrawlerMain= new WebCrawlerMain();
	@Test
	public void test() {
		webCrawlerMain.getPageLinks("https://www.wipro.com/");
		fail("Not yet implemented");
	}

}
