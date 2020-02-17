import java.math.BigDecimal;
import java.security.Policy;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import customHelper.HelperFormatter;
import enumLib.Frekuensi;
import enumLib.Gender;
import enumLib.KetentuanProduk;
import enumLib.PaymentMethod;
import enumLib.StatusPerson;
import enumLib.statusKK;
import person.Kendaraan;
import person.Nasabah;
import person.Person;
import person.Prospect;
import polis.Polis;
import product.Product;

public class Master {
//	private static String namaAplikasi;
//	private static String jenis;
//	private static String pembuat;
//	private static String tahunDibuat;
	
//	Database
	private static HashMap<Integer, Prospect> db_prospect = new HashMap<Integer, Prospect>();
	private static HashMap<String, Nasabah> db_nasabah = new HashMap<String, Nasabah>();
	private static HashMap<String, Product> db_product = new HashMap<String, Product>();
	private static HashMap<String, Polis> db_policy = new HashMap<String, Polis>();
	
	public static void init() {
		setProduct();
		setProspect();
	}
	
	
	public static void setProspect() {
		Prospect baru = new Prospect(1, "Hendrik", "Tio", "1207222207950001", 
			LocalDate.of(1995, 7, 22), "Jakarta", 
			Gender.MALE, "Programmer", StatusPerson.PROSPECT);
		Master.setProspect(baru);
	}
	
	public static void setProduct() {
//		new MataKuliah("Object Oriented Programming", Jurusan.PROGRAMMING, 20);
		db_product.put("sehat bersama", 
				new Product("Sehat Bersama", "Kesehatan", Frekuensi.MONTHLY, "Claim perawatan kelas 1", 
						KetentuanProduk.KELUARGA));
		db_product.put("sehat extra", 
				new Product("Sehat Extra", "Kesehatan", Frekuensi.MONTHLY, "Claim perawatan kelas VIP", 
						KetentuanProduk.SENDIRI));
		db_product.put("life keluarga", 
				new Product("Life Keluarga", "Jiwa", Frekuensi.MONTHLY, 
						"Mendapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung.", 
						KetentuanProduk.KELUARGA));
		db_product.put("life special", 
				new Product("Life Special", "Jiwa", Frekuensi.ANNUALLY, 
						"Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung.", 
						KetentuanProduk.SENDIRI));
		db_product.put("protection", 
				new Product("Protection", "Kendaraan", Frekuensi.ANNUALLY, 
						"Mendapatkan 100.000.000 apabila terjadi sesuatu.", 
						KetentuanProduk.KENDARAAN));
		db_product.put("protection plus", 
				new Product("Protection Plus", "Kendaraan", Frekuensi.ANNUALLY, 
						"Mendapatkan ganti rugi total loss apabila terjadi sesuatu.", 
						KetentuanProduk.KENDARAAN));
		
	}
	
	public static void getAllProspect() {
		// TODO Auto-generated method stub
		try{
			if(db_prospect.size() == 0) {
				System.out.println("Tidak ada data prospect");
			} else {
				for(Prospect pros: db_prospect.values()) {
					pros.printSummary();
				}
			}
		}
		catch(NullPointerException e){
		   System.out.println("Error : " + e.getMessage());
		}	
	}
	
	public static void changeProspect(Integer noProspect, 
		String noKTP, String statusKK, String payment){
		Prospect pros = db_prospect.get(noProspect);
		String nomorNasabah = null; 
		LocalDate datenow = LocalDate.now(ZoneId.of("Asia/Jakarta"));
//		statusKK statusKeluarga = null;
		PaymentMethod payMethod = null;
		
		try {
			nomorNasabah = datenow.getMonthValue() + "/" + datenow.getYear() + "/" + noProspect;
			
			System.out.printf("NOMOR NASABAH : %s \n", nomorNasabah);
			
//			UPDATE PROSPECT TO NASABAH IN db_prospect BY ID 
			setProspect(new Prospect(noProspect, pros.getNamaDepan(), 
					pros.getNamaBelakang(), noKTP, pros.getTglLahir(), pros.getTempatLahir(), 
					pros.getJenisKelamin(), pros.getPekerjaan(), StatusPerson.NASABAH));
//			PUT NASABAH TO db_nasabah BY ID 
			Nasabah nas = new Nasabah(noProspect, pros.getNamaDepan(), pros.getNamaBelakang(),
					noKTP, pros.getTglLahir(), pros.getTempatLahir(), pros.getJenisKelamin(), 
					pros.getPekerjaan(), StatusPerson.NASABAH, nomorNasabah, 
					HelperFormatter.formatStatusKeluarga(statusKK),
					HelperFormatter.formatPaymentMethod(payment));
			setNasabah(nas);
			
		} catch(Exception e) {
//			System.out.println("Format yang anda masukan salah, coba lagi.");
			System.out.println(e.getMessage());
		}	
	}
	
	private static void setNasabah(Nasabah newNasabah) {
		// TODO Auto-generated method stub
//		db_nasabah = new HashMap<String, Nasabah>();
//		put data to db based on Prospect params
		db_nasabah.put(newNasabah.getNomorNasabah(), newNasabah);
	}
	
	public static void setProspect(Prospect newProspect) {
//		init DB
//		put data to db based on Prospect params
		db_prospect.put(newProspect.getNoProspect(), newProspect);
	}
	
	public static Integer getLatestProspect() {
		return db_prospect.size();
	}
	
	public static Integer getLatestNasabah() {
		return db_nasabah.size();
	}

	public static void getAllNasabah() {
		// TODO Auto-generated method stub
		try{
			if(db_nasabah.size() == 0) {
				System.out.println("Tidak ada data nasabah.");
			} else {
				for(Nasabah nas: db_nasabah.values()) {
					nas.printSummary();
				}
			}
		}
		catch(NullPointerException e){
		   System.out.println("ERROR getAllNasabah() : " + e.getMessage());
		}	
	}

	public static Product getProduct(String namaProduct) {
		// TODO Auto-generated method stub
		return db_product.get(namaProduct);
		
	}

	public static Nasabah getNasabah(String noCust) {
		// TODO Auto-generated method stub
		return db_nasabah.get(noCust);
		
	}
	
	public static void custBuyProduct(String noCust, String namaProduct, String noCustTanggung) {
		// TODO Auto-generated method stub
		try {
			Nasabah nas = db_nasabah.get(noCust);
			Nasabah custTanggung = db_nasabah.get(noCustTanggung);
			Product prod = db_product.get(namaProduct);
			int noPolis = db_policy.size()+1;
			String noCustPolis = nas.getNomorNasabah() + "/" + noPolis;
//			Integer biayaIuran = getBiayaIuran(nas, prod);
						
			Integer jarak = Period.between(
					nas.getTglLahir(), LocalDate.now(ZoneId.of("Asia/Jakarta")
					)).getYears();
			
			Integer biayaIuran;
			if (prod.getNamaProduk() == "Sehat Bersama") {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 200000;
				} else {
					biayaIuran = 400000;
				}
			} else if (prod.getNamaProduk() == "Sehat Extra") {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 300000;
				} else {
					biayaIuran = 500000;
				}
			} else if (prod.getNamaProduk() == "Life Keluarga") {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 250000;
				} else {
					biayaIuran = 450000;
				}
			} else if (prod.getNamaProduk() == "Life Special") {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 3600000;
				} else {
					biayaIuran = 4800000;
				}
			} else if (prod.getNamaProduk() == "Protection") {
				biayaIuran = 2000000;
			} else {
				biayaIuran = 2500000;
			}
			
//			System.out.println(biayaIuran);
//			System.out.println(jarak);
//			System.out.println(prod.getNamaProduk() == "Sehat Bersama");
			
			
//			Set Polis
			Polis polisBaru = new Polis(nas, db_product.get(namaProduct), noCustPolis, 
					custTanggung, new BigDecimal(biayaIuran), LocalDate.now());
			
			db_policy.put(noCustPolis, polisBaru);

			System.out.println("========================");
			System.out.println("Polis berhasil di simpan");
			System.out.println("========================");
			Program.printMainMenu();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR : custBuyProduct() " +e.getMessage());
		}
	}

	public static void custBuyProductForVehicle(String noCust, String namaProduct, String jenisKendaraan, String nopol,
			String noSTNK, String merkKendaraan, String modelKendaraan, String warnaKendaraan) {
		// TODO Auto-generated method stub
//		try {
			Nasabah nas = db_nasabah.get(noCust);
			Product prod = db_product.get(namaProduct);
			int noPolis = db_policy.size()+1;
			String noCustPolis = nas.getNomorNasabah() + "/" + noPolis;
			
			System.out.println(noCustPolis);
			
			Integer jarak = Period.between(
					nas.getTglLahir(), LocalDate.now(ZoneId.of("Asia/Jakarta")
					)).getYears();
			
			Integer biayaIuran;
			if (prod.getNamaProduk().equals("Sehat Bersama")) {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 200000;
				} else {
					biayaIuran = 400000;
				}
			} else if (prod.getNamaProduk().equals("Sehat Extra")) {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 300000;
				} else {
					biayaIuran = 500000;
				}
			} else if (prod.getNamaProduk().equals("Life Keluarga")) {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 250000;
				} else {
					biayaIuran = 450000;
				}
			} else if (prod.getNamaProduk().equals("Life Special")) {
				if (jarak > 0 && jarak <= 20) {
					biayaIuran = 3600000;
				} else {
					biayaIuran = 4800000;
				}
			} else if (prod.getNamaProduk().equals("Protection")) {
				biayaIuran = 2000000;
			} else {
				biayaIuran = 2500000;
			}
			
			System.out.println("BIAYA IURAN : " + biayaIuran);
//			System.out.println(jarak);
			
			System.out.println("SIZE POLIS : " + db_policy.size());
//			Set Polis
//			Polis(Nasabah nasabah, Product product, String noCustPolis, String jenisKendaraan, String nopol, String noSTNK,
//						String merkKendaraan, String modelKendaraan, String warnaKendaraan, BigDecimal biayaIuran, LocalDate tglPolis)
			Polis polisBaru = new Polis(nas, prod, noCustPolis, 
					jenisKendaraan, nopol, noSTNK, merkKendaraan, modelKendaraan, warnaKendaraan, 
					new BigDecimal(biayaIuran), LocalDate.now());
			
			db_policy.put(noCustPolis, polisBaru);
			

			System.out.println("SIZE POLIS SETELAH PUT : " + db_policy.size());
//			db_policy.put(key, value)
			
			System.out.println("========================");
			System.out.println("Polis berhasil di simpan");
			System.out.println("========================");
			Program.printMainMenu();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("ERROR : custBuyProductforVehicle1() " +e.getMessage());
//		}
	}


	public static Integer getBiayaIuran(Nasabah nasabah, Product product) {
		// TODO Auto-generated method stub
		Integer jarak = Period.between(
				nasabah.getTglLahir(), LocalDate.now(ZoneId.of("Asia/Jakarta")
				)).getYears();
		System.out.println(jarak);
		System.out.println(product.getNamaProduk().toLowerCase());
		System.out.println(nasabah.getTglLahir());
		int result;
		if (product.getNamaProduk().toLowerCase() == "sehat bersama") {
			if (jarak > 0 && jarak <= 20) {
				result = 200000;
			} else {
				result = 400000;
			}
		} else if (product.getNamaProduk().toLowerCase() == "sehat extra") {
			if (jarak > 0 && jarak <= 20) {
				result = 300000;
			} else {
				result = 500000;
			}
		} else if (product.getNamaProduk().toLowerCase() == "life keluarga") {
			if (jarak > 0 && jarak <= 20) {
				result = 250000;
			} else {
				result = 450000;
			}
		} else if (product.getNamaProduk().toLowerCase() == "life special") {
			if (jarak > 0 && jarak <= 20) {
				result = 3600000;
			} else {
				result = 4800000;
			}
		} else if (product.getNamaProduk().toLowerCase() == "protection") {
			result = 2000000;
		} else if (product.getNamaProduk().toLowerCase() == "protection plus") {
			result = 2500000;
		} else {
			result = 0;
		}
		return result;
	}

	public static void getAllPolicy() {
		// TODO Auto-generated method stub
		if(db_policy.size() == 0) {
			System.out.println("Tidak ada data policy.");
		} else {
			for(Polis pol: db_policy.values()) {
				pol.printSummary();
			}
		}
	}

	public static void printPolicy(String key) {
		// TODO Auto-generated method stub
		System.out.println("SIZE POLIS : " + db_policy.size());
		for(Polis polis: db_policy.values()) {
			String value = polis.getNoCustPolis();
			polis.generateBiayaIuran();
			polis.getNasabah();
			if (polis.getNasabah().getNomorNasabah().equals(key)) {
				polis.printDetail();	
			}
//			2/2020/1*
//			if(value.matches(".*" + key + ".*")) {	
			//			};
		}
		
	}
	
	public static void printTotalPolicy() {
		// TODO Auto-generated method stub
		for(Nasabah nas: db_nasabah.values()) {
			Integer sizePolis = 0;
			for(Polis polis : db_policy.values()) {
				String noCustPolis = polis.getNasabah().getNomorNasabah();
				String noCust = nas.getNomorNasabah();
				
			if (noCustPolis == noCust) {
				sizePolis++;
				System.out.println(nas.getNamaDepan() + " " + nas.getNamaBelakang() + " : " + sizePolis + " Polis");
			}
			
			}
		}
	}
}
