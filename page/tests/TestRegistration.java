package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.Constant;
import utility.ExcelUtils;

public class TestRegistration {
	
	
	//Metoda za manuelnu registraciju korisnika 
	public static void ManualReg(WebDriver dr) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Zapocnite registraciju.");
			System.out.println("Unesite ime:");
			String fn = sc.nextLine();
			RegistrationPage.FirstName(dr, fn);
			System.out.println("Unesite prezime:");
			String ln = sc.nextLine();
			RegistrationPage.LastName(dr, ln);
			System.out.println("Unesite korisnicko ime:");
			String un = sc.nextLine();
			RegistrationPage.Username(dr, un);
			System.out.println("Unesite mejl:");
			String em = sc.nextLine();
			RegistrationPage.Email(dr, em);
			System.out.println("Unesite sifru:");
			String pw = sc.nextLine();
			RegistrationPage.Password(dr, pw);
			RegistrationPage.Register(dr);
			System.out.println("Uspesno ste se registrovali.");
			
			/*
			String da = "da";
			String ne = "ne";
			System.out.println("Da li zelite da se prijavite na sajt? Unesite: da/ne");
			while(true) {
				String poruka = sc.nextLine();
				if(poruka.contentEquals(da)) {
				LogInPage.UserNameLogIn(dr, un);
				LogInPage.PasswordLogIn(dr, pw);
				LogInPage.LogInButton(dr);
				break;
				}
				else if(poruka.contentEquals(ne)) {
					System.out.println("Korisnik nije prijavljen.");
					break;
				}
				else {
					System.out.println("Ukucajte poruku ponovo."); 
					continue;
				}
			}
			
			System.out.println("Da li zelite da se odjavite sa sajta? Unesite: da/ne");
			while(true) {
				String poruka = sc.nextLine();
				if(poruka.contentEquals(da)) {
					LogInPage.LogOutButton(dr);
					break; }
				else if(poruka.contentEquals(ne)) {
					System.out.println("Korisnik ostaje ulogovan");
					break;
				}
				else {
					System.out.println("Ukucajte poruku ponovo."); 
					continue;
				}
			} */
			
		}
	
	//Metoda za automatsku registraciju korisnika iz eksel tabele
	public static void AutomReg(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.SHEET_NAME1);
		
		int CountOfRows = ExcelUtils.getWorkSheet().getLastRowNum();
		
		int kolonaA=0;
		int kolonaB=1;
		int kolonaC=2;
		int kolonaD=3;
		int kolonaE=4;
		
		for(int i=1;i<=CountOfRows;i++) {
		RegistrationPage.FirstName(dr, ExcelUtils.getCellData(i, kolonaA));
		RegistrationPage.LastName(dr, ExcelUtils.getCellData(i, kolonaB));
		RegistrationPage.Username(dr, ExcelUtils.getCellData(i, kolonaC));
		RegistrationPage.Email(dr, ExcelUtils.getCellData(i, kolonaD));
		RegistrationPage.Password(dr, ExcelUtils.getCellData(i, kolonaE));
		RegistrationPage.Register(dr);
		}
		
	}
	

}
