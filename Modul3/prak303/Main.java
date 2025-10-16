package Modul3.prak303;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (Harus Unik): ");
                    String nim = input.nextLine();
                    daftarMahasiswa.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    break;

                case 2:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nimHapus = input.nextLine();
                    boolean ditemukan = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.getNim().equals(nimHapus)) {
                            daftarMahasiswa.remove(m);
                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) System.out.println("NIM tidak ditemukan!");
                    break;

                case 3:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = input.nextLine();
                    boolean ketemu = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.getNim().equals(nimCari)) {
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                            ketemu = true;
                            break;
                        }
                    }
                    if (!ketemu) System.out.println("Mahasiswa tidak ditemukan.");
                    break;

                case 4:
                    System.out.println("Daftar Mahasiswa:");
                    for (Mahasiswa m : daftarMahasiswa) {
                        System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    daftarMahasiswa.clear(); 
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        input.close();
    }
}
