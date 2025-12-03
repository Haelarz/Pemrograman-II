package dao;

import java.util.List;
import model.Buku;

public interface BukuDao {
	void addBuku(Buku buku) throws Exception;
    void editBuku(Buku buku) throws Exception;
    void deleteBuku(int id) throws Exception;
    List<Buku> findAllBuku() throws Exception;
}