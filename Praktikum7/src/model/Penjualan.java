package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Penjualan {
    private final IntegerProperty id;
    private final IntegerProperty jumlah;
    private final IntegerProperty totalHarga;
    private final ObjectProperty<LocalDate> tanggal;
    private final IntegerProperty pelangganId;
    private final IntegerProperty bukuId;
    
    // Properti Tambahan untuk Tampilan Tabel (Hasil JOIN Query)
    private final StringProperty namaPelanggan;
    private final StringProperty judulBuku;

    // Konstruktor Lengkap (Digunakan oleh DAO saat Read dari Database)
    public Penjualan(int id, int jumlah, int totalHarga, LocalDate tanggal, 
                     int pelangganId, int bukuId, String namaPelanggan, String judulBuku) {
        this.id = new SimpleIntegerProperty(id);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleIntegerProperty(totalHarga);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
        this.pelangganId = new SimpleIntegerProperty(pelangganId);
        this.bukuId = new SimpleIntegerProperty(bukuId);
        
        // Data ini diambil dari tabel Pelanggan & Buku via JOIN
        this.namaPelanggan = new SimpleStringProperty(namaPelanggan);
        this.judulBuku = new SimpleStringProperty(judulBuku);
    }

    // Konstruktor Simpel (Digunakan saat User Input Data Baru)
    public Penjualan(int jumlah, int totalHarga, LocalDate tanggal, int pelangganId, int bukuId) {
        // Nama Pelanggan & Judul Buku dikosongkan dulu karena belum disimpan
        this(0, jumlah, totalHarga, tanggal, pelangganId, bukuId, "-", "-");
    }

    // --- Property Getters & Setters ---

    public IntegerProperty idProperty() { 
    	return id; 
    }
    public int getId() { 
    	return id.get(); 
    }
    public void setId(int id) { 
    	this.id.set(id); 
    }

    public IntegerProperty jumlahProperty() { 
    	return jumlah; 
    }
    public int getJumlah() { 
    	return jumlah.get(); 
    }
    public void setJumlah(int jumlah) { 
    	this.jumlah.set(jumlah); 
    }
    
    public IntegerProperty totalHargaProperty() { 
    	return totalHarga; 
    }
    public int getTotalHarga() { 
    	return totalHarga.get(); 
    }
    public void setTotalHarga(int total) { 
    	this.totalHarga.set(total); 
    }
    
    public ObjectProperty<LocalDate> tanggalProperty() { 
    	return tanggal; 
    }
    public LocalDate getTanggal() { 
    	return tanggal.get(); 
    }
    public void setTanggal(LocalDate tgl) { 
    	this.tanggal.set(tgl); 
    }
    
    public IntegerProperty pelangganIdProperty() { 
    	return pelangganId; 
    }
    public int getPelangganId() { 
    	return pelangganId.get(); 
    }
    
    public IntegerProperty bukuIdProperty() { 
    	return bukuId; 
    }
    public int getBukuId() { 
    	return bukuId.get(); 
    }
    
    // Getter khusus untuk kolom Tabel
    public StringProperty namaPelangganProperty() { 
    	return namaPelanggan; 
    }
    public StringProperty judulBukuProperty() { 
    	return judulBuku; 
    }
}