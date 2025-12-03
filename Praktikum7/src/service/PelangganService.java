package service;

import java.util.List;

import dao.PelangganDao;
import dao.impl.PelangganDaoImpl;
import model.Pelanggan;

public class PelangganService {
	// Menghubungkan Service ke DAO
    private final PelangganDao dao = new PelangganDaoImpl();

    public List<Pelanggan> getAllPelanggan() throws Exception {
        return dao.findAllPelanggan();
    }

    public void addPelanggan(Pelanggan p) throws Exception {
        validasi(p);
        dao.addPelanggan(p);
    }

    public void editPelanggan(Pelanggan p) throws Exception {
        validasi(p);
        if (p.getId() <= 0) throw new Exception("ID Pelanggan tidak valid!");
        dao.editPelanggan(p);
    }

    public void deletePelanggan(int id) throws Exception {
        if (id <= 0) throw new Exception("Pilih data yang ingin dihapus!");
        dao.deletePelanggan(id);
    }

    // Logika Validasi Input
    private void validasi(Pelanggan p) throws Exception {
        if (p.getNama() == null || p.getNama().trim().isEmpty()) {
            throw new Exception("Nama Pelanggan wajib diisi!");
        }
        if (p.getEmail() == null || p.getEmail().trim().isEmpty()) {
            throw new Exception("Email wajib diisi!");
        }
        if (p.getTelepon() == null || p.getTelepon().trim().isEmpty()) {
            throw new Exception("Nomor Telepon wajib diisi!");
        }
        // Validasi format telepon (hanya angka)
        if (!p.getTelepon().matches("\\d+")) {
            throw new Exception("Nomor Telepon harus berupa angka!");
        }
    }
}
