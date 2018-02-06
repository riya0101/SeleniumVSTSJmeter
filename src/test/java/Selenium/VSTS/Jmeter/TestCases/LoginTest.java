package Selenium.VSTS.Jmeter.TestCases;

import java.io.IOException;

import org.junit.Test;

import Selenium.VSTS.Jmeter.Pages.LoginPage;

public class LoginTest {
	
	@Test
	public void login() throws IOException
	{
		LoginPage lg= new LoginPage();
		lg.doLogin();
	}

}
