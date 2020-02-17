package polis;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import person.Nasabah;
import product.Product;

public class Polis {
	
	 private Nasabah nasabah;
	 private Product product;
	 private String noCustPolis;
	 private Nasabah custTertanggung;
//	 private String noCustTanggung;
	 private BigDecimal biayaIuran;
	 private LocalDate tglPolis;
	 
	private String jenisKendaraan;
	private String nopol;
	private String noSTNK;
	private String merkKendaraan;
	private String modelKendaraan;
	private String warnaKendaraan;
	
//	Polis Orang
//	Polis(nas, db_product.get(namaProduct), noCustPolis, 
//			noCustTanggung, biayaIuran, LocalDate.now());

	public Polis(Nasabah nasabah, Product product, String noCustPolis, Nasabah custTertanggung, BigDecimal biayaIuran,
			LocalDate tglPolis) {
		super();
		this.nasabah = nasabah;
		this.product = product;
		this.noCustPolis = noCustPolis;
		this.custTertanggung = custTertanggung;
//		this.noCustTanggung = noCustTanggung;
		this.biayaIuran = biayaIuran;
		this.tglPolis = tglPolis;
	}

	public Polis(Nasabah nasabah, Product product, String noCustPolis, String jenisKendaraan, String nopol, String noSTNK,
			String merkKendaraan, String modelKendaraan, String warnaKendaraan, BigDecimal biayaIuran, LocalDate tglPolis) {
		// TODO Auto-generated constructor stub
		this.nasabah = nasabah;
		this.product = product;
		this.noCustPolis = noCustPolis;
		this.jenisKendaraan = jenisKendaraan;
		this.nopol = nopol;
		this.noSTNK = noSTNK;
		this.merkKendaraan = merkKendaraan;
		this.modelKendaraan = modelKendaraan;
		this.warnaKendaraan = warnaKendaraan;
		this.biayaIuran = biayaIuran;
		this.tglPolis = tglPolis;
	}

	public void printSummary() {
		// TODO Auto-generated method stub
//		No: 11/2018/1, Shanty Asmara, Perempuan, 21 April 1988 (Jakarta), Pegawai Swasta
//		KTP: 3120002321041988, Status di KK: Ibu, Payment Method: Credit Card

		String summary = String.format("No. Polis: %s, No Nasabah: %s, %s %s, %s, %s (%s), %s\n"
				+ "%s, Status di KK : %s, Payment Method : %s\n"
				+ "======================================================================", 
				this.getNoCustPolis(), this.nasabah.getNomorNasabah(), this.nasabah.getNamaDepan(),
				this.nasabah.getNamaBelakang(), this.nasabah.getJenisKelamin(),
				this.nasabah.getTglLahir(), this.nasabah.getTempatLahir(),
				this.nasabah.getPekerjaan(), this.nasabah.getNomorKTP(),
				this.nasabah.getStatusKeluarga(), this.nasabah.getPaymentMethod());
		System.out.println(summary);
	}

	public Nasabah getNasabah() {
		return nasabah;
	}

	public void setNasabah(Nasabah nasabah) {
		this.nasabah = nasabah;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getNoCustPolis() {
		return noCustPolis;
	}

	public void setNoCustPolis(String noCustPolis) {
		this.noCustPolis = noCustPolis;
	}

//	public String getNoCustTanggung() {
//		return noCustTanggung;
//	}
//
//	public void setNoCustTanggung(String noCustTanggung) {
//		this.noCustTanggung = noCustTanggung;
//	}
	
	public Nasabah getCustTertanggung() {
		return custTertanggung;
	}
	
	public void setCustTertanggung(Nasabah noCustTanggung) {
		this.custTertanggung = noCustTanggung;
	}

	public BigDecimal getBiayaIuran() {
		return biayaIuran;
	}

	public void setBiayaIuran(BigDecimal biayaIuran) {
		this.biayaIuran = biayaIuran;
	}

	public LocalDate getTglPolis() {
		return tglPolis;
	}

	public void setTglPolis(LocalDate tglPolis) {
		this.tglPolis = tglPolis;
	}

	public String getJenisKendaraan() {
		return jenisKendaraan;
	}

	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

	public String getNopol() {
		return nopol;
	}

	public void setNopol(String nopol) {
		this.nopol = nopol;
	}

	public String getNoSTNK() {
		return noSTNK;
	}

	public void setNoSTNK(String noSTNK) {
		this.noSTNK = noSTNK;
	}

	public String getMerkKendaraan() {
		return merkKendaraan;
	}

	public void setMerkKendaraan(String merkKendaraan) {
		this.merkKendaraan = merkKendaraan;
	}

	public String getModelKendaraan() {
		return modelKendaraan;
	}

	public void setModelKendaraan(String modelKendaraan) {
		this.modelKendaraan = modelKendaraan;
	}

	public String getWarnaKendaraan() {
		return warnaKendaraan;
	}

	public void setWarnaKendaraan(String warnaKendaraan) {
		this.warnaKendaraan = warnaKendaraan;
	}

	
	public void generateBiayaIuran() {
		// TODO Auto-generated method stub
		Integer jarak = Period.between(
				this.nasabah.getTglLahir(), LocalDate.now(ZoneId.of("Asia/Jakarta")
				)).getYears();
		
		switch (this.product.getNamaProduk()) {
			case "sehat bersama":
				if (jarak > 0 && jarak <= 20) {
					this.biayaIuran = new BigDecimal("200000");
				} else {
					this.biayaIuran = new BigDecimal("400000");
				}
				break;
			case "sehat extra":
				if (jarak > 0 && jarak <= 20) {
					this.biayaIuran = new BigDecimal("300000");
				} else {
					this.biayaIuran = new BigDecimal("500000");
				}
				break;
			case "life keluarga":
				if (jarak > 0 && jarak <= 20) {
					this.biayaIuran = new BigDecimal("250000");
				} else {
					this.biayaIuran = new BigDecimal("450000");
				}
				break;
			case "life special":
				if (jarak > 0 && jarak <= 20) {
					this.biayaIuran = new BigDecimal("3600000");
				} else {
					this.biayaIuran = new BigDecimal("4800000");
				}
				break;
			case "protection":
				this.biayaIuran = new BigDecimal("2000000");
				break;
			case "protection plus":
				this.biayaIuran = new BigDecimal("2500000");
				break;
		}
	}
	
	public void printDetail() {
		// TODO Auto-generated method stub

		Nasabah nas = this.getNasabah();
		Product prod = this.getProduct();
//		this.generateBiayaIuran();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		Locale indonesia = new Locale("id", "ID");
		
		System.out.println("================ CUSTOMER INFO ================");
		nas.printSummary();
		System.out.println("================ POLICY INFO ================");
		System.out.println("Jenis kendaraan : " + this.jenisKendaraan);
		if (!this.jenisKendaraan.isEmpty()) {
			printDetailPolisKendaraan();
		}else {
			printDetailPolisNonKendaraan();
		}
		
		System.out.println("================PAYMENT================");
//		String payment = String.format("================PAYMENT================"
//				+ "%s, %s", this.getTglPolis(), this.getBiayaIuran());
		String payment;
		for (int i = 0; i < 3; i++) {
			switch(prod.getFrekuensi()) {
			case ANNUALLY:
				payment = String.format("%s, %s", 
						this.getTglPolis().plusYears(i).format(formatter), 
						NumberFormat.getCurrencyInstance(indonesia).format(this.biayaIuran));
				System.out.println(payment);
			break;
			case MONTHLY:
				payment = String.format("%s, %s", 
						this.getTglPolis().plusMonths(i).format(formatter), 
						NumberFormat.getCurrencyInstance(indonesia).format(this.biayaIuran));
				System.out.println(payment);
			break;
			}
		}
	}

	private void printDetailPolisNonKendaraan() {
		Product prod = this.getProduct();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		Locale indonesia = new Locale("id", "ID");
		// TODO Auto-generated method stub
		String prodInfo = String.format("Tertanggung: %s\n" + 
				"Product: %s \n" + 
				"Tanggal Mulai Dijalankan: %s\n" + 
				"Manfaat: %s\n" + 
				"=========================\n", 
				custTertanggung.getNamaDepan() + " " + custTertanggung.getNamaBelakang(), 
				prod.getNamaProduk(), this.getTglPolis().format(formatter),
				prod.getManfaat());
		System.out.println(prodInfo);
	}	
	private void printDetailPolisKendaraan() {
		Product prod = this.getProduct();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		Locale indonesia = new Locale("id", "ID");
		// TODO Auto-generated method stub
		String prodInfo = String.format(
				"Product: %s \n" + 
				"Tanggal Mulai Dijalankan: %s\n" + 
				"Manfaat: %s\n" + 
				"Merk Kendaraan: %s"
				+ "Plat nomor: %s" + 
				"=========================\n", 
				prod.getNamaProduk(), this.getTglPolis().format(formatter),
				prod.getManfaat(), this.getMerkKendaraan(), this.getNopol());
		System.out.println(prodInfo);
	}	
}
