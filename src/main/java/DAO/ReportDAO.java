package DAO;

import context.DBContext;
import entity.Category;
import entity.Product;
import entity.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    public List<Report> getReports() {
        List<Report> reports = new ArrayList<>();
        try {
            String query = "select * from REPORT";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int order_id = rs.getInt("order_id");
                int damagePercent = rs.getInt("damagePercent");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String date = rs.getString("date");
                String prePic = rs.getString("prePic");
                String afterPic = rs.getString("afterPic");
                reports.add(new Report(id, order_id, damagePercent, title, content, date, prePic, afterPic));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }

    public void addReport(int order_id, int damagePercent, String title, String content, String prePic,
            String afterPic) {
        try {
            String query = "insert into REPORT(order_id, damagePercent, title, content, date, prePic, afterPic) values(?, ?, ?, ?, CAST( GETDATE() AS Date ), ?, ?)";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order_id);
            ps.setInt(2, damagePercent);
            ps.setString(3, title);
            ps.setString(4, content);
            ps.setString(5, prePic);
            ps.setString(6, afterPic);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}