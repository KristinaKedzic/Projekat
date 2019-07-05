package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	private static final String FirstName = "//input[@name='firstname']";
	private static final String LastName = "//input[@name='lastname']";
	private static final String username = "//div[@class='register_form']//input[@name='username']";
	private static final String email = "//input[@name='email']";
	private static final String password = "//div[@class='register_form']//input[@name='password']";
	private static final String Register = "//input[@id='blue_btn']";
	
	//Metoda za unos imena
	public static void FirstName(WebDriver dr, String fn) {
		WebElement wb = dr.findElement(By.xpath(FirstName));
		wb.click();
		wb.sendKeys(fn);
	}
	
	//Metoda za unos prezimena
	public static void LastName(WebDriver dr, String ln) {
		WebElement wb = dr.findElement(By.xpath(LastName));
		wb.click();
		wb.sendKeys(ln);
	}
	
	//Metoda za unos korisnickog imena
	public static void Username(WebDriver dr, String un) {
		WebElement wb = dr.findElement(By.xpath(username));
		wb.click();
		wb.sendKeys(un);
	}
	
	//Metoda za unos mejla
	public static void Email(WebDriver dr, String em) {
		WebElement wb = dr.findElement(By.xpath(email));
		wb.click();
		wb.sendKeys(em);
	}
	
	//Metoda za unos sifre
	public static void Password(WebDriver dr, String pw) {
		WebElement wb = dr.findElement(By.xpath(password));
		wb.click();
		wb.sendKeys(pw);
	}
	
	//Metoda za kliktanje na dugme za registraciju
	public static void Register(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Register));
		wb.click();
	}

}
