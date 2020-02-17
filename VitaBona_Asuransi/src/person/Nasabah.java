package person;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.LinkedList;

import customHelper.HelperFormatter;
//import classLibrary.Enrollment;
import enumLib.Gender;
import enumLib.PaymentMethod;
import enumLib.StatusPerson;
import enumLib.statusKK;
//import HelperFormatter.*;

public class Nasabah extends Person{
	
	private String nomorNasabah; //Nomor Nasabah (unik) nama depan,
	private statusKK statusKeluarga; //status keluarga di KK (Kartu Keluarga),
	private PaymentMethod paymentMethod; //	dan metode pembayaran. 
	
//	private LinkedList<Kendaraan> kendaraan; //Not used
	
	public Nasabah(Integer noProspect, String namaDepan, String namaBelakang, String nomorKTP, LocalDate tglLahir,
			String tempatLahir, Gender jenisKelamin, String pekerjaan, StatusPerson status, String nomorNasabah, statusKK statusKeluarga,
			PaymentMethod paymentMethod) {
		super(noProspect, namaDepan, namaBelakang, nomorKTP, tglLahir, tempatLahir, jenisKelamin, pekerjaan, status);
		
		this.nomorNasabah = nomorNasabah;
		this.statusKeluarga = statusKeluarga;
		this.paymentMethod = paymentMethod;
	}
	
//	setter getter

	public String getNomorNasabah() {
		return nomorNasabah;
	}

	public void setNomorNasabah(String nomorNasabah) {
		this.nomorNasabah = nomorNasabah;
	}

	public statusKK getStatusKeluarga() {
		return statusKeluarga;
	}

	public void setStatusKeluarga(statusKK statusKeluarga) {
		this.statusKeluarga = statusKeluarga;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}	
//	setter getter

	public void printSummary() {
		// TODO Auto-generated method stub
		
//		No: 11/2018/1, Shanty Asmara, Perempuan, 21 April 1988 (Jakarta), Pegawai Swasta
//		KTP: 3120002321041988, Status di KK: Ibu, Payment Method: Credit Card
//		=====================================================================
		
		String summary = String.format("No: %s, %s %s, %s, %s (%s), %s\n"
				+ "%s, Status di KK : %s, Payment Method : %s\n"
				+ "======================================================================", 
				this.getNomorNasabah(), this.getNamaDepan(), this.getNamaBelakang(),
				this.getJenisKelamin(), this.getTglLahir(), this.getTempatLahir(), 
				this.getPekerjaan(), this.getNomorKTP(), formatStatusKeluarga(this.getStatusKeluarga()), 
				HelperFormatter.formatPaymentMethod(this.getPaymentMethod()));
		System.out.println(summary);
		
	}
	
//	public static String formatPaymentMethod(PaymentMethod payment) {
//		String payMethod = "";
//		switch(payment) {
//		case CREDIT_CARD:
//			payMethod = "Credit Card";
//			break;
//		case AUTO_DEBIT:
//			payMethod = "Auto Debit/Collection";
//			break;
//		case VOUCHER_PRABAYAR:
//			payMethod = "Voucher Prabayar";
//			break;
//		}
//		return payMethod;
//	}
	
	public static String formatStatusKeluarga(statusKK s) {
		String status = null;
		switch(s) {
		case HUSBAND:
			status = "Ayah";
			break;
		case WIFE:
			status = "Ibu";
			break;
		case CHILD:
			status = "Anak";
			break;
		}
		return status;
	}	
}
