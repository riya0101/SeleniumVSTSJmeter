package Selenium.VSTS.Jmeter.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import Selenium.VSTS.Jmeter.MasterPage.Base;

public class LoginPage extends Base {
	
	public LoginPage() throws IOException {
		
	}

	public void doLogin() throws IOException
	{
		
		Base.sendKeys_textbox("username_textbox_xpath","username");
		Base.sendKeys_textbox("password_textbox_xpath","password");
		Base.click_button("login_button_xpath");
		Base.close_browser();
		
		
	}

}
