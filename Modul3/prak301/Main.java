package Modul3.prak301;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<Dadu> daftarDadu = new LinkedList<>();
		
		System.out.print("Masukkan Jumlah Dadu: ");
		int jumlah = scan.nextInt();
		
		int total = 0;
		
		for (int i = 0; i < jumlah; i++) {
			Dadu d = new Dadu();
			daftarDadu.add(d);
			int nilai = d.getNilai();
			System.out.println("Dadu ke-" + (i+1) + " bernilai " + nilai);
			total += nilai;
		}
		
		System.out.println("Total nilai dadu keseluruhan " + total);
		scan.close();
	}
}