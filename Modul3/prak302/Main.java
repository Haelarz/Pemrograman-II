package Modul3.prak302;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Negara> daftarNegara = new LinkedList<>();
        
        HashMap<Integer, String> bulan = new HashMap<>();
        bulan.put(1, "Januari");
        bulan.put(2, "Februari");
        bulan.put(3, "Maret");
        bulan.put(4, "April");
        bulan.put(5, "Mei");
        bulan.put(6, "Juni");
        bulan.put(7, "Juli");
        bulan.put(8, "Agustus");
        bulan.put(9, "September");
        bulan.put(10, "Oktober");
        bulan.put(11, "November");
        bulan.put(12, "Desember");

        System.out.print("Masukkan jumlah negara: ");
        int jumlah = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Nama negara: ");
            String nama = input.nextLine();

            System.out.print("Jenis kepemimpinan: ");
            String jenis = input.nextLine().toLowerCase();

            System.out.print("Nama pemimpin: ");
            String pemimpin = input.nextLine();

            if (jenis.equals("monarki")) {
                daftarNegara.add(new Negara(nama, jenis, pemimpin));
            } else {
                System.out.print("Tanggal kemerdekaan: ");
                int tanggal = input.nextInt();
                System.out.print("Bulan kemerdekaan (angka): ");
                int bulanKem = input.nextInt();
                System.out.print("Tahun kemerdekaan: ");
                int tahun = input.nextInt();
                input.nextLine(); 
                daftarNegara.add(new Negara(nama, jenis, pemimpin, tanggal, bulanKem, tahun));
            }
            System.out.println();
        }

        for (Negara n : daftarNegara) {
            if (n.getJenisKepemimpinan().equalsIgnoreCase("monarki")) {
                System.out.println("Negara " + n.getNama() +
                        " mempunyai Raja bernama " + n.getNamaPemimpin());
            } else {
                String namaBulan = bulan.get(n.getBulanKemerdekaan());
                System.out.println("Negara " + n.getNama() +
                        " mempunyai " + n.getJenisKepemimpinan().substring(0, 1).toUpperCase() +
                        n.getJenisKepemimpinan().substring(1) +
                        " bernama " + n.getNamaPemimpin());
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " +
                        n.getTanggalKemerdekaan() + " " + namaBulan + " " + n.getTahunKemerdekaan());
            }
            System.out.println();
        }

        input.close();
    }
}
