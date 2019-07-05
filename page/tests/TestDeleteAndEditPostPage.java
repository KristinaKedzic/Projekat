package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.DeleteAndEditPostPage;
import page.objects.PostPublishingPage;

public class TestDeleteAndEditPostPage {
	
	//Metoda za brisanje objave
	public static void DeletePost(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Da li zelite da izbrisete prve dve objave? Unesite: da/ne");
		String da = "da";
		String ne = "ne";
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
			for(int i = 0; i<2; i++) {
				DeleteAndEditPostPage.Tackice(dr);
				DeleteAndEditPostPage.Delete(dr);
				}
			System.out.println("Prve dve objave su obrisane.");	
			break;
			}
			else if(poruka.contentEquals(ne)) {
				System.out.println("Objave su ostale nepromenjene.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo.");
				continue;
			}
		}
	}
	
	
	//Metoda za prepravljanje objave
	public static void EditPost(WebDriver dr) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Prepraviti postojecu objavu.");
		DeleteAndEditPostPage.Tackice(dr);
		DeleteAndEditPostPage.Edit(dr);
		
		String da = "da";
		String ne = "ne";
		
		System.out.println("Da li zelite da izmenite naziv objave? Unesite: da/ne");
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
			System.out.println("Unesite novi naziv:");
			String naz = sc.nextLine();
			DeleteAndEditPostPage.EditNaziv(dr, naz);
			break;
			}
			else if (poruka.contentEquals(ne)) {
				System.out.println("Naziv objave ostaje isti.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo.");
				continue;
			}
		}
		
		System.out.println("Da li zelite da izmenite lokaciju objave? Unesite: da/ne");
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
			System.out.println("Unesite novu lokaciju:");
			String lok = sc.nextLine();
			DeleteAndEditPostPage.EditLokacija(dr, lok);
			break;
			}
			else if (poruka.contentEquals(ne)) {
				System.out.println("Naziv lokacije ostaje isti.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo.");
				continue;
			}
		}
		
		System.out.println("Da li zelite da izmenite sliku? Unesite: da/ne");
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
			DeleteAndEditPostPage.EditBrowse(dr);
			break;
			}
			else if (poruka.contentEquals(ne)) {
				System.out.println("Slika ostaje ista.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo.");
				continue;
			}
		}
		
		System.out.println("Da li zelite da izmenite prevozno sredstvo? Unesite: da/ne");
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
			System.out.println("Ukucajte novo prevozno sredstvo od ponudjenih: Walk, Car, Motorbike, Bicycle, Bus.");
			while(true) {
				try {
					String prevsred = sc.nextLine();
					DeleteAndEditPostPage.EditPrevoznoSredstvo(dr, prevsred);
					break;
					}
				catch(Exception e) {
					System.out.println("Ukucati poruku ponovo.");
					continue;
					}
				}
			break;
			}
			else if (poruka.contentEquals(ne)) {
				System.out.println("Prevozno sredstvo ostaje isto.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo.");
				continue;
			}
		}
		
		System.out.println("Da li zelite da izmenite opis objave? Unesite: da/ne");
		while(true) {
			String poruka = sc.nextLine();
			if(poruka.contentEquals(da)) {
			System.out.println("Unesite novi opis:");
			String opis = sc.nextLine();
			DeleteAndEditPostPage.EditOpis(dr, opis);
			break;
			}
			else if (poruka.contentEquals(ne)) {
				System.out.println("Opis objave ostaje isti.");
				break;
			}
			else {
				System.out.println("Ukucajte poruku ponovo.");
				continue;
			}
		}
		
		DeleteAndEditPostPage.Editpost(dr);
		System.out.println("Vasa objava je prepravljena.");
	}
	

}
