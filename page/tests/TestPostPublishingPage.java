package page.tests;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LogInPage;
import page.objects.PostPublishingPage;
import utility.Constant;
import utility.ExcelUtils;

public class TestPostPublishingPage {
	
	//Metoda za manuelni unos objave
	public static void ManualPost(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Napraviti novu objavu na sajtu.");
		PostPublishingPage.MakeAPost(dr);
		System.out.println("Unesite naziv:");
		String naz = sc.nextLine();
		PostPublishingPage.Naziv(dr, naz);
		System.out.println("Unesite lokaciju:");
		String lok = sc.nextLine();
		PostPublishingPage.Lokacija(dr, lok);
		PostPublishingPage.Browse(dr);
		System.out.println("Ukucajte prevozno sredstvo od ponudjenih: Walk, Car, Motorbike, Bicycle, Bus.");
		while(true) {
			try {
			String prevsred = sc.nextLine();
			PostPublishingPage.PrevoznoSredstvo(dr, prevsred);
			break;
				}
			catch(Exception e) {
				System.out.println("Ukucajte poruku ponovo");
				continue;
				}
			} 
		System.out.println("Unesite opis:");
		String opis = sc.nextLine();
		PostPublishingPage.Opis(dr, opis);
		PostPublishingPage.Post(dr);
		System.out.println("Vasa objava je postavljena.");
	}
	
	//Metoda za automatski unos objave iz eksel tabele
	public static void AutomPost(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.SHEET_NAME2);
		
		int CountOfRows = ExcelUtils.getWorkSheet().getLastRowNum();
		
		int kolonaA=0;
		int kolonaB=1;
		int kolonaC=2;
		
		for(int i=1;i<=CountOfRows;i++) {
		PostPublishingPage.MakeAPost(dr);
		PostPublishingPage.Naziv(dr, ExcelUtils.getCellData(i, kolonaB));
		PostPublishingPage.Lokacija(dr, ExcelUtils.getCellData(i, kolonaC));
		PostPublishingPage.Opis(dr,ExcelUtils.getCellData(i, kolonaA));
		PostPublishingPage.Post(dr);
		}
	}
	

}
