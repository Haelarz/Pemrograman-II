package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BukuDao;
import model.Buku;
import util.DatabaseHelper;

public class BukuDaoImpl implements BukuDao{
	@Override
    public void addBuku(Buku b) throws Exception {
        String sql = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setInt(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
        }
    }

    @Override
    public void editBuku(Buku b) throws Exception {
        String sql = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setInt(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setInt(5, b.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteBuku(int id) throws Exception {
        String sql = "DELETE FROM buku WHERE buku_id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Buku> findAllBuku() throws Exception {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(
                    rs.getInt("buku_id"),
                    rs.getString("judul"),
                    rs.getString("penulis"),
                    rs.getInt("harga"),
                    rs.getInt("stok")
                ));
            }
        }
        return list;
    }
}
