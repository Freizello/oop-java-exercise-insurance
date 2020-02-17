package person;

import java.time.LocalDate;

import enumLib.Gender;
import enumLib.PaymentMethod;
import enumLib.StatusPerson;
import enumLib.statusKK;

public class Prospect extends Person{
//	private StatusPerson status;

	public Prospect(Integer noProspect, String namaDepan, String namaBelakang, String nomorKTP, LocalDate tglLahir,
			String tempatLahir, Gender jenisKelamin, String pekerjaan, StatusPerson status) {
		super(noProspect, namaDepan, namaBelakang, nomorKTP, tglLahir, tempatLahir, jenisKelamin, pekerjaan, status);
	}
	
//	tanpa KTP
	public Prospect(Integer noProspect, String namaDepan, String namaBelakang, LocalDate tglLahir,
			String tempatLahir, Gender jenisKelamin, String pekerjaan, StatusPerson status) {
		// TODO Auto-generated constructor stub
		super(noProspect, namaDepan, namaBelakang, tglLahir, tempatLahir, jenisKelamin, pekerjaan, status);
//		this.status = status;
	}
	
	public void printSummary() {
		// TODO Auto-generated method stub
		
//		No: 1, Shanty Asmara, Perempuan, 21 April 1988 (Jakarta), Pegawai Swasta, Prospect
		String summary = String.format("No: %s, %s %s, %s, %s (%s), %s, %s", 
				this.getNoProspect(), this.getNamaDepan(), this.getNamaBelakang(),
				formatGender(this.getJenisKelamin()), this.getTglLahir(), this.getTempatLahir(), this.getPekerjaan(), this.getStatus());

		System.out.println(summary);
	}
	
	public static String formatGender(Gender s) {
		String gender = null;
		switch(s) {
		case MALE:
			gender = "Laki Laki";
			break;
		case FEMALE:
			gender = "Perempuan";
			break;
		}
		return gender;
	}
	
// Setter Getter		
}



