package page.objects;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public static final String PAGE_URL="http://localhost/izlet/index.php";
	
	//Metoda za otvaranje pocetne strane
	public static void openPage(WebDriver dr) {
		dr.get(PAGE_URL);
	}
	
	//Metoda za preusmeravanje na pocetnu stranu "izlet" ako je otvorena neka druga stranica
	public static void navigate(WebDriver dr) {
		dr.navigate().to(PAGE_URL);
	}
	
	

}
