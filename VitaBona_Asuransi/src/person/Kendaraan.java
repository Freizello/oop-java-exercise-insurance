package person;


public class Kendaraan {

	String nopol;
	String noSTNK;
	String jenisKendaraan;
	String merkKendaraan;
	String modelKendaraan;
	String warnaKendaraan;
	
	public Kendaraan(String nopol, String noSTNK, String jenisKendaraan, String merkKendaraan, String modelKendaraan,
			String warnaKendaraan) {
		this.nopol = nopol;
		this.noSTNK = noSTNK;
		this.jenisKendaraan = jenisKendaraan;
		this.merkKendaraan = merkKendaraan;
		this.modelKendaraan = modelKendaraan;
		this.warnaKendaraan = warnaKendaraan;
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

	public String getJenisKendaraan() {
		return jenisKendaraan;
	}

	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
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

	public void printKendaraan() {
		// TODO Auto-generated method stub
		String detail = String.format("%s", 
			this.getMerkKendaraan()
		);
		System.out.println(detail);
	}
	
}
