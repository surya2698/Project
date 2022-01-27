package org.hotel;

import java.util.Date;
import org.base.BaseClass;
import org.pages.HotelLoginpage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Hotel extends BaseClass {

	@BeforeClass
	public static void beforeclass() {
		browser("chrome");
		urllaunch("http://adactinhotelapp.com/");
		impwait(10);
		System.out.println("Start");
	}

	@AfterClass
	public static void afterclass() {
		// quit();
		System.out.println("End");
	}

	@BeforeMethod
	public void before() {
		Date d = new Date();
		System.out.println("beforetime" + d);
	}

	@AfterMethod
	public void after() {
		Date d = new Date();
		System.out.println("aftertime" + d);
	}
    
	@Parameters({"username","password"})
	@Test
	public void test1(@Optional("surya")String username,@Optional("453212")String pass) throws InterruptedException {
		HotelLoginpage h = new HotelLoginpage();
		urllaunch("http://adactinhotelapp.com/");
		SoftAssert s = new SoftAssert();
		s.assertTrue(currenturl().contains("adactin"));
		sendkeys(h.getTxtusername(), username);
		s.assertEquals(getAttribute(h.getTxtusername()), "suryachandran", "verified textuser");
		sendkeys(h.getTxtpass(), pass);
		s.assertEquals(getAttribute(h.getTxtpass()), "prakash", "verified txtpass");
		h.getBtnlogin().click();
		System.out.println("test1");
		Thread.sleep(2000);
		s.assertAll();
	}

	@Test
	public void test2() throws InterruptedException {
		HotelLoginpage h = new HotelLoginpage();
		SoftAssert s = new SoftAssert();
		selectByIndex(h.getLocation(), 3);
		selectByIndex(h.getHotel(), 2);
		s.assertFalse(h.getHotel().isSelected(), "select or not");
		selectByIndex(h.getRoom(), 2);
		selectByIndex(h.getRoomno(), 2);
		s.assertFalse(h.getRoomno().isSelected(), "select or not");
		h.getIndate().clear();
		sendkeys(h.getIndate(), "05/02/2022");
		s.assertEquals(getAttribute(h.getIndate()), "05/02/2022", "verify indate");
		h.getOutdate().clear();
		sendkeys(h.getOutdate(), "08/02/2022");
		s.assertEquals(getAttribute(h.getOutdate()), "08/02/2022", "verify outdate");
		selectByIndex(h.getAdultroom(), 2);
		selectByIndex(h.getChildroom(), 1);
		h.getSearch().click();
		System.out.println("test2");
		Thread.sleep(2000);
		s.assertAll();
	}

	@Test
	public void test3() throws InterruptedException {
		HotelLoginpage h = new HotelLoginpage();
		h.getRadiobutton().click();
		h.getContinueclick().click();
		System.out.println("test3");
		Thread.sleep(1000);
	}
    @Parameters({"firstname","lastname","address","credit","card"})
	@Test
	public void test4(String frstname,String lstname,String adrs,String credit,String cvv) throws InterruptedException {
		HotelLoginpage h = new HotelLoginpage();
		SoftAssert s = new SoftAssert();
		sendkeys(h.getFirstname(), frstname);
		sendkeys(h.getLastname(), lstname);
		sendkeys(h.getAddress(), adrs);
		s.assertEquals(getAttribute(h.getAddress()), "Eshwari", "verify address");
		sendkeys(h.getCreditno(), credit);
		selectByIndex(h.getCredittype(), 2);
		selectByIndex(h.getExpirymonth(), 1);
		selectByIndex(h.getExpiryyear(), 11);
		sendkeys(h.getCvvno(), cvv);
		h.getBooking().click();
		System.out.println("test4");
		Thread.sleep(7000);
		String text = getAttribute(h.getOrder());
		System.out.println(text);
		s.assertAll();
	}

}
