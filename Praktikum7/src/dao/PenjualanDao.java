package dao;

import java.util.List;
import model.Penjualan;

public interface PenjualanDao {
	void addPenjualan(Penjualan penjualan) throws Exception;
    void deletePenjualan(int id) throws Exception;
    List<Penjualan> findAllPenjualan() throws Exception;
}
