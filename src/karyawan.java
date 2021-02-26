
public class karyawan {

	public int gaji;
	public String name, gender, job, id= "";
	public double bonus;
	
	


	public int getGaji() {
		return gaji;
	}



	public void setGaji(int gaji) {
		this.gaji = gaji;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public double getBonus() {
		return bonus;
	}



	public void setBonus(double bonus) {
		this.bonus = bonus;
	}



	public karyawan(int gaji, String name, String gender, String job, String id, double bonus) {
		super();
		this.gaji = gaji;
		this.name = name;
		this.gender = gender;
		this.job = job;
		this.id = id;
		this.bonus = bonus;
	}



	public karyawan() {
		// TODO Auto-generated constructor stub
	}

}
