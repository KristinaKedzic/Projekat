package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPublishingPage {
	
	private static final String MakeAPost = "//a[contains(text(),'Make a post')]";
	private static final String Naziv = "//input[@placeholder='Naziv']";
	private static final String Lokacija = "//input[@placeholder='Lokacija']";
	private static final String Browse = "//input[@id='image']";
	private static final String PrevoznoSredstvo = "//div[@class='popupPost']//select[@name='transport']";
	private static final String Opis = "//textarea[@placeholder='Opis']";
	private static final String Post = "//div[@class='popupPost']//input[@name='postSubmit']";
	
	//Metoda za kliktanje na dugme za pravljenje objave
	public static void MakeAPost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(MakeAPost));
		wb.click();
	}
	
	//Metoda za unos naziva objave
	public static void Naziv(WebDriver dr, String naz) {
		WebElement wb = dr.findElement(By.xpath(Naziv));
		wb.click();
		wb.sendKeys(naz);
	}
	
	//Metoda za unos lokacije objave
	public static void Lokacija(WebDriver dr, String lok) {
		WebElement wb = dr.findElement(By.xpath(Lokacija));
		wb.click();
		wb.sendKeys(lok);
	}
	
	//Metoda za unos slike na objavi
	public static void Browse(WebDriver dr) {
		String filePath = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg";
		WebElement wb = dr.findElement(By.xpath(Browse));
		wb.sendKeys(filePath);
	} 
	
	//Metoda za izbor sredstva za prevoz na objavi
	public static void PrevoznoSredstvo(WebDriver dr, String prevsred) {
		Select prevoz = new Select(dr.findElement(By.xpath(PrevoznoSredstvo)));
		prevoz.selectByVisibleText(prevsred);
	}
	
	//Metoda za opis objave
	public static void Opis(WebDriver dr, String opis) {
		WebElement wb = dr.findElement(By.xpath(Opis));
		wb.click();
		wb.sendKeys(opis);
	}
	
	//Metoda za objavljivanje objave
	public static void Post(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(Post));
		wb.click();
	}

}
