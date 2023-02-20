package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Location;

public class LocationDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void saveLocation(String acc, Double lat, Double lng) throws Exception {
        if (checkExistedAcc(acc)) {
            String sql = "UPDATE Location SET lat = ?, lng = ? WHERE account = ?";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setDouble(1, lng);
                ps.setDouble(2, lat);
                ps.setString(3, acc);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String sql = "INSERT INTO Location VALUES(?, ?, ?)";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, acc);
                ps.setDouble(2, lat);
                ps.setDouble(3, lng);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean checkExistedAcc(String acc) throws Exception {
        // check existed account in Location table
        String sql = "SELECT * FROM Location WHERE account = ?";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, acc);
        rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString("account").equals(acc))
                return true;
        }
        return false;
    }

    public List<Location> getLocationList() throws Exception {
        String sql = "SELECT * FROM Location";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List<Location> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Location(rs.getString("account"), rs.getDouble("lat"), rs.getDouble("lng")));
        }
        return list;
    }

}
