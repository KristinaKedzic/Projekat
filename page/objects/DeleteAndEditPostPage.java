package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DeleteAndEditPostPage {
	
	private static final String Tackice = "fa-ellipsis-v";
	private static final String Edit = "fa-edit";
	private static final String Delete = "fa-trash-alt";
	
	private static final String EditNaziv = "//input[@id='title']";
	private static final String EditLokacija = "//input[@id='location']";
	private static final String EditBrowse= "//input[@id='editImage']";
	private static final String EditPrevoznoSredstvo = "//select[@id='transport']";
	private static final String EditOpis = "//textarea[@id='description']";
	private static final String EditPost = "//div[@class='popupEdit']//input[@name='postSubmit']";
	
	//Metoda za izbor padajuceg menija za tri tackice, u okviru koga se nalaze prepravljanje i brisanje
	public static void Tackice(WebDriver dr) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> padajucimeni = dr.findElements(By.className(Tackice));
		WebElement wb = padajucimeni.get(0);
		wb.click();
	}
	
	//Metoda za izbor dugmeta za prepravljanje objave
	public static void Edit(WebDriver dr) {
		List<WebElement> popravljanje = dr.findElements(By.className(Edit));
		WebElement wb = popravljanje.get(0);
		wb.click();
	}
	
	//Metoda za izbor dugmeta za brisanje objave
	public static void Delete(WebDriver dr) {
		List<WebElement> brisanje = dr.findElements(By.className(Delete));
		WebElement wb = brisanje.get(0);
		wb.click();
	}
	
	//Metoda za prepravljanje naziva objave
	public static void EditNaziv(WebDriver dr, String naz) {
		WebElement wb = dr.findElement(By.xpath(EditNaziv));
		wb.click();
		wb.clear();
		wb.sendKeys(naz);
	}
	
	//Metoda za prepravljanje lokacije objave
	public static void EditLokacija(WebDriver dr, String lok) {
		WebElement wb = dr.findElement(By.xpath(EditLokacija));
		wb.click();
		wb.clear();
		wb.sendKeys(lok);
	}
	
	//Metoda za unos nove slike u objavu
	public static void EditBrowse(WebDriver dr) throws InterruptedException {
		String filePath = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg";
		WebElement wb = dr.findElement(By.xpath(EditBrowse));
		wb.sendKeys(filePath);
		Thread.sleep(2000);
	}
	
	//Metoda za prepravljanje stredstva za prevoz na objavi
	public static void EditPrevoznoSredstvo(WebDriver dr, String prevsred) {
		Select prevoz = new Select(dr.findElement(By.xpath(EditPrevoznoSredstvo)));
		prevoz.selectByVisibleText(prevsred);
	}
	
	//Metoda za prepravljanje opisa objave
	public static void EditOpis(WebDriver dr, String opis) {
		WebElement wb = dr.findElement(By.xpath(EditOpis));
		wb.click();
		wb.clear();
		wb.sendKeys(opis);
	}
	
	//Metoda za objavljivanje prepravljene objave
	public static void Editpost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EditPost));
		wb.click();
	}

}
