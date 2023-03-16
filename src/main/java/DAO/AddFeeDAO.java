package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.additionFee;

public class AddFeeDAO {
    public void addFee(int report_id, String title, int fee, String reason) throws Exception {
        String sql = "insert into [additionFee] values (?,?,?,?)";
        try (Connection conn = new DBContext().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, report_id);
            ps.setString(2, title);
            ps.setInt(3, fee);
            ps.setString(4, reason);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<additionFee> getFeeList() throws Exception {
        String sql = "select * from additionFee";
        List<additionFee> list = new ArrayList<>();
        try (Connection conn = new DBContext().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = (rs.getInt("id"));
                int report_id = (rs.getInt("report_id"));
                String title = (rs.getString("title"));
                int fee = (rs.getInt("fee"));
                String reason = (rs.getString("reason"));
                additionFee af = new additionFee(id, report_id, title, fee, reason);
                list.add(af);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public additionFee getFeeByReportID(int report_id) throws Exception {
        String sql = "select * from additionFee where report_id = ?";
        try (Connection conn = new DBContext().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, report_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = (rs.getInt("id"));
                String title = (rs.getString("title"));
                int fee = (rs.getInt("fee"));
                String reason = (rs.getString("reason"));
                additionFee af = new additionFee(id, report_id, title, fee, reason);
                return af;
            }
        }
        return null;
    }
}
