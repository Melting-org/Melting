package com.melting.crawling;

import java.io.IOException;
import java.net.SocketException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestCrawling {

	public static void main(String[] args) throws SocketException {
		
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
		
		// WebDriver 가 로드될때까지 5초 기다림
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		// 웹 페이지 띄우기
		driver.get(url);

		try {
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[1]/a/div[1]/img")).click();
			String title1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[1]/a/div[2]/p")).getText();
			String author1= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();

			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[2]/a/div[1]/img")).click();
			String title2 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author2= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[3]/a/div[1]/img")).click();
			String title3 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author3= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[4]/a/div[1]/img")).click();
			String title4 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author4= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[5]/a/div[1]/img")).click();
			String title5 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author5= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[6]/a/div[1]/img")).click();
			String title6 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author6= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			
			
			System.out.println("================================================");
//			System.out.println(title);
			System.out.println(title1);
			System.out.println(author1);
			
			System.out.println(title2);
			System.out.println(author2);
			
			System.out.println(title3);
			System.out.println(author3);
			
			System.out.println(title4);
			System.out.println(author4);
			
			System.out.println(title5);
			System.out.println(author5);
			
			System.out.println(title6);
			System.out.println(author6);
	
			System.out.println("================================================");
			
		} catch (NoSuchElementException e) {
			System.out.println("ㅋㅋ");
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[1]/a/div[1]/img")).click();
			String title1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[1]/a/div[2]/p")).getText();
			String author1= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();

			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[2]/a/div[1]/img")).click();
			String title2 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author2= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[3]/a/div[1]/img")).click();
			String title3 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author3= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[4]/a/div[1]/img")).click();
			String title4 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author4= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[5]/a/div[1]/img")).click();
			String title5 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author5= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[6]/a/div[1]/img")).click();
			String title6 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/h3/span[2]")).getText();
			String author6= driver.findElement(By.xpath("//*[@id=\"container\"]/section/article[2]/div[1]/header/div/div/div[1]/span[1]/em")).getText();
			driver.navigate().back();
			
			
			
			System.out.println("================================================");
//				System.out.println(title);
			System.out.println(title1);
			System.out.println(author1);
			
			System.out.println(title2);
			System.out.println(author2);
			
			System.out.println(title3);
			System.out.println(author3);
			
			System.out.println(title4);
			System.out.println(author4);
			
			System.out.println(title5);
			System.out.println(author5);
			
			System.out.println(title6);
			System.out.println(author6);

			System.out.println("================================================");
			
			
		}	
			
		
//		NoSuchElementException
//			title.append(title1);
//		}
        
        
		//*[@id="bottom_listwrap"]/section[1]/article/div[1]/table/tbody/tr[4]/td[2]/a[1]
		//*[@id="bottom_listwrap"]/section[1]/article/div[1]/table/tbody/tr[5]/td[2]/a[1]

		
	
		driver.quit();
		

	}

}
