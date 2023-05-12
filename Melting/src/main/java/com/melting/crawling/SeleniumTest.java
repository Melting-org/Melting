package com.melting.crawling;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	//private static RemoteWebDriver js;

	public static void main(String[] args) {
		
		Path path = Paths.get("C:/SetupFiles/chromedriver/chromedriver.exe");
		String URL = "https://www.dcinside.com/";

		// chrome driver 세팅
		System.setProperty("webdriver.chrome.driver", path.toString());

		// 브라우저 선택
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);

		// WebDriver 가 로드될때까지 10초 기다림
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 웹 페이지 띄우기
		driver.get(URL);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/section[1]/article[1]/div[3]/ul[1]/li[1]/a/div[1]/img")).click();
		
		
		System.out.println("================================================");
		System.out.println("성공");
		System.out.println("================================================");
		
		
		driver.navigate().back();
		driver.quit();
		

	}
	

}
