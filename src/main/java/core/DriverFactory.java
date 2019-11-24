package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static core.LocalProperties.BROWSER;

public final class DriverFactory {

	private static WebDriver driver;

	private static Logger logger = LogManager.getLogger(DriverFactory.class);

	/**
	 * Construtor privado para que a classe não seja instanciada.
	 */
	private DriverFactory() {
	}

	/**
	 * Define qual navegador vai ser utilizado para realizar os testes
	 *
	 * @return o navegador a ser utilizado
	 * @throws MalformedURLException quando a URL informada não é válida
	 */
	public static WebDriver getDriver() throws MalformedURLException {
		if (driver == null) {
			logger.warn(MessagesLog.INSTANTIATE_DRIVER);
			switch (BROWSER) {
			case FIREFOX:
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
				driver = new RemoteWebDriver(new URL(LocalProperties.HUB_URL), firefoxOptions);
				driver.manage().window().maximize();
				logger.info(driver);
				break;
			case CHROME:
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
				driver = new RemoteWebDriver(new URL(LocalProperties.HUB_URL), chromeOptions);
				driver.manage().window().maximize();
				logger.info(driver);
				break;
			}

			logger.info(MessagesLog.IMPLICIT_WAIT);
			driver.manage().timeouts().implicitlyWait(LocalProperties.WAIT_TIME_DRIVER_IN_SECONDS, TimeUnit.SECONDS);
		}

		return driver;
	}

	/**
	 * Navega para o ambiente ADMIN que será realizado os testes
	 *
	 * @throws MalformedURLException quando a URL informada não é válida
	 */
	public static void navigateToSite() throws MalformedURLException {
		logger.info(MessagesLog.URL);
		getDriver().navigate().to(LocalProperties.SITE);
	}

	/**
	 * Encerra a instância do Driver fechando o navegador
	 */
	public static void killDriver() {
		if (driver != null) {
			logger.info(MessagesLog.CLOSE_BROWSER);
			driver.quit();
			driver = null;
		}
	}

}
