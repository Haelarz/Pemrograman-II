package Modul2;

//Pada baris ini terjadi error karena nama class tidak sesuai dengan instansiasi di file main (Pegawai).
//public class Employee {
public class Pegawai {
	public String nama;
    // Pada baris ini terjadi error karena tipe data asal seharusnya String, bukan char.
    // public char asal;
    public String asal;

    public String jabatan;
    public int umur = 17; // Tambahkan nilai default agar sesuai dengan output "17 tahun"

    public String getNama() {
        return nama;
    }

    // Pada baris ini terjadi error karena tipe data kembalian tidak sesuai (asal bertipe String, bukan char).
    // public String getAsal() {
    //     return asal;
    // }
    public String getAsal() {
        return asal;
    }

    // Pada baris ini terjadi error karena parameter 'j' tidak dideklarasikan dalam method.
    // public void setJabatan() {
    //     this.jabatan = j;
    // }
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}
