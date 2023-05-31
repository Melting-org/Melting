package com.melting.dao;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Crawling;

@Mapper
public interface CrawlingDAO {

	boolean saveCrawlingData(Crawling crawling);

}
