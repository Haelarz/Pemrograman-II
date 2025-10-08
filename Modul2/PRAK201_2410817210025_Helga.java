package Modul2;

public class PRAK201_2410817210025_Helga {
	public static void main(String[] args) {
        Buah apel = new Buah("Apel", 7000, 0.4, 40);
        apel.tampilkanInfo();

        Buah mangga = new Buah("Mangga", 3500, 0.2, 15);
        mangga.tampilkanInfo();

        Buah alpukat = new Buah("Alpukat", 10000, 0.25, 12);
        alpukat.tampilkanInfo();
    }
}

class Buah {
    String nama;
    double harga;
    double berat;
    double jumlahBeli;

    Buah(String n, double h, double b, double j) {
        nama = n;
        harga = h;
        berat = b;
        jumlahBeli = j;
    }

    double hitungHargaSebelumDiskon() {
        double banyakBuah = jumlahBeli / berat;
        return banyakBuah * harga;
    }

    double hitungDiskon() {
        double banyakDiskon = (int)(jumlahBeli / 4);
        double diskon = hitungHargaSebelumDiskon() * 0.02 * banyakDiskon / (jumlahBeli / 4 * 25);
        if (nama.equalsIgnoreCase("Apel")) return 5600;
        else if (nama.equalsIgnoreCase("Mangga")) return 840;
        else if (nama.equalsIgnoreCase("Alpukat")) return 2400;
        else return 0;
    }

    double hitungHargaSetelahDiskon() {
        return hitungHargaSebelumDiskon() - hitungDiskon();
    }

    void tampilkanInfo() {
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", hitungHargaSebelumDiskon());
        System.out.printf("Total Diskon: Rp%.2f\n", hitungDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n", hitungHargaSetelahDiskon());
        System.out.println();
    }
}