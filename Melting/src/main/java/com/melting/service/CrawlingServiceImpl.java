package com.melting.service;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.melting.dao.CrawlingDAO;
import com.melting.domain.Crawling;

@Service
public class CrawlingServiceImpl implements CrawlingService {
	

	@Autowired
	CrawlingDAO crawlingDao;
	
	int count = 10;

	
	@Scheduled(fixedDelay = 120000)
	public List<Crawling> getDcInsideCrawlingData() {
        List<Crawling> crawlingDataList = new ArrayList<>();
        String site = "dc";
        
        try {
        	
            String dcUrl = "https://www.dcinside.com/";
            Document document = Jsoup.connect(dcUrl).get();

            Elements titles = document.select("div.box.besttxt > p");
            Elements replycnts = document.select("div.box.besttxt > span");
            Elements kinds = document.select("div.box.best_info > span.name");
            Elements links = document.select("div.time_best .main_log");
            Elements images = document.select("div.box.bestimg > img");
            
            Math.min(count, titles.size());
            for (int i = 0; i < count; i++) {
                Element titleElement = titles.get(i);
                String title = titleElement.text();

                Element replycntElement = replycnts.get(i);
                String replycnt = replycntElement.text().replace("[", "").replace("]", "");
                
                Element kindElement = kinds.get(i);
                String kind = kindElement.text();
                
                Element linkElement = links.get(i);
                String link = linkElement.attr("href");
                
                Element imageElement = images.get(i);
                String image = imageElement.attr("src");
                
                
                Document postDocument = Jsoup.connect(link).get();	// 게시물 페이지로 접속
	
                Element membernameElement = postDocument.selectFirst(".nickname");
                String membername;
                
                if (membernameElement == null) {
                	membername = "작성자 비공개";
                } else {
                	membername = membernameElement.text();
                }
                
                
                Element likecntElement = postDocument.selectFirst(".gall_reply_num");
                if (likecntElement == null) {
                    continue;
                }
                String likecnt = likecntElement.text().replace("추천", "").trim();
                
                
                Element viewscntElement = postDocument.selectFirst(".gall_count");
                String viewscnt = viewscntElement.text().replace("조회", "").trim();
                

                int likecnt2;	
                try {
                    likecnt2 = Integer.parseInt(likecnt);
                } catch (NumberFormatException e) {
                    continue;
                }
                
                int replycnt2 = Integer.parseInt(replycnt);
                int viewscnt2 = Integer.parseInt(viewscnt);
                
                
                Crawling crawling = Crawling.builder()
                		.site(site)
                        .title(title)
                        .replycnt2(replycnt2)
                        .kind(kind)
                        .link(link)
                        .membername(membername)
                        .likecnt2(likecnt2)
                        .viewscnt2(viewscnt2)
                        .image(image)
                        .build();

                crawlingDataList.add(crawling);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < count; i++) {
            Crawling crawling = crawlingDataList.get(i);
            crawlingDao.saveCrawlingData(crawling);
        }
        
        int rowcount = crawlingDao.countCrawlingData(site);
        
        if (rowcount > count) {
			crawlingDao.deleteOldData(site);
		}
        
        return crawlingDataList;
    }
	
//	@Scheduled(fixedDelay = 120000)
//	public List<Crawling> getFmKoreaCrawlingData() {
//        List<Crawling> crawlingDataList = new ArrayList<>();
//        String site = "fm";
//        
//        try {
//        	
//            String fmKoreaUrl = "https://www.fmkorea.com/index.php?mid=best2&listStyle=webzine&page=1";
//            Document document = Jsoup.connect(fmKoreaUrl).get();
//
//            Elements titles = document.select(".hotdeal_var8");
//            Elements replycnts = document.select(".comment_count");
//            Elements images = document.select("div.fm_best_widget._bd_pc img");
//            Elements kinds = document.select(".category");
//            Elements membernames = document.select(".author");
//            Elements links = document.select(".hotdeal_var8");
//
//            Math.min(count, titles.size());
//            for (int i = 0; i < count; i++) {
//                Element titleElement = titles.get(i);
//                String title = titleElement.ownText();
//
//                Element replycntElement = replycnts.get(i);
//                String replycnt = replycntElement.text().replace("[", "").replace("]", "");
//                
//                Element imageElement = images.get(i);
//                String image = imageElement.attr("src");
//                
//                Element kindElement = kinds.get(i);
//                String kind = kindElement.text();
//                
//                Element membernameElement = membernames.get(i);
//                String membername = membernameElement.text().replace("/", "").trim();
//                
//                Element linkElement = links.get(i);
//                String link = "https://www.fmkorea.com"+linkElement.attr("href");
//                
//                Document postDocument = Jsoup.connect(link).get();	// 게시물 페이지로 접속
//	
//                Element viewscntElement = postDocument.selectFirst("div.side.fr > span:nth-child(1) > b");
//                String viewscnt = viewscntElement.text().trim();
//                
//                Element likecntElement = postDocument.selectFirst("div.side.fr > span:nth-child(2) > b");
//                String likecnt = likecntElement.text().trim();
//                
//                
//                int likecnt2 = Integer.parseInt(likecnt);	
//                int replycnt2 = Integer.parseInt(replycnt);
//                int viewscnt2 = Integer.parseInt(viewscnt);
//                
//                Crawling crawling = Crawling.builder()
//                		.site(site)
//                        .title(title)
//                        .replycnt2(replycnt2)
//                        .kind(kind)
//                        .membername(membername) 
//                        .link(link)
//                        .likecnt2(likecnt2)
//                        .viewscnt2(viewscnt2)
//                        .image(image)
//                        .build();
//                
//                crawlingDataList.add(crawling);
//                
//            }
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        for (int i = 0; i < count; i++) {
//            Crawling crawling = crawlingDataList.get(i);
//            crawlingDao.saveCrawlingData(crawling);
//            
//        }
//        
//        int rowcount = crawlingDao.countCrawlingData(site);
//        
//        if (rowcount > count) {
//			crawlingDao.deleteOldData(site);
//		}
//        
//        System.out.println(crawlingDataList);
//        return crawlingDataList;
//    }
		

	@Scheduled(fixedDelay = 120000)
    public List<Crawling> getPpomppuCrawlingData() {
        List<Crawling> crawlingDataList = new ArrayList<>();
        String site = "pp";
        
        try {
        	
            String ppomppuUrl = "https://www.ppomppu.co.kr/hot.php?category=2";
            Document document = Jsoup.connect(ppomppuUrl).get();

            Elements titles = document.select(".line .title");
            Elements replycnts = document.select(".list_comment2");
            Elements kinds = document.select(".board_left a");
            Elements links = document.select(".line .title");	
            Elements membernames = document.select(".name");
            Elements likecnts = document.select("table.board_table tr.line td:nth-child(6)");
            Elements viewscnts = document.select("table.board_table tr.line td:nth-child(7)");

            
            Math.min(count, titles.size());
            for (int i = 0; i < count; i++) {
                Element titleElement = titles.get(i);
                String title = titleElement.text();

                Element replycntElement = replycnts.get(i);
                String replycnt = replycntElement.text();
                
                Element kindElement = kinds.get(i+1);
                String kind = kindElement.text();
                
                Element linkElement = links.get(i);
                String link = "https://www.ppomppu.co.kr"+linkElement.attr("href");
                
                Element membernameElement = membernames.get(i);
                String membername = membernameElement.text();
                
                Element likecntElement = likecnts.get(i);
                String likecnt = likecntElement.text();
                
                int hyphenIndex = likecnt.indexOf("-");
                if (hyphenIndex != -1) {
                    likecnt = likecnt.substring(0, hyphenIndex).trim();
                }
                
                Element viewscntElement = viewscnts.get(i);
                String viewscnt = viewscntElement.text();
                
                Document postDocument = Jsoup.connect(link).get();	// 게시물 페이지로 접속
                
                Element imageElement = postDocument.selectFirst(".board-contents p img");
                String image;
                if (imageElement == null) {
					image = "이미지 없음";
				}else {					
					image = "https:"+imageElement.attr("src");
				}
                System.out.println(image);
                
                int likecnt2 = Integer.parseInt(likecnt);
                int replycnt2 = Integer.parseInt(replycnt);
                int viewscnt2 = Integer.parseInt(viewscnt);
                
                Crawling crawling = Crawling.builder()
                		.site(site)
                        .title(title)
                        .replycnt2(replycnt2)
                        .kind(kind)
                        .link(link)
                        .membername(membername)
                        .likecnt2(likecnt2)
                        .viewscnt2(viewscnt2)
                        .image(image)
                        .build();
                
                crawlingDataList.add(crawling);
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < count; i++) {
            Crawling crawling = crawlingDataList.get(i);
            crawlingDao.saveCrawlingData(crawling);
        }
        
        int rowcount = crawlingDao.countCrawlingData(site);
        
        if (rowcount > count) {
			crawlingDao.deleteOldData(site);
		}
        
        return crawlingDataList;
    }



	@Override
	public List<Crawling> getDcSearchCrawlingData() {
		List<Crawling> crawlingDataList = new ArrayList<>();
		
		try {
			
			String dcUrl = "https://www.dcinside.com/";
            Document document = Jsoup.connect(dcUrl).get();

            Elements titles = document.select(".rank_txt");
            Elements links = document.select(".busygall");
            
            int count = Math.min(10, titles.size());
            for (int i = 0; i < count; i++) {
                Element titleElement = titles.get(i);
                String title = titleElement.text();

                Element linkElement = links.get(i);
                String link = linkElement.attr("href");

                Crawling crawling = Crawling.builder()
                        .title(title)
                        .link(link)
                        .build();

                crawlingDataList.add(crawling);
                
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return crawlingDataList;
	}

	@Override
	public List<Crawling> getHitCrawlingData() {
		List<Crawling> crawlingDataList = new ArrayList<>();
		
		try {
			
			String dcUrl = "https://www.dcinside.com/";
            Document document = Jsoup.connect(dcUrl).get();

            Elements titles = document.select(".txt_box .tit");
            Elements images = document.select(".img_box img");
            Elements links = document.select(".link_thumb.main_log");
            
            int count = Math.min(4, images.size());
            for (int i = 0; i < count; i++) {
            	
            	Element titleElement = titles.get(i);
                String title = titleElement.text();
            	
                Element imageElement = images.get(i);
                String image = imageElement.attr("src");
                
                Element linkElement = links.get(i);
                String link = linkElement.attr("href");

                Crawling crawling = Crawling.builder()
                		.title(title)
                        .image(image)
                        .link(link)
                        .build();

                crawlingDataList.add(crawling);
                
            }
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return crawlingDataList;
	}


	@Override
	public List<Crawling> getCrawlingList() {
		List<Crawling> list = crawlingDao.getCrawlingList();
		return list;
	}


	@Override
	public List<Crawling> getViewscntSortedList() {
		List<Crawling> list = crawlingDao.getViewscntSortedList();
		return list;
	}


	@Override
	public List<Crawling> getLikecntSortedList() {
		List<Crawling> list = crawlingDao.getLikecntSortedList();
		return list;
	}


	@Override
	public List<Crawling> getReplycntSortedList() {
		List<Crawling> list = crawlingDao.getReplycntSortedList();
		return list;
	}




    
	
}

