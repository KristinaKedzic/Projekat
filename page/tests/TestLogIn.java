package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.Constant;
import utility.ExcelUtils;

public class TestLogIn {

	//Metoda za manuelu prijavu korisnika na sajt
	public static void ManualLogIn(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Prijava korisnika na sajt.");
		System.out.println("Unesite vase korisnicko ime:");
		String unli = sc.nextLine();
		LogInPage.UserNameLogIn(dr, unli);
		System.out.println("Unesite vasu sifru:");
		String pwli = sc.nextLine();
		LogInPage.PasswordLogIn(dr, pwli);
		LogInPage.LogInButton(dr);
		
	}
	
	//Metoda za mauelnu odjavu korisnika sa sajta
	public static void ManualLogOut(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Da li zelite da se odjavite sa sajta? Uneti: da/ne");
		String da = "da";
		String ne = "ne";
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
				LogInPage.LogOutButton(dr);
				break; }
			else if(poruka.contentEquals(ne)) {
				System.out.println("Korisnik ostaje ulogovan.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo."); 
				continue;
			}
		}
	}
	
	//Metoda za automatsku prijavu korisnika na sajt iz eksel tabele
	public static void AutomLogIn(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.SHEET_NAME1);
		
		int CountOfRows = ExcelUtils.getWorkSheet().getLastRowNum();
		
		int kolonaC=2;
		int kolonaE=4;
		
		for(int i=1;i<=CountOfRows;i++) {
		LogInPage.UserNameLogIn(dr, ExcelUtils.getCellData(i, kolonaC));
		LogInPage.PasswordLogIn(dr, ExcelUtils.getCellData(i, kolonaE));
		LogInPage.LogInButton(dr);
		LogInPage.LogOutButton(dr);
		}
		
	}
	
		
	
}
