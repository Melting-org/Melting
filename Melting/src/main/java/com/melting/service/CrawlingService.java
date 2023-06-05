package com.melting.service;

import java.util.List;

import com.melting.domain.Crawling;

public interface CrawlingService {

	public List<Crawling> getDcInsideCrawlingData();

	public List<Crawling> getFmKoreaCrawlingData();

	public List<Crawling> getPpomppuCrawlingData();
	
	public List<Crawling> getDcSearchCrawlingData();

	public List<Crawling> getHitCrawlingData();
	
//	public void deleteOldData(int rowLimit);
	
//	public void deleteCrawlingData();

	public List<Crawling> getLikecntSortedData();

	public List<Crawling> getReplycntSortedData();

	


}
