//package com.melting.util;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class BestAllCrawling {
//
//	public static void main(String[] args) throws Exception {
//		
//		Path path = Paths.get("C:/SetupFiles/chromedriver/chromedriver.exe");
//		String dcUrl = "https://www.dcinside.com/";
//		String fmUrl = "https://www.fmkorea.com/index.php?mid=best2&listStyle=list&page=1";
//		String ppUrl = "https://www.ppomppu.co.kr/hot.php?category=2";
//		String ruUrl = "https://bbs.ruliweb.com/best/all/now?orderby=readcount&range=24h";
//		String ivUrl = "https://www.inven.co.kr/board/webzine/2097?my=chu"; 
//		
//		// chrome driver 세팅
//		System.setProperty("webdriver.chrome.driver", path.toString());
//		
//		// 브라우저 선택
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		chromeOptions.addArguments("headless");  //브라우저 안띄움
//		chromeOptions.addArguments("--disable-popup-blocking");  //팝업 안띄움
//		chromeOptions.addArguments("--disable-gpu");  // gpu 비활성화
//		chromeOptions.addArguments("--blink-settings=imagesEnabled=false");   // 이미지 다운 안받음
//		
//		WebDriver driver = new ChromeDriver(chromeOptions);
//		
//		// WebDriver가 로드될때까지 60초 기다림
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		
//		
//		int n = 2;	//글 수
//		
//		// 디시인사이드 dc
//		String[] dcTitle =new String[n];	//글제목
//		String[] dcWriter =new String[n];	//작성자(글 들어가서)
//		String[] dcRegDate =new String[n];	//글 등록일(글 들어가서 해야 정확)
//		String[] dcViews =new String[n];	//조회수
//		String[] dcLike =new String[n];	//추천수
//		String[] dcComment =new String[n];	//댓글수
//		String[] dcLink = new String[n];	//링크
//		String[] dcCategory = new String[n];	//카테고리
//		
//		// 에펨코리아 fm
//		String[] fmLink = new String[n];
//		String[] fmRegDate = new String[n];
//		String[] fmCategory = new String[n];
//		String[] fmTitle = new String[n];
//		String[] fmWriter = new String[n];
//		String[] fmViews = new String[n];
//		String[] fmLike = new String[n];
//		String[] fmComment = new String[n];
//		
//		// 뽐뿌 pp
//		String[] ppLink = new String[n];
//		String[] ppRegDate = new String[n];
//		String[] ppCategory = new String[n];
//		String[] ppTitle = new String[n];
//		String[] ppWriter = new String[n];
//		String[] ppViews = new String[n];
//		String[] ppLike = new String[n];
//		String[] ppComment = new String[n];
//		
//		// 루리웹 ru
//		String[] ruLink = new String[n];
//		String[] ruRegDate = new String[n];
//		String[] ruCategory = new String[n];
//		String[] ruTitle = new String[n];
//		String[] ruWriter = new String[n];
//		String[] ruViews = new String[n];
//		String[] ruLike = new String[n];
//		String[] ruComment = new String[n];
//		
//		// 인벤 iv
//		String[] ivLink = new String[n];
//		String[] ivRegDate = new String[n];
//		String[] ivCategory = new String[n];
//		String[] ivTitle = new String[n];
//		String[] ivWriter = new String[n];
//		String[] ivViews = new String[n];
//		String[] ivLike = new String[n];
//		String[] ivComment = new String[n];
//		
//		/*dc 크롤링*/
//		driver.get(dcUrl);	// 웹 페이지 띄우기
//		Thread.sleep(1000);
//		
//		for(int i=1; i<=n; i++) {	
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a")));			
//			WebElement linkE = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a"));
//            dcLink[i-1] = linkE.getAttribute("href");
//            
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[2]")));
//			dcRegDate[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[2]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[1]")));
//			dcCategory[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[3]/span[1]")).getText();
//           
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")));
//			dcTitle[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+1+"]/a/div[2]/span")));
//			dcComment[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+1+"]/a/div[2]/span")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")));			
//			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li["+i+"]/a/div[2]/p")).click();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")));
//			dcWriter[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[1]")));
//			dcViews[i-1] = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[2]/span[1]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gall_reply_num")));
//			dcLike[i-1] = driver.findElement(By.className("gall_reply_num")).getText();
//
//			driver.navigate().back();
//			Thread.sleep(1000);
//		}
//			
//		/*fm 크롤링*/
//		driver.get(fmUrl);
//		Thread.sleep(1000);
//		
//		for(int i=1; i<=n; i++) {	
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]")));			
//			WebElement linkE = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]"));
//            fmLink[i-1] = linkE.getAttribute("href");
//            
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[4]")));
//			fmRegDate[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[4]")).getText();		
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[1]/a")));
//			fmCategory[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[1]/a")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]")));
//			fmTitle[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[1]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[3]/span/a")));
//			fmWriter[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[3]/span/a")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[5]")));
//			fmViews[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[5]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[6]")));
//			fmLike[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[6]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[2]")));
//			fmComment[i-1] = driver.findElement(By.xpath("//*[@id=\"bd_1996392141_0\"]/div/table/tbody/tr["+(i+1)+"]/td[2]/a[2]")).getText();	
//		}
//		
//		/*뽐뿌 크롤링*/
//		driver.get(ppUrl);	// 웹 페이지 띄우기
//		Thread.sleep(1000);
//		
//		for(int i=1; i<=n; i++) {	
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[4]/a")));			
//			WebElement linkE = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[4]/a"));
//            ppLink[i-1] = linkE.getAttribute("href");
//            
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[5]")));
//			ppRegDate[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[5]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[1]/a")));
//			ppCategory[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[1]/a")).getText();
//           
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[4]/a")));
//			ppTitle[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[4]/a")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[4]/sup/span")));
//			ppComment[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[4]/sup/span")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[2]/div")));
//			ppWriter[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[2]/div")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[7]")));
//			ppViews[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[7]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[6]")));
//			ppLike[i-1] = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/table[1]/tbody/tr["+(i+5)+"]/td[6]")).getText();
//		}	
//		
//		/*루리웹 크롤링*/
//		driver.get(ruUrl);	// 웹 페이지 띄우기
//		Thread.sleep(1000);
//		
//		for(int i=1; i<=n; i++) {	
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/a")));			
//			WebElement linkE = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/a"));
//			ruLink[i-1] = linkE.getAttribute("href");
//            
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/span[7]")));
//            ruRegDate[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/span[7]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/a[1]")));
//			ruCategory[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/a[1]")).getText();
//           
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/a")));
//			ruTitle[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/a")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/a/span/span")));
//			ruComment[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/a/span/span")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/a[2]")));
//			ruWriter[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/a[2]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/span[5]/strong")));
//			ruViews[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/span[5]/strong")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/span[3]/strong")));
//			ruLike[i-1] = driver.findElement(By.xpath("//*[@id=\"best_body\"]/table/tbody/tr["+i+"]/td/div/div/div[2]/div/span[3]/strong")).getText();
//		}
//		
//		/*인벤 크롤링*/
//		driver.get(ivUrl);	// 웹 페이지 띄우기
//		Thread.sleep(1000);
//		
//		for(int i=1; i<=n; i++) {	
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/div/a")));			
//			WebElement linkE = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/div/a"));
//			ivLink[i-1] = linkE.getAttribute("href");
//			
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[4]")));
//            ivRegDate[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[4]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/div/a/span")));
//			ivCategory[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/div/a/span")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/div/a")));
//			ivTitle[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/div/a")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/span")));
//			ivComment[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[2]/div/span")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[3]/span")));
//			ivWriter[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[3]/span")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[5]")));
//			ivViews[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[5]")).getText();
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[6]")));
//			ivLike[i-1] = driver.findElement(By.xpath("//*[@id=\"new-board\"]/form/div/table/tbody/tr["+i+"]/td[6]")).getText();
//		}
//		
//		// 5초 후에 WebDriver 종료
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            // WebDriver 종료
//            driver.quit();
//        }
//		
//		System.out.println("dc ==============================================");
//		
//		for (int i=0; i<n; i++) {
//			System.out.println(i+1+"번째");
//			System.out.println("title : " + dcTitle[i]);
//			System.out.println("writer : " + dcWriter[i]);
//			System.out.println("regDate : " + dcRegDate[i]);
//			System.out.println("views : " + dcViews[i]);
//			System.out.println("like : " + dcLike[i]);
//			System.out.println("comment : " + dcComment[i]);
//			System.out.println("link : " + dcLink[i]);
//			System.out.println("category : " + dcCategory[i]);
//			System.out.println("=== 다음 ===");
//		}
//		System.out.println("================================================");
//		
//		System.out.println("fm ==============================================");
//		
//		for (int i=0; i<n; i++) {
//			System.out.println(i+1+"번째");
//			System.out.println(fmRegDate[i]);
//			System.out.println(fmLink[i]);
//			System.out.println(fmCategory[i]);
//			System.out.println(fmTitle[i]);
//			System.out.println(fmWriter[i]);
//			System.out.println(fmViews[i]);
//			System.out.println(fmLike[i]);
//			System.out.println(fmComment[i]);
//			
//			System.out.println("=== 다음 ===");
//		}
//		System.out.println("================================================");
//		
//		System.out.println("pp ==============================================");
//		for(int i=0; i<n; i++) {
//			System.out.println(i+1+"번째");
//			System.out.println(ppRegDate[i]);
//			System.out.println(ppLink[i]);
//			System.out.println(ppCategory[i]);
//			System.out.println(ppTitle[i]);
//			System.out.println(ppWriter[i]);
//			System.out.println(ppViews[i]);
//			System.out.println(ppLike[i]);
//			System.out.println(ppComment[i]);
//			System.out.println("=== 다음 ===");
//		}	
//		System.out.println("================================================");
//		System.out.println("ru ==============================================");
//		for(int i=0; i<n; i++) {
//			System.out.println(i+1+"번째");
//			System.out.println(ruRegDate[i]);
//			System.out.println(ruLink[i]);
//			System.out.println(ruCategory[i]);
//			System.out.println(ruTitle[i]);
//			System.out.println(ruWriter[i]);
//			System.out.println(ruViews[i]);
//			System.out.println(ruLike[i]);
//			System.out.println(ruComment[i]);
//			System.out.println("=== 다음 ===");
//		}	
//		System.out.println("================================================");
//		System.out.println("iv ==============================================");
//		for(int i=0; i<n; i++) {
//			System.out.println(i+1+"번째");
//			System.out.println(ivRegDate[i]);
//			System.out.println(ivLink[i]);
//			System.out.println(ivCategory[i]);
//			System.out.println(ivTitle[i]);
//			System.out.println(ivWriter[i]);
//			System.out.println(ivViews[i]);
//			System.out.println(ivLike[i]);
//			System.out.println(ivComment[i]);
//			System.out.println("=== 다음 ===");
//		}	
//		System.out.println("================================================");
//		
//		
////		driver.close();		
//	}
//
//}
