import java.util.ArrayList;
	import java.util.Scanner; 
	import java.util.Random;
public class main {

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();  
		ArrayList<karyawan> listkaryawan = new ArrayList<>();

	public main() {
		mainMenu(); 
	}

	void mainMenu() {
		int menu = 0;			
			do {

				System.out.println("Welcome to PT Mentol App");
				System.out.println("------------------------");
				System.out.println("1. Insert Data Karyawan");
				System.out.println("2. View Data Karyawan");
				System.out.println("3. Update Data Karyawan");
				System.out.println("4. Delete Data Karyawan");
				System.out.print(">> ");
				menu = catchNumber();
				switch (menu) {
				case 1:
					insert();
					break;
				case 2:
					view();
					break;
				case 3:
					update();
					break;
				case 4:
					delete(); 
					break;
				}
				
			} while (menu != 4 );
		
		}
			

	public int catchNumber() {
		int menu ; 
		try {
			menu = scan.nextInt();
			scan.nextLine();
			
		} catch (Exception e) {
			menu = -1 ;
			scan.nextLine(); 
		}
		
		return menu ; 
	}
	
	void insert() {
		karyawan data = new karyawan();
			
			
	do {
		System.out.print("input nama karyawan [>=3] :");
		data.name=scan.nextLine(); 
	} while (!(data.name.length()>=3));
			
	do {
		System.out.print("input jenis kelamin [Laki -laki |Perempuan]");
		data.gender=scan.nextLine(); 
	} while (!(data.gender.equals("Laki-laki") || data.gender.equals("Perempuan")));
		
	
	do {
		System.out.print("input jabatan [Manager |Supervisor| Admin ]");
		data.job =scan.nextLine(); 
	} while (!(data.job.equals("Manager") || data.job.equals("Supervisor") || data.job.equals("Admin")));
	

	if(data.job.equals("Manager")) {
		data.gaji = 8000000;
	} else if(data.job.equals("Supervisor")) {
		data.gaji = 6000000;
	} else if(data.job.equals("Admin")) {
		data.gaji = 4000000;
	}
	
	for(int i = 0; i < 2; i++) {
		data.id += (char) (65 + rand.nextInt(26));
	}
	data.id += "-";
	for(int i = 0; i < 4; i++) {
		data.id += rand.nextInt(10);
	}
	
	listkaryawan.add(data);
	System.out.println("Berhasil menambahkan karyawan dengan id " + data.id);
	
	int tempmanager =0, tempsupervisor =0, tempadmin =0;
	double bonus;
	for(int i = 0; i < listkaryawan.size(); i++) {
		if(listkaryawan.get(i).job.equals("Manager")) {
			tempmanager++;
		} else if(listkaryawan.get(i).job.equals("Supervisor")) {
			tempsupervisor++;
		} else if(listkaryawan.get(i).job.equals("Admin")) {
			tempadmin++;
		}
	}
	
	ArrayList<karyawan> BONUS = new ArrayList<>();
	int perm=0; 
	if(tempmanager % 3 == 1 && tempmanager > 3) {
		perm = tempmanager % 3;
		bonus = 10;
		for(int i = 0; i < listkaryawan.size(); i++) {
			if(listkaryawan.get(i).job.equals("Manager") && (tempmanager - perm) > 0) {
				listkaryawan.get(i).gaji = listkaryawan.get(i).gaji + (int) ((bonus/100) * listkaryawan.get(i).gaji);
				BONUS.add(listkaryawan.get(i));
				tempmanager--;
			}
		}
		System.out.print("Bonus sebesar " + bonus + "% telah diberikan kepada karyawan dengan id ");
		for (int i = 0; i < (BONUS.size() - 1); i++) {
			System.out.print(BONUS.get(i).id + ", ");
		}
		System.out.println(BONUS.get(BONUS.size()-1).id);
		
		
	} else if(tempsupervisor % 3 == 1 && tempsupervisor > 3) {
		perm = tempsupervisor % 3;
		bonus = 7.5;
		for(int i = 0; i < listkaryawan.size(); i++) {
			if(listkaryawan.get(i).job.equals("Supervisor") && (tempsupervisor - perm) > 0) {
				listkaryawan.get(i).gaji = listkaryawan.get(i).gaji + (int) ((bonus/100) * listkaryawan.get(i).gaji);
				BONUS.add(listkaryawan.get(i));
				tempsupervisor--;
			}
		}
		System.out.print("Bonus sebesar " + bonus + "% telah diberikan kepada karyawan dengan id ");
		for (int i = 0; i < (BONUS.size() - 1); i++) {
			System.out.print(BONUS.get(i).id + ", ");
		}
		System.out.println(BONUS.get(BONUS.size()-1).id);
		
	} else if(tempadmin % 3 == 1 && tempadmin > 3) {
		perm = tempadmin % 3;
		bonus = 5;
		for(int i = 0; i < listkaryawan.size(); i++) {
			if(listkaryawan.get(i).job.equals("Admin") && (tempadmin - perm) > 0) {
				listkaryawan.get(i).gaji = listkaryawan.get(i).gaji + (int) ((bonus/100) * listkaryawan.get(i).gaji);
				BONUS.add(listkaryawan.get(i));
				tempadmin--;
			}
		}
		System.out.print("Bonus sebesar " + bonus + "% telah diberikan kepada karyawan dengan id ");
		for (int i = 0; i < (BONUS.size() - 1); i++) {
			System.out.print(BONUS.get(i).id + ", ");
		}
		System.out.println(BONUS.get(BONUS.size()-1).id);
	} 
	
}		
	
	
	
	void view() {
		if (listkaryawan.isEmpty()) {
			System.out.println("NO DATA FOUND");
			
		} else {
			for(int i = 0; i < listkaryawan.size(); i++) {
				nameAscending(); 
				System.out.println("No. " + (i+1));
				System.out.println("Id: " +listkaryawan.get(i).getId());
				System.out.println("Name: " + listkaryawan.get(i).getName());
				System.out.println("Gender: " + listkaryawan.get(i).getGender());
				System.out.println("Job : " + listkaryawan.get(i).getJob());
				System.out.println("Gaji: " + listkaryawan.get(i).getGaji());
				System.out.println("-----------------------------------");
				
				}

			
			}
			
		
			
		}
	
	
	
	void nameAscending () {
		for(int j = 0; j < listkaryawan.size() - 1; j++) {
			if(listkaryawan.get(j).name.compareToIgnoreCase(listkaryawan.get(j+1).name) > 0) {
				karyawan temp = listkaryawan.get(j);
				listkaryawan.set(j, listkaryawan.get(j+1));
				listkaryawan.set(j+1, temp);
		
			}
		}
	}

	
	void update() {
		int update;
		boolean no = true;
		view();
		System.out.print("Input nomor data yang ingin di-update: ");
		update = catchNumber()-1 ; 

		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			listkaryawan.get(update).name = scan.nextLine();
			for (int i = 0; i < listkaryawan.get(update).name.length(); i++) {
				if(!(listkaryawan.get(update).name.charAt(i) < '0' || listkaryawan.get(update).name.charAt(i) > '9')) {
					no = false;
				}
			}
		} while (listkaryawan.get(update).name.length() < 3 || no != true);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			listkaryawan.get(update).gender = scan.nextLine();
		} while (!(listkaryawan.get(update).gender.equals("Laki-laki") || listkaryawan.get(update).gender.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): " );
			listkaryawan.get(update).gender = scan.nextLine();
		} while (!(listkaryawan.get(update).gender.equals("Manager") || listkaryawan.get(update).gender.equals("Supervisor") || listkaryawan.get(update).gender.equals("Admin")));
		
		if(listkaryawan.get(update).job.equals("Manager")) {
			listkaryawan.get(update).gaji = 8000000;
		} else if(listkaryawan.get(update).job.equals("Supervisor")) {
			listkaryawan.get(update).gaji = 6000000;
		} else if(listkaryawan.get(update).job.equals("Admin")) {
			listkaryawan.get(update).gaji = 4000000;
		}
		
		listkaryawan.get(update).id= "";
		
		for(int i = 0; i < 2; i++) {
			listkaryawan.get(update).id += (char) (65 + rand.nextInt(26));
		}
		listkaryawan.get(update).id += "-";
		for(int i = 0; i < 4; i++) {
			listkaryawan.get(update).id += rand.nextInt(10);
		}
		
		System.out.println("Data karyawan berhasil diupdate!");
		
		
	}
	
	void delete() {
		int delete;
		view();
		System.out.print("Input nomor data yang ingin dihapus: ");
		delete = catchNumber() - 1;
		listkaryawan.remove(delete);
	}
		
	public static void main(String[] args) {
		new main(); 

	}

}
