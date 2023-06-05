package com.melting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Crawling;

@Mapper
public interface CrawlingDAO {

	public void saveCrawlingData(Crawling crawling);

	public void deleteOldData(int rowLimit);

//	public void deleteByCreatedAtBefore(Date created_at);


	
	

}
