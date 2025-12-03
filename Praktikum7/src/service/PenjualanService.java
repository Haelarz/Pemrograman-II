package service;

import java.util.List;

import dao.PenjualanDao;
import dao.impl.PenjualanDaoImpl;
import model.Penjualan;

public class PenjualanService {
	private final PenjualanDao dao = new PenjualanDaoImpl();

    public List<Penjualan> getAllPenjualan() throws Exception {
        return dao.findAllPenjualan();
    }

    public void addPenjualan(Penjualan p) throws Exception {
        if (p.getJumlah() <= 0) {
            throw new Exception("Jumlah pembelian harus lebih dari 0!");
        }
        
        if (p.getPelangganId() <= 0) {
            throw new Exception("ID Pelanggan tidak valid / belum diisi!");
        }
        if (p.getBukuId() <= 0) {
            throw new Exception("ID Buku tidak valid / belum diisi!");
        }
        
        if (p.getTanggal() == null) {
            throw new Exception("Tanggal transaksi belum diisi!");
        }

        dao.addPenjualan(p);
    }

    public void deletePenjualan(int id) throws Exception {
        if (id <= 0) throw new Exception("Pilih data penjualan yang ingin dihapus!");
        dao.deletePenjualan(id);
    }
}
