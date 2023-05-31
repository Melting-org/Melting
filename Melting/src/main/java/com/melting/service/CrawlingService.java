package com.melting.service;

import java.util.List;

import com.melting.domain.Crawling;

public interface CrawlingService {

	public List<Crawling> getDcInsideCrawlingData();

	public List<Crawling> getFmKoreaCrawlingData();

	public List<Crawling> getPpomppuCrawlingData();

	public boolean saveCrawlingData(Crawling crawling);

	public List<Crawling> getDcSearchCrawlingData();

	public List<Crawling> getHitCrawlingData();


}
