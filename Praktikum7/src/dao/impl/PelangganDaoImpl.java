package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PelangganDao;
import model.Pelanggan;
import util.DatabaseHelper;

public class PelangganDaoImpl implements PelangganDao {
	@Override
    public void addPelanggan(Pelanggan p) throws Exception {
        String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.executeUpdate();
        }
    }

    @Override
    public void editPelanggan(Pelanggan p) throws Exception {
        String sql = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePelanggan(int id) throws Exception {
        String sql = "DELETE FROM pelanggan WHERE id=?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Pelanggan> findAllPelanggan() throws Exception {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Pelanggan(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("telepon")
                ));
            }
        }
        return list;
    }
}
