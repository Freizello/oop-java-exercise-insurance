import java.security.Policy;
import java.sql.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import customHelper.HelperFormatter;
import enumLib.Gender;
import enumLib.StatusPerson;
import person.Nasabah;
import person.Prospect;
import polis.Polis;
import product.Product;
public class Program {
	
	public static void main(String[] args) {
		
		Master.init();
		
//		try {
////			Master.getNasabah("ATS");
//			System.out.println(Master.getNasabah("ATS"));
//			} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("ERROR Nasabah tidak ada :" + e.getMessage());
//		}
		
		printMainMenu();	
	}
	
//	Interface
	public static void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.print("\nVITA BONA ASURANSI"
			+ "\n==================\n"
			+ "Pilih lah salah satu menu di bawah ini:\r\n" + 
			"1.	Menu Prospect\r\n" + 
			"2.	Menu Customer\r\n" + 
			"3.	Exit Application\r\n" + 
			"\r\n" + 
			"Masukkan pilihan menu : ");
		
		Scanner scn = new Scanner(System.in);
		scanMainMenu(scn);
	}
	
	public static void scanMainMenu(Scanner scn) {
		// TODO Auto-generated method stub
		String input = scn.nextLine();
		boolean isvalid = validateInput(input, 3);
		if(!isvalid) {
			printMainMenu();
		}
		
		switch (input) {
		case "1":
			System.out.println("\n");
			printProspectMenu();
			break;
		case "2":
			System.out.println("\n");
			if (Master.getLatestNasabah() == 0) {
				printNoCostumerMenu();
			} else {
				printCostumerMenu();	
			}
			break;
		case "3":
			System.exit(0);
		default:
			System.out.println("\n");
			printMainMenu();
			break;
		}
	}
	

	private static void printNoCostumerMenu() {
		// TODO Auto-generated method stub
		printAllNasabah();
		System.out.println("====================");
		System.out.println("Back to main menu...");
		
		printMainMenu();
	}

	private static void printProspectMenu() {
	// TODO Auto-generated method stub
			System.out.println("");
			printAllProspect();
			
			System.out.print("\n Menu Prospect"
				+ "\n==================\n"
				+ "Pilih lah salah satu menu di bawah ini:\r\n" + 
				"1.	Add Prospect\r\n" + 
				"2.	Prospect to Customer\r\n" + 
				"3.	Main menu\r\n" + 
				"\r\n" + 
				"Masukkan pilihan menu : ");
			
			Scanner scn = new Scanner(System.in);
			scanProspectMenu(scn);
	}
	
	public static void scanProspectMenu(Scanner scn) {
		// TODO Auto-generated method stub
		String input = scn.nextLine();
		boolean isvalid = validateInput(input, 3);
		if(!isvalid) {
			printMainMenu();
		}
		
		switch (input) {
		case "1":
			System.out.println("\n");
			printAddProspectMenu();
			break;
		case "2":
			System.out.println("\n");
			if (Master.getLatestProspect() == 0) {
				printNoProsToCustMenu();
			} else {
				printProsToCustMenu();
			}
			break;
		case "3" :
			printMainMenu();
		case "4":
			System.exit(0);
		default:
			printProspectMenu();
			break;
		}
	}

	private static void printNoProsToCustMenu() {
		// TODO Auto-generated method stub
		printAllProspect();
		System.out.println("====================");
		System.out.println("Back to main menu...");
		printMainMenu();
	}

	private static void printProsToCustMenu() {
		// TODO Auto-generated method stub
		try {
			printAllProspect();
					
			System.out.printf("\n===========\n"
					+ "Ketik nomor prospect yang ingin dijadikan nasabah : ");
			Scanner scn = new Scanner(System.in);
			
			scanProsToCust(scn);
			
		} catch(Exception e) {
			System.out.println("ERROR printProsToCustMenu() : " + e.getMessage());
		}
		
		
		
	}

	private static void scanProsToCust(Scanner scn) {
		// TODO Auto-generated method stub
		
		try {
			
			String noProspect = scn.nextLine();
			System.out.print("Nomor KTP : "); 
			String noKTP = scn.nextLine();
			System.out.print("Status KK : "); 
			String statusKK = scn.nextLine();
			System.out.print("Payment Method : "); 
			String payment = scn.nextLine();		
			
			Master.changeProspect(Integer.parseInt(noProspect), noKTP, statusKK, payment);
			System.out.println("Input Data Berhasil");
			printMainMenu();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
//				
//		boolean isvalid = validateInput(input, 3);
//		if(!isvalid) {
//			printMainMenu();
//		}
//		
//		switch (input) {
//		case "1":
//			System.out.println("\n");
//			printProspectMenu();
//			break;
//		case "2":
//			System.out.println("\n");
//			printCostumerMenu();
//			break;
//		case "3":
//			System.exit(0);
//		default:
//			System.out.println("\n");
//			printMainMenu();
//			break;
//		}
			
	}

	private static void printAddProspectMenu() {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		System.out.printf("Masukan data prospect satu-persatu:\r\n" + 
			"==============================\r\n" + 
			"Nama Depan : "); String namaDepan = scn.nextLine();
		System.out.print("Nama Belakang : "); String namaBelakang = scn.nextLine();
		System.out.print("Tanggal Lahir (dd/MM/yyyy) : "); String tglLahir = scn.nextLine();
		System.out.print("Tempat Lahir  : "); String tempatLahir = scn.nextLine();		
		System.out.print("Jenis Kelamin  : "); String jenisKelamin = scn.nextLine();		
		System.out.print("Pekerjaan  : "); String pekerjaan = scn.nextLine();
		
		Integer newNoPros = 0;
		try {
			 newNoPros = Master.getLatestProspect() + 1;
		} catch(Exception e) {
			newNoPros += 1;
		}
				
//		System.out.println("ID BARU : " + newNoPros.toString());
		try {
			Prospect baru = new Prospect(newNoPros, namaDepan, namaBelakang,
					HelperFormatter.formatLocalDate(tglLahir, "dd/MM/yyyy"), tempatLahir, 
					HelperFormatter.formatGender(jenisKelamin), pekerjaan, StatusPerson.PROSPECT);
			
			Master.setProspect(baru);
			
			System.out.println("Berhasil menambahkan prospect baru");
			printProspectMenu();
		} catch (Exception e){
			System.out.println("Gagal menambahkan prospect baru");
			printProspectMenu();
		};
		
		
		
	}
	
	private static void printCostumerMenu() {
	// TODO Auto-generated method stub	
		printAllNasabah();
		
		Master.printTotalPolicy();
		
		System.out.print("\n Menu Prospect"
			+ "\n==================\n"
			+ "Pilih lah salah satu menu di bawah ini:\r\n" + 
			"1.	Buy Product\r\n" + 
			"2.	Detail Policy\r\n" + 
			"3. Summary Policy\r\n" +
			"4.	Main menu\r\n" + 
			"\r\n" + 
			"Masukkan pilihan menu : ");
		
		Scanner scn = new Scanner(System.in);
		scanCustomerMenu(scn);
		
	}	
	
	private static void scanCustomerMenu(Scanner scn) {
		// TODO Auto-generated method stub
		String input = scn.nextLine();
		boolean isvalid = validateInput(input, 4);
		if(!isvalid) {
			printMainMenu();
		}
		
		switch (input) {
		case "1":
			System.out.println("\n");
			printBuyProductMenu();
			break;
		case "2":
			System.out.println("\n");
			printDetailPolicy();
			break;
		case "3" :
			Master.printTotalPolicy();
		case "4" :
			printMainMenu();
		default:
			printProspectMenu();
			break;
		}
		
	}

	private static void printDetailPolicy() {
		// TODO Auto-generated method stub
		printAllPolicy();
		Scanner scn = new Scanner(System.in);
		System.out.println("Pilih Nomor Customer : "); String noCust = scn.nextLine();
		Master.printPolicy(noCust);
		
	}

	private static void printAllPolicy() {
		// TODO Auto-generated method stub
		Master.getAllPolicy();
		
		
	}

	private static void printBuyProductMenu() {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		printAllNasabah();
		System.out.print("Pilih nomor customer : "); String noCust = scn.nextLine();
//		printAllProduk();
		System.out.print("Pilih nama produk : "); String namaProduct = scn.nextLine().toLowerCase();
		
		switch (Master.getProduct(namaProduct).getKetentuan()) {
		case KELUARGA:
			printAsuransiKeluarga(noCust, namaProduct);
			break;
		case SENDIRI:
			printAsuransiSendiri(noCust, namaProduct);
			break;
		case KENDARAAN:
			printAsuransiKendaraan(noCust, namaProduct);
//			printKendaraan(noCust, Master.getProduct(namaProduct));
			break;
		default:
			printBuyProductMenu();
			break;
		}		
	}

	private static void printAsuransiSendiri(String noCust, String namaProduct) {
		// TODO Auto-generated method stub
		Master.custBuyProduct(noCust, namaProduct, noCust);
	}

	private static void printAsuransiKeluarga(String noCust, String namaProduct) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in); 
		System.out.print("Pilih nomor customer tertanggung : "); String noCustTanggung = scn.nextLine();
		Master.custBuyProduct(noCust, namaProduct, noCustTanggung);

	}

	private static void printAsuransiKendaraan(String noCust, String namaProduct) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		System.out.println("Input data kendaraan : ");
		System.out.print("Jenis kendaraan : "); String jenisKendaraan = scn.nextLine();
		System.out.print("Nomor polisi : "); String nopol = scn.nextLine();
		System.out.print("Nomor STNK : "); String noSTNK = scn.nextLine();
		System.out.print("Merk kendaraan : "); String merkKendaraan = scn.nextLine();
		System.out.print("Model kendaraan: : "); String modelKendaraan = scn.nextLine();
		System.out.print("Warna kendaraan: : "); String warnaKendaraan = scn.nextLine();
		
		Master.custBuyProductForVehicle(noCust, namaProduct, jenisKendaraan, nopol, noSTNK, merkKendaraan,
				modelKendaraan, warnaKendaraan);
	}

	private static void printAllNasabah() {
		// TODO Auto-generated method stub
		Master.getAllNasabah();
	}

	private static void printAllProspect() {
		// TODO Auto-generated method stub
		Master.getAllProspect();
	}

	//	Validation
	private static boolean validateInput(String input, int maxMenu) {
		boolean validation = false;
		try {
			int numericInput = Integer.parseInt(input);
			if(numericInput <= maxMenu && numericInput >= 1) {
				validation = true;
			} else {
				System.out.printf("Tolong masukan antara 1 - %d\n", maxMenu);
			}
		}catch(Exception exception) {
			System.out.println("Format yang anda masukan salah, coba lagi.");
		}
		return validation;
	}
	
//	private static void addProspect(Scanner scn) {
//		// TODO Auto-generated method stub
//		Integer noPros = Master.getLatestProspect();
//		String namaDepan =;
//		String namaBelakang;
//		LocalDate tglLahir;
//		String tempatLahir;
//		Gender jenisKelamin;
//		String pekerjaan;
//		
//		
//		
//		Prospect baru = new Prospect(noPros.toString(), namaDepan, namaBelakang,
//				tglLahir, "Jakarta", jenisKelamin, pekerjaan, StatusPerson.PROSPECT);
//		Master.setProspect(baru);
//	}
	
	

}
