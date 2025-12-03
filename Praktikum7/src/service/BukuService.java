package service;

import java.util.List;

import dao.BukuDao;
import dao.impl.BukuDaoImpl;
import model.Buku;

public class BukuService {
	private final BukuDao dao = new BukuDaoImpl();

    public List<Buku> getAllBuku() throws Exception {
        return dao.findAllBuku();
    }

    public void addBuku(Buku b) throws Exception {
        validasi(b);
        dao.addBuku(b);
    }

    public void editBuku(Buku b) throws Exception {
        validasi(b);
        if (b.getBukuId() <= 0) throw new Exception("ID Buku tidak valid!");
        dao.editBuku(b);
    }

    public void deleteBuku(int id) throws Exception {
        if (id <= 0) throw new Exception("Pilih buku yang ingin dihapus!");
        dao.deleteBuku(id);
    }

    private void validasi(Buku b) throws Exception {
        if (b.getJudul() == null || b.getJudul().trim().isEmpty()) {
            throw new Exception("Judul Buku wajib diisi!");
        }
        if (b.getPenulis() == null || b.getPenulis().trim().isEmpty()) {
            throw new Exception("Nama Penulis wajib diisi!");
        }
        if (b.getHarga() < 0) {
            throw new Exception("Harga tidak boleh negatif!");
        }
        if (b.getStok() < 0) {
            throw new Exception("Stok tidak boleh negatif!");
        }
    }
}
