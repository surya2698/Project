package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelLoginpage extends BaseClass {
	public HotelLoginpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement txtusername;
	@FindBy(name = "password")
	private WebElement txtpass;
	@FindBy(name = "login")
	private WebElement btnlogin;
	@FindBy(id = "location")
	private WebElement location;
	@FindBy(id = "hotels")
	private WebElement hotel;
	@FindBy(id = "room_type")
	private WebElement room;
	@FindBy(id = "room_nos")
	private WebElement roomno;
	@FindBy(id = "datepick_in")
	private WebElement indate;
	@FindBy(id = "datepick_out")
	private WebElement outdate;
	@FindBy(id = "adult_room")
	private WebElement adultroom;
	@FindBy(id = "child_room")
	private WebElement childroom;
	@FindBy(id = "Submit")
	private WebElement search;
	@FindBy(id = "radiobutton_0")
	private WebElement radiobutton;
	@FindBy(id = "continue")
	private WebElement continueclick;
	@FindBy(id = "first_name")
	private WebElement firstname;
	@FindBy(id = "last_name")
	private WebElement lastname;
	@FindBy(id = "address")
	private WebElement address;
	@FindBy(id = "cc_num")
	private WebElement creditno;
	@FindBy(id = "cc_type")
	private WebElement credittype;
	@FindBy(id = "cc_exp_month")
	private WebElement expirymonth;
	@FindBy(id = "cc_exp_year")
	private WebElement expiryyear;
	@FindBy(id = "cc_cvv")
	private WebElement cvvno;
	@FindBy(id = "book_now")
	private WebElement booking;
	@FindBy(id = "order_no")
	private WebElement order;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRoomno() {
		return roomno;
	}

	public WebElement getIndate() {
		return indate;
	}

	public WebElement getOutdate() {
		return outdate;
	}

	public WebElement getAdultroom() {
		return adultroom;
	}

	public WebElement getChildroom() {
		return childroom;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getContinueclick() {
		return continueclick;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditno() {
		return creditno;
	}

	public WebElement getCredittype() {
		return credittype;
	}

	public WebElement getExpirymonth() {
		return expirymonth;
	}

	public WebElement getExpiryyear() {
		return expiryyear;
	}

	public WebElement getCvvno() {
		return cvvno;
	}

	public WebElement getBooking() {
		return booking;
	}

	public WebElement getOrder() {
		return order;
	}

}
