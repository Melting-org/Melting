package com.melting.crawling;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestCrawling {

	public static void main(String[] args) throws Exception {
		
		Path path = Paths.get("C:/SetupFiles/chromedriver/chromedriver.exe");
		String url = "https://www.dcinside.com/";
		
		// chrome driver 세팅
		System.setProperty("webdriver.chrome.driver", path.toString());
		
		// 브라우저 선택
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
//		chromeOptions.addArguments("headless");  //브라우저 안띄움
//		chromeOptions.addArguments("--disable-popup-blocking");  //팝업 안띄움
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		// WebDriver 가 로드될때까지 10초 기다림
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 웹 페이지 띄우기
		driver.get(url);	
		Thread.sleep(1000);
		

		String[] title =new String[3];	//글제목
		String[] writer =new String[3];	//작성자
		String[] regDate =new String[3];	//글 등록일
		String[] views =new String[3];	//조회수
		String[] like =new String[3];	//추천수
		String[] commentC =new String[3];	//댓글수
//		String[] content =new String[3];	//글내용
//		List<String> contentList = new ArrayList<String>();
//		List<WebElement> content = null;
//		int j;
		
		

		// 크롤링
		for(int i=1; i<=3; i++) {			
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")).click();
			Thread.sleep(1000);
			title[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			writer[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			regDate[i-1] = driver.findElement(By.className("gall_date")).getText();
			views[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[1]")).getText();
			like[i-1] = driver.findElement(By.className("gall_reply_num")).getText();
			commentC[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[3]/a")).getText();
//			content = driver.findElements(By.className("write_div")).get(j);
			
			
			driver.navigate().back();
			Thread.sleep(1000);
			
//			keyword_list = []
//					
//			keywords = bs.find_all('li', attrs={'class':'tag'})
//	                for key in keywords:
//	                    keyword_list.append(key.get_text())
			
		}
		
	

		System.out.println("================================================");
		
		for (int i=0; i<3; i++) {
			System.out.println(title[i]);
			System.out.println(writer[i]);
			System.out.println(regDate[i]);
			System.out.println(views[i]);
			System.out.println(like[i]);
			System.out.println(commentC[i]);
//			System.out.println(content[i]);
//			System.out.println(content);
		}
//		System.out.println("dcArray"+dcArray);
//		System.out.println(dcArray[0]);


		System.out.println("================================================");
			
			
//		} catch (SocketException e) {
//			e.printStackTrace();
//		}
		
		
		

		
//			title.append(title1);
//		}
        


		
	
//		driver.quit();	//안없앨 시 SocketException: Connection reset 발생
//		driver.close();
		

	}

}
