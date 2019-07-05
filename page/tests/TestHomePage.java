package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;

public class TestHomePage {
	
	//Metoda za otvaranje pocetne strane sajta "izlet"
	public static void OpenPage(WebDriver dr) {
		if(!dr.getCurrentUrl().equals(HomePage.PAGE_URL))
			dr.navigate().to(HomePage.PAGE_URL);
	}

}
