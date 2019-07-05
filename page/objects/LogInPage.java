package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	
	
	private static final String usernameLogIn = "//input[@placeholder='username']";
	private static final String passwordLogIn = "//input[@placeholder='password']";
	private static final String logInButton  = "//input[@name='login']";
	private static final String logOutButton = "//a[@id='logoutBtn']";
	
	//Metoda za unos korisnickog imena za prijavu na sajt
	public static void UserNameLogIn(WebDriver dr, String unli) {
		WebElement wb = dr.findElement(By.xpath(usernameLogIn));
		wb.click();
		wb.sendKeys(unli);
	}
	
	//Metoda za unos sifre za prijavu za sajt
	public static void PasswordLogIn(WebDriver dr, String pwli) {
		WebElement wb = dr.findElement(By.xpath(passwordLogIn));
		wb.click();
		wb.sendKeys(pwli);
	}
	
	//Metoda za dugme za prijavu na sajt
	public static void LogInButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(logInButton));
		wb.click();
	}
	
	//Metoda za dugme za odjavu sa sajta
	public static void LogOutButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(logOutButton));
		wb.click();
	}

}
