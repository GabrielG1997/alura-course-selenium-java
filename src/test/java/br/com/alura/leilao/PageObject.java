package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {
	
	protected WebDriver browser;

	public PageObject(WebDriver browser) {
		if (browser != null) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-win32/chromedriver.exe");
			this.browser = browser;
		} else {
			this.browser = new ChromeDriver();
		}
		this.browser.manage().timeouts()
				.pageLoadTimeout( 10, TimeUnit.SECONDS )
				.implicitlyWait( 5, TimeUnit.SECONDS );
	}

	public void fechar() {
		this.browser.quit();
	}

}
