package com.melting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Crawling;

@Mapper
public interface CrawlingDAO {

	public boolean saveCrawlingData(Crawling crawling);

	public void deleteByCreatedAtBefore(Date created_at);

}
