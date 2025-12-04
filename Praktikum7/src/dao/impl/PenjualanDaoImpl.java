package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PenjualanDao;
import model.Penjualan;
import util.DatabaseHelper;

public class PenjualanDaoImpl implements PenjualanDao{
	@Override
    public void addPenjualan(Penjualan p) throws Exception {
        String sql = "INSERT INTO penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getJumlah());
            ps.setInt(2, p.getTotalHarga());
            ps.setDate(3, Date.valueOf(p.getTanggal()));
            ps.setInt(4, p.getPelangganId());
            ps.setInt(5, p.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePenjualan(int id) throws Exception {
        String sql = "DELETE FROM penjualan WHERE penjualan_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Penjualan> findAllPenjualan() throws Exception {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT p.*, pel.nama AS nama_pelanggan, b.judul AS judul_buku " +
                     "FROM penjualan p " +
                     "JOIN pelanggan pel ON p.pelanggan_id = pel.pelanggan_id " +
                     "JOIN buku b ON p.buku_id = b.buku_id";
                     
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getInt("total_harga"),
                    rs.getDate("tanggal").toLocalDate(), 
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("judul_buku")     
                ));
            }
        }
        return list;
    }
}
