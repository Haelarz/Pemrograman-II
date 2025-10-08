package Modul2;

public class Soal3Main {
	public static void main(String[] args) {
        Pegawai p1 = new Pegawai();

        // Pada baris ini terjadi error karena kurang titik koma di akhir baris.
        // p1.nama = "Roi"
        p1.nama = "Roi";

        // Pada baris ini tidak ada error, tapi pastikan tipe data 'asal' di Pegawai adalah String agar cocok.
        p1.asal = "Kingdom of Orvel";

        p1.setJabatan("Assasin");

        // Pada baris ini tidak ada error, hanya pastikan getter sudah benar.
        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        System.out.println("Umur: " + p1.umur + " tahun");
    }
}
