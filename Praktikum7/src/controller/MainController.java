package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import model.Pelanggan;
import model.Buku;
import model.Penjualan;
import service.PelangganService;
import service.BukuService;
import service.PenjualanService;

public class MainController {

    @FXML private TextField txtNama, txtEmail, txtTelepon;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNama;
    @FXML private TableColumn<Pelanggan, String> colEmail;
    @FXML private TableColumn<Pelanggan, String> colTelepon;

    @FXML private TextField txtJudul, txtPenulis, txtHarga, txtStok;
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colPenulis;
    @FXML private TableColumn<Buku, Integer> colHarga;
    @FXML private TableColumn<Buku, Integer> colStok;

    @FXML private TextField txtJualPelangganId; 
    @FXML private TextField txtJualBukuId;     
    @FXML private TextField txtJumlahJual;
    @FXML private TextField txtTanggal;         
    
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> colJualTanggal;
    @FXML private TableColumn<Penjualan, String> colJualPelanggan;
    @FXML private TableColumn<Penjualan, String> colJualBuku;
    @FXML private TableColumn<Penjualan, Integer> colJualJumlah;
    @FXML private TableColumn<Penjualan, Integer> colJualTotal;

    private PelangganService pelangganService = new PelangganService();
    private BukuService bukuService = new BukuService();
    private PenjualanService penjualanService = new PenjualanService();

    private int selectedPelangganId = 0;
    private int selectedBukuId = 0;
    private int selectedPenjualanId = 0;

    @FXML
    public void initialize() {
        initPelanggan();
        initBuku();
        initPenjualan();
    }

    private void initPelanggan() {
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colEmail.setCellValueFactory(cell -> cell.getValue().emailProperty());
        colTelepon.setCellValueFactory(cell -> cell.getValue().teleponProperty());
        loadDataPelanggan();

        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            if (newVal != null) {
                txtNama.setText(newVal.getNama());
                txtEmail.setText(newVal.getEmail());
                txtTelepon.setText(newVal.getTelepon());
                selectedPelangganId = newVal.getId();
            }
        });
    }

    private void initBuku() {
        colJudul.setCellValueFactory(cell -> cell.getValue().judulProperty());
        colPenulis.setCellValueFactory(cell -> cell.getValue().penulisProperty());
        colHarga.setCellValueFactory(cell -> cell.getValue().hargaProperty().asObject());
        colStok.setCellValueFactory(cell -> cell.getValue().stokProperty().asObject());
        loadDataBuku();

        tblBuku.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            if (newVal != null) {
                txtJudul.setText(newVal.getJudul());
                txtPenulis.setText(newVal.getPenulis());
                txtHarga.setText(String.valueOf(newVal.getHarga()));
                txtStok.setText(String.valueOf(newVal.getStok()));
                selectedBukuId = newVal.getBukuId();
            }
        });
    }

    private void initPenjualan() {
        colJualPelanggan.setCellValueFactory(c -> c.getValue().namaPelangganProperty());
        colJualBuku.setCellValueFactory(c -> c.getValue().judulBukuProperty());
        colJualJumlah.setCellValueFactory(c -> c.getValue().jumlahProperty().asObject());
        colJualTotal.setCellValueFactory(c -> c.getValue().totalHargaProperty().asObject());
        colJualTanggal.setCellValueFactory(c -> c.getValue().tanggalProperty().asString());
        loadDataPenjualan();

        tblPenjualan.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            if (newVal != null) selectedPenjualanId = newVal.getId();
        });
    }

    @FXML private void onAddPelanggan() {
        try {
            Pelanggan p = new Pelanggan(txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            pelangganService.addPelanggan(p);
            onSuccess("Pelanggan ditambahkan!", 1);
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML private void onEditPelanggan() {
        if (selectedPelangganId == 0) return;
        try {
            Pelanggan p = new Pelanggan(selectedPelangganId, txtNama.getText(), txtEmail.getText(), txtTelepon.getText());
            pelangganService.editPelanggan(p);
            onSuccess("Pelanggan diupdate!", 1);
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML private void onDeletePelanggan() {
        if (selectedPelangganId == 0) return;
        try {
            pelangganService.deletePelanggan(selectedPelangganId);
            onSuccess("Pelanggan dihapus!", 1);
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML private void onAddBuku() {
        try {
            Buku b = new Buku(txtJudul.getText(), txtPenulis.getText(), 
                             Integer.parseInt(txtHarga.getText()), Integer.parseInt(txtStok.getText()));
            bukuService.addBuku(b);
            onSuccess("Buku ditambahkan!", 2);
        } catch (NumberFormatException e) { showAlert("Error", "Harga/Stok harus angka!"); }
          catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML private void onEditBuku() {
        if (selectedBukuId == 0) return;
        try {
            Buku b = new Buku(selectedBukuId, txtJudul.getText(), txtPenulis.getText(), 
                             Integer.parseInt(txtHarga.getText()), Integer.parseInt(txtStok.getText()));
            bukuService.editBuku(b);
            onSuccess("Buku diupdate!", 2);
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML private void onDeleteBuku() {
        if (selectedBukuId == 0) return;
        try {
            bukuService.deleteBuku(selectedBukuId);
            onSuccess("Buku dihapus!", 2);
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    @FXML private void onAddPenjualan() {
        try {
            int idPelanggan = Integer.parseInt(txtJualPelangganId.getText());
            int idBuku = Integer.parseInt(txtJualBukuId.getText());
            int jumlah = Integer.parseInt(txtJumlahJual.getText());
            LocalDate tanggal = LocalDate.parse(txtTanggal.getText()); 

            Buku bukuDipilih = bukuService.getAllBuku().stream()
                    .filter(b -> b.getBukuId() == idBuku)
                    .findFirst()
                    .orElseThrow(() -> new Exception("ID Buku tidak ditemukan di database!"));

            int totalHarga = bukuDipilih.getHarga() * jumlah;

            Penjualan p = new Penjualan(jumlah, totalHarga, tanggal, idPelanggan, idBuku);
            penjualanService.addPenjualan(p);

            onSuccess("Transaksi Berhasil! Total: Rp " + totalHarga, 3);

        } catch (NumberFormatException e) {
            showAlert("Format Salah", "ID Pelanggan, ID Buku, dan Jumlah harus angka!");
        } catch (DateTimeParseException e) {
            showAlert("Format Tanggal Salah", "Gunakan format YYYY-MM-DD (contoh: 2023-12-31)");
        } catch (Exception e) {
            showAlert("Gagal Simpan", e.getMessage());
        }
    }

    @FXML private void onDeletePenjualan() {
        if (selectedPenjualanId == 0) return;
        try {
            penjualanService.deletePenjualan(selectedPenjualanId);
            onSuccess("Data penjualan dihapus!", 3);
        } catch (Exception e) { showAlert("Gagal", e.getMessage()); }
    }

    private void loadDataPelanggan() {
        try { tblPelanggan.setItems(FXCollections.observableArrayList(pelangganService.getAllPelanggan())); } 
        catch (Exception e) { e.printStackTrace(); }
    }
    private void loadDataBuku() {
        try { tblBuku.setItems(FXCollections.observableArrayList(bukuService.getAllBuku())); } 
        catch (Exception e) { e.printStackTrace(); }
    }
    private void loadDataPenjualan() {
        try { tblPenjualan.setItems(FXCollections.observableArrayList(penjualanService.getAllPenjualan())); } 
        catch (Exception e) { e.printStackTrace(); }
    }

    private void onSuccess(String msg, int type) {
        showAlert("Sukses", msg);
        if (type == 1) { 
            txtNama.clear(); txtEmail.clear(); txtTelepon.clear();
            selectedPelangganId = 0; loadDataPelanggan();
        } else if (type == 2) { 
            txtJudul.clear(); txtPenulis.clear(); txtHarga.clear(); txtStok.clear();
            selectedBukuId = 0; loadDataBuku();
        } else if (type == 3) {
            txtJualPelangganId.clear(); txtJualBukuId.clear(); txtJumlahJual.clear(); txtTanggal.clear();
            selectedPenjualanId = 0; loadDataPenjualan();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}