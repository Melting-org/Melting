package com.melting.crawling;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestAllCrawling {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("C:/SetupFiles/chromedriver/chromedriver.exe");
		String dc_url = "https://www.dcinside.com/";
		String fm_url = "https://www.fmkorea.com/index.php?mid=best2&listStyle=list&page=1";
		
		// chrome driver 세팅
		System.setProperty("webdriver.chrome.driver", path.toString());
		
		// 브라우저 선택
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.addArguments("headless");  //브라우저 안띄움
		chromeOptions.addArguments("--disable-popup-blocking");  //팝업 안띄움
		chromeOptions.addArguments("--disable-gpu");  // gpu 비활성화
//		chromeOptions.addArguments("--blink-settings=imagesEnabled=false");   // 이미지 다운 안받음
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		// WebDriver가 로드될때까지 600초 기다림
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		
		// 웹 페이지 띄우기
		driver.get(dc_url);
		Thread.sleep(1000);
		
		int n = 2;	//글 수
		// dc
		//이미지
		String[] title =new String[n];	//글제목
		String[] writer =new String[n];	//작성자(글 들어가서)
		String[] regDate =new String[n];	//글 등록일(글 들어가서 해야 정확)
		String[] views =new String[n];	//조회수
		String[] like =new String[n];	//추천수
		String[] comment =new String[n];	//댓글수
		String[] link = new String[n];	//링크
		String[] category = new String[n];	//카테고리
		
		// fm
		String[] fmLink = new String[n];
		String[] fmRegDate = new String[n];
		String[] fmCategory = new String[n];
		String[] fmTitle = new String[n];
		String[] fmWriter = new String[n];
		String[] fmViews = new String[n];
		String[] fmLike = new String[n];
		String[] fmComment = new String[n];
		
		
		
		// 크롤링
		for(int i=1; i<=n; i++) {	

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a")));			
			WebElement linkE = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a"));
            link[i-1] = linkE.getAttribute("href");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[2]")));
			regDate[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[2]")).getText();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[1]")));
			category[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[1]")).getText();
           
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")));			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")));
			title[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")));
			writer[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			
		
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[1]")));
//			views[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[1]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gall_reply_num")));
//			like[i-1] = driver.findElement(By.className("gall_reply_num")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[3]/a")));
//			comment[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[3]/a")).getText();

			driver.navigate().back();
			Thread.sleep(1000);
			
		}
		
		
//		driver.close();
		driver.get(fm_url);
		for(int i=1; i<=n; i++) {	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]")));			
			WebElement linkE = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]"));
            fmLink[i-1] = linkE.getAttribute("href");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[4]")));
			fmRegDate[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[4]")).getText();		
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[1]/a")));
			fmCategory[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[1]/a")).getText();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]")));
			fmTitle[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]")).getText();
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[3]/span/a/text()")));
			fmWriter[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[3]/span/a/text()")).getText();
//			
//			
			//*[@id="bd_1996392141_0"]/div/table/tbody/tr["+i+1+"]/td[6]	//추천
			//*[@id="bd_1996392141_0"]/div/table/tbody/tr[3]/td[6]
			//*[@id="bd_1996392141_0"]/div/table/tbody/tr["+i+1+"]/td[5]	//조회
			//*[@id="bd_1996392141_0"]/div/table/tbody/tr[3]/td[5]
			//*[@id="bd_1996392141_0"]/div/table/tbody/tr["+i+1+"]/td[2]/a[2]	//댓글
			//*[@id="bd_1996392141_0"]/div/table/tbody/tr[3]/td[2]/a[2]	
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[5]")));
			fmViews[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[5]")).getText();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[6]")));
			fmLike[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+i+1+"]/td[6]")).getText();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[2]")));
			fmComment[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[2]")).getText();
//
//			driver.navigate().back();
//			Thread.sleep(1000);
			
			
		}
		
		System.out.println("dc ==============================================");
		
		for (int i=0; i<n; i++) {
			System.out.println(i+1+"번째");
//			System.out.println("title : " + title[i]);
//			System.out.println("writer : " + writer[i]);
			System.out.println("regDate : " + regDate[i]);
//			System.out.println("views : " + views[i]);
//			System.out.println("like : " + like[i]);
//			System.out.println("comment : " + comment[i]);
			System.out.println("link : " + link[i]);
			System.out.println("category : " + category[i]);
			System.out.println("=== 다음 ===");
		}
		
		System.out.println("fm ==============================================");
		
		for (int i=0; i<n; i++) {
			System.out.println(i+1+"번째");
			System.out.println("fmRegDate : " + fmRegDate[i]);
			System.out.println("fnLink : " + fmLink[i]);
			System.out.println("fmTitle : " + fmTitle[i]);
			System.out.println("fmWriter : " + fmWriter[i]);
			System.out.println(fmViews);
			System.out.println(fmLike);
			System.out.println(fmComment);
			
			System.out.println("=== 다음 ===");
		}
		System.out.println("================================================");
		
		
		
		
	}

}
