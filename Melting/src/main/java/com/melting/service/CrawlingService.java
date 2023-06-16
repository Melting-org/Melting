package com.melting.service;

import java.util.List;

import com.melting.domain.Crawling;

public interface CrawlingService {

//	public List<Crawling> getDcInsideCrawlingData();

//	public List<Crawling> getFmKoreaCrawlingData();

//	public List<Crawling> getPpomppuCrawlingData();
//	
//	public List<Crawling> getTheqooCrawlingData();
	
	public List<Crawling> getDcSearchCrawlingData();

	public List<Crawling> getHitCrawlingData();

	public List<Crawling> getCrawlingList();

	public List<Crawling> getViewscntSortedList();

	public List<Crawling> getLikecntSortedList();
	
	public List<Crawling> getReplycntSortedList();
	

	


}
