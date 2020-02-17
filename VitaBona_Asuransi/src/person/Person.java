package person;

import java.time.LocalDate;

import enumLib.Gender;
import enumLib.StatusPerson;

public class Person {
	private Integer noProspect;
	private String namaDepan;
	private String namaBelakang;
	private String nomorKTP;
	private LocalDate tglLahir;
	private String tempatLahir;
	private Gender jenisKelamin;
	private String pekerjaan;
	private StatusPerson status;

	public Person(Integer noProspect, String namaDepan, String namaBelakang, String nomorKTP, LocalDate tglLahir,
		String tempatLahir, Gender jenisKelamin, String pekerjaan, StatusPerson status) {
	super();
	this.noProspect = noProspect;
	this.namaDepan = namaDepan;
	this.namaBelakang = namaBelakang;
	this.nomorKTP = nomorKTP;
	this.tglLahir = tglLahir;
	this.tempatLahir = tempatLahir;
	this.jenisKelamin = jenisKelamin;
	this.pekerjaan = pekerjaan;
	this.status = status;
}
//	tanpa KTP
	public Person(Integer noProspect, String namaDepan, String namaBelakang, LocalDate tglLahir, String tempatLahir,
			Gender jenisKelamin, String pekerjaan, StatusPerson status) {
		// TODO Auto-generated constructor stub
		super();
		this.noProspect = noProspect;
		this.namaDepan = namaDepan;
		this.namaBelakang = namaBelakang;
		this.tglLahir = tglLahir;
		this.tempatLahir = tempatLahir;
		this.jenisKelamin = jenisKelamin;
		this.pekerjaan = pekerjaan;
		this.status = status;
	}
	//	Setter getter
	public Integer getNoProspect() {
		return noProspect;
	}
	public void setNoProspect(Integer noProspect) {
		this.noProspect = noProspect;
	}
	public String getNamaDepan() {
		return namaDepan;
	}
	public void setNamaDepan(String namaDepan) {
		this.namaDepan = namaDepan;
	}
	public String getNamaBelakang() {
		return namaBelakang;
	}
	public void setNamaBelakang(String namaBelakang) {
		this.namaBelakang = namaBelakang;
	}
	public String getNomorKTP() {
		return nomorKTP;
	}
	public void setNomorKTP(String nomorKTP) {
		this.nomorKTP = nomorKTP;
	}
	public LocalDate getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(LocalDate tglLahir) {
		this.tglLahir = tglLahir;
	}
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	public Gender getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(Gender jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getPekerjaan() {
		return pekerjaan;
	}
	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	public StatusPerson getStatus() {
		return status;
	}
	public void setStatus(StatusPerson Status) {
		this.status = status;
	}
//	Setter getter	
}

