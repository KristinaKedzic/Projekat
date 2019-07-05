package main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.tests.TestDeleteAndEditPostPage;
import page.tests.TestHomePage;
import page.tests.TestLogIn;
import page.tests.TestPostPublishingPage;
import page.tests.TestRegistration;

public class GlavniProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Zapoceti testiranje sajta 'izlet':");
		
		try {
			TestHomePage.OpenPage(driver);
			
			System.out.println("Da li zelite da testirate manuelno ili automatski sajt:");
			while(true) {
				String mauel = "manuelno";
				String autom = "automatski";
				String odg = sc.nextLine();
				if(odg.contentEquals(mauel)) {
				TestRegistration.ManualReg(driver);
				TestLogIn.ManualLogIn(driver);
				TestPostPublishingPage.ManualPost(driver);
				TestPostPublishingPage.ManualPost(driver);
				TestPostPublishingPage.ManualPost(driver);
				break;
			}
				else if(odg.contentEquals(autom)) {
				TestRegistration.AutomReg(driver);
				TestLogIn.AutomLogIn(driver);
				TestLogIn.ManualLogIn(driver);
				TestPostPublishingPage.AutomPost(driver);
				break;
				}
				else {
					System.out.println("Ukucati poruku ponovo.");
					continue;
				}
		}
			
		TestDeleteAndEditPostPage.DeletePost(driver);
		TestDeleteAndEditPostPage.EditPost(driver);
		TestLogIn.ManualLogOut(driver);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			driver.quit();
			System.out.println("Testiranje je zavrseno.");
		}

	}

}
