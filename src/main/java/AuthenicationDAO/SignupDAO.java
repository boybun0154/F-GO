/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuthenicationDAO;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class SignupDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account checkAccountExist(String acc) {
        try {
            String query = "select * from ACCOUNT where account = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return a;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void signup(String user, String pass, String role) {
        String query = "insert into ACCOUNT values(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, role);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void addAccIDToCustomer(int accid,String customerName,String phone, String email) {
        String query = "INSERT INTO CUSTOMER (accountID, isVerify,customerName,phone,email)\n"
                + "VALUES (?, 0,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accid);
            ps.setString(2, customerName);
            ps.setString(3, phone);
            ps.setString(4, email);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
