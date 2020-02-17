package customHelper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import enumLib.Gender;
import enumLib.PaymentMethod;
import enumLib.statusKK;

public class HelperFormatter {
	
	public static LocalDate formatLocalDate(String date, String pattern) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate dateFormatted = LocalDate.parse(date, formatter);
		return dateFormatted;
	}
	
	public static Gender formatGender(String s) {
		Gender gender = null;
		switch(s.toLowerCase()) {
		case "l":
		case "pria":
		case "laki":
		case "laki laki":
		case "laki-laki":
		case "cowo":
			gender = Gender.MALE;
			break;
		case "p":
		case "wanita":
		case "cewe":
			gender = Gender.FEMALE;
			break;
		}
		return gender;
	}
	
	public static String formatGender(Gender s) {
		String gender = null;
		switch(s) {
		case MALE:
			gender = "Laki laki";
			break;
		case FEMALE:
			gender = "Perempuan";
			break;
		}
		return gender;
	}
	
	public static statusKK formatStatusKeluarga(String s) {
		statusKK status = null;
		switch(s.toLowerCase()) {
		case "ibu":
		case "istri":
			status = statusKK.WIFE;
			break;
		case "ayah":
		case "bapak":
		case "suami":
		case "kepala keluarga":
			status = statusKK.HUSBAND;
			break;
		case "anak":
		case "anak kandung":
			status = statusKK.CHILD;
			break;
		}
		return status;
	}
	
	public static String formatStatusKeluarga(statusKK s) {
		String status = null;
		switch(s) {
		case WIFE:
			status = "Istri";
			break;
		case HUSBAND:
			status = "Suami";
			break;
		case CHILD:
			status = "Anak";
			break;
		}
		return status;
	}

	public static PaymentMethod formatPaymentMethod(String payment) {
		// TODO Auto-generated method stub
		PaymentMethod payMethod = null;
		switch(payment.toLowerCase()) {
		case "credit card":
		case "cc":
		case "cre":
			payMethod = PaymentMethod.CREDIT_CARD;
			break;
		case "auto debit":
		case "ad":
		case "col":
		case "collection":
			payMethod = PaymentMethod.AUTO_DEBIT;
			break;
		case "voucher prabayar":
		case "vp":
		case "vou":
			payMethod = PaymentMethod.VOUCHER_PRABAYAR;
			break;
		}
		return payMethod;
	}
	
	public static String formatPaymentMethod(PaymentMethod payment) {
		// TODO Auto-generated method stub
		String payMethod = null;
		switch(payment) {
		case CREDIT_CARD:
			payMethod = "Credit Card";
			break;
		case AUTO_DEBIT:
			payMethod = "Auto Debit";
			break;
		case VOUCHER_PRABAYAR:
			payMethod = "Voucher Prabayar";
			break;
		}
		return payMethod;
	}
}
