//package com.melting.crawling;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.Duration;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class bestCrawlingTest {
//
//	public static void main(String[] args) {
//		Path path = Paths.get("C:/SetupFiles/chromedriver/chromedriver.exe");
//		String url = "https://www.dcinside.com/";
//		Document doc = null;
//		
//		// chrome driver 세팅
//		System.setProperty("webdriver.chrome.driver", path.toString());
//		
//		// 브라우저 선택
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		
//		WebDriver driver = new ChromeDriver(chromeOptions);
//		
//		// WebDriver 가 로드될때까지 5초 기다림
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//		driver.get(url);
//		driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[1]/a/div[2]/p")).click();
//		driver.navigate().back();
//		
//		
//		try {
//			doc = Jsoup.connect(url).get();
//			System.out.println(doc.toString());
//			
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		driver.navigate().back();
//		driver.quit();
//		
//		
//		
//		
//		
//		
//
//	}
//
//}
