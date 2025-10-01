package PraktikumModulI;
import java.util.Scanner;

public class PRAK101_2410817210025_Helga {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan Nama Lengkap: ");
        String nama = scan.nextLine();

        System.out.print("Masukkan Tempat Lahir: ");
        String tempat = scan.nextLine();

        System.out.print("Masukkan Tanggal Lahir: ");
        int tanggal = scan.nextInt();

        System.out.print("Masukkan Bulan Lahir: ");
        int bulan = scan.nextInt();

        System.out.print("Masukkan Tahun Lahir: ");
        int tahun = scan.nextInt();

        System.out.print("Masukkan Tinggi Badan: ");
        int tinggi = scan.nextInt();

        System.out.print("Masukkan Berat Badan: ");
        double berat = scan.nextDouble();

        String[] namaBulan = {
            "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.println("Nama Lengkap " + nama + ", Lahir di " + tempat +
                " pada Tanggal " + tanggal + " " + namaBulan[bulan] + " " + tahun);
        System.out.println("Tinggi Badan " + tinggi + " cm dan Berat Badan " + berat + " kilogram");

        scan.close();
	}
	
}