package org.base;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// browser launch
	public static WebDriver browser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			return driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			return driver = new EdgeDriver();
		}
		return driver;
	}

	// current url
	public static String currenturl() {
		return driver.getCurrentUrl();
	}

	// url launch
	public static void urllaunch(String url) {
		driver.get(url);
	}

	// get title
	public static void gettitle(String title) {
		System.out.println(driver.getTitle());
	}

	// gettext
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;

	}

	// wait max
	public static void impwait(int sec) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// Normal Click
	public static void click(WebElement e) {
		e.click();

	}

	// quit
	public static void quit() {
		driver.quit();
	}

	// close
	public static void close() {
		driver.close();
	}

	// sendkeys
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
	}

	// drag and drop
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
		a.dragAndDrop(from, to).perform();

	}

	// moveTOElement
	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	// actionsClick
	public static void actionClick(WebElement clk) {
		Actions a = new Actions(driver);
		a.click(clk).perform();

	}

	// doubleClick
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();

	}

	// contextClick
	public static void contextClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();

	}

	// simpleAlert
	public static void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// confirmAlert
	public static void confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	// promptAlert
	public static void promptAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();

	}

	// selectByIndex
	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);

	}

	// selectByValue
	public static void selectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);

	}

	// selectByVisibleText
	public static void selectByVisibleText(WebElement e, String Text) {
		Select s = new Select(e);
		s.selectByVisibleText(Text);

	}

	// ismultiple
	public static boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		return s.isMultiple();

	}

	// getFirstSelectedOptions
	public static String getFirstSelectedOption(WebElement e) {
		Select s = new Select(e);
		WebElement firstoption = s.getFirstSelectedOption();
		return firstoption.getText();
	}

	// deSelectedByIndex
	public static void deSelectedByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.deselectByIndex(index);

	}

	// deSelectedByValue
	public static void deSelectedByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);

	}

	// deSelectedByVisible
	public static void deSelectedByVisible(WebElement e, String text) {
		Select s = new Select(e);
		s.deselectByVisibleText(text);

	}

	// deSelectedAll
	public static void deSelectedAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();

	}

	// Screenshot
	public static void Screenshot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\91790\\eclipse-workspace\\AMavenproject\\Scrrenshot\\" + name + ".png");
		FileUtils.copyFile(src, des);

	}

	// getAttribute
	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
	}

	// javasetAttribute
	public static void setAttribute(String text, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", e);

	}

	// javagetAttribute
	public static String javagetAttribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object att = js.executeScript("return arguments[0].getAttribute('value')", e);
		return att.toString();

	}

	// javaClick
	public static void javaClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);

	}

	// scrolldown

	public static void scrolldown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);

	}

	// scrollup
	public static void scrollup(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}

	// frameIndex
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);

	}

	// frameName
	public static void frameName(String name) {
		driver.switchTo().frame(name);

	}

	// frameWebElement

	public static void frameWebElement(WebElement e) {
		driver.switchTo().frame(e);

	}

	// defaultContent
	public static void defaultContent() {
		driver.switchTo().defaultContent();

	}

	// parentFrame
	public static void parentFrame() {
		driver.switchTo().parentFrame();

	}

	// window handle
	public static String gethandle() {
		return driver.getWindowHandle();

	}

	// window handles
	public static void gethandles(int index) {
		Set<String> st = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(st);
		driver.switchTo().window(li.get(index));

	}

	// navigate tourl
	public static void tourl(String url) {
		driver.navigate().to(url);

	}

	// navigate back
	public static void back() {
		driver.navigate().back();

	}

	// navigate forward
	public static void forward() {
		driver.navigate().forward();

	}

	// navigate refresh
	public static void refresh() {
		driver.navigate().refresh();

	}

	// isDisplayed
	public static boolean isDisplayed(WebElement e) {
		return e.isDisplayed();

	}

	// isSelected
	public static boolean isSelected(WebElement e) {
		return e.isSelected();

	}

	// isEnabled
	public static boolean isEnabled(WebElement e) {
		return e.isEnabled();

	}

	// findelement
	public static WebElement findElement(String locatername, String locater) {
		WebElement e = null;
		if (locatername.equals("id")) {
			e = driver.findElement(By.id(locater));
		} else if (locatername.equals("name")) {
			e = driver.findElement(By.name(locater));
		} else if (locatername.equals("xpath")) {
			e = driver.findElement(By.xpath(locater));
		} else if (locatername.equals("tagname")) {
			e = driver.findElement(By.tagName(locater));

		}
		return e;
	}

	// Excel

	private static String excel (String name, String sheetname, int rowno, int cellno) throws IOException {
		File f = new File(
				"C:\\Users\\91790\\eclipse-workspace\\AMavenproject\\src\\test\\resources\\" + name + ".xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(rowno);
		Cell c = r.getCell(cellno);

		String value = null;
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row ro = s.getRow(i);
			for (int j = 0; j < ro.getPhysicalNumberOfCells(); j++) {
				Cell ce = ro.getCell(j);

				int type = ce.getCellType();

				if (type == 1) {
					value = ce.getStringCellValue();

				} else {
					if (DateUtil.isCellDateFormatted(ce)) {
						Date date = ce.getDateCellValue();
						SimpleDateFormat si = new SimpleDateFormat();
						value = si.format(date);

					} else {
						double numericCellValue = ce.getNumericCellValue();
						long l = (long) numericCellValue;
						value = String.valueOf(l);

					}

				}

			}
			System.out.println("------------");
		}
		return value;

	}

}
