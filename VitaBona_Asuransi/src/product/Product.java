package product;

//import java.math.BigDecimal;

import enumLib.Frekuensi;
import enumLib.KetentuanProduk;

public class Product {
	private String namaProduk;
	private String jenisProduk;
	private Frekuensi frekuensi;
	private String manfaat;
	private KetentuanProduk ketentuan;
	
	public Product(String namaProduk, String jenisProduk, Frekuensi frekuensi, String manfaat,
			KetentuanProduk ketentuan) {
		super();
		this.namaProduk = namaProduk;
		this.jenisProduk = jenisProduk;
		this.frekuensi = frekuensi;
		this.manfaat = manfaat;
		this.ketentuan = ketentuan;
	}

	public String getNamaProduk() {
		return namaProduk;
	}

	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}

	public String getJenisProduk() {
		return jenisProduk;
	}

	public void setJenisProduk(String jenisProduk) {
		this.jenisProduk = jenisProduk;
	}

	public Frekuensi getFrekuensi() {
		return frekuensi;
	}

	public void setFrekuensi(Frekuensi frekuensi) {
		this.frekuensi = frekuensi;
	}
	
	public String getManfaat() {
		return manfaat;
	}

	public void setManfaat(String manfaat) {
		this.manfaat = manfaat;
	}

	public KetentuanProduk getKetentuan() {
		return ketentuan;
	}

	public void setKetentuan(KetentuanProduk ketentuan) {
		this.ketentuan = ketentuan;
	}

	
	
}

