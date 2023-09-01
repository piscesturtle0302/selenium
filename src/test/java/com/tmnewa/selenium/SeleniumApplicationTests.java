package com.tmnewa.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SeleniumApplicationTests {

	@Test
	public void testContent() throws Exception{
		WebDriverManager.chromedriver().setup();//啟動chromedriver
		ChromeDriver driver = new ChromeDriver();//新增chromedriver物件

		driver.get("http://localhost:8080/IDNOcreator/");//使用chromedirver取得網頁
		String title = driver.getTitle();//取得網頁TITLE
		System.out.println("-----this test title : " + title);

		WebElement createBtn = driver.findElement(By.id("creatNewResidenceIdNoBtn"));//抓取網頁元素
		createBtn.click();//進行該元素動作

		Thread.sleep(2000);

		WebElement checkText = driver.findElement(By.id("checkResponse"));
		String result = checkText.getText();

		System.out.println("checkResponse text : " + result);
		Assertions.assertEquals("符合規則", result);//進行判斷

		driver.quit();//結束chromedriver
	}

}
