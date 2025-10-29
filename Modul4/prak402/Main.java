package Modul4.prak402;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.print("Pilih jenis Hewan yang ingin diinputkan:"
				+ "\n1 = Kucing"
				+ "\n2 = Anjing"
				+ "\nMasukkan pilihan: ");
		
		int pilihan = scanner.nextInt();scanner.nextLine();
		String n, r, w;
		String[] k;
		switch(pilihan) {
		case 1:
			System.out.printf("Nama hewan peliharaan: ");
			n = scanner.nextLine();
			System.out.printf("Ras: ");
			r = scanner.nextLine();
			System.out.printf("Warna Bulu: ");
			w = scanner.nextLine();
			
			Kucing kucing = new Kucing(r, n, w);
			kucing.displayDetailKucing();
			break;
		case 2:
			System.out.printf("Nama hewan peliharaan: ");
			n = scanner.nextLine();
			System.out.printf("Ras: ");
			r = scanner.nextLine();
			System.out.printf("Warna Bulu: ");
			w = scanner.nextLine();
			System.out.printf("Kemampuan: ");
			k = scanner.nextLine().split("[,]");
			
			Anjing anjing = new Anjing(r, n, w, k);
			anjing.displayDetailAnjing();
			break;
		default:
			System.out.println("Input salah");
			break;
		}
		
		scanner.close();
	}
}
